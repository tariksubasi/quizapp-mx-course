/*global logger*/
/*
    CSVasTable
    ========================

    @file      : CSVasTable.js
    @version   : {{version}}
    @author    : {{author}}
    @date      : {{date}}
    @copyright : {{copyright}}
    @license   : {{license}}

    Documentation
    ========================
    Describe your widget here.
*/

// Required module list. Remove unnecessary modules, you can always get them back from the boilerplate.
define([
    "dojo/_base/declare",
    "mxui/widget/_WidgetBase",
    "dijit/_TemplatedMixin",

    "mxui/dom",
    "dojo/dom",
    "dojo/dom-prop",
    "dojo/dom-geometry",
    "dojo/dom-class",
    "dojo/dom-style",
    "dojo/dom-construct",
    "dojo/_base/array",
    "dojo/_base/lang",
    "dojo/text",
    "dojo/html",
    "dojo/_base/event",

    "CSVasTable/lib/papaparse",
	"dojo/text!CSVasTable/widget/template/CSVasTable.html"
], function (declare, _WidgetBase, _TemplatedMixin, dom, dojoDom, dojoProp, dojoGeometry, dojoClass, dojoStyle, dojoConstruct, dojoArray, dojoLang, dojoText, dojoHtml, dojoEvent, Papa, widgetTemplate) {
    "use strict";

    // Declare widget's prototype.
    return declare("CSVasTable.widget.CSVasTable", [ _WidgetBase, _TemplatedMixin ], {
        // _TemplatedMixin will create our dom node using this HTML template.
		templateString: widgetTemplate,

        // Parameters configured in the Modeler.
        csv: "",

        // Internal variables. Non-primitives created in the prototype are shared between all widget instances.
        _handles: null,
        _contextObj: null,
        _alertDiv: null,
        _readOnly: false,

        // dojo.declare.constructor is called to construct the widget instance. Implement to initialize non-primitive properties.
        constructor: function () {
            this.log(".constructor");
            this._handles = [];
        },

        log() {
            var args = Array.prototype.slice.call(arguments);
            if (this.id) {
                args.unshift(this.id);
            }
            if (mx && mx.logger && mx.logger.debug) {
                mx.logger.debug.apply(mx.logger, args);
            } else {
                logger.debug.apply(logger, args);
            }
        },

        // dijit._WidgetBase.postCreate is called after constructing the widget. Implement to do extra setup work.
        postCreate: function () {
            this.log(".postCreate");

            if (this.readOnly || this.get("disabled") || this.readonly) {
              this._readOnly = true;
            }

            this._updateRendering();
            this._setupEvents();
        },

        // mxui.widget._WidgetBase.update is called when context is changed or initialized. Implement to re-render and / or fetch data.
        update: function (obj, callback) {
            this.log(".update");

            this._contextObj = obj;
            this._resetSubscriptions();
            this._updateRendering(callback); // We're passing the callback to updateRendering to be called after DOM-manipulation
        },

        // mxui.widget._WidgetBase.enable is called when the widget should enable editing. Implement to enable editing if widget is input widget.
        enable: function () {
          this.log(".enable");
        },

        // mxui.widget._WidgetBase.enable is called when the widget should disable editing. Implement to disable editing if widget is input widget.
        disable: function () {
          this.log(".disable");
        },

        // mxui.widget._WidgetBase.resize is called when the page's layout is recalculated. Implement to do sizing calculations. Prefer using CSS instead.
        resize: function (box) {
          this.log(".resize");
        },

        // mxui.widget._WidgetBase.uninitialize is called when the widget is destroyed. Implement to do special tear-down work.
        uninitialize: function () {
          this.log(".uninitialize");
            // Clean up listeners, helper objects, etc. There is no need to remove listeners added with this.connect / this.subscribe / this.own.
        },

        // We want to stop events on a mobile device
        _stopBubblingEventOnMobile: function (e) {
            this.log("._stopBubblingEventOnMobile");
            if (typeof document.ontouchstart !== "undefined") {
                dojoEvent.stop(e);
            }
        },

        // Attach events to HTML dom elements
        _setupEvents: function () {
            this.log("._setupEvents");
        },

        // Rerender the interface.
        _updateRendering: function (callback) {
            this.log("._updateRendering");
			
			this.domNode.innerHTML = "";
			
			if (!this._contextObj) {
				this._executeCallback(callback, "_updateRendering");
				return;
			}
			
			var csvData = this._contextObj.get(this.csv);
            var tableElement = document.createElement("table");
			tableElement.className = 'csv';
            var headersElement = document.createElement("thead");
			tableElement.appendChild(headersElement);
			var headerRow = document.createElement("tr");
            headersElement.appendChild(headerRow);
            var tableBodyElement = document.createElement("tbody");
            tableElement.appendChild(tableBodyElement);
            
            var result = Papa.parse(csvData, {
                delimiter: ',',
                escapeChar: '\\',
                header: true,
                quoteChar: '"',
                newLine: '\r\n',
                error: dojoLang.hitch(this, function(err) {
                    console.error("Error while parsing CSV:" , err);
                    this._executeCallback(callback, "_updateRendering");
                })
            });
            
            for (var i=0; i < result.meta.fields.length; i++) {
                var headerCell = document.createElement("th");
                headerCell.innerHTML = result.meta.fields[i];
                headerRow.appendChild(headerCell);
            }
            
            for (var i=0; i< result.data.length; i++) {
            	var valueRowElement = document.createElement("tr");
            	Object.keys(result.data[i]).forEach(function(key) {
            		var valueCellElement = document.createElement("td");
                    valueCellElement.innerHTML = result.data[i][key];
                    valueRowElement.appendChild(valueCellElement);
            	});
                tableBodyElement.appendChild(valueRowElement);
            }
            
            tableElement.appendChild(tableBodyElement);
            tableElement.appendChild(tableBodyElement);
            this.domNode.appendChild(tableElement);
            this._executeCallback(callback, "_updateRendering");
        },

        // Handle validations.
        _handleValidation: function (validations) {
            this.log("._handleValidation");
        },

        // Show an error message.
        _showError: function (message) {
            this.log("._showError");
            if (this._alertDiv !== null) {
                dojoHtml.set(this._alertDiv, message);
                return true;
            }
            this._alertDiv = dojoConstruct.create("div", {
                "class": "alert alert-danger",
                "innerHTML": message
            });
            dojoConstruct.place(this._alertDiv, this.domNode);
        },

        // Add a validation.
        _addValidation: function (message) {
            this.log("._addValidation");
            this._showError(message);
        },

        _unsubscribe: function () {
          if (this._handles) {
              dojoArray.forEach(this._handles, function (handle) {
                  mx.data.unsubscribe(handle);
              });
              this._handles = [];
          }
        },

        // Reset subscriptions.
        _resetSubscriptions: function () {
            this.log("._resetSubscriptions");
            // Release handles on previous object, if any.
            this._unsubscribe();

            // When a mendix object exists create subscribtions.
            if (this._contextObj) {
                var objectHandle = mx.data.subscribe({
                    guid: this._contextObj.getGuid(),
                    callback: dojoLang.hitch(this, function (guid) {
                        this._updateRendering();
                    })
                });

                var attrHandle = mx.data.subscribe({
                    guid: this._contextObj.getGuid(),
                    attr: this.csv,
                    callback: dojoLang.hitch(this, function (guid, attr, attrValue) {
                        this._updateRendering();
                    })
                });
				
                this._handles = [ objectHandle, attrHandle ];
            }
        },
		
		_executeCallback: function (cb, from) {
            this.log("._executeCallback" + (from ? " from " + from : ""));
            if (cb && typeof cb === "function") {
                cb();
            }
        }
    });
});

require(["CSVasTable/widget/CSVasTable"]);

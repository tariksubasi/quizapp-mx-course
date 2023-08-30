ALTER TABLE "solver$solvertest" ADD "teststatus" VARCHAR_IGNORECASE(8) NULL;
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('2ab9033a-ae35-4cce-ae7f-4ab536809ed4', '50032e86-aa25-486c-91d3-93213ba10b36', 'TestStatus', 'teststatus', 40, 8, '', false);
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230830 13:43:14';

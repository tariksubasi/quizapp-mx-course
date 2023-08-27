ALTER TABLE "solver$solvertest" ADD "testname" VARCHAR_IGNORECASE(200) NULL;
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('f8c36258-6f2f-4d4b-9378-2d323cc53116', '50032e86-aa25-486c-91d3-93213ba10b36', 'TestName', 'testname', 30, 200, '', false);
CREATE TABLE "randomobject$exampleobject" (
	"id" BIGINT NOT NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "remote", "remote_primary_key") VALUES ('a4615add-fcbc-4bae-b8e6-ce9ca4297e62', 'RandomObject.ExampleObject', 'randomobject$exampleobject', false, false);
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230827 12:48:52';

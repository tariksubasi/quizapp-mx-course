ALTER TABLE "quizapp$remoteobject" ADD "submetaobjectname" VARCHAR_IGNORECASE(255) NULL;
UPDATE "quizapp$remoteobject" SET "submetaobjectname" = 'QuizApp.RemoteObject';
CREATE INDEX "idx_quizapp$remoteobject_submetaobjectname_asc" ON "quizapp$remoteobject" ("submetaobjectname" ASC,"id" ASC);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('2556cd71-8043-3c76-94da-f4c0b540ea90', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'submetaobjectname', 'submetaobjectname', 30, 255, 'QuizApp.RemoteObject', false);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('335287f3-127b-3d39-9906-b47b012d3f8f', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'idx_quizapp$remoteobject_submetaobjectname_asc');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('335287f3-127b-3d39-9906-b47b012d3f8f', '2556cd71-8043-3c76-94da-f4c0b540ea90', false, 0);
CREATE TABLE "quizapp$car" (
	"id" BIGINT NOT NULL,
	"taxamount" DECIMAL(28, 8) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('8e339268-b159-4aa2-abd5-eba3a4daeda6', 'QuizApp.Car', 'quizapp$car', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('4c13b36c-c116-4dee-b664-e719eef1f325', '8e339268-b159-4aa2-abd5-eba3a4daeda6', 'TaxAmount', 'taxamount', 5, 0, '0', false);
CREATE TABLE "quizapp$motorcycle" (
	"id" BIGINT NOT NULL,
	"taxamount" DECIMAL(28, 8) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('97f4708f-1b0b-4d56-85ea-f0da5b115381', 'QuizApp.MotorCycle', 'quizapp$motorcycle', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('0b425060-10cb-4b39-928c-e71319c85edd', '97f4708f-1b0b-4d56-85ea-f0da5b115381', 'TaxAmount', 'taxamount', 5, 0, '0', false);
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230813 12:09:09';

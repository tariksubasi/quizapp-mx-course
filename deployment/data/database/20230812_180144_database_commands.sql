CREATE TABLE "oql$csvdownload" (
	"id" BIGINT NOT NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('a04645e5-f2f0-43df-be5c-94002924ae0e', 'OQL.CSVDownload', 'oql$csvdownload', '170ce49d-f29c-4fac-99a6-b55e8a3aeb39', false, false);
CREATE TABLE "quizapp$remoteobject" (
	"id" BIGINT NOT NULL,
	"_id" VARCHAR_IGNORECASE(200) NULL,
	"customcreateddate" TIMESTAMP NULL,
	"customchangeddate" TIMESTAMP NULL,
	"customcreateddateaslong" BIGINT NULL,
	"customchangeddateaslong" BIGINT NULL,
	"createddate" TIMESTAMP NULL,
	"changeddate" TIMESTAMP NULL,
	"system$owner" BIGINT NULL,
	"system$changedby" BIGINT NULL,
	PRIMARY KEY("id"));
CREATE INDEX "idx_quizapp$remoteobject_system$owner" ON "quizapp$remoteobject" ("system$owner" ASC,"id" ASC);
CREATE INDEX "idx_quizapp$remoteobject_system$changedby" ON "quizapp$remoteobject" ("system$changedby" ASC,"id" ASC);
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "remote", "remote_primary_key") VALUES ('eae3b556-6a28-4bad-92cb-5419749311c9', 'QuizApp.RemoteObject', 'quizapp$remoteobject', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('f852daab-fdca-45c9-a43c-0a8298331b25', 'eae3b556-6a28-4bad-92cb-5419749311c9', '_Id', '_id', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('92d477de-fa50-46b1-bf99-364bf875e20c', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'CustomCreatedDate', 'customcreateddate', 20, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('36341592-2c11-484a-950d-40e6342c3fe4', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'CustomChangedDate', 'customchangeddate', 20, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('45f75de2-5b0d-42aa-8d28-ae5ca1559878', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'CustomCreatedDateAsLong', 'customcreateddateaslong', 4, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('39ee5280-c2b8-443d-ae40-cf46064a50cc', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'CustomChangedDateAsLong', 'customchangeddateaslong', 4, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('1ffd2103-0d55-3ff8-9a76-f053d526d0fe', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'createdDate', 'createddate', 20, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('f9c71eeb-e19f-3bdf-a89d-5d47f63cc288', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'changedDate', 'changeddate', 20, 0, '', false);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('46cda4ad-7175-3ba0-9ed1-118fe2f91a5c', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'idx_quizapp$remoteobject_system$owner');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('46cda4ad-7175-3ba0-9ed1-118fe2f91a5c', 'a3723c27-4a55-3334-839b-a0b0e06d78c9', false, 0);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('817b0157-c72f-3c9c-bfd8-759940c73c11', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'idx_quizapp$remoteobject_system$changedby');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('817b0157-c72f-3c9c-bfd8-759940c73c11', 'e05b1fb3-37f0-3173-92e0-413aaec3b066', false, 0);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name") VALUES ('a3723c27-4a55-3334-839b-a0b0e06d78c9', 'System.owner', 'system$owner', 'eae3b556-6a28-4bad-92cb-5419749311c9', '282e2e60-88a5-469d-84a5-ba8d9151644f', 'id', 'system$owner');
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name") VALUES ('e05b1fb3-37f0-3173-92e0-413aaec3b066', 'System.changedBy', 'system$changedby', 'eae3b556-6a28-4bad-92cb-5419749311c9', '282e2e60-88a5-469d-84a5-ba8d9151644f', 'id', 'system$changedby');
CREATE TABLE "oql$exampleperson" (
	"id" BIGINT NOT NULL,
	"number" BIGINT NULL,
	"name" VARCHAR_IGNORECASE(200) NULL,
	"dateofbirth" TIMESTAMP NULL,
	"age" INT NULL,
	"longage" BIGINT NULL,
	"active" BOOLEAN NULL,
	"heightindecimal" DECIMAL(28, 8) NULL,
	"gender" VARCHAR_IGNORECASE(6) NULL,
	PRIMARY KEY("id"));
CREATE SEQUENCE "oql$exampleperson_number_mxseq" AS BIGINT START WITH 1;
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "remote", "remote_primary_key") VALUES ('641062f1-a582-40f2-bd72-915049299902', 'OQL.ExamplePerson', 'oql$exampleperson', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('e953fba8-f7ea-43a5-b8b5-9a4d185efa63', '641062f1-a582-40f2-bd72-915049299902', 'Number', 'number', 0, 0, '1', true);
INSERT INTO "mendixsystem$sequence" ("attribute_id", "name", "start_value", "current_value") VALUES ('e953fba8-f7ea-43a5-b8b5-9a4d185efa63', 'oql$exampleperson_number_mxseq', 1, 0);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('2b70b21f-ca0b-47e8-8e39-945307273adc', '641062f1-a582-40f2-bd72-915049299902', 'Name', 'name', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('67558714-187a-465b-bf39-15997f14e9ef', '641062f1-a582-40f2-bd72-915049299902', 'DateOfBirth', 'dateofbirth', 20, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('d99e6588-17ca-4002-8b22-3efa671c175a', '641062f1-a582-40f2-bd72-915049299902', 'Age', 'age', 3, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('ba854bb5-9bd7-47d0-98d9-e6cbe9432ac4', '641062f1-a582-40f2-bd72-915049299902', 'LongAge', 'longage', 4, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('67e7f01c-85a5-4bb2-810d-6601100fb0df', '641062f1-a582-40f2-bd72-915049299902', 'Active', 'active', 10, 0, 'false', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('e8cfb043-ee93-403d-bb0a-c558952fde41', '641062f1-a582-40f2-bd72-915049299902', 'HeightInDecimal', 'heightindecimal', 5, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('e9607f13-ceee-48c9-9e7c-b6d326c54cd8', '641062f1-a582-40f2-bd72-915049299902', 'Gender', 'gender', 40, 6, '', false);
CREATE TABLE "quizapp$remoteobject_account_changedby" (
	"quizapp$remoteobjectid" BIGINT NOT NULL,
	"administration$accountid" BIGINT NOT NULL,
	PRIMARY KEY("quizapp$remoteobjectid","administration$accountid"),
	CONSTRAINT "uniq_quizapp$remoteobject_account_changedby_quizapp$remoteobjectid" UNIQUE ("quizapp$remoteobjectid"));
CREATE INDEX "idx_quizapp$remoteobject_account_changedby_administration$account_quizapp$remoteobject" ON "quizapp$remoteobject_account_changedby" ("administration$accountid" ASC,"quizapp$remoteobjectid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('85fab805-79f6-4f7e-bdcc-85b7fe3142e4', 'QuizApp.RemoteObject_Account_ChangedBy', 'quizapp$remoteobject_account_changedby', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'c921ccbb-a670-48d9-833d-6a76c1406917', 'quizapp$remoteobjectid', 'administration$accountid', 'idx_quizapp$remoteobject_account_changedby_administration$account_quizapp$remoteobject');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_quizapp$remoteobject_account_changedby_quizapp$remoteobjectid', '85fab805-79f6-4f7e-bdcc-85b7fe3142e4', 'e21dbf72-82b2-3956-af15-f57120bdc1db');
CREATE TABLE "quizapp$remoteobject_account_createdby" (
	"quizapp$remoteobjectid" BIGINT NOT NULL,
	"administration$accountid" BIGINT NOT NULL,
	PRIMARY KEY("quizapp$remoteobjectid","administration$accountid"),
	CONSTRAINT "uniq_quizapp$remoteobject_account_createdby_quizapp$remoteobjectid" UNIQUE ("quizapp$remoteobjectid"));
CREATE INDEX "idx_quizapp$remoteobject_account_createdby_administration$account_quizapp$remoteobject" ON "quizapp$remoteobject_account_createdby" ("administration$accountid" ASC,"quizapp$remoteobjectid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('a0124147-9107-4f47-b441-c3dc18c75182', 'QuizApp.RemoteObject_Account_CreatedBy', 'quizapp$remoteobject_account_createdby', 'eae3b556-6a28-4bad-92cb-5419749311c9', 'c921ccbb-a670-48d9-833d-6a76c1406917', 'quizapp$remoteobjectid', 'administration$accountid', 'idx_quizapp$remoteobject_account_createdby_administration$account_quizapp$remoteobject');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_quizapp$remoteobject_account_createdby_quizapp$remoteobjectid', 'a0124147-9107-4f47-b441-c3dc18c75182', 'e983ba81-4dda-3cb1-a0a9-d121a2110ad6');
CREATE TABLE "oql$marriedto" (
	"oql$examplepersonid1" BIGINT NOT NULL,
	"oql$examplepersonid2" BIGINT NOT NULL,
	PRIMARY KEY("oql$examplepersonid1","oql$examplepersonid2"),
	CONSTRAINT "uniq_oql$marriedto_oql$examplepersonid1" UNIQUE ("oql$examplepersonid1"));
CREATE INDEX "idx_oql$marriedto_oql$exampleperson_oql$exampleperson" ON "oql$marriedto" ("oql$examplepersonid2" ASC,"oql$examplepersonid1" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('5f2d0946-aaa2-44f5-b44a-d66b046f9866', 'OQL.MarriedTo', 'oql$marriedto', '641062f1-a582-40f2-bd72-915049299902', '641062f1-a582-40f2-bd72-915049299902', 'oql$examplepersonid1', 'oql$examplepersonid2', 'idx_oql$marriedto_oql$exampleperson_oql$exampleperson');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_oql$marriedto_oql$examplepersonid1', '5f2d0946-aaa2-44f5-b44a-d66b046f9866', 'afaf6aa6-743e-3e58-9898-8ceb3ea17cd0');
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230812 18:01:44';

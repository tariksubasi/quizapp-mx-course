CREATE TABLE "quizapp$pdfdocument" (
	"id" BIGINT NOT NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('5641cf1f-22f2-4b69-b181-a774228181c1', 'QuizApp.PDFDocument', 'quizapp$pdfdocument', '170ce49d-f29c-4fac-99a6-b55e8a3aeb39', false, false);
CREATE TABLE "documentgeneration$documentrequest" (
	"id" BIGINT NOT NULL,
	"requestid" VARCHAR_IGNORECASE(200) NULL,
	"filename" VARCHAR_IGNORECASE(200) NULL,
	"resultentity" VARCHAR_IGNORECASE(200) NULL,
	"microflowname" VARCHAR_IGNORECASE(200) NULL,
	"contextobjectguid" BIGINT NULL,
	"securitytoken" VARCHAR_IGNORECASE(200) NULL,
	"expirationdate" TIMESTAMP NULL,
	"createddate" TIMESTAMP NULL,
	PRIMARY KEY("id"),
	CONSTRAINT "uniq_documentgeneration$documentrequest_requestid" UNIQUE ("requestid"));
CREATE INDEX "idx_documentgeneration$documentrequest_requestid_asc" ON "documentgeneration$documentrequest" ("requestid" ASC,"id" ASC);
CREATE INDEX "idx_documentgeneration$documentrequest_expirationdate_asc" ON "documentgeneration$documentrequest" ("expirationdate" ASC,"id" ASC);
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "remote", "remote_primary_key") VALUES ('f9d96778-9236-454f-82fe-9cabc9137d76', 'DocumentGeneration.DocumentRequest', 'documentgeneration$documentrequest', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('558547aa-5f28-4929-b982-6a3ea1735f10', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'RequestId', 'requestid', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('0fd04865-7be8-41e9-8611-52dc5b41ca42', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'FileName', 'filename', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('b881cfb0-f471-4054-a38b-a7516e171ffc', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'ResultEntity', 'resultentity', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('500b150b-1fda-41eb-88cd-b142339c4043', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'MicroflowName', 'microflowname', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('f64f2373-bc09-4250-bfb1-bce929f976a1', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'ContextObjectGuid', 'contextobjectguid', 4, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('ae6ad481-629c-4215-919f-f642b85e1e6f', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'SecurityToken', 'securitytoken', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('8fbe3645-cf7d-4261-90b3-795ae2b5b36e', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'ExpirationDate', 'expirationdate', 20, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('f43d3d0d-aaa4-3d09-a348-a1eb9735c573', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'createdDate', 'createddate', 20, 0, '', false);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('757f5ed1-68af-469e-9c16-7b8ebe2c0cc9', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'idx_documentgeneration$documentrequest_requestid_asc');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('757f5ed1-68af-469e-9c16-7b8ebe2c0cc9', '558547aa-5f28-4929-b982-6a3ea1735f10', false, 0);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('a1e51bfa-5385-4662-bed7-1a6b3546691d', 'f9d96778-9236-454f-82fe-9cabc9137d76', 'idx_documentgeneration$documentrequest_expirationdate_asc');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('a1e51bfa-5385-4662-bed7-1a6b3546691d', '8fbe3645-cf7d-4261-90b3-795ae2b5b36e', false, 0);
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_documentgeneration$documentrequest_requestid', 'f9d96778-9236-454f-82fe-9cabc9137d76', '558547aa-5f28-4929-b982-6a3ea1735f10');
CREATE TABLE "documentgeneration$configuration" (
	"id" BIGINT NOT NULL,
	"registrationstatus" VARCHAR_IGNORECASE(12) NULL,
	"applicationurl" VARCHAR_IGNORECASE(200) NULL,
	"accesstoken" VARCHAR_IGNORECASE(2147483647) NULL,
	"accesstokenexpirationdate" TIMESTAMP NULL,
	"refreshtoken" VARCHAR_IGNORECASE(2147483647) NULL,
	"verificationtoken" VARCHAR_IGNORECASE(200) NULL,
	"verificationtokenexpirationdate" TIMESTAMP NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "remote", "remote_primary_key") VALUES ('773594d9-99ef-41b0-b6fb-59b6bcb22519', 'DocumentGeneration.Configuration', 'documentgeneration$configuration', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('fba7ca67-94ae-4861-8b77-014e50104c6c', '773594d9-99ef-41b0-b6fb-59b6bcb22519', 'RegistrationStatus', 'registrationstatus', 40, 12, 'Unregistered', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('e42419a2-233d-4d60-a70b-a01447c16b4f', '773594d9-99ef-41b0-b6fb-59b6bcb22519', 'ApplicationUrl', 'applicationurl', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('c9bac10c-0f21-42ca-adcd-f3597272d6ba', '773594d9-99ef-41b0-b6fb-59b6bcb22519', 'AccessToken', 'accesstoken', 30, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('443036b8-4931-4ef2-81d2-37f9d1ce3390', '773594d9-99ef-41b0-b6fb-59b6bcb22519', 'AccessTokenExpirationDate', 'accesstokenexpirationdate', 20, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('d1ea762f-ff34-4699-aea1-bcb5f202b627', '773594d9-99ef-41b0-b6fb-59b6bcb22519', 'RefreshToken', 'refreshtoken', 30, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('78fb1848-6954-4892-91e7-0c43c52a5cd1', '773594d9-99ef-41b0-b6fb-59b6bcb22519', 'VerificationToken', 'verificationtoken', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('eec9ac72-dc89-4243-bf8c-4be884cdb803', '773594d9-99ef-41b0-b6fb-59b6bcb22519', 'VerificationTokenExpirationDate', 'verificationtokenexpirationdate', 20, 0, '', false);
CREATE TABLE "documentgeneration$documentrequest_documentuser" (
	"documentgeneration$documentrequestid" BIGINT NOT NULL,
	"system$userid" BIGINT NOT NULL,
	PRIMARY KEY("documentgeneration$documentrequestid","system$userid"),
	CONSTRAINT "uniq_documentgeneration$documentrequest_documentuser_documentgeneration$documentrequestid" UNIQUE ("documentgeneration$documentrequestid"));
CREATE INDEX "idx_documentgeneration$documentrequest_documentuser_system$user_documentgeneration$documentrequest" ON "documentgeneration$documentrequest_documentuser" ("system$userid" ASC,"documentgeneration$documentrequestid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('870a5d19-f4ba-45d1-a36d-631c9ac2aaea', 'DocumentGeneration.DocumentRequest_DocumentUser', 'documentgeneration$documentrequest_documentuser', 'f9d96778-9236-454f-82fe-9cabc9137d76', '282e2e60-88a5-469d-84a5-ba8d9151644f', 'documentgeneration$documentrequestid', 'system$userid', 'idx_documentgeneration$documentrequest_documentuser_system$user_documentgeneration$documentrequest');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_documentgeneration$documentrequest_documentuser_documentgeneration$documentrequestid', '870a5d19-f4ba-45d1-a36d-631c9ac2aaea', '6a9e930e-57a3-3821-83ad-02b5a6d5303c');
CREATE TABLE "documentgeneration$documentrequest_filedocument" (
	"documentgeneration$documentrequestid" BIGINT NOT NULL,
	"system$filedocumentid" BIGINT NOT NULL,
	PRIMARY KEY("documentgeneration$documentrequestid","system$filedocumentid"),
	CONSTRAINT "uniq_documentgeneration$documentrequest_filedocument_documentgeneration$documentrequestid" UNIQUE ("documentgeneration$documentrequestid"));
CREATE INDEX "idx_documentgeneration$documentrequest_filedocument_system$filedocument_documentgeneration$documentrequest" ON "documentgeneration$documentrequest_filedocument" ("system$filedocumentid" ASC,"documentgeneration$documentrequestid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('2c208574-e905-4a8d-b2b3-19b18a8ff510', 'DocumentGeneration.DocumentRequest_FileDocument', 'documentgeneration$documentrequest_filedocument', 'f9d96778-9236-454f-82fe-9cabc9137d76', '170ce49d-f29c-4fac-99a6-b55e8a3aeb39', 'documentgeneration$documentrequestid', 'system$filedocumentid', 'idx_documentgeneration$documentrequest_filedocument_system$filedocument_documentgeneration$documentrequest');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_documentgeneration$documentrequest_filedocument_documentgeneration$documentrequestid', '2c208574-e905-4a8d-b2b3-19b18a8ff510', '7ad602f9-542a-3265-98cd-f0f266fd6345');
CREATE TABLE "documentgeneration$documentrequest_session" (
	"documentgeneration$documentrequestid" BIGINT NOT NULL,
	"system$sessionid" BIGINT NOT NULL,
	PRIMARY KEY("documentgeneration$documentrequestid","system$sessionid"),
	CONSTRAINT "uniq_documentgeneration$documentrequest_session_documentgeneration$documentrequestid" UNIQUE ("documentgeneration$documentrequestid"));
CREATE INDEX "idx_documentgeneration$documentrequest_session_system$session_documentgeneration$documentrequest" ON "documentgeneration$documentrequest_session" ("system$sessionid" ASC,"documentgeneration$documentrequestid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('2575e7b4-69c8-4a4a-937d-69dcbb58891a', 'DocumentGeneration.DocumentRequest_Session', 'documentgeneration$documentrequest_session', 'f9d96778-9236-454f-82fe-9cabc9137d76', '37f9fd49-5318-4c63-9a51-f761779b202f', 'documentgeneration$documentrequestid', 'system$sessionid', 'idx_documentgeneration$documentrequest_session_system$session_documentgeneration$documentrequest');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_documentgeneration$documentrequest_session_documentgeneration$documentrequestid', '2575e7b4-69c8-4a4a-937d-69dcbb58891a', '51d11720-d7e1-3778-96a3-2144a420042b');
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230909 16:11:01';

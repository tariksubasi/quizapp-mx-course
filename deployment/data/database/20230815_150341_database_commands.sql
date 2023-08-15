CREATE TABLE "extensions$city" (
	"id" BIGINT NOT NULL,
	"name" VARCHAR_IGNORECASE(200) NULL,
	"createddate" TIMESTAMP NULL,
	"changeddate" TIMESTAMP NULL,
	"system$owner" BIGINT NULL,
	"system$changedby" BIGINT NULL,
	PRIMARY KEY("id"));
CREATE INDEX "idx_extensions$city_system$owner" ON "extensions$city" ("system$owner" ASC,"id" ASC);
CREATE INDEX "idx_extensions$city_system$changedby" ON "extensions$city" ("system$changedby" ASC,"id" ASC);
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "remote", "remote_primary_key") VALUES ('70271641-51a7-441a-8b2a-9429cc8041e8', 'Extensions.City', 'extensions$city', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('8ac64a84-f9af-4e18-8d0f-8a51e31bca99', '70271641-51a7-441a-8b2a-9429cc8041e8', 'Name', 'name', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('32f02377-a161-3bd3-84c3-6d706368fb13', '70271641-51a7-441a-8b2a-9429cc8041e8', 'createdDate', 'createddate', 20, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('357f6904-de9c-3ead-b4cb-d207baa43ce2', '70271641-51a7-441a-8b2a-9429cc8041e8', 'changedDate', 'changeddate', 20, 0, '', false);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('e42c0f46-3fd5-358f-ad5c-302906d3c3a6', '70271641-51a7-441a-8b2a-9429cc8041e8', 'idx_extensions$city_system$owner');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('e42c0f46-3fd5-358f-ad5c-302906d3c3a6', 'bfb80810-866a-3cf7-8899-8d019d12d9f0', false, 0);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('f6065a62-1c2f-3c44-936e-1e463a24ee99', '70271641-51a7-441a-8b2a-9429cc8041e8', 'idx_extensions$city_system$changedby');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('f6065a62-1c2f-3c44-936e-1e463a24ee99', 'ac06d04b-2af4-3731-8513-73bf7bc342e1', false, 0);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name") VALUES ('bfb80810-866a-3cf7-8899-8d019d12d9f0', 'System.owner', 'system$owner', '70271641-51a7-441a-8b2a-9429cc8041e8', '282e2e60-88a5-469d-84a5-ba8d9151644f', 'id', 'system$owner');
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name") VALUES ('ac06d04b-2af4-3731-8513-73bf7bc342e1', 'System.changedBy', 'system$changedby', '70271641-51a7-441a-8b2a-9429cc8041e8', '282e2e60-88a5-469d-84a5-ba8d9151644f', 'id', 'system$changedby');
CREATE TABLE "extensions$country" (
	"id" BIGINT NOT NULL,
	"name" VARCHAR_IGNORECASE(200) NULL,
	"createddate" TIMESTAMP NULL,
	"changeddate" TIMESTAMP NULL,
	"system$owner" BIGINT NULL,
	"system$changedby" BIGINT NULL,
	PRIMARY KEY("id"));
CREATE INDEX "idx_extensions$country_system$owner" ON "extensions$country" ("system$owner" ASC,"id" ASC);
CREATE INDEX "idx_extensions$country_system$changedby" ON "extensions$country" ("system$changedby" ASC,"id" ASC);
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "remote", "remote_primary_key") VALUES ('87e52d8a-d5b2-406b-98b9-f0fede462011', 'Extensions.Country', 'extensions$country', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('22d121d6-72cf-4f19-9e13-ab63fd2a59f4', '87e52d8a-d5b2-406b-98b9-f0fede462011', 'Name', 'name', 30, 200, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('1eb58021-1adc-3511-9d25-a57f8e560df6', '87e52d8a-d5b2-406b-98b9-f0fede462011', 'createdDate', 'createddate', 20, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('3bf9f6f7-dd7f-327f-9dad-5d55a2b76fc9', '87e52d8a-d5b2-406b-98b9-f0fede462011', 'changedDate', 'changeddate', 20, 0, '', false);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('38816667-aba1-379d-995d-5dbc4407b288', '87e52d8a-d5b2-406b-98b9-f0fede462011', 'idx_extensions$country_system$owner');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('38816667-aba1-379d-995d-5dbc4407b288', '6071e6f6-33ad-32e1-8e06-6ef065da37dd', false, 0);
INSERT INTO "mendixsystem$index" ("id", "table_id", "index_name") VALUES ('c3104678-60d1-33d7-97b8-861da1c0d134', '87e52d8a-d5b2-406b-98b9-f0fede462011', 'idx_extensions$country_system$changedby');
INSERT INTO "mendixsystem$index_column" ("index_id", "column_id", "sort_order", "ordinal") VALUES ('c3104678-60d1-33d7-97b8-861da1c0d134', 'c815b8ca-131e-3c67-b344-5d6eb40f9f94', false, 0);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name") VALUES ('6071e6f6-33ad-32e1-8e06-6ef065da37dd', 'System.owner', 'system$owner', '87e52d8a-d5b2-406b-98b9-f0fede462011', '282e2e60-88a5-469d-84a5-ba8d9151644f', 'id', 'system$owner');
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name") VALUES ('c815b8ca-131e-3c67-b344-5d6eb40f9f94', 'System.changedBy', 'system$changedby', '87e52d8a-d5b2-406b-98b9-f0fede462011', '282e2e60-88a5-469d-84a5-ba8d9151644f', 'id', 'system$changedby');
CREATE TABLE "administration$account_city" (
	"administration$accountid" BIGINT NOT NULL,
	"extensions$cityid" BIGINT NOT NULL,
	PRIMARY KEY("administration$accountid","extensions$cityid"),
	CONSTRAINT "uniq_administration$account_city_administration$accountid" UNIQUE ("administration$accountid"));
CREATE INDEX "idx_administration$account_city_extensions$city_administration$account" ON "administration$account_city" ("extensions$cityid" ASC,"administration$accountid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('925ed09a-1e69-4cf6-8461-23180cfd1799', 'Administration.Account_City', 'administration$account_city', 'c921ccbb-a670-48d9-833d-6a76c1406917', '70271641-51a7-441a-8b2a-9429cc8041e8', 'administration$accountid', 'extensions$cityid', 'idx_administration$account_city_extensions$city_administration$account');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_administration$account_city_administration$accountid', '925ed09a-1e69-4cf6-8461-23180cfd1799', '866e3f6e-3cf6-3243-955c-b0bb871e1eab');
CREATE TABLE "extensions$city_country" (
	"extensions$cityid" BIGINT NOT NULL,
	"extensions$countryid" BIGINT NOT NULL,
	PRIMARY KEY("extensions$cityid","extensions$countryid"),
	CONSTRAINT "uniq_extensions$city_country_extensions$cityid" UNIQUE ("extensions$cityid"));
CREATE INDEX "idx_extensions$city_country_extensions$country_extensions$city" ON "extensions$city_country" ("extensions$countryid" ASC,"extensions$cityid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('67225831-d35f-4076-b4da-369b57adf081', 'Extensions.City_Country', 'extensions$city_country', '70271641-51a7-441a-8b2a-9429cc8041e8', '87e52d8a-d5b2-406b-98b9-f0fede462011', 'extensions$cityid', 'extensions$countryid', 'idx_extensions$city_country_extensions$country_extensions$city');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_extensions$city_country_extensions$cityid', '67225831-d35f-4076-b4da-369b57adf081', 'ab6d9374-4f7a-34af-95fd-c87e570195df');
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230815 15:03:41';

CREATE TABLE "builder$question" (
	"id" BIGINT NOT NULL,
	"questionid" BIGINT NULL,
	"questionbody" VARCHAR_IGNORECASE(2147483647) NULL,
	"optiona" VARCHAR_IGNORECASE(2147483647) NULL,
	"optionb" VARCHAR_IGNORECASE(2147483647) NULL,
	"optionc" VARCHAR_IGNORECASE(2147483647) NULL,
	"optiond" VARCHAR_IGNORECASE(2147483647) NULL,
	"answer" VARCHAR_IGNORECASE(1) NULL,
	"sort" INT NULL,
	PRIMARY KEY("id"));
CREATE SEQUENCE "builder$question_questionid_mxseq" AS BIGINT START WITH 1;
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('387272c2-bf38-429e-84e2-4ffe48e43b5f', 'Builder.Question', 'builder$question', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('73e8da6a-a5bd-4cf9-9e85-b6f05b2faaf8', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'QuestionId', 'questionid', 0, 0, '1', true);
INSERT INTO "mendixsystem$sequence" ("attribute_id", "name", "start_value", "current_value") VALUES ('73e8da6a-a5bd-4cf9-9e85-b6f05b2faaf8', 'builder$question_questionid_mxseq', 1, 0);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('bac1172f-1781-41aa-bb1e-b9f3f579e829', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'QuestionBody', 'questionbody', 30, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('7f9fba12-00e6-473a-9a18-e9683083d0b4', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'OptionA', 'optiona', 30, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('1f0d9520-6c94-4e5c-99ee-866eefae7e5c', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'OptionB', 'optionb', 30, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('d0d47863-5f20-4ad9-a7e2-2edc907dc727', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'OptionC', 'optionc', 30, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('229d4f9a-7d6c-4725-a4ed-cafd5bd21292', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'OptionD', 'optiond', 30, 0, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('aa39d293-aaf9-4522-8fe1-ad3610d6159e', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'Answer', 'answer', 40, 1, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('c3c01c6b-3ac2-446e-81cf-d502f4edca1a', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'Sort', 'sort', 3, 0, '0', false);
CREATE TABLE "builder$test" (
	"id" BIGINT NOT NULL,
	"testid" BIGINT NULL,
	"testname" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
CREATE SEQUENCE "builder$test_testid_mxseq" AS BIGINT START WITH 1;
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('86a0b5be-2631-4e1d-a72a-c7a1c5e904b6', 'Builder.Test', 'builder$test', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('f7bdd4fc-7f27-486b-bdad-f0cfbdc69681', '86a0b5be-2631-4e1d-a72a-c7a1c5e904b6', 'TestId', 'testid', 0, 0, '1', true);
INSERT INTO "mendixsystem$sequence" ("attribute_id", "name", "start_value", "current_value") VALUES ('f7bdd4fc-7f27-486b-bdad-f0cfbdc69681', 'builder$test_testid_mxseq', 1, 0);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('98b28830-6f7b-4372-be3a-431147cf2d22', '86a0b5be-2631-4e1d-a72a-c7a1c5e904b6', 'TestName', 'testname', 30, 200, '', false);
CREATE TABLE "builder$question_test" (
	"builder$questionid" BIGINT NOT NULL,
	"builder$testid" BIGINT NOT NULL,
	PRIMARY KEY("builder$questionid","builder$testid"),
	CONSTRAINT "uniq_builder$question_test_builder$questionid" UNIQUE ("builder$questionid"));
CREATE INDEX "idx_builder$question_test_builder$test_builder$question" ON "builder$question_test" ("builder$testid" ASC,"builder$questionid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('ab03ceda-6964-4ae2-b335-e34b6b223f02', 'Builder.Question_Test', 'builder$question_test', '387272c2-bf38-429e-84e2-4ffe48e43b5f', '86a0b5be-2631-4e1d-a72a-c7a1c5e904b6', 'builder$questionid', 'builder$testid', 'idx_builder$question_test_builder$test_builder$question');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_builder$question_test_builder$questionid', 'ab03ceda-6964-4ae2-b335-e34b6b223f02', '946843df-31f4-34ea-9428-25d8609d1d0f');
CREATE TABLE "builder$test_lecture" (
	"builder$testid" BIGINT NOT NULL,
	"builder$lectureid" BIGINT NOT NULL,
	PRIMARY KEY("builder$testid","builder$lectureid"),
	CONSTRAINT "uniq_builder$test_lecture_builder$testid" UNIQUE ("builder$testid"));
CREATE INDEX "idx_builder$test_lecture_builder$lecture_builder$test" ON "builder$test_lecture" ("builder$lectureid" ASC,"builder$testid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('a71bb1f9-8282-4b25-b8bf-e5928c36e231', 'Builder.Test_Lecture', 'builder$test_lecture', '86a0b5be-2631-4e1d-a72a-c7a1c5e904b6', 'eb950f9d-2e54-447e-a8b4-a61bf7b0273b', 'builder$testid', 'builder$lectureid', 'idx_builder$test_lecture_builder$lecture_builder$test');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_builder$test_lecture_builder$testid', 'a71bb1f9-8282-4b25-b8bf-e5928c36e231', 'eee01c4f-e09b-3b8b-a901-676036241ceb');
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230819 19:11:26';

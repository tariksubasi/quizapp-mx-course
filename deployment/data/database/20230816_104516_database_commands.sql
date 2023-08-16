CREATE TABLE "builder$lecture" (
	"id" BIGINT NOT NULL,
	"lectureid" BIGINT NULL,
	"lecturename" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
CREATE SEQUENCE "builder$lecture_lectureid_mxseq" AS BIGINT START WITH 1;
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('eb950f9d-2e54-447e-a8b4-a61bf7b0273b', 'Builder.Lecture', 'builder$lecture', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('b7ed237b-937b-498f-8f70-0e9671a186f2', 'eb950f9d-2e54-447e-a8b4-a61bf7b0273b', 'LectureId', 'lectureid', 0, 0, '1', true);
INSERT INTO "mendixsystem$sequence" ("attribute_id", "name", "start_value", "current_value") VALUES ('b7ed237b-937b-498f-8f70-0e9671a186f2', 'builder$lecture_lectureid_mxseq', 1, 0);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('8e37ff77-daa7-451d-afe7-29a5b1bc7def', 'eb950f9d-2e54-447e-a8b4-a61bf7b0273b', 'LectureName', 'lecturename', 30, 200, '', false);
CREATE TABLE "builder$school" (
	"id" BIGINT NOT NULL,
	"schoolid" BIGINT NULL,
	"schooltype" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
CREATE SEQUENCE "builder$school_schoolid_mxseq" AS BIGINT START WITH 1;
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('e7ab7200-8014-41e8-b8de-a382efee5eec', 'Builder.School', 'builder$school', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('04166baa-40a8-459f-97f6-2d533055f6de', 'e7ab7200-8014-41e8-b8de-a382efee5eec', 'SchoolId', 'schoolid', 0, 0, '1', true);
INSERT INTO "mendixsystem$sequence" ("attribute_id", "name", "start_value", "current_value") VALUES ('04166baa-40a8-459f-97f6-2d533055f6de', 'builder$school_schoolid_mxseq', 1, 0);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('b921d166-f739-4f50-b901-25a2e21d65ad', 'e7ab7200-8014-41e8-b8de-a382efee5eec', 'SchoolType', 'schooltype', 30, 200, '', false);
CREATE TABLE "builder$course" (
	"id" BIGINT NOT NULL,
	"courseid" BIGINT NULL,
	"coursename" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
CREATE SEQUENCE "builder$course_courseid_mxseq" AS BIGINT START WITH 1;
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('84c944ab-026a-4132-bb7e-a50ef9a17df2', 'Builder.Course', 'builder$course', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('0eb47b24-2dfa-459b-8b35-f9e9a7c67006', '84c944ab-026a-4132-bb7e-a50ef9a17df2', 'CourseId', 'courseid', 0, 0, '1', true);
INSERT INTO "mendixsystem$sequence" ("attribute_id", "name", "start_value", "current_value") VALUES ('0eb47b24-2dfa-459b-8b35-f9e9a7c67006', 'builder$course_courseid_mxseq', 1, 0);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('f5304138-4f68-4520-8c61-7d2459ec2a55', '84c944ab-026a-4132-bb7e-a50ef9a17df2', 'CourseName', 'coursename', 30, 200, '', false);
CREATE TABLE "builder$lecture_course" (
	"builder$lectureid" BIGINT NOT NULL,
	"builder$courseid" BIGINT NOT NULL,
	PRIMARY KEY("builder$lectureid","builder$courseid"),
	CONSTRAINT "uniq_builder$lecture_course_builder$lectureid" UNIQUE ("builder$lectureid"));
CREATE INDEX "idx_builder$lecture_course_builder$course_builder$lecture" ON "builder$lecture_course" ("builder$courseid" ASC,"builder$lectureid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('4c0682ae-f457-46b0-834c-74f0ad374b94', 'Builder.Lecture_Course', 'builder$lecture_course', 'eb950f9d-2e54-447e-a8b4-a61bf7b0273b', '84c944ab-026a-4132-bb7e-a50ef9a17df2', 'builder$lectureid', 'builder$courseid', 'idx_builder$lecture_course_builder$course_builder$lecture');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_builder$lecture_course_builder$lectureid', '4c0682ae-f457-46b0-834c-74f0ad374b94', 'c2d01ba3-ce39-392d-b86c-347c8d319d37');
CREATE TABLE "builder$course_school" (
	"builder$courseid" BIGINT NOT NULL,
	"builder$schoolid" BIGINT NOT NULL,
	PRIMARY KEY("builder$courseid","builder$schoolid"),
	CONSTRAINT "uniq_builder$course_school_builder$courseid" UNIQUE ("builder$courseid"));
CREATE INDEX "idx_builder$course_school_builder$school_builder$course" ON "builder$course_school" ("builder$schoolid" ASC,"builder$courseid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('f12f39b4-5dda-4705-9407-a39953e8c9e5', 'Builder.Course_School', 'builder$course_school', '84c944ab-026a-4132-bb7e-a50ef9a17df2', 'e7ab7200-8014-41e8-b8de-a382efee5eec', 'builder$courseid', 'builder$schoolid', 'idx_builder$course_school_builder$school_builder$course');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_builder$course_school_builder$courseid', 'f12f39b4-5dda-4705-9407-a39953e8c9e5', '43742e14-23f9-378a-bf22-1d5279a69a9f');
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230816 10:45:16';

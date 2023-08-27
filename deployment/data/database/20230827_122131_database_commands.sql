CREATE TABLE "solver$solvertest" (
	"id" BIGINT NOT NULL,
	"testid" BIGINT NULL,
	"totalspenttime" DECIMAL(28, 8) NULL,
	"correctanswercount" INT NULL,
	"wronganswercount" INT NULL,
	"emptyanswercount" INT NULL,
	PRIMARY KEY("id"));
CREATE SEQUENCE "solver$solvertest_testid_mxseq" AS BIGINT START WITH 1;
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('50032e86-aa25-486c-91d3-93213ba10b36', 'Solver.SolverTest', 'solver$solvertest', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('884ce10d-5cff-4289-a39c-5b62c2d408e7', '50032e86-aa25-486c-91d3-93213ba10b36', 'TestId', 'testid', 0, 0, '1', true);
INSERT INTO "mendixsystem$sequence" ("attribute_id", "name", "start_value", "current_value") VALUES ('884ce10d-5cff-4289-a39c-5b62c2d408e7', 'solver$solvertest_testid_mxseq', 1, 0);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('73d3397e-5c7a-44b2-adbf-774481101c26', '50032e86-aa25-486c-91d3-93213ba10b36', 'TotalSpentTime', 'totalspenttime', 5, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('785833db-9728-456b-be42-6bd852be0f27', '50032e86-aa25-486c-91d3-93213ba10b36', 'CorrectAnswerCount', 'correctanswercount', 3, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('3f7d40fe-d20d-44ef-9a4f-dc91aba0e4b8', '50032e86-aa25-486c-91d3-93213ba10b36', 'WrongAnswerCount', 'wronganswercount', 3, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('5ca6e3ad-30da-4226-b49f-a1e8ded4b611', '50032e86-aa25-486c-91d3-93213ba10b36', 'EmptyAnswerCount', 'emptyanswercount', 3, 0, '0', false);
CREATE TABLE "solver$solverquestion" (
	"id" BIGINT NOT NULL,
	"solverquestionid" BIGINT NULL,
	"answer" VARCHAR_IGNORECASE(1) NULL,
	"spenttime" DECIMAL(28, 8) NULL,
	"sort" INT NULL,
	"iscorrect" BOOLEAN NULL,
	PRIMARY KEY("id"));
CREATE SEQUENCE "solver$solverquestion_solverquestionid_mxseq" AS BIGINT START WITH 1;
INSERT INTO "mendixsystem$entity" ("id", "entity_name", "table_name", "superentity_id", "remote", "remote_primary_key") VALUES ('965ff916-35d6-41c6-904e-fcb046528994', 'Solver.SolverQuestion', 'solver$solverquestion', 'eae3b556-6a28-4bad-92cb-5419749311c9', false, false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('0757e341-0293-4d6a-a693-a7ad820621bf', '965ff916-35d6-41c6-904e-fcb046528994', 'SolverQuestionId', 'solverquestionid', 0, 0, '1', true);
INSERT INTO "mendixsystem$sequence" ("attribute_id", "name", "start_value", "current_value") VALUES ('0757e341-0293-4d6a-a693-a7ad820621bf', 'solver$solverquestion_solverquestionid_mxseq', 1, 0);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('f9ccd78e-9c2a-4a5d-b769-74ac989ed200', '965ff916-35d6-41c6-904e-fcb046528994', 'Answer', 'answer', 40, 1, '', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('e8492bd2-49e0-4f62-b46f-4fe148197846', '965ff916-35d6-41c6-904e-fcb046528994', 'SpentTime', 'spenttime', 5, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('aae9f3de-97cb-49c7-8d59-6e601f02676d', '965ff916-35d6-41c6-904e-fcb046528994', 'Sort', 'sort', 3, 0, '0', false);
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('af7a9825-5370-444f-8089-04f7d10a10f3', '965ff916-35d6-41c6-904e-fcb046528994', 'IsCorrect', 'iscorrect', 10, 0, 'false', false);
CREATE TABLE "solver$solverquestion_solvertest" (
	"solver$solverquestionid" BIGINT NOT NULL,
	"solver$solvertestid" BIGINT NOT NULL,
	PRIMARY KEY("solver$solverquestionid","solver$solvertestid"),
	CONSTRAINT "uniq_solver$solverquestion_solvertest_solver$solverquestionid" UNIQUE ("solver$solverquestionid"));
CREATE INDEX "idx_solver$solverquestion_solvertest_solver$solvertest_solver$solverquestion" ON "solver$solverquestion_solvertest" ("solver$solvertestid" ASC,"solver$solverquestionid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('7a1e75dd-40ca-46e6-acdd-b0af0f484263', 'Solver.SolverQuestion_SolverTest', 'solver$solverquestion_solvertest', '965ff916-35d6-41c6-904e-fcb046528994', '50032e86-aa25-486c-91d3-93213ba10b36', 'solver$solverquestionid', 'solver$solvertestid', 'idx_solver$solverquestion_solvertest_solver$solvertest_solver$solverquestion');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_solver$solverquestion_solvertest_solver$solverquestionid', '7a1e75dd-40ca-46e6-acdd-b0af0f484263', '81866a6e-a14f-3b1e-8188-c733b236a81d');
CREATE TABLE "solver$solverquestion_question" (
	"solver$solverquestionid" BIGINT NOT NULL,
	"builder$questionid" BIGINT NOT NULL,
	PRIMARY KEY("solver$solverquestionid","builder$questionid"),
	CONSTRAINT "uniq_solver$solverquestion_question_solver$solverquestionid" UNIQUE ("solver$solverquestionid"));
CREATE INDEX "idx_solver$solverquestion_question_builder$question_solver$solverquestion" ON "solver$solverquestion_question" ("builder$questionid" ASC,"solver$solverquestionid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('bd3f7cef-bf3c-4055-af9f-bf60cb11cc82', 'Solver.SolverQuestion_Question', 'solver$solverquestion_question', '965ff916-35d6-41c6-904e-fcb046528994', '387272c2-bf38-429e-84e2-4ffe48e43b5f', 'solver$solverquestionid', 'builder$questionid', 'idx_solver$solverquestion_question_builder$question_solver$solverquestion');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_solver$solverquestion_question_solver$solverquestionid', 'bd3f7cef-bf3c-4055-af9f-bf60cb11cc82', '250ca5c8-742b-35cd-847e-f84f8c4a7753');
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230827 12:21:31';

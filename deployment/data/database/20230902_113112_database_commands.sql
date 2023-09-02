CREATE TABLE "solver$solvertest_lecture" (
	"solver$solvertestid" BIGINT NOT NULL,
	"builder$lectureid" BIGINT NOT NULL,
	PRIMARY KEY("solver$solvertestid","builder$lectureid"),
	CONSTRAINT "uniq_solver$solvertest_lecture_solver$solvertestid" UNIQUE ("solver$solvertestid"));
CREATE INDEX "idx_solver$solvertest_lecture_builder$lecture_solver$solvertest" ON "solver$solvertest_lecture" ("builder$lectureid" ASC,"solver$solvertestid" ASC);
INSERT INTO "mendixsystem$association" ("id", "association_name", "table_name", "parent_entity_id", "child_entity_id", "parent_column_name", "child_column_name", "index_name") VALUES ('c4858f37-74fa-4570-8f97-598f031088a6', 'Solver.SolverTest_Lecture', 'solver$solvertest_lecture', '50032e86-aa25-486c-91d3-93213ba10b36', 'eb950f9d-2e54-447e-a8b4-a61bf7b0273b', 'solver$solvertestid', 'builder$lectureid', 'idx_solver$solvertest_lecture_builder$lecture_solver$solvertest');
INSERT INTO "mendixsystem$unique_constraint" ("name", "table_id", "column_id") VALUES ('uniq_solver$solvertest_lecture_solver$solvertestid', 'c4858f37-74fa-4570-8f97-598f031088a6', 'b620e335-b235-30f8-bded-7cfb7bb0104c');
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230902 11:31:12';

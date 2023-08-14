ALTER TABLE "administration$account" ADD "_id" VARCHAR_IGNORECASE(200) NULL;
INSERT INTO "mendixsystem$attribute" ("id", "entity_id", "attribute_name", "column_name", "type", "length", "default_value", "is_auto_number") VALUES ('fff58523-239a-41e5-8070-76c867434870', 'c921ccbb-a670-48d9-833d-6a76c1406917', '_Id', '_id', 30, 200, '', false);
UPDATE "mendixsystem$version" SET "versionnumber" = '4.2', "lastsyncdate" = '20230814 14:34:11';

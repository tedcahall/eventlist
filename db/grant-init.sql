# grant access to the MySQL user cahall
# https://stackoverflow.com/questions/5906585/how-to-change-the-character-set-and-collation-throughout-a-database
# ALTER DATABASE <database_name> CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs;
# ALTER TABLE <table_name> CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs;
# ALTER TABLE <table_name> MODIFY <column_name> VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs;
# cs means 'case sensitive' which is needed for an index that is case sensitive like Plaid trans_id and account_id

CREATE DATABASE IF NOT EXISTS eventlist DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;
CREATE USER 'eventadmin'@'localhost' IDENTIFIED BY 'xxxxxxxxxx';
GRANT ALL on eventlist.* to 'eventadmin'@'localhost';

-- CREATE SCHEMA IF NOT EXISTS public;
-- --
-- create table if not exists authority (
--   id BIGINT,
--   name varchar(255) NOT NULL,
--   primary key  (id)
-- );
--
-- create table if not exists profile (
--   id BIGINT,
--   name varchar(255) NOT NULL,
--   primary key  (id)
-- );
--
-- create table if not exists PROFILE_AUTHORITY (
--   profile_id BIGINT,
--   authority_id BIGINT
-- );
--
-- INSERT INTO profile (id, name) VALUES (1, 'user');
-- INSERT INTO profile (id, name) VALUES (2, 'admin');
-- INSERT INTO profile (id, name) VALUES (3, 'manager');
--
--
-- INSERT INTO authority (id, name) VALUES (1, 'add manager');
-- INSERT INTO authority (id, name) VALUES (2, 'delete users');
--
-- INSERT INTO PROFILE_AUTHORITY (profile_id, profile_id) values (1, 1);
-- INSERT INTO PROFILE_AUTHORITY (profile_id, profile_id) values (1, 2);
-- INSERT INTO PROFILE_AUTHORITY (profile_id, profile_id) values (2, 1);
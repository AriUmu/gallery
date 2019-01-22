CREATE SCHEMA if not exists PERSISTENCE;
DROP TABLE IF EXISTS user;

-- create table user (
--   id bigint auto_increment,
--   name varchar(255),
--   login varchar(255),
--   password varchar(255),
--   sessionId long,
--   lastLoginTime TIMESTAMP,
--   profile OBJECT,
--   primary key (id)
-- );
--
-- INSERT INTO user (name, login, password, sessionId, lastLoginTime, profile) VALUES ('user1', 'userlogin', 'qwerty', 1234, '17-09-2012 18:47:52.69');
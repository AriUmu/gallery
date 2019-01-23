DROP SCHEMA IF EXISTS public;

create table user (
  id bigint,
  name varchar(255),
  login varchar(255),
  password varchar(255),
  sessionId BIGINT,
  lastLoginTime TIMESTAMP,
  profile OTHER,
  primary key (id)
);

-- INSERT INTO user (name, login, password, sessionId, lastLoginTime, profile) VALUES ('user1', 'userlogin', 'qwerty', 1234, '17-09-2012 18:47:52.69');
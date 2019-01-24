CREATE SCHEMA IF NOT EXISTS public;

create table profile (
  id BIGINT,
  name varchar(255) NOT NULL,
  primary key  (id)
);

INSERT INTO profile (id, name) VALUES (1, 'user');
INSERT INTO profile (id, name) VALUES (2, 'admin');
INSERT INTO profile (id, name) VALUES (3, 'manager');
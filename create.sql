CREATE DATABASE org_api;
\c org_api;
CREATE TABLE departments(id serial PRIMARY KEY, name VARCHAR, description VARCHAR, numberofemployees INTEGER );
CREATE TABLE users(id serial PRIMARY KEY,name VARCHAR,role VARCHAR, departmentid INTEGER);
CREATE TABLE news (id serial PRIMARY KEY, content VARCHAR, author VARCHAR,departmentid INTEGER, type VARCHAR);
CREATE DATABASE org_api_test WITH TEMPLATE org_api;
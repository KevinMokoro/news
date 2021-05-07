CREATE DATABASE org_api;
\c org_api;
CREATE TABLE departments(id SERIAL PRIMARY KEY, departmentname VARCHAR, description VARCHAR, totalemployees INTEGER );
CREATE TABLE users(id SERIAL PRIMARY KEY,username VARCHAR,address VARCHAR,phone INTEGER,email VARCHAR,departmentid INTEGER, position VARCHAR, roles VARCHAR);
CREATE TABLE news(id SERIAL PRIMARY KEY,news VARCHAR,departmentid INTEGER);
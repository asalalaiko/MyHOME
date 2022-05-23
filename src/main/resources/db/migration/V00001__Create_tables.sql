CREATE TABLE IF NOT EXISTS users
(
    id SERIAL PRIMARY KEY,
    login varchar(100),
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    role varchar(100),
    locked boolean,
    email varchar(255)
    );

CREATE SEQUENCE SEQ_USER START WITH 1 INCREMENT BY 1 ;
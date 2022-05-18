CREATE TABLE IF NOT EXISTS users
(
    id SERIAL PRIMARY KEY,
    login varchar(100),
    password varchar(100),
    first_name varchar(100),
    last_name varchar(100),
    role bigint,
    locked bit,
    email varchar(100)
    )



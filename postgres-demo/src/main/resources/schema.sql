DROP TABLE IF EXISTS customer;
CREATE TABLE customer(id serial PRIMARY KEY, firstname VARCHAR(16), lastname VARCHAR(16), email VARCHAR(50));
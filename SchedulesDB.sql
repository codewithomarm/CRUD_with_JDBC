CREATE DATABASE schedules;

USE schedules;
CREATE TABLE person (
	id INT auto_increment PRIMARY KEY,
    first_name varchar(45) NOT NULL,
    middle_name varchar(45),
    pa_surname varchar(45) NOT NULL,
    ma_surname varchar(45),
    username varchar(30) NOT NULL
);

INSERT INTO person (first_name, pa_surname, ma_surname, username)
	VALUES ('Omar', 'Montoya', 'Gomez', 'kiffenbeats');

INSERT INTO person (first_name, pa_surname, ma_surname, username)
	VALUES ('Marlly', 'Guido', 'Alain', 'marsh');
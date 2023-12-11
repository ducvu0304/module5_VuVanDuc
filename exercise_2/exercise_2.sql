DROP DATABASE IF EXISTS exercise_2;
CREATE DATABASE IF NOT EXISTS exercise_2;
USE exercise_2;


CREATE TABLE city(
	zip_code INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` 	VARCHAR(255) NOT NULL
);
INSERT INTO city(`name`) VALUES('Ho Chi Minh'), ('Ha Noi');


CREATE TABLE author(
	id 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	`name` 	VARCHAR(255) NOT NULL,
	zip_code 	INT NOT NULL,
    FOREIGN KEY(zip_code) REFERENCES city(zip_code)
);

INSERT INTO author(`name`, zip_code) VALUES('Nguyen Anh', 1), ('Xuan Hong', 2);


CREATE TABLE category(
	id	INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);

INSERT INTO category(`name`) VALUES('java');


CREATE TABLE book(
	id	INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
	category_id	 INT NOT NULL,
	author_id	INT NOT NULL,
	FOREIGN KEY(author_id) REFERENCES author(id),
    FOREIGN KEY(category_id) REFERENCES category(id)
);

INSERT INTO book(`name`, category_id,author_id) 
VALUES('Java 123', 1, 1), ('Java 124', 1, 1), ('Java 125', 1, 1), ('Java 126', 1, 1), ('Java 113', 1, 2),('Java 114', 1, 2),('Java 115', 1, 2),('Java 116', 1, 2) ;



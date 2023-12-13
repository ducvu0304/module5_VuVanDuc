DROP DATABASE IF EXISTS student_management;
CREATE DATABASE IF NOT EXISTS student_management;
USE student_management;

CREATE TABLE `student` (
  `student_id` 	INT NOT NULL AUTO_INCREMENT,
  `student_name` varchar(100) NOT NULL,
  `birth_date` 	date NOT NULL,
  `gender` 		bit(1) NOT NULL,
  `address` 	text NOT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `phoneNumber` (`phone_number`),
  KEY `IndexName` (`phone_number`)
);

INSERT INTO student(student_name, birth_date, gender, address, phone_number)
VALUES
('Nguyen Van A', '1996-10-10',1, 'Tan Binh', '0966111111'),
('Nguyen Van B', '1996-10-10',1, 'Binh Tan', '0966111112'),
('Nguyen Van C', '1996-10-10',1, 'Quan 1', '0966111113'),
('Nguyen Van D', '1996-10-10',1, 'Quan 2', '0966111114'),
('Nguyen Van E', '1996-10-10',1, 'Quan 3', '0966111115'),
('Nguyen Van F', '1996-10-10',1, 'Quan 4', '0966111116');

CREATE TABLE `subject` (
  `subject_id`	INT NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) NOT NULL,
  `priority`	int NOT NULL,
  PRIMARY KEY (`subject_id`)
);

INSERT INTO `subject`(subject_name, priority)
VALUES 
('Java scrore', 3),
('Servlet & Jsp', 2),
('Sping MVC', 1),
('Sping Boot', 1);

CREATE TABLE `mark` (
  `subject_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  `point` double DEFAULT NULL,
  KEY `fk_sbid_mark` (`subject_id`),
  KEY `fk_stid_mark` (`student_id`),
  CONSTRAINT `fk_sbid_mark` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `fk_stid_mark` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
);

INSERT INTO `mark`(subject_id, student_id, `point`)
VALUES  (1, 1, 9), (1, 2, 9), (1, 3, 8), (1, 4, 6), (1, 5, 4), (1, 6, 5),
		(2, 1, 4), (2, 2, 5), (2, 3, 6), (2, 4, 7), (2, 5, 8), (2, 6, 9),
		(3, 1, 5), (3, 2, 7), (3, 3, 8), (3, 4, 5), (3, 5, 9), (3, 6, 5),
		(4, 1, 7), (4, 2, 5), (4, 3, 10), (4, 4, 8), (4, 5, 6), (4, 6, 7);
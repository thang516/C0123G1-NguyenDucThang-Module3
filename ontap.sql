CREATE DATABASE student_ontap ; 
USE student_ontap;
CREATE TABLE students(
id INT PRIMARY KEY AUTO_INCREMENT , 
`name` VARCHAR(50) NOT NULL , 
class_id INT , FOREIGN KEY (class_id) REFERENCES classs(class_id) ,
`point` FLOAT NOT NULL  
);
CREATE TABLE classs(
class_id INT PRIMARY KEY ,
class_name VARCHAR(50) NOT NULL 
);
  
INSERT INTO classs VALUES(1,'CO123G!'),(2,'CO23G1'),(3,'C033G1');
INSERT INTO students(`name`,class_id,`point`) VALUES('Nguyễn Đức Thắng',1,9),('Kiều Quốc Khánh',2,9),('Huỳnh Đức ĐỊnh',3,8);

SELECT s.`name` , s.`point`,c.* FROM students AS  s
INNER JOIN classs AS c ON c.class_id = s.class_id;
INSERT INTO students(`name`,class_id,`point`) VALUES('Nguyễn Đức ',2,10);
SELECT * FROM students;
SELECT * FROM classs;

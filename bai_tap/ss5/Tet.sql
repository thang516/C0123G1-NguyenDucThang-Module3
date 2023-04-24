CREATE DATABASE khach_hang;
use khach_hang;
CREATE TABLE customer(
customer_id INT PRIMARY KEY ,
full_name VARCHAR(50) NOT NULL ,
sex BIT NOT NULL , 
citizen_id VARCHAR(11) NOT NULL ,
phone_number VARCHAR(11)  
);
 INSERT INTO customer VALUE(1,'Nguyễn Đức Thắng',1,'201854945','0782391943'),
 (2,'Hồ Viễn',1,'2019555666','0905456789') ;
 
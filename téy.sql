CREATE DATABASE product ; 
USE product;
CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
price FLOAT NOT NULL ,
`description` VARCHAR(100) NOT NULL 
);
INSERT INTO products VALUE(1,"Sữa Ông thọ",15,'thơm ngon'),
(2,"Sữa Ông Phúc",18,'thơm ngon '),
(3,"Sữa Ông Nở",18,'thơm ngon ');
SELECT * FROM products ;
INSERT INTO products VALUE(5,'Sữa chua',10,'NGon ĐÓA');
DELIMITER //
CREATE PROCEDURE delete_by_id(IN p_id INT)
BEGIN
DELETE FROM product WHERE id = p_id;
END//
DELIMITER ;
CALL delete_by_id(3);
 DROP DATABASE product;
 
 DELIMITER //
 CREATE PROCEDURE delete_by_name(IN p_id INT) 
 BEGIN
 DELETE FROM products Where id = p_id ;
 END//
 DELIMITER ;
 CALL delete_by_name(5);
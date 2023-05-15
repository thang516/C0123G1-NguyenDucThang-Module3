CREATE DATABASE product_manager ;
USE product_manager;

CREATE TABLE origins (
 product_origin INT PRIMARY KEY  , 
origin_name VARCHAR(50) NOT NULL
);
CREATE TABLE products (
id INT PRIMARY KEY AUTO_INCREMENT ,
`name` VARCHAR(50) NOT NULL,
product_origin INT , FOREIGN KEY (product_origin) REFERENCES  origins(product_origin) ,
price FLOAT NOT NULL 
);
INSERT INTO origins VALUES(1,'Trung Quốc'),(2,'Việt Nam'),(3,'pháp');
INSERT INTO products (`name`,product_origin,price) VALUES('Sữa tươi',1,24),('Sữa Chua',2,28);

SELECT p.*,o.origin_name FROM products p 
INNER JOIN origins o ON o.product_origin = p.product_origin;
INSERT INTO products(`name`,product_origin,price) VALUES('sữa ensua',1,89);
SELECT * FROM products;
SELECT * FROM origins;
DELETE FROM products WHere id=3;
SELECT p.*,o.origin_name FROM products p 
INNER JOIN origins o ON o.product_origin = p.product_origin;
INSERT INTO products(`name`,product_origin,`price`) VALUES('Nga',1,45);
DELETE FROM products WHERE id = 5;
SELECT * FROM products WHERE `name` Like '%sua%'
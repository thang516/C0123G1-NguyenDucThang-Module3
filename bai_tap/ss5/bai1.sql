CREATE DATABASE demo;
USE demo;
CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT  ,
product_code INT NOT NULL  UNIQUE ,
product_name VARCHAR(50) NOT NULL ,
product_price DOUBLE NOT NULL CHECK(product_price > 0) , 
product_amount INT NOT NULL CHECK(product_amount > 0) ,
product_description VARCHAR(50),
product_status  BIT 
);
INSERT INTO products VALUE(1,1,'trà sữa',1000,12,'đảm bảo chất lượng',1),
(2,2,'trà trà đào',20000,50,'đảm bảo chất lượng',1),
(3,3,'trà Ôlong',25000,30,'đảm bảo chất lượng',1),
(4,4,'trà chanh',30000,40,'đảm bảo chất lượng',1),
(5,5,'trà tắc',40000,60,'đảm bảo chất lượng',1);

-- bước 3
EXPLAIN SELECT * FROM products WHERE product_code =3;
CREATE UNIQUE INDEX product_code_index ON products(product_code);
CREATE  INDEX composite_index ON products(product_name, product_price);
EXPLAIN SELECT * FROM products WHERE product_code =3;
-- bước 4
CREATE VIEW w_products as  SELECT  product_code ,product_name , product_price ,
product_status FROM products ;
SELECT * FROM w_products ;

-- sửa đổi view 
SELECT * FROM w_products ;
SET SQL_SAFE_UPDATES = 0 ;
UPDATE w_products SET product_name = 'trà gừng' WHERE product_name ='trà tắc' ;
SET SQL_SAFE_UPDATES = 1 ;
-- xóa view 
 DROP VIEW  w_products ;

-- bước 5 
-- tạo SP lấy tất cả các sản phẩm trong bảng
DELIMITER // 
CREATE PROCEDURE get_all_products()
BEGIN 
SELECT * FROM products ;
END // 
DELIMITER ;
CALL get_all_products();

-- tạo SP thêm 1 sản phẩm mới 
DELIMITER // 
CREATE PROCEDURE add_products(IN id INT,product_code INT  ,
product_name VARCHAR(50) ,
product_price DOUBLE  , 
product_amount INT  ,
product_description VARCHAR(50),
product_status  BIT 
) 
BEGIN 
INSERT INTO products VALUE (id,product_code,product_name,product_price,product_amount,product_description,product_status);
END // 
DELIMITER 
CALL add_products(6,6,'trà chanh xí muội',335000,40,'đảm bảo chất lượng',1);

-- tạo SP sửa thông tin sản phẩm theo id 


DELIMITER // 
CREATE PROCEDURE update_products (IN p_id INT,p_name VARCHAR(50) )
BEGIN 
UPDATE  products SET product_name =p_name   WHERE id = p_id ;
END //
DELIMITER ; 

CALL update_products (1,"sửa tươi");
-- tạo sp xóa theo id 
DELIMITER // 
CREATE PROCEDURE delete_products(IN id INT )
BEGIN 
DELETE FROM products WHERE id= id ; 
END // 
DELIMITER ; 
CALL delete_products(5);

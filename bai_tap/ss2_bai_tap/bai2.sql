CREATE DATABASE quan_li_ban_hang;
USE quan_li_ban_hang;

CREATE TABLE customers(
customer_id INT PRIMARY KEY AUTO_INCREMENT ,
customer_name VARCHAR(50) NOT NULL,
customer_age INT NOT NULL ,CHECK (customer_age > 0 ) 
);
INSERT INTO customers (customer_name, customer_age)
VALUES ("Minh Quan",10),
	   ("Ngoc Anh",20),
	   ("Hong Ha",30);

CREATE TABLE orders (
order_id INT PRIMARY KEY AUTO_INCREMENT,
order_date DATE  NOT NULL,
order_total_price DOUBLE,
customer_id INT, FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
INSERT INTO orders (customer_id, order_date,order_total_price)
VALUES  (1,'2006-03-21',null),
		(2,'2006-03-23',null),
		(1,'2006-03-16',null);

CREATE TABLE products(
product_id INT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(50) NOT NULL,
product_price DOUBLE  NOT NULL 
);
INSERT INTO products ( product_name, product_price)
VALUES ("May Giat", 3),
	   ("Tu Lanh", 5),
	   ("Dieu Hoa", 7),
	   ("Quat", 1),
	   ("Bep Dien", 2);

CREATE TABLE order_detail(

PRIMARY KEY(order_id,product_id),
order_id INT ,FOREIGN KEY(order_id)REFERENCES orders(order_id),
product_id INT ,FOREIGN KEY(product_id)REFERENCES products(product_id),
order_detail_qty INT CHECK(order_detail_qty >0) 

);
INSERT INTO order_detail (order_id,product_id,order_detail_qty) 
VALUES (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT * FROM orders;
-- Hiển thị danh sách các khách hàng đã mua hàng, 
-- và danh sách sản phẩm được mua bởi các khách

SELECT c.customer_name AS' Tên khách hàng '  , p.product_name
 FROM customers c
 INNER JOIN orders o ON o.customer_id = c.customer_id 
  INNER JOIN order_detail  od ON od.order_id = o.order_id 
   INNER JOIN products p ON p.product_id  = od.product_id ;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT * FROM customers c 
LEFT JOIN orders o  ON c.customer_id = o.customer_id 
WHERE o.customer_id  IS NULL
;
SELECT * FROM customers c 
LEFT JOIN orders od ON od.customer_id = c.customer_id WHERE od.order_id IS NULL ;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng
--  xuất hiện trong hóa đơn
-- . Giá bán của từng loại được tính = odQTY*pPrice)
/* cách 2 : SELECT  od.order_id AS'MÃ HÓA ĐƠN ',od.order_date AS"NGÀY BÁN" ,
SUM(odl.order_detail_qty*p.product_price) AS'GIÁ'
 FROM orders od
INNER JOIN order_detail odl ON odl.order_id =  od.order_id 
INNER JOIN products p ON p.product_id =  odl.product_id GROUP BY od.order_id ; */

SELECT * FROM  orders od 
INNER JOIN (SELECT order_id, sum(order_detail_qty * product_price) as sum FROM order_detail odl 
INNER JOIN products p ON p.product_id=odl.product_id GROUP BY order_id) as tbl on od.order_id = tbl.order_id

-- DROP DATABASE quan_li_ban_hang;

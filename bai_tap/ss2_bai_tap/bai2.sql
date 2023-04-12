CREATE DATABASE quan_li_ban_hang;
USE quan_li_ban_hang;

CREATE TABLE customer(
customer_id INT PRIMARY KEY AUTO_INCREMENT ,
customer_name VARCHAR(50),
customer_age BIT

);
CREATE TABLE `order` (
order_id INT PRIMARY KEY,
customer_id INT, FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
order_date DATE ,
order_total_price DOUBLE
);
CREATE TABLE product(
product_id INT PRIMARY KEY,
product_name VARCHAR(50),
product_price DOUBLE
);
CREATE TABLE order_detail(
order_id INT ,FOREIGN KEY(order_id)REFERENCES `order`(order_id),
product_id INT ,FOREIGN KEY(product_id)REFERENCES product(product_id),
order_detail_qty INT
);

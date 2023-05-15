CREATE DATABASE hop_dong ; 
USE hop_dong ;


CREATE TABLE loai_hop_dong(
id_contract INT  PRIMARY KEY , 
name_contract VARCHAR(50) 
);
CREATE TABLE hop_dong_giao_dich(
id INT PRIMARY KEY AUTO_INCREMENT , 
`name` VARCHAR(50) NOT NULL ,
id_contract INT NOT NULL , FOREIGN KEY(id_contract) REFERENCES loai_hop_dong(id_contract) ,
ngay VARCHAR(50) NOT NULL ,
ngay_ket_thuc VARCHAR(50) NOT NULL 
);
INSERT INTO hop_dong_giao_dich (`name`,id_contract,ngay,ngay_ket_thuc) VALUES('hợp đồng ma',1,'05/15/2023','05/16/2023'),('hợp đồng tài chính ',2,'05/16/2023','05/17/2023') ;
INSERT INTO loai_hop_dong(id_contract,name_contract)VALUES(1,'Loại hợp đồng giao dịch') , (2,'Loại hợp đồng THuê');
SELECT hd.* ,lhd.name_contract , hd.ngay , hd.ngay_ket_thuc FROM  hop_dong_giao_dich hd 
INNER JOIN loai_hop_dong lhd On lhd.id_contract = hd.id_contract;
SELECT * FROM loai_hop_dong;
INSERT INTO hop_dong_giao_dich (`name`,id_contract,ngay,ngay_ket_thuc) VALUES('Hợp đồng Ảo Giác',1,'05/07/2023','05/08/2023');
DELETE FROM hop_dong_giao_dich hd WHERE id = 5 ; 
SELECT hd.`name`,hd.id_contract,hd.ngay,hd.ngay_ket_thuc, lhd.name_contract FROM hop_dong_giao_dich hd 
INNER JOIN loai_hop_dong lhd ON lhd.id_contract = hd.id_contract
 WHERE `name` Like '%hợp đồng%' AND lhd.name_contract LIKE '%giao dich%' ; 
 
 UPDATE hop_dong_giao_dich SET `name` = 'tài' , id_contract = 2 , ngay = '05/16/2023',ngay_ket_thuc='05/17/2023'  
 
 WHERE id =5 ;
CREATE DATABASE thi;
USE thi;
CREATE TABLE loai_thu_cung(
id_loai_thu_cung INT PRIMARY KEY AUTO_INCREMENT ,
ten_loai_thu_cung VARCHAR(50) 
);
CREATE TABLE thu_cung (
id_thu_cung  INT PRIMARY KEY AUTO_INCREMENT,
id_loai_thu_cung INT , FOREIGN KEY(id_loai_thu_cung) REFERENCES loai_thu_cung(id_loai_thu_cung) ,
mo_ta VARCHAR(50) NOT NULL ,
ten_tai_khoan VARCHAR(50) NOT NULL 
);
CREATE TABLE chu_nhan(
cccd VARCHAR(10) PRIMARY KEY , 
ho_ten VARCHAR(50) NOT NULL, 
so_dien_thoai VARCHAR(50) NOT NULL ,
ten_tai_khoan VARCHAR(50) NOT NULL 
);
CREATE TABLE ve_phat(
ma_so_ve_phat INT PRIMARY KEY AUTO_INCREMENT , 
ten_tai_khoan_bi_phat VARCHAR(50) NOT NULL , 
id_thu_cung INT , FOREIGN KEY (id_thu_cung) REFERENCES thu_cung(id_thu_cung),
thong_tin_loi_vi_pham VARCHAR(50) NOT NULL , 
ngay_gio_vi_pham VARCHAR(50) ,
so_tien_can_dong_phat VARCHAR(50),
ghi_chu_them VARCHAR(50)
);
INSERT INTO loai_thu_cung (ten_loai_thu_cung) VALUES ('chó'),('mèo') ;
INSERT INTO thu_cung (id_loai_thu_cung,mo_ta,ten_tai_khoan) VALUES (1,'chó màu nâu','thang') ,(2,'mèo anh','adz');
INSERT INTO chu_nhan (cccd,ho_ten,so_dien_thoai,ten_tai_khoan) VALUES ('201854945','Nguyễn Thắng','03396871717','thang') ,('2018549335','Nguyễn hòa','0339683337','adz');
INSERT INTO ve_phat (ten_tai_khoan_bi_phat,id_thu_cung,thong_tin_loi_vi_pham,ngay_gio_vi_pham,so_tien_can_dong_phat,ghi_chu_them) VALUES 
('thang','1','tha rong','14/02/2023 : 08:30','500k','ĐỪng Thả rông') ,('adz','2','thả rông','14/03/2023 : 10:30','400k','ĐỪng Thả rông');
SELECT * FROM ve_phat;
INSERT INTO ve_phat (ten_tai_khoan_bi_phat,id_thu_cung,thong_tin_loi_vi_pham,ngay_gio_vi_pham,so_tien_can_dong_phat,ghi_chu_them) VALUES ('vien','1','tha bậy','14/02/2023 : 08:30','500k','ĐỪng Thả rông') 
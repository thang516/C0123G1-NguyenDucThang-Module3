CREATE DATABASE vat_tu;
USE vat_tu;
CREATE TABLE so_dien_thoai(
so_dien_thoai VARCHAR(11) PRIMARY KEY ,
 ma_nha_cung_cap INT,FOREIGN KEY (ma_nha_cung_cap) REFERENCES nha_cung_cap(ma_nha_cung_cap)

);
CREATE TABLE phieu_xuat(
so_px INT PRIMARY KEY AUTO_INCREMENT,
ngay_xuat DATE NOT NULL
);
CREATE TABLE phieu_nhap(
so_pn INT PRIMARY KEY AUTO_INCREMENT,
ngay_nhap DATE NOT NULL
);
CREATE TABLE nha_cung_cap (
    ma_nha_cung_cap INT PRIMARY KEY AUTO_INCREMENT,
    ten_nha_cung_cap VARCHAR(50) NOT NULL ,
    dia_chi VARCHAR(50) NOT NULL
);
CREATE TABLE don_dat_hang(
so_dat_hang INT PRIMARY KEY AUTO_INCREMENT ,
ngay_dat_hang DATE NOT NULL,
ma_nha_cung_cap INT, FOREIGN KEY (ma_nha_cung_cap)REFERENCES nha_cung_cap(ma_nha_cung_cap)
);
CREATE TABLE vat_tu (
    ma_vat_tu INT PRIMARY KEY AUTO_INCREMENT ,
    ten_vat_tu VARCHAR(50) NOT NULL 
);
CREATE TABLE chi_tiet_phieu_xuat (
don_gia_xuat DOUBLE NOT NULL  ,
so_luong_xuat INT NOT NULL ,
 so_px INT,
    FOREIGN KEY (so_px)
        REFERENCES phieu_xuat (so_px),
         so_pn INT,
   ma_vat_tu INT,FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu) ,
   PRIMARY KEY(so_px,ma_vat_tu)
);
CREATE TABLE chi_tiet_phieu_nhap (
    don_gia_nhap DOUBLE NOT NULL ,
    so_luong_nhap INT NOT NULL ,
    so_pn INT,
    FOREIGN KEY (so_pn)
        REFERENCES phieu_nhap (so_pn),
    ma_vat_tu INT,
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu),
	PRIMARY KEY (so_pn,ma_vat_tu)
);
CREATE TABLE chi_tiet_don_hang (
ma_vat_tu INT,FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu),
so_dat_hang INT, FOREIGN KEY (so_dat_hang) REFERENCES don_dat_hang(so_dat_hang),
PRIMARY KEY (ma_vat_tu,so_dat_hang)
);

drop database vat_tu;

CREATE SCHEMA `hibernateexercise`;

CREATE TABLE `hibernateexercise`.`sinh_vien` (
  `MSSV` VARCHAR(8) NOT NULL,
  `HoVaTen` NVARCHAR(50) NOT NULL,
  `GioiTinh` NVARCHAR(5) NOT NULL,
  `CMND` VARCHAR(10) NOT NULL,
  `MaLop` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`MSSV`));
  
INSERT INTO `hibernateexercise`.`sinh_vien` (`MSSV`, `HoVaTen`, `GioiTinh`, `CMND`, `MaLop`)
VALUES ('1712764', 'Bùi Chí Thanh', 'Nam', '215476789', '17CTT6');

CREATE TABLE `hibernateexercise`.`mon_hoc` (
  `MaMon` VARCHAR(10) NOT NULL,
  `TenMon` NVARCHAR(100) NOT NULL,
  PRIMARY KEY (`MaMon`));
  
CREATE TABLE `hibernateexercise`.`lop_hoc` (
  `MaLop` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`MaLop`));
  
  CREATE TABLE `hibernateexercise`.`chi_tiet_lop_hoc` (
  `MaLop` VARCHAR(10) NOT NULL,
  `MaMon` VARCHAR(10) NOT NULL,
  `PhongHoc` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`MaLop`,`MaMon`));
  
 CREATE TABLE `hibernateexercise`.`chi_tiet_mon_hoc` (
  `MaLop` VARCHAR(10) NOT NULL,
  `MaMon` VARCHAR(10) NOT NULL,
  `MSSV` VARCHAR(8) NOT NULL,
   `DiemGK` FLOAT(2,1),
  `DiemCK` FLOAT(2,1),
  `DiemKhac` FLOAT(2,1),
  `DiemTong` FLOAT(2,1),
  PRIMARY KEY (`MaLop`,`MaMon`,`MSSV`));
  
    CREATE TABLE `hibernateexercise`.`tai_khoan` (
  `TaiKhoan` VARCHAR(20) NOT NULL,
  `MatKhau` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`TaiKhoan`));
  
    CREATE TABLE `hibernateexercise`.`phuc_khao` (
  `MSSV` VARCHAR(8) NOT NULL,
  `MaMon` VARCHAR(10) NOT NULL,
  `CotDiem` VARCHAR(8) NOT NULL,
  `DiemMongMuon` FLOAT(2,1) NOT NULL,
  `LiDo` TEXT NOT NULL,
  PRIMARY KEY (`MSSV`,`MaMon`,`CotDiem`));
  
SET FOREIGN_KEY_CHECKS=0;

-- Khoa ngoai cho Sinh Vien

ALTER TABLE `hibernateexercise`.`sinh_vien` 
ADD CONSTRAINT FK_MaLop_SV_LH
  FOREIGN KEY (MaLop)
  REFERENCES `hibernateexercise`.`lop_hoc` (MaLop);
  
-- Khoa ngoai cho Chi tiet lop hoc
  
ALTER TABLE `hibernateexercise`.`chi_tiet_lop_hoc` 
ADD CONSTRAINT FK_MaLop_CTLH_LH
  FOREIGN KEY (MaLop)
  REFERENCES `hibernateexercise`.`lop_hoc` (MaLop); 
  
  ALTER TABLE `hibernateexercise`.`chi_tiet_lop_hoc` 
ADD CONSTRAINT FK_MaMon_CTLH_MH
  FOREIGN KEY (MaMon)
  REFERENCES `hibernateexercise`.`mon_hoc` (MaMon); 

-- Khoa ngoai cho Chi tiet mon hoc

ALTER TABLE `hibernateexercise`.`chi_tiet_mon_hoc` 
ADD CONSTRAINT FK_MaLop_CTMH_LH
  FOREIGN KEY (MaLop)
  REFERENCES `hibernateexercise`.`lop_hoc` (MaLop);  
  
    ALTER TABLE `hibernateexercise`.`chi_tiet_mon_hoc` 
ADD CONSTRAINT FK_MaMon_CTMH_MH
  FOREIGN KEY (MaMon)
  REFERENCES `hibernateexercise`.`mon_hoc` (MaMon); 
  
  ALTER TABLE `hibernateexercise`.`chi_tiet_mon_hoc` 
ADD CONSTRAINT FK_MSSV_CTMH_SV
  FOREIGN KEY (MSSV)
  REFERENCES `hibernateexercise`.`sinh_vien` (MSSV);

-- Khoa ngoai cho Tai khoan

  ALTER TABLE `hibernateexercise`.`tai_khoan` 
ADD CONSTRAINT FK_MSSV_TK_SV
  FOREIGN KEY (TaiKhoan)
  REFERENCES `hibernateexercise`.`sinh_vien` (MSSV);
  
-- Khoa ngoai cho Phuc khao

ALTER TABLE `hibernateexercise`.`phuc_khao` 
ADD CONSTRAINT FK_MSSV_PK_SV
  FOREIGN KEY (MSSV)
  REFERENCES `hibernateexercise`.`sinh_vien` (MSSV);
  
  ALTER TABLE `hibernateexercise`.`phuc_khao` 
ADD CONSTRAINT FK_MaMon_PK_SV
  FOREIGN KEY (MaMon)
  REFERENCES `hibernateexercise`.`mon_hoc` (MaMon);
  
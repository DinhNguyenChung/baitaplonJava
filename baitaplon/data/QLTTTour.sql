use master
go
CREATE database QLTTTour

go
USE  QLTTTour
go

CREATE TABLE Tour(
	maTour VARCHAR(10) primary key,
	tenTour NVARCHAR(30) NULL,
	diaDiemDen NVARCHAR(50) NULL,
	ngayKhoiHanh date NULL,
	ngayKetThuc date NULL,
	giaTour MONEY null,
	soLuongKhach int NULL,
);


CREATE TABLE KhachHang(
   maKH  VARCHAR (10) primary key,
   tenKH NVARCHAR (50) NULL, 
   ngaySinh date  null,
   diaChi NVARCHAR(50) null,
   sdt varchar(12)  null,
   email VARCHAR(50) NULL,
   cmnd VARCHAR (12)  NULL,
);

CREATE TABLE NhanVien(
   maNV  VARCHAR (10) primary key,
   tenNV NVARCHAR (50) NULL, 
   ngaySinh date  null,
   diaChi NVARCHAR(50) null,
   sdt varchar(12)  null,
   email VARCHAR(50) NULL,
   cmnd VARCHAR (12)  NULL,
);


CREATE TABLE HoaDon(
	maHD VARCHAR(10) primary key,
	ngayLap date null,
	maKH VARCHAR (10) null,
	Constraint F_KH_HD Foreign key(maKH) references KhachHang(maKH),
	maNV VARCHAR (10) null,
	Constraint F_NV_HD Foreign key(maNV) references NhanVien(maNV),
	tongTien money null,
);

CREATE TABLE ChiTietHoaDon(
	maCTHD VARCHAR(10) primary key,
	maHD VARCHAR (10) null,
	Constraint F_HD_CTHD Foreign key(maHD) references HoaDon(maHD),
	maTour VARCHAR (10) null,
	Constraint F_T_CTHD Foreign key(maTour) references Tour(maTour),
	soLuongKhach int null,
	donGia money null,
	thanhTien money null,
);


INSERT Tour([maTour], [tenTour],[diaDiemDen],[ngayKhoiHanh],[ngayKetThuc],[giaTour],[soLuongKhach]) 
VALUES ('MT001', N'Tour Đà Lạt',N'Lâm Đồng','2023-04-30','2023-05-02',3000000,35)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT002', N'Tour Hà Giang',N'Hà Giang','2023-05-1','2023-05-03',5000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT003', N'Tour Lý Sơn',N'Quảng Ngãi','2023-05-2','2023-05-03',2000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT004', N'Tour Phú Lài',N'Hà Giang','2023-05-2','2023-05-05',5000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT005', N'Tour Tháp Chàm',N'Phan Thiết','2023-05-10','2023-05-12',4500000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT006', N'Tour Hội An',N'Đà Nẵng','2023-05-1','2023-05-03',3500000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT007', N'Tour Ngũ Hành Sơn',N'Đà Nẵng','2023-05-2','2023-05-02',3000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT008', N'Tour Biển Mỹ Khê',N'Quảng Ngãi','2023-05-1','2023-05-03',4000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT009', N'Tour Mỹ Khê',N'Quảng Nam','2023-05-1','2023-05-02',2000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT010', N'Tour Núi Bà Đen',N'Tây Ninh','2023-05-10','2023-05-12',3000000,30)


INSERT Tour([maTour], [tenTour],[diaDiemDen],[ngayKhoiHanh],[ngayKetThuc],[giaTour],[soLuongKhach]) 
VALUES ('MT011', N'Tour Đà Lạt',N'Lâm Đồng','2023-05-10','2023-05-12',3000000,35)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT012', N'Tour Hà Giang',N'Hà Giang','2023-05-10','2023-05-12',5000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT013', N'Tour Lý Sơn',N'Quảng Ngãi','2023-05-12','2023-05-14',2000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT014', N'Tour Phú Lài',N'Hà Giang','2023-05-7','2023-05-08',3500000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT015', N'Tour Tháp Chàm',N'Phan Thiết','2023-05-11','2023-05-13',4500000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT016', N'Tour Hội An',N'Đà Nẵng','2023-05-5','2023-05-06',3500000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT017', N'Tour Ngũ Hành Sơn',N'Đà Nẵng','2023-05-20','2023-05-22',3000000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT018', N'Tour Biển Mỹ Khê',N'Quảng Ngãi','2023-05-15','2023-05-16',1500000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT019', N'Tour Mỹ Khê',N'Quảng Nam','2023-05-20','2023-05-21',1700000,30)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT020', N'Tour Núi Bà Đen',N'Tây Ninh','2023-05-24','2023-05-26',3000000,30)



INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH001',N'Nguyễn Văn Nam','2000-02-02',N'Hà Nội','0334657483','nam@gmail.com','223344551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH002',N'Nguyễn Thị Minh','2003-04-24',N'Kiên Giang','0331157483','minh@gmail.com','211674551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH003',N'Nguyễn Văn Dương','2000-09-02',N'Hồ Chí Minh','0335657483','duong@gmail.com','213344551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH004',N'Nguyễn Thị Châu','2003-05-24',N'Bình Định','0338157483','chau@gmail.com','281674551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH005',N'Dương Văn Hạnh','2000-03-02',N'Hải Phòng','0996574833','hanh@gmail.com','223456551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH006',N'Nguyễn Thị Phương Nhi','2002-04-21',N'Hồ Chí Minh','0330057483','nhi@gmail.com','211894551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH007',N'Nguyễn Bình Minh','2003-10-02',N'Quảng Ngãi','0334657663','minh@gmail.com','223311781')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH008',N'Nguyễn Thị Lợi','1999-02-2',N'Kiên Giang','0333321483','loi@gmail.com','215534551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH009',N'Đinh Minh Mẫn','2000-02-02',N'Ninh Bình','0334650000','man@gmail.com','221156551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH010',N'Nguyễn Thị Hồng','2002-02-22',N'Đồng Tháp','0338796483','hong@gmail.com','200324551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH011',N'Nguyễn Văn Thành','2000-12-02',N'Lạng Sơn','0339007483','thanh@gmail.com','211354751')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH012',N'Nguyễn Thị Nga','2003-04-28',N'An Giang','0982374833','nga@gmail.com','211002551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH013',N'Nguyễn Anh Tài','1990-09-02',N'Hồ Chí Minh','0330357112','tai@gmail.com','213300051')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH014',N'Nguyễn Thị Phước','2000-09-20',N'Bình Định','0338176423','phuoc@gmail.com','281655631')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH015',N'Ngọc Châu Bùi','2000-03-12',N'Quảng Ninh','0979232833','bui03@gmail.com','220054761')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH016',N'Nguyễn Thanh Tùng','1996-07-20',N'Thái Bình','0331234830','tung@gmail.com','211811151')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH017',N'Nguyễn Bạc Phận','2002-10-12',N'Huế','0335457222','phan@gmail.com','277861781')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH018',N'Nguyễn Thị Nhan','1990-02-21',N'Bến Tre','0358732148','nhan123@gmail.com','216621651')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH019',N'Đinh Minh Hiền','2001-03-12',N'Ninh Bình','0334650220','hiendinh@gmail.com','266753255')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH020',N'Nguyễn Thị Trang','2002-02-28',N'An Giang','0357776483','trang@gmail.com','201124222')


INSERT NhanVien([maNV],[tenNV],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
Values ('NV001',N'Nguyễn Văn Xuân','2000-04-20',N'Ninh Bình','0334756454','xuan@gmail.com','123543254342')
INSERT NhanVien([maNV],[tenNV],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
Values ('NV002',N'Nguyễn Thị Ánh','2000-03-20',N'Cà Mau','0334756454','anh@gmail.com','223243254342')

INSERT NhanVien([maNV],[tenNV],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
Values ('NV003',N'Nguyễn Văn Tính','1999-03-03',N'Hồ Chí Minh','0335777454','xuan@gmail.com','123543254342')
INSERT NhanVien([maNV],[tenNV],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
Values ('NV004',N'Nguyễn Thị Mộng','2000-10-20',N'Vũng Tàu','0335096454','mong@gmail.com','220011254342')

INSERT NhanVien([maNV],[tenNV],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
Values ('NV005',N'Nguyễn Minh Hùng','1997-11-21',N'Hồ Chí Minh','0333056454','hung@gmail.com','222234024342')




INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD001','2023-04-10','KH001','NV001',60000000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD002','2023-04-11','KH002','NV002',150000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD003','2023-04-10','KH003','NV003',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD004','2023-04-13','KH004','NV004',150000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD005','2023-04-13','KH005','NV005',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD006','2023-04-14','KH006','NV002',150000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD007','2023-04-15','KH007','NV003',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD008','2023-04-15','KH008','NV001',150000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD009','2023-05-1','KH009','NV003',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD010','2023-04-24','KH010','NV001',60000000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD011','2023-04-1','KH011','NV001',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD012','2023-04-3','KH012','NV002',150000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD013','2023-04-10','KH013','NV003',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD014','2023-04-23','KH014','NV004',150000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD015','2023-04-30','KH015','NV005',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD016','2023-04-04','KH016','NV002',150000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD017','2023-04-5','KH017','NV003',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD018','2023-04-25','KH018','NV001',150000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD019','2023-05-28','KH019','NV003',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD020','2023-04-30','KH020','NV001',150000)



INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD001','HD001','MT001',20,3000000,60000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD002','HD002','MT002',25,5000000,125000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD003','HD003','MT003',10,2000000,20000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD004','HD004','MT004',20,5000000,100000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD005','HD005','MT005',20,3000000,60000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD006','HD006','MT006',20,4500000,90000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD007','HD007','MT007',25,3000000,75000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD008','HD008','MT008',25,4000000,100000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD009','HD009','MT009',20,2000000,40000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD010','HD010','MT010',20,3000000,60000000)


INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD011','HD011','MT010',10,3000000,30000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD012','HD012','MT011',25,3000000,75000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD013','HD013','MT013',20,2000000,40000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD014','HD014','MT014',20,3500000,70000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD015','HD015','MT015',20,4500000,90000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD016','HD016','MT016',20,3500000,70000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD017','HD017','MT017',29,3000000,87000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD018','HD018','MT019',25,1700000,42500000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD019','HD019','MT018',20,2500000,50000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD020','HD020','MT018',10,3000000,30000000)


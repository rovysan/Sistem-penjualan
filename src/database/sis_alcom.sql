-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sis_alcom
--

CREATE DATABASE IF NOT EXISTS sis_alcom;
USE sis_alcom;

--
-- Temporary table structure for view `rincian`
--
DROP TABLE IF EXISTS `rincian`;
DROP VIEW IF EXISTS `rincian`;
CREATE TABLE `rincian` (
  `no_faktur` varchar(9),
  `qty_jual` int(10) unsigned,
  `kode_barang` varchar(9),
  `nama_barang` varchar(50),
  `harga_jual` int(11),
  `jumlah` bigint(21) unsigned
);

--
-- Definition of table `barang`
--

DROP TABLE IF EXISTS `barang`;
CREATE TABLE `barang` (
  `kode_barang` varchar(9) NOT NULL,
  `nama_barang` varchar(50) DEFAULT NULL,
  `harga_beli` int(11) DEFAULT NULL,
  `harga_jual` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`kode_barang`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` (`kode_barang`,`nama_barang`,`harga_beli`,`harga_jual`,`quantity`) VALUES 
 ('B001','MB Biostar',450000,450000,7),
 ('B002','Ram DDR-1 2 GB',200000,250000,10),
 ('B003','Prosesor Dualcore E750',600000,700000,5),
 ('B004','Power Suplay 450 Wat',150000,300000,4);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;


--
-- Definition of table `divisi`
--

DROP TABLE IF EXISTS `divisi`;
CREATE TABLE `divisi` (
  `kode_divisi` varchar(9) NOT NULL,
  `divisi` varchar(45) NOT NULL,
  `gapok` int(10) unsigned NOT NULL,
  PRIMARY KEY (`kode_divisi`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `divisi`
--

/*!40000 ALTER TABLE `divisi` DISABLE KEYS */;
/*!40000 ALTER TABLE `divisi` ENABLE KEYS */;


--
-- Definition of table `faktur`
--

DROP TABLE IF EXISTS `faktur`;
CREATE TABLE `faktur` (
  `No_Faktur` varchar(9) NOT NULL DEFAULT '',
  `Kode_Pelanggan` varchar(9) NOT NULL,
  `Tgl_Jual` datetime NOT NULL,
  `Total_Jual` int(11) NOT NULL,
  `NIK` varchar(9) NOT NULL,
  `Penerima` varchar(50) NOT NULL,
  PRIMARY KEY (`No_Faktur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faktur`
--

/*!40000 ALTER TABLE `faktur` DISABLE KEYS */;
INSERT INTO `faktur` (`No_Faktur`,`Kode_Pelanggan`,`Tgl_Jual`,`Total_Jual`,`NIK`,`Penerima`) VALUES 
 ('22344','003','2012-06-23 00:00:00',1200000,'A0001','Munir'),
 ('F56554','004','2012-02-23 00:00:00',0,'A00','Samsudin'),
 ('F56555','P001','2012-02-20 00:00:00',0,'K001','Muhlasin'),
 ('F56556','P002','2012-02-20 00:00:00',3000000,'K001','saiun'),
 ('F56557','P001','2012-02-03 00:00:00',0,'K003','Mulia'),
 ('F56558','P001','2011-02-23 00:00:00',0,'K001','Muhidin'),
 ('F56659','P001','2001-02-23 00:00:00',1800000,'K001','Mukhdar'),
 ('F56670','P001','2012-11-11 00:00:00',0,'K001','Sutils'),
 ('F56680','P001','2001-01-01 00:00:00',0,'K001','toha'),
 ('F56681','P001','2012-01-01 00:00:00',0,'K001','Tini'),
 ('F56682','P001','2011-01-01 00:00:00',0,'K001','Johan'),
 ('F56683','P001','2011-01-02 00:00:00',0,'K001','Yunli'),
 ('F56684','P002','2013-01-01 00:00:00',1400000,'K002','Muhsin'),
 ('F56685','P001','2001-01-01 00:00:00',750000,'K001','Mujir'),
 ('F56686','P001','2011-02-02 00:00:00',300000,'K001','Muhli'),
 ('F56687','P001','2001-08-08 00:00:00',950000,'K001','asi'),
 ('F56688','P001','2102-02-02 00:00:00',250000,'K001','johan'),
 ('F56689','P001','2001-02-02 00:00:00',2600000,'K001','muslih'),
 ('F56690','P001','2001-02-23 00:00:00',750000,'K001','musa'),
 ('F56691','P001','2001-02-23 00:00:00',14100000,'K002','Munjir'),
 ('F56692','P001','2002-02-03 00:00:00',1800000,'K001','Munas'),
 ('F56693','P001','2001-01-02 00:00:00',5750000,'K001','Muhlison'),
 ('F56694','P001','2001-02-02 00:00:00',1200000,'K001','Munlas'),
 ('F56695','P001','2011-02-02 00:00:00',1800000,'K001','muhdar'),
 ('F56696','P001','2003-02-02 00:00:00',1800000,'K001','muli'),
 ('F56697','P001','2001-02-23 00:00:00',58200000,'K001','kijo');
/*!40000 ALTER TABLE `faktur` ENABLE KEYS */;


--
-- Definition of table `karyawan`
--

DROP TABLE IF EXISTS `karyawan`;
CREATE TABLE `karyawan` (
  `nik` varchar(9) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jk` varchar(5) NOT NULL,
  PRIMARY KEY (`nik`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

/*!40000 ALTER TABLE `karyawan` DISABLE KEYS */;
INSERT INTO `karyawan` (`nik`,`nama`,`alamat`,`jk`) VALUES 
 ('K001','Muhamad Soleh','Kalitulang Rt.23 Rw.6 Gondang Watumalang, Wonosobo','L'),
 ('K002','Den Indra Wati','Banjar Negara','P'),
 ('K003','Ngakang Ngarsono','Kertek','L'),
 ('K004','Muslih','Kalitulang','L');
/*!40000 ALTER TABLE `karyawan` ENABLE KEYS */;


--
-- Definition of table `pelanggan`
--

DROP TABLE IF EXISTS `pelanggan`;
CREATE TABLE `pelanggan` (
  `Kode_Pel` varchar(9) NOT NULL,
  `Nama_Pel` varchar(50) NOT NULL,
  `Alt_Pel` varchar(50) NOT NULL,
  `Telp_Pel` varchar(15) NOT NULL,
  PRIMARY KEY (`Kode_Pel`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

/*!40000 ALTER TABLE `pelanggan` DISABLE KEYS */;
INSERT INTO `pelanggan` (`Kode_Pel`,`Nama_Pel`,`Alt_Pel`,`Telp_Pel`) VALUES 
 ('P001','Sulis Tiyono','Mandiriaja','08562889626'),
 ('P002','Solihatun Anisah','Kaliasem','081227488211'),
 ('P003','Ahmad Sirat','Godang','0834002934');
/*!40000 ALTER TABLE `pelanggan` ENABLE KEYS */;


--
-- Definition of table `trans_jual`
--

DROP TABLE IF EXISTS `trans_jual`;
CREATE TABLE `trans_jual` (
  `No_Faktur` varchar(9) NOT NULL,
  `Qty_Jual` int(10) unsigned NOT NULL,
  `Kode_Barang` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trans_jual`
--

/*!40000 ALTER TABLE `trans_jual` DISABLE KEYS */;
INSERT INTO `trans_jual` (`No_Faktur`,`Qty_Jual`,`Kode_Barang`) VALUES 
 ('F56686',1,'B004'),
 ('F56687',1,'B002'),
 ('F56687',1,'B003'),
 ('F56688',1,'B002'),
 ('F56689',2,'B003'),
 ('F56690',3,'B002'),
 ('F56691',1,'B004'),
 ('F56693',23,'B002'),
 ('F56697',97,'B001'),
 ('22344',2,'B001'),
 ('F56556',2,'B001'),
 ('F56556',3,'B001'),
 ('F56659',3,'B001');
/*!40000 ALTER TABLE `trans_jual` ENABLE KEYS */;


--
-- Definition of view `rincian`
--

DROP TABLE IF EXISTS `rincian`;
DROP VIEW IF EXISTS `rincian`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `rincian` AS select `trans_jual`.`No_Faktur` AS `no_faktur`,`trans_jual`.`Qty_Jual` AS `qty_jual`,`trans_jual`.`Kode_Barang` AS `kode_barang`,`barang`.`nama_barang` AS `nama_barang`,`barang`.`harga_jual` AS `harga_jual`,(`barang`.`harga_jual` * `trans_jual`.`Qty_Jual`) AS `jumlah` from (`trans_jual` join `barang` on((`barang`.`kode_barang` = `trans_jual`.`Kode_Barang`))) where (`trans_jual`.`No_Faktur` = 'F56659');



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

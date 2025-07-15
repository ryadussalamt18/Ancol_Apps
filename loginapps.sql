-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 27, 2024 at 06:51 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loginapps`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabellogin`
--

CREATE TABLE `tabellogin` (
  `Email` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tabellogin`
--

INSERT INTO `tabellogin` (`Email`, `Password`) VALUES
('PBO@gmail.com', '12345'),
('Ryadussalam@gmail.com', '12345'),
('Tirta@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `t_annualpass`
--

CREATE TABLE `t_annualpass` (
  `No_Transaksi` varchar(25) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Pilih_Tanggal` date NOT NULL,
  `Pilh_Tiket` varchar(25) NOT NULL,
  `Harga_Tiket` varchar(25) NOT NULL,
  `Jumlah_Tiket` varchar(25) NOT NULL,
  `SubTotal` varchar(25) NOT NULL,
  `Bayar` varchar(25) NOT NULL,
  `Kembalian` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `t_annualpass`
--

INSERT INTO `t_annualpass` (`No_Transaksi`, `Nama`, `Pilih_Tanggal`, `Pilh_Tiket`, `Harga_Tiket`, `Jumlah_Tiket`, `SubTotal`, `Bayar`, `Kembalian`) VALUES
('00002', 'A1', '2024-01-19', 'Ancol - AnnualPass', '500000', '5', '2500000', '3000000', '500000');

-- --------------------------------------------------------

--
-- Table structure for table `t_reguler`
--

CREATE TABLE `t_reguler` (
  `No_Transaksi` varchar(25) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Pilih_Tanggal` date NOT NULL,
  `Pilh_Tiket` varchar(25) NOT NULL,
  `Harga_Tiket` varchar(25) NOT NULL,
  `Jumlah_Tiket` varchar(25) NOT NULL,
  `Tiket_Kendaraan` varchar(25) NOT NULL,
  `Harga_TiketKendaraan` varchar(25) NOT NULL,
  `Jumlah_Kendaraan` varchar(25) NOT NULL,
  `SubTotal` varchar(25) NOT NULL,
  `Bayar` varchar(25) NOT NULL,
  `Kembalian` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `t_reguler`
--

INSERT INTO `t_reguler` (`No_Transaksi`, `Nama`, `Pilih_Tanggal`, `Pilh_Tiket`, `Harga_Tiket`, `Jumlah_Tiket`, `Tiket_Kendaraan`, `Harga_TiketKendaraan`, `Jumlah_Kendaraan`, `SubTotal`, `Bayar`, `Kembalian`) VALUES
('00002', 'A1', '2024-01-19', 'Ancol - Regular', '30000', '6', '3. Bus', '100000', '6', '780000', '800000', '20000'),
('00003', 'PBO', '2024-01-19', 'Dufan - Regular', '25000', '5', '3. Bus', '100000', '5', '625000', '700000', '75000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabellogin`
--
ALTER TABLE `tabellogin`
  ADD PRIMARY KEY (`Email`);

--
-- Indexes for table `t_annualpass`
--
ALTER TABLE `t_annualpass`
  ADD PRIMARY KEY (`No_Transaksi`);

--
-- Indexes for table `t_reguler`
--
ALTER TABLE `t_reguler`
  ADD PRIMARY KEY (`No_Transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

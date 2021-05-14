-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 05:15 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cart_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `CID` int(11) NOT NULL,
  `Item_Code` varchar(6) NOT NULL,
  `Item_Name` varchar(20) NOT NULL,
  `Price` varchar(10) NOT NULL,
  `Qty` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`CID`, `Item_Code`, `Item_Name`, `Price`, `Qty`) VALUES
(1, '12', 'SHIRT', '250.00', '200'),
(3, '433GTY', 'SKIRT', '350.00', '500');

-- --------------------------------------------------------

--
-- Table structure for table `cart_system`
--

CREATE TABLE `cart_system` (
  `CID` int(11) NOT NULL,
  `Item_Code` varchar(6) NOT NULL,
  `Item_Name` varchar(20) NOT NULL,
  `Price` varchar(10) NOT NULL,
  `Qty` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart_system`
--

INSERT INTO `cart_system` (`CID`, `Item_Code`, `Item_Name`, `Price`, `Qty`) VALUES
(3, 'ght456', 'Skirtdedef', '10066', '5'),
(4, '444', 'dfgv', '4555', '4'),
(5, '444', 'dfgv', '4555', '4'),
(8, 'RRF445', 'SKIRT', '2280', '200'),
(10, '43', 'fdv', '20.00', '4'),
(11, '43', 'fdv', '20.00', '4'),
(12, '43', 'fdv', '20.00', '4'),
(13, '43', 'fdv', '20.00', '4'),
(14, '43', 'fdv', '20.00', '4'),
(15, '43', 'fdv', '20.00', '4'),
(16, '43', 'fdv', '20.00', '4'),
(17, '43', 'fdv', '20.00', '4'),
(18, '43', 'fdv', '20.00', '4'),
(19, '43', 'fdv', '20.00', '4'),
(20, '43', 'fdv', '20.00', '4'),
(21, '43', 'fdv', '20.00', '4'),
(22, '43', 'fdv', '20.00', '4'),
(23, '543', 'gtrv', '20.00', '436'),
(24, '543', 'gtrv', '20.00', '436'),
(25, '543', 'gtrv', '20.00', '436'),
(26, '543', 'gtrv', '20.00', '436'),
(27, '543', 'gtrv', '20.00', '436'),
(28, '543', 'gtrv', '20.00', '436'),
(29, '543', 'gtrv', '20.00', '436'),
(30, '543', 'gtrv', '20.00', '436'),
(31, '543', 'gtrv', '20.00', '436'),
(32, '543', 'gtrv', '20.00', '436'),
(33, '65', 'gbft', '56.00', '8'),
(34, '678', 'uvlyj', '20.00', '99');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`CID`);

--
-- Indexes for table `cart_system`
--
ALTER TABLE `cart_system`
  ADD PRIMARY KEY (`CID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carts`
--
ALTER TABLE `carts`
  MODIFY `CID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cart_system`
--
ALTER TABLE `cart_system`
  MODIFY `CID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

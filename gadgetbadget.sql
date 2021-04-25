-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2021 at 06:12 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyer1`
--

CREATE TABLE `buyer1` (
  `bID` int(11) NOT NULL,
  `bName` varchar(255) NOT NULL,
  `bAddress` varchar(255) NOT NULL,
  `bEmail` varchar(255) NOT NULL,
  `bDate` varchar(255) NOT NULL,
  `pNo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer1`
--

INSERT INTO `buyer1` (`bID`, `bName`, `bAddress`, `bEmail`, `bDate`, `pNo`) VALUES
(11, 'Samantha Perera', 'Colombo road, Kurunegala', 'samanthaperera@gmail.com', '20-01-2021', '0761234567'),
(12, 'Kamal Sirisena', 'Kandy road, Colombo', 'kamalsirisena@gmail.com', '14-03-2021', '0767654321'),
(13, 'Nayomi Fernando', 'Kurunegala road, Gampaha ', 'nayomifernando@gmail.com', '11-04-2021', '0789874563');

-- --------------------------------------------------------

--
-- Table structure for table `investor`
--

CREATE TABLE `investor` (
  `fid` int(11) NOT NULL,
  `ftype` varchar(20) CHARACTER SET latin1 NOT NULL,
  `fsource` varchar(20) CHARACTER SET latin1 NOT NULL,
  `famount` float NOT NULL,
  `fdate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `investor`
--

INSERT INTO `investor` (`fid`, `ftype`, `fsource`, `famount`, `fdate`) VALUES
(1, 'Passive Investor', 'Debit Capital', 50000, '20-02-2021'),
(2, 'Active Investor', 'Equity Capital', 100000, '10-03-2021');

-- --------------------------------------------------------

--
-- Table structure for table `pay1`
--

CREATE TABLE `pay1` (
  `pyId` int(11) NOT NULL,
  `pyDes` varchar(20) NOT NULL,
  `pyDate` varchar(20) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pay1`
--

INSERT INTO `pay1` (`pyId`, `pyDes`, `pyDate`, `amount`) VALUES
(1, 'Animal research', '2020/03/14', 10000),
(2, 'Computer science', '2020/04/14', 12000);

-- --------------------------------------------------------

--
-- Table structure for table `product1`
--

CREATE TABLE `product1` (
  `pId` int(11) NOT NULL,
  `pName` varchar(50) NOT NULL,
  `pDate` varchar(20) NOT NULL,
  `pPrice` varchar(20) NOT NULL,
  `pDes` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product1`
--

INSERT INTO `product1` (`pId`, `pName`, `pDate`, `pPrice`, `pDes`) VALUES
(101, 'Smarter Home Robots', '10-March-2019', '185000.00', 'Uses artificial intelligence to scan room size, identify obstacles'),
(102, 'Proactive  healthcare Management', '03- August- 2020', '75000.00', 'Learning to analyze clinical and claims data to discover gaps in a patient’s healthcare treatment'),
(103, 'Smart Map', '04-January-2021', '67000.00', 'With AI-enabled mapping, the search giant\'s technology scans road information and uses algorithms to determine the optimal route to take, be it on foot or in a car, bike, bus, or train.');

-- --------------------------------------------------------

--
-- Table structure for table `research`
--

CREATE TABLE `research` (
  `rId` int(11) NOT NULL,
  `rName` varchar(20) NOT NULL,
  `pName` varchar(200) NOT NULL,
  `rDate` varchar(20) NOT NULL,
  `rDes` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `research`
--

INSERT INTO `research` (`rId`, `rName`, `pName`, `rDate`, `rDes`) VALUES
(1, 'Senaka sampth', 'Proactive  healthcare Management', '15-March - 2020', 'good product'),
(2, 'Thusitha mangala', 'Smarter Home Robots', '25-march - 2020', 'good product');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyer1`
--
ALTER TABLE `buyer1`
  ADD PRIMARY KEY (`bID`);

--
-- Indexes for table `investor`
--
ALTER TABLE `investor`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `pay1`
--
ALTER TABLE `pay1`
  ADD PRIMARY KEY (`pyId`);

--
-- Indexes for table `product1`
--
ALTER TABLE `product1`
  ADD PRIMARY KEY (`pId`);

--
-- Indexes for table `research`
--
ALTER TABLE `research`
  ADD PRIMARY KEY (`rId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyer1`
--
ALTER TABLE `buyer1`
  MODIFY `bID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `investor`
--
ALTER TABLE `investor`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pay1`
--
ALTER TABLE `pay1`
  MODIFY `pyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `product1`
--
ALTER TABLE `product1`
  MODIFY `pId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT for table `research`
--
ALTER TABLE `research`
  MODIFY `rId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

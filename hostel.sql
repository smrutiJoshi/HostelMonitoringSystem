-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2018 at 01:47 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hostel`
--

-- --------------------------------------------------------

--
-- Table structure for table `credential`
--

CREATE TABLE `credential` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credential`
--

INSERT INTO `credential` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `enrollmentno` int(11) DEFAULT NULL,
  `dob` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`enrollmentno`, `dob`) VALUES
(NULL, NULL),
(1234, '20-08-1996'),
(NULL, NULL),
(1234, '20-08-1996'),
(111, '20-08-1996'),
(111, '20-08-1996'),
(111, '20-08-1996'),
(111, '20-08-1996'),
(12, '20-08-1999'),
(123, '20-12-1997');

-- --------------------------------------------------------

--
-- Table structure for table `registers`
--

CREATE TABLE `registers` (
  `rollno` int(50) NOT NULL,
  `name` varchar(223) NOT NULL,
  `addr` varchar(223) NOT NULL,
  `phno` int(11) NOT NULL,
  `branch` varchar(333) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `isregistered` tinyint(1) NOT NULL,
  `username` varchar(233) NOT NULL,
  `password` varchar(233) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registers`
--

INSERT INTO `registers` (`rollno`, `name`, `addr`, `phno`, `branch`, `dob`, `isregistered`, `username`, `password`) VALUES
(44, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', 'admin'),
(55, 'smruti', 'null', 2318621, 'ETC', 'null', 0, 'sadmin', 'sadmin'),
(59, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', 'admin'),
(552, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', 'rrrr'),
(554, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', ''),
(558, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', 'admin'),
(600, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', 'admin'),
(601, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', 'admin'),
(602, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', 'admin'),
(603, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', ''),
(604, 'fff', 'null', 2318621, 'ETC', 'null', 0, 'admin', ''),
(606, 'smruti', 'Ponda', 2318621, 'ETC', '2018-04-06', 0, 'admin', 'admin'),
(789, 'yui', 'jkl', 567890, 'IT', '2017-12-07', 0, 'ftg', 'ftg'),
(1234, 'eds', 'dffgh', 74512689, 'COMP', '2018-04-27', 0, 'admin', 'admin'),
(1345, 'keerti', 'null', 6789, 'COMP', 'null', 0, 'keerti', 'kitu'),
(141105065, 'vaishnavee', 'ponda', 67676767, 'comp', '04/09/1996', 0, 'vai', 'vai');

-- --------------------------------------------------------

--
-- Table structure for table `scredential`
--

CREATE TABLE `scredential` (
  `username1` varchar(255) NOT NULL,
  `password1` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `scredential`
--

INSERT INTO `scredential` (`username1`, `password1`) VALUES
('sadmin', 'sadmin');

-- --------------------------------------------------------

--
-- Table structure for table `semconfirm`
--

CREATE TABLE `semconfirm` (
  `semconfirmid` int(11) NOT NULL,
  `rollno` int(50) NOT NULL,
  `sem` int(1) NOT NULL,
  `isChecked` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semconfirm`
--

INSERT INTO `semconfirm` (`semconfirmid`, `rollno`, `sem`, `isChecked`) VALUES
(1, 600, 1, 0),
(2, 602, 1, 0),
(3, 604, 1, 0),
(4, 606, 1, 0),
(5, 1234, 6, 0),
(6, 789, 4, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registers`
--
ALTER TABLE `registers`
  ADD PRIMARY KEY (`rollno`);

--
-- Indexes for table `semconfirm`
--
ALTER TABLE `semconfirm`
  ADD PRIMARY KEY (`semconfirmid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `semconfirm`
--
ALTER TABLE `semconfirm`
  MODIFY `semconfirmid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

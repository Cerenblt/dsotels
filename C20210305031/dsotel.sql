-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2024 at 03:42 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dsotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `İD` int(250) NOT NULL,
  `Reservatıon ıd` int(250) DEFAULT NULL,
  `Amount` decimal(5,0) DEFAULT NULL,
  `Payment_Date` date DEFAULT NULL,
  `Payment_method` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`İD`, `Reservatıon ıd`, `Amount`, `Payment_Date`, `Payment_method`) VALUES
(2, 2, '4', '2024-05-15', 'CRE'),
(3, 3, '2', '2024-05-15', 'CAS'),
(4, 4, '2', '2024-05-15', 'CAS'),
(5, 5, '1', '2024-05-15', 'EFT');

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `ReservatıonID` int(100) NOT NULL,
  `UserID` int(200) DEFAULT NULL,
  `Room Number` int(10) DEFAULT NULL,
  `Check_in_date` date NOT NULL,
  `Check_out_date` date DEFAULT NULL,
  `Total_Price` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`ReservatıonID`, `UserID`, `Room Number`, `Check_in_date`, `Check_out_date`, `Total_Price`) VALUES
(2, 6, 5, '2024-05-15', '2024-05-30', '450.000 TL'),
(3, 3, 1, '2024-06-06', '2024-06-09', '21.000 TL'),
(4, 8, 2, '2024-07-17', '2024-05-20', '42.000TL'),
(5, 4, 4, '2024-05-30', '2024-05-31', '22.000TL');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `Id` int(11) NOT NULL,
  `Room Number` int(100) DEFAULT NULL,
  `Type` varchar(6) DEFAULT NULL,
  `Price_per_Night` decimal(50,0) DEFAULT NULL,
  `Availability` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`Id`, `Room Number`, `Type`, `Price_per_Night`, `Availability`) VALUES
(2, 1, 'Single', '7000', 1),
(3, 2, 'Double', '14000', 1),
(4, 3, 'Double', '11000', 1),
(5, 4, 'FAMILY', '25000', 0),
(6, 5, 'DELUXE', '18000', 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserID` int(250) NOT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `Password` int(100) DEFAULT NULL,
  `First Name` varchar(50) DEFAULT NULL,
  `Last Name` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `Username`, `Password`, `First Name`, `Last Name`, `Email`) VALUES
(3, 'Chloe', 3848, 'Chloe', 'Masata', 'chloe78@gmail.com'),
(4, 'Arzu Kaplan', 4525, 'Arzu', 'Kaplan', 'arzukaplan@.hotmail.com'),
(5, 'Reception', 3696, 'HOTEL', 'RECEPTION', 'Armanda_hotel@reception.info@gmail.com'),
(6, 'Customer', 1358900, 'Ceren', 'Bulut', 'cbtugce3@gmail.com'),
(7, 'Administrative', 1414154, 'ARMANDA HOTEL', 'admiistrative', 'Armanda.hotel_adrative.info@hotmail.tr'),
(8, 'POE', 1788, 'Poe', 'POLO', 'travellerpoe1@hotmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`İD`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`ReservatıonID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `İD` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `ReservatıonID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserID` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

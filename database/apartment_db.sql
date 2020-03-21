-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2020 at 04:17 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apartment_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `apartment`
--

CREATE TABLE `apartment` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `no_of_units` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apartment`
--

INSERT INTO `apartment` (`id`, `user_id`, `name`, `address`, `no_of_units`) VALUES
(1, 2, 'Apartment', '123', 1),
(2, 5, 'oregairu', 'Japan', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tenants`
--

CREATE TABLE `tenants` (
  `id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `contact_no` bigint(20) NOT NULL,
  `balance` double NOT NULL,
  `advance` double NOT NULL,
  `last_payment` date NOT NULL,
  `water_bill` double NOT NULL,
  `electric_bill` double NOT NULL,
  `last_checked` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tenants`
--

INSERT INTO `tenants` (`id`, `unit_id`, `last_name`, `first_name`, `contact_no`, `balance`, `advance`, `last_payment`, `water_bill`, `electric_bill`, `last_checked`) VALUES
(12, 8, 'Yagami', 'Light', 9123456789, 0, 4000, '2020-03-16', 43, 43, '2020-03-12'),
(13, 9, '', 'L', 9123456789, 35000, 5000, '2020-03-12', 0, 0, '2020-03-12'),
(16, 13, 'Senados', 'Rene', 9123456789, 0, 500, '0000-00-00', 0, 0, '2020-03-12'),
(17, 15, 'Wiws', 'sd', 9123456879, 5000, 0, '0000-00-00', 0, 0, '2020-03-14'),
(22, 24, 'seraf', 'seraf', 123, 0, 1957, '2020-03-16', 85, 85, '2020-03-14');

-- --------------------------------------------------------

--
-- Table structure for table `units`
--

CREATE TABLE `units` (
  `id` int(11) NOT NULL,
  `apartment_id` int(11) NOT NULL,
  `unit_name` varchar(20) NOT NULL,
  `unit_price` int(20) NOT NULL,
  `unit_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `units`
--

INSERT INTO `units` (`id`, `apartment_id`, `unit_name`, `unit_price`, `unit_type`) VALUES
(8, 2, '2-A', 5000, 'studio'),
(9, 2, '2-B', 5000, 'studio'),
(13, 2, '2-E', 5000, '123'),
(22, 2, '1-A', 5000, '123'),
(24, 1, '1-Z', 123, 'studio');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `email`, `password`) VALUES
(2, 'Senados', 'Rafael', 'SeRaf', 'senados.rafael@gmail.com', '123'),
(4, 'Monkey', 'Luffy', 'OnePiece', 'OnePiece@gmail.com', '123'),
(5, 'Hachiman', 'Hikigaya', 'hachiman', 'hachiman@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apartment`
--
ALTER TABLE `apartment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tenants`
--
ALTER TABLE `tenants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `units`
--
ALTER TABLE `units`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apartment`
--
ALTER TABLE `apartment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tenants`
--
ALTER TABLE `tenants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `units`
--
ALTER TABLE `units`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

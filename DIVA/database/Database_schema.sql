-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 17, 2016 at 05:29 PM
-- Server version: 5.5.47-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `diva_main`
--
CREATE DATABASE IF NOT EXISTS `diva_main` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `diva_main`;

-- --------------------------------------------------------

--
-- Table structure for table `account_balance`
--

CREATE TABLE IF NOT EXISTS `account_balance` (
  `id_number` smallint(5) unsigned NOT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `account_balance`:
--   `id_number`
--       `users` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE IF NOT EXISTS `branch` (
  `br_num` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `street_name` varchar(40) NOT NULL,
  `city` varchar(25) NOT NULL,
  `province` set('AB','BC','MB','NB','NL','NS','NT','NU','ON','PE','QC','SK','YT') NOT NULL DEFAULT 'BC',
  `zip_code` varchar(6) NOT NULL,
  PRIMARY KEY (`br_num`),
  UNIQUE KEY `zip_code` (`zip_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

-- --------------------------------------------------------

--
-- Table structure for table `branch_vehicle`
--

CREATE TABLE IF NOT EXISTS `branch_vehicle` (
  `vehicle_id` mediumint(8) unsigned NOT NULL,
  `location` tinyint(2) unsigned NOT NULL,
  PRIMARY KEY (`vehicle_id`),
  KEY `location` (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `branch_vehicle`:
--   `vehicle_id`
--       `vehicle` -> `vehicle_id`
--   `location`
--       `branch` -> `br_num`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE IF NOT EXISTS `car` (
  `vehicle_id` mediumint(8) unsigned NOT NULL,
  `class` enum('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van') NOT NULL,
  `baggage` tinyint(1) unsigned NOT NULL,
  `door` varchar(3) DEFAULT NULL,
  `transmission` bit(1) DEFAULT b'1',
  `air_condition` bit(1) DEFAULT b'1',
  `capacity` decimal(1,0) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`),
  KEY `class` (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `car`:
--   `vehicle_id`
--       `vehicle` -> `vehicle_id`
--   `class`
--       `car_price` -> `class`
--

-- --------------------------------------------------------

--
-- Table structure for table `car_price`
--

CREATE TABLE IF NOT EXISTS `car_price` (
  `class` enum('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van') NOT NULL,
  `perHour` decimal(5,2) NOT NULL,
  `perDay` decimal(5,2) NOT NULL,
  `perWeek` decimal(5,2) NOT NULL,
  `perMonth` decimal(6,2) NOT NULL,
  `perKM` decimal(3,2) NOT NULL,
  PRIMARY KEY (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id_number` smallint(5) unsigned NOT NULL,
  `standing` set('Good','Probation','Suspended') NOT NULL DEFAULT 'Good',
  `cc_Num` varchar(48) DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  `name_on_cCard` varchar(20) DEFAULT NULL,
  `street_name` varchar(40) NOT NULL,
  `city` varchar(25) NOT NULL,
  `province` set('AB','BC','MB','NB','NL','NS','NT','NU','ON','PE','QC','SK','YT') NOT NULL,
  `zipcode` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `customer`:
--   `id_number`
--       `users` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id_number` smallint(5) unsigned NOT NULL,
  `works_at` tinyint(2) unsigned NOT NULL,
  `e_type` enum('Clerk','Manager','SystemAdmin') DEFAULT NULL,
  PRIMARY KEY (`id_number`),
  KEY `works_at` (`works_at`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `employee`:
--   `works_at`
--       `branch` -> `br_num`
--   `id_number`
--       `users` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE IF NOT EXISTS `equipment` (
  `serial_num` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `location` tinyint(2) unsigned NOT NULL,
  `eq_type` enum('ski rack','child safety seat','lift gate','car-towing eq') NOT NULL,
  PRIMARY KEY (`serial_num`),
  KEY `location` (`location`),
  KEY `eq_type` (`eq_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- RELATIONS FOR TABLE `equipment`:
--   `location`
--       `branch` -> `br_num`
--

-- --------------------------------------------------------

--
-- Table structure for table `equipment_price`
--

CREATE TABLE IF NOT EXISTS `equipment_price` (
  `class` enum('ski rack','child safety seat','lift gate','car-towing eq') NOT NULL,
  `perWeek` decimal(5,2) NOT NULL,
  `perDay` decimal(5,2) NOT NULL,
  `perHour` decimal(5,2) NOT NULL,
  PRIMARY KEY (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `extra_charge`
--

CREATE TABLE IF NOT EXISTS `extra_charge` (
  `type` varchar(20) NOT NULL,
  `price` decimal(6,2) unsigned NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `insurance_car_price`
--

CREATE TABLE IF NOT EXISTS `insurance_car_price` (
  `class` enum('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van') NOT NULL,
  `perHour` decimal(5,2) NOT NULL,
  `perDay` decimal(5,2) NOT NULL,
  `perWeek` decimal(5,2) NOT NULL,
  PRIMARY KEY (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `insurance_car_price`:
--   `class`
--       `car_price` -> `class`
--

-- --------------------------------------------------------

--
-- Table structure for table `insurance_truck_price`
--

CREATE TABLE IF NOT EXISTS `insurance_truck_price` (
  `class` enum('24-foot','15-foot','12-foot','box-truck') NOT NULL,
  `perHour` decimal(5,2) NOT NULL,
  `perDay` decimal(5,2) NOT NULL,
  `perWeek` decimal(5,2) NOT NULL,
  PRIMARY KEY (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `insurance_truck_price`:
--   `class`
--       `truck_price` -> `class`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment_log`
--

CREATE TABLE IF NOT EXISTS `payment_log` (
  `id_number` smallint(5) unsigned NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `p_date` date NOT NULL,
  `reason` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `payment_log`:
--   `id_number`
--       `users` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE IF NOT EXISTS `receipt` (
  `receipt_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` smallint(5) unsigned NOT NULL,
  `employee_id` smallint(5) unsigned DEFAULT NULL,
  `payment_info` varchar(500) DEFAULT NULL,
  `basic_info` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`receipt_id`),
  KEY `customer_id` (`customer_id`),
  KEY `employee_id` (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- RELATIONS FOR TABLE `receipt`:
--   `customer_id`
--       `customer` -> `id_number`
--   `employee_id`
--       `employee` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE IF NOT EXISTS `rental` (
  `reservation_id` mediumint(8) unsigned NOT NULL,
  `is_paid_rental` tinyint(1) DEFAULT NULL,
  `is_paid_extra_charge` tinyint(1) DEFAULT NULL,
  `clerk_id` smallint(5) unsigned NOT NULL,
  `is_check_overdue` tinyint(1) NOT NULL,
  `is_check_return_branch` tinyint(1) NOT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `clerk_id` (`clerk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `rental`:
--   `reservation_id`
--       `reservation` -> `reservation_id`
--   `clerk_id`
--       `employee` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `rented_equipment`
--

CREATE TABLE IF NOT EXISTS `rented_equipment` (
  `reservation_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `equipment_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`reservation_id`,`equipment_id`),
  KEY `equipment_id` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `rented_equipment`:
--   `reservation_id`
--       `reservation` -> `reservation_id`
--   `equipment_id`
--       `equipment` -> `serial_num`
--

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE IF NOT EXISTS `report` (
  `report_num` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `reporting_clerk` smallint(5) unsigned NOT NULL,
  `rental_id` mediumint(8) unsigned NOT NULL,
  `milage` mediumint(8) unsigned NOT NULL,
  `gasLevel` smallint(3) unsigned NOT NULL,
  `comments` text,
  `state` enum('before_rental','after_rental') NOT NULL,
  `report_date` datetime NOT NULL,
  PRIMARY KEY (`report_num`),
  UNIQUE KEY `uc_res_state` (`rental_id`,`state`),
  KEY `reporting_clerk` (`reporting_clerk`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- RELATIONS FOR TABLE `report`:
--   `rental_id`
--       `reservation` -> `reservation_id`
--   `reporting_clerk`
--       `employee` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `report_accident`
--

CREATE TABLE IF NOT EXISTS `report_accident` (
  `report_num` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `rental_id` mediumint(8) unsigned DEFAULT NULL,
  `clerk_id` smallint(5) unsigned NOT NULL,
  `accident_date` datetime NOT NULL,
  `comments` text,
  `driver` varchar(40) NOT NULL,
  `balance` decimal(8,2) NOT NULL,
  `street_name` varchar(40) NOT NULL,
  `city` varchar(25) NOT NULL,
  `province` set('AB','BC','MB','NB','NL','NS','NT','NU','ON','PE','QC','SK','YT') NOT NULL,
  `zipcode` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`report_num`),
  UNIQUE KEY `rental_id` (`rental_id`),
  KEY `clerk_id` (`clerk_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- RELATIONS FOR TABLE `report_accident`:
--   `rental_id`
--       `rental` -> `reservation_id`
--   `clerk_id`
--       `employee` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `reservation_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `customer` smallint(5) unsigned NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `start_branch` tinyint(2) unsigned NOT NULL,
  `end_branch` tinyint(2) unsigned NOT NULL,
  `vehicle_id` mediumint(8) unsigned NOT NULL,
  `balance` decimal(6,2) NOT NULL,
  `withInsurance` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `uc_date_vehicle` (`start_date`,`end_date`,`vehicle_id`),
  KEY `customer` (`customer`),
  KEY `start_branch` (`start_branch`),
  KEY `end_branch` (`end_branch`),
  KEY `vehicle_id` (`vehicle_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=70 ;

--
-- RELATIONS FOR TABLE `reservation`:
--   `customer`
--       `customer` -> `id_number`
--   `start_branch`
--       `branch` -> `br_num`
--   `end_branch`
--       `branch` -> `br_num`
--   `vehicle_id`
--       `vehicle` -> `vehicle_id`
--

-- --------------------------------------------------------

--
-- Table structure for table `super_customer`
--

CREATE TABLE IF NOT EXISTS `super_customer` (
  `id_number` smallint(5) unsigned NOT NULL,
  `points` smallint(6) unsigned DEFAULT '500',
  PRIMARY KEY (`id_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `super_customer`:
--   `id_number`
--       `customer` -> `id_number`
--

-- --------------------------------------------------------

--
-- Table structure for table `truck`
--

CREATE TABLE IF NOT EXISTS `truck` (
  `vehicle_id` mediumint(8) unsigned NOT NULL,
  `class` enum('24-foot','15-foot','12-foot','box-truck') NOT NULL,
  `interior_b_l` decimal(4,2) unsigned NOT NULL,
  `interior_b_w` decimal(4,2) unsigned NOT NULL,
  `interior_b_h` decimal(4,2) unsigned NOT NULL,
  `capacity_kg` decimal(5,0) unsigned NOT NULL,
  PRIMARY KEY (`vehicle_id`),
  KEY `class` (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `truck`:
--   `vehicle_id`
--       `vehicle` -> `vehicle_id`
--   `class`
--       `truck_price` -> `class`
--

-- --------------------------------------------------------

--
-- Table structure for table `truck_price`
--

CREATE TABLE IF NOT EXISTS `truck_price` (
  `class` enum('24-foot','15-foot','12-foot','box-truck') NOT NULL,
  `perHour` decimal(5,2) NOT NULL,
  `perDay` decimal(5,2) NOT NULL,
  `perWeek` decimal(5,2) NOT NULL,
  `perMonth` decimal(6,2) NOT NULL,
  `perKM` decimal(3,2) NOT NULL,
  PRIMARY KEY (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_number` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `email` varchar(40) NOT NULL,
  `account_uName` varchar(20) NOT NULL,
  `account_password` varchar(512) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_number`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=96 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE IF NOT EXISTS `vehicle` (
  `vehicle_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(20) NOT NULL,
  `v_year` year(4) NOT NULL,
  `model` varchar(20) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `sale_status` enum('sold','for sale','for rent','damaged') DEFAULT 'for rent',
  `path` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=107 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_sale_price`
--

CREATE TABLE IF NOT EXISTS `vehicle_sale_price` (
  `vehicle_id` mediumint(8) unsigned NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `vehicle_sale_price`:
--   `vehicle_id`
--       `vehicle` -> `vehicle_id`
--

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account_balance`
--
ALTER TABLE `account_balance`
  ADD CONSTRAINT `account_balance_ibfk_1` FOREIGN KEY (`id_number`) REFERENCES `users` (`id_number`);

--
-- Constraints for table `branch_vehicle`
--
ALTER TABLE `branch_vehicle`
  ADD CONSTRAINT `branch_vehicle_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`),
  ADD CONSTRAINT `branch_vehicle_ibfk_2` FOREIGN KEY (`location`) REFERENCES `branch` (`br_num`);

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `car_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`),
  ADD CONSTRAINT `car_ibfk_2` FOREIGN KEY (`class`) REFERENCES `car_price` (`class`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`id_number`) REFERENCES `users` (`id_number`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`works_at`) REFERENCES `branch` (`br_num`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`id_number`) REFERENCES `users` (`id_number`);

--
-- Constraints for table `equipment`
--
ALTER TABLE `equipment`
  ADD CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`location`) REFERENCES `branch` (`br_num`);

--
-- Constraints for table `insurance_car_price`
--
ALTER TABLE `insurance_car_price`
  ADD CONSTRAINT `insurance_car_price_ibfk_1` FOREIGN KEY (`class`) REFERENCES `car_price` (`class`);

--
-- Constraints for table `insurance_truck_price`
--
ALTER TABLE `insurance_truck_price`
  ADD CONSTRAINT `insurance_truck_price_ibfk_1` FOREIGN KEY (`class`) REFERENCES `truck_price` (`class`);

--
-- Constraints for table `payment_log`
--
ALTER TABLE `payment_log`
  ADD CONSTRAINT `payment_log_ibfk_1` FOREIGN KEY (`id_number`) REFERENCES `users` (`id_number`);

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id_number`),
  ADD CONSTRAINT `receipt_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id_number`);

--
-- Constraints for table `rental`
--
ALTER TABLE `rental`
  ADD CONSTRAINT `rental_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`),
  ADD CONSTRAINT `rental_ibfk_2` FOREIGN KEY (`clerk_id`) REFERENCES `employee` (`id_number`);

--
-- Constraints for table `rented_equipment`
--
ALTER TABLE `rented_equipment`
  ADD CONSTRAINT `rented_equipment_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`),
  ADD CONSTRAINT `rented_equipment_ibfk_2` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`serial_num`);

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`rental_id`) REFERENCES `reservation` (`reservation_id`),
  ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`reporting_clerk`) REFERENCES `employee` (`id_number`);

--
-- Constraints for table `report_accident`
--
ALTER TABLE `report_accident`
  ADD CONSTRAINT `report_accident_ibfk_1` FOREIGN KEY (`rental_id`) REFERENCES `rental` (`reservation_id`),
  ADD CONSTRAINT `report_accident_ibfk_2` FOREIGN KEY (`clerk_id`) REFERENCES `employee` (`id_number`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`customer`) REFERENCES `customer` (`id_number`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`start_branch`) REFERENCES `branch` (`br_num`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`end_branch`) REFERENCES `branch` (`br_num`),
  ADD CONSTRAINT `reservation_ibfk_4` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`);

--
-- Constraints for table `super_customer`
--
ALTER TABLE `super_customer`
  ADD CONSTRAINT `super_customer_ibfk_1` FOREIGN KEY (`id_number`) REFERENCES `customer` (`id_number`);

--
-- Constraints for table `truck`
--
ALTER TABLE `truck`
  ADD CONSTRAINT `truck_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`),
  ADD CONSTRAINT `truck_ibfk_2` FOREIGN KEY (`class`) REFERENCES `truck_price` (`class`);

--
-- Constraints for table `vehicle_sale_price`
--
ALTER TABLE `vehicle_sale_price`
  ADD CONSTRAINT `vehicle_sale_price_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

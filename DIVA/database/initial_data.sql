SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
--
-- Database: `diva_main`
--

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`br_num`, `street_name`, `city`, `province`, `zip_code`) VALUES(1, '100 Manitoba Street', 'Vancouver', 'BC', 'V5Y2Z6');
INSERT INTO `branch` (`br_num`, `street_name`, `city`, `province`, `zip_code`) VALUES(2, '3211 Grant McConachie Way', 'Richmond', 'BC', 'V7B 0A');
INSERT INTO `branch` (`br_num`, `street_name`, `city`, `province`, `zip_code`) VALUES(3, '757 Hornby Street', 'Vancouver', 'BC', 'V6Z1S2');
INSERT INTO `branch` (`br_num`, `street_name`, `city`, `province`, `zip_code`) VALUES(4, ' 100 Manitoba Street', 'Vancouver', 'BC', 'V4TZ7T');
INSERT INTO `branch` (`br_num`, `street_name`, `city`, `province`, `zip_code`) VALUES(5, '2871 East 1st', 'Vancouver', 'BC', 'V7S1A1');
INSERT INTO `branch` (`br_num`, `street_name`, `city`, `province`, `zip_code`) VALUES(8, '123 Fake Street', 'Saskatoon', 'SK', 'V8R6S1');

--
-- Dumping data for table `branch_vehicle`
--

INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(11, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(16, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(17, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(18, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(31, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(34, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(35, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(38, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(43, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(44, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(46, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(48, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(51, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(52, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(53, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(56, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(57, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(58, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(63, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(70, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(72, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(82, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(91, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(92, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(93, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(94, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(95, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(100, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(106, 1);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(2, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(3, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(4, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(5, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(12, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(13, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(14, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(15, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(29, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(37, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(39, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(81, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(83, 2);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(41, 3);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(60, 3);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(61, 3);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(62, 3);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(73, 3);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(99, 3);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(1, 4);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(55, 4);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(74, 4);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(80, 4);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(30, 5);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(54, 5);
INSERT INTO `branch_vehicle` (`vehicle_id`, `location`) VALUES(66, 5);

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(1, 'economy', 2, '4', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(2, 'compact', 1, '3', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(3, 'midsized', 2, '4', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(6, 'economy', 2, '5', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(10, 'midsized', 2, '4', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(11, 'midsized', 2, '4', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(17, 'economy', 2, '2', b'1', b'1', 1);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(18, 'economy', 2, '2', b'1', b'1', 1);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(19, 'luxury', 2, '3', b'1', b'0', 0);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(20, 'luxury', 2, '3', b'1', b'0', 0);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(21, 'luxury', 2, '3', b'1', b'0', 0);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(22, 'luxury', 2, '3', b'1', b'0', 0);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(24, 'luxury', 2, '3', b'1', b'0', 0);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(25, 'luxury', 2, '3', b'1', b'0', 0);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(26, 'luxury', 2, '2', b'1', b'1', 1);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(27, 'luxury', 2, '2', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(28, 'luxury', 2, '2', b'1', b'1', 2);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(30, 'luxury', 2, '3', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(32, 'luxury', 2, '2', b'1', b'1', 2);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(33, 'luxury', 2, '2', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(34, 'luxury', 2, '3', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(35, 'luxury', 2, '3', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(37, 'compact', 2, '2', b'0', b'0', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(38, 'compact', 4, '4', b'0', b'0', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(39, 'compact', 3, '2', b'0', b'0', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(41, 'midsized', 3, '4', b'0', b'0', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(43, 'luxury', 4, '4', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(44, 'luxury', 4, '4', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(46, 'luxury', 4, '4', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(48, 'luxury', 4, '4', b'1', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(52, 'luxury', 2, '3', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(55, 'economy', 4, '4', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(56, 'economy', 4, '4', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(57, 'economy', 4, '4', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(58, 'economy', 4, '4', b'1', b'1', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(60, 'fullsized', 3, '4', b'0', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(62, 'economy', 3, '4', b'0', b'1', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(63, 'luxury', 5, '4', b'0', b'0', 5);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(65, 'economy', 5, '4', b'1', b'1', 9);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(66, 'economy', 5, '4', b'1', b'1', 9);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(67, 'economy', 5, '4', b'1', b'1', 9);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(68, 'economy', 5, '4', b'1', b'1', 9);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(70, 'economy', 5, '4', b'1', b'1', 9);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(72, 'fullsized', 2, '3', b'1', b'1', 1);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(81, 'compact', 5, '2', b'1', b'0', 4);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(82, 'compact', 4, '4', b'1', b'0', 3);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(83, 'SUV', 3, '2', b'0', b'1', 2);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(91, 'SUV', 4, '4', b'0', b'1', 2);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(92, 'SUV', 4, '4', b'0', b'1', 2);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(93, 'SUV', 4, '4', b'0', b'1', 2);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(94, 'SUV', 4, '4', b'0', b'1', 2);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(95, 'compact', 3, '4', b'0', b'0', 3);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(99, 'SUV', 5, '2', b'1', b'0', 3);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(100, 'SUV', 4, '2', b'1', b'1', 3);
INSERT INTO `car` (`vehicle_id`, `class`, `baggage`, `door`, `transmission`, `air_condition`, `capacity`) VALUES(106, 'SUV', 6, '2', b'1', b'0', 3);

--
-- Dumping data for table `car_price`
--

INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('economy', 3.00, 15.00, 80.00, 300.00, 0.25);
INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('compact', 3.10, 15.99, 90.00, 520.00, 0.30);
INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('midsized', 3.50, 18.00, 100.00, 680.00, 0.35);
INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('standard', 3.60, 20.00, 140.00, 950.00, 0.40);
INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('fullsized', 3.99, 25.00, 175.00, 1125.00, 0.50);
INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('premium', 4.25, 30.00, 210.00, 1300.00, 0.55);
INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('luxury', 10.00, 80.00, 500.00, 1800.00, 0.88);
INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('SUV', 4.25, 30.00, 210.00, 1300.00, 0.55);
INSERT INTO `car_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('van', 4.25, 30.00, 210.00, 1300.00, 0.55);

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id_number`, `works_at`, `e_type`) VALUES(4, 2, 'Clerk');
INSERT INTO `employee` (`id_number`, `works_at`, `e_type`) VALUES(5, 2, 'Manager');
INSERT INTO `employee` (`id_number`, `works_at`, `e_type`) VALUES(6, 3, 'Clerk');
INSERT INTO `employee` (`id_number`, `works_at`, `e_type`) VALUES(7, 3, 'Manager');
INSERT INTO `employee` (`id_number`, `works_at`, `e_type`) VALUES(8, 1, 'SystemAdmin');
--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`serial_num`, `location`, `eq_type`) VALUES(1, 2, 'ski rack');
INSERT INTO `equipment` (`serial_num`, `location`, `eq_type`) VALUES(2, 2, 'child safety seat');
INSERT INTO `equipment` (`serial_num`, `location`, `eq_type`) VALUES(3, 1, 'lift gate');
INSERT INTO `equipment` (`serial_num`, `location`, `eq_type`) VALUES(4, 4, 'lift gate');
INSERT INTO `equipment` (`serial_num`, `location`, `eq_type`) VALUES(5, 5, 'car-towing eq');
INSERT INTO `equipment` (`serial_num`, `location`, `eq_type`) VALUES(6, 3, 'ski rack');

--
-- Dumping data for table `equipment_price`
--

INSERT INTO `equipment_price` (`class`, `perWeek`, `perDay`, `perHour`) VALUES('ski rack', 50.00, 10.00, 2.00);
INSERT INTO `equipment_price` (`class`, `perWeek`, `perDay`, `perHour`) VALUES('child safety seat', 50.00, 10.00, 2.00);
INSERT INTO `equipment_price` (`class`, `perWeek`, `perDay`, `perHour`) VALUES('lift gate', 60.00, 12.00, 3.00);
INSERT INTO `equipment_price` (`class`, `perWeek`, `perDay`, `perHour`) VALUES('car-towing eq', 100.00, 18.00, 5.00);

--
-- Dumping data for table `extra_charge`
--

INSERT INTO `extra_charge` (`type`, `price`) VALUES('gas_tank', 0.60);
INSERT INTO `extra_charge` (`type`, `price`) VALUES('overdue_daily', 30.00);
INSERT INTO `extra_charge` (`type`, `price`) VALUES('wrong_branch', 100.00);

--
-- Dumping data for table `insurance_car_price`
--

INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('economy', 0.30, 6.26, 36.52);
INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('compact', 0.36, 7.51, 43.83);
INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('midsized', 0.43, 9.02, 52.59);
INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('standard', 0.52, 10.82, 63.11);
INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('fullsized', 0.62, 12.98, 75.73);
INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('premium', 0.75, 15.58, 90.88);
INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('luxury', 1.29, 26.92, 157.04);
INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('SUV', 0.90, 18.69, 109.05);
INSERT INTO `insurance_car_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('van', 1.07, 22.43, 130.86);

--
-- Dumping data for table `insurance_truck_price`
--

INSERT INTO `insurance_truck_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('24-foot', 1.19, 22.76, 364.09);
INSERT INTO `insurance_truck_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('15-foot', 0.89, 17.07, 273.07);
INSERT INTO `insurance_truck_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('12-foot', 0.67, 12.80, 204.80);
INSERT INTO `insurance_truck_price` (`class`, `perHour`, `perDay`, `perWeek`) VALUES('box-truck', 0.50, 9.60, 153.60);

--
-- Dumping data for table `truck`
--

INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(4, '15-foot', 7.08, 8.00, 15.00, 1150);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(5, '24-foot', 8.50, 8.00, 24.00, 3200);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(9, '15-foot', 7.08, 8.00, 15.00, 1150);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(12, '24-foot', 8.50, 8.00, 24.00, 3200);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(16, '24-foot', 8.50, 8.00, 24.00, 3200);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(29, '24-foot', 8.50, 8.00, 24.00, 3200);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(31, '15-foot', 8.50, 8.00, 24.00, 5200);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(51, 'box-truck', 8.50, 8.00, 24.00, 3200);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(53, '12-foot', 4.50, 4.00, 2.00, 2300);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(54, '12-foot', 4.50, 4.00, 2.00, 2300);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(61, '24-foot', 6.00, 5.50, 1.00, 600);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(73, '12-foot', 8.50, 8.00, 24.00, 4200);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(74, '12-foot', 8.50, 8.00, 24.00, 5200);
INSERT INTO `truck` (`vehicle_id`, `class`, `interior_b_l`, `interior_b_w`, `interior_b_h`, `capacity_kg`) VALUES(80, 'box-truck', 9.00, 8.00, 5.00, 5200);

--
-- Dumping data for table `truck_price`
--

INSERT INTO `truck_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('24-foot', 8.00, 45.00, 300.00, 1100.00, 0.66);
INSERT INTO `truck_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('15-foot', 7.00, 40.00, 270.00, 1000.00, 0.60);
INSERT INTO `truck_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('12-foot', 6.50, 35.00, 250.00, 900.00, 0.55);
INSERT INTO `truck_price` (`class`, `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM`) VALUES('box-truck', 6.00, 30.00, 220.00, 800.00, 0.50);

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(1, 'John', 'Doe', '7780000000', 'joedoe@example.com', 'jdoe01', 'xaxaxa', 1);
INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(2, 'Marry', 'Jane', '7780000001', 'marryjane@example.com', 'mjane01', 'admin', 1);
INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(3, 'James', 'Kurt', '7780000003', 'jameskurt@example.com', 'jkurt01', 'admin', 1);
INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(4, 'Steward', 'Freeman', '7780000004', 'stewardfreeman@example.com', 'sfreeman01', 'admin', 1);
INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(5, 'Luke', 'Phillips', '7780000005', 'lukephillips@example.com', 'lphillips01', 'admin', 1);
INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(6, 'Noah', 'Johnson', '7780000006', 'noahjohnson@example.com', 'njohnson01', 'admin', 1);
INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(7, 'Omar', 'Barnes', '7780000007', 'omarbarnes@example.com', 'obarnes01', 'admin', 1);
INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(8, 'Elizabeth', 'Hunter', '7780000008', 'ehunter@example.com', 'ehunter01', 'admin1', 1);
INSERT INTO `users` (`id_number`, `first_name`, `last_name`, `phone`, `email`, `account_uName`, `account_password`, `isActive`) VALUES(9, 'John', 'Johnson', '778190021', 'jj@live.sa', 'jjohn00', 'system', 0);

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(1, 'Chevrolet', 2010, 'Spark', 'Green', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(2, 'Chevrolet', 2010, 'Sonic', 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(3, 'Chrysler', 2010, '200', 'Dark Blue', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(4, 'U-Haul', 2010, NULL, 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(5, 'U-Haul', 2010, NULL, 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(6, 'Chevrolet', 2011, 'Spark', 'Blue', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(9, 'U-Haul', 2011, '', 'White', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(10, 'Chrysler', 2010, 'Sonic', 'Blue', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(11, 'Chrysler', 2010, 'Sonic', 'Blue', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(12, 'U-haul', 2011, '', 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(13, 'U-haul', 2011, '', 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(14, 'U-haul', 2011, '', 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(15, 'U-haul', 2011, 'null', 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(16, 'FedEx', 2011, 'XWing-2398', 'teal', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(17, 'Toyota', 2020, 'Corolla', 'maroon', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(18, 'Toyota', 2020, 'Corolla', 'maroon', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(19, 'Subaru', 2016, 'Sti-360', 'Striped Scarlet Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(20, 'Subaru', 2016, 'Sti-360', 'ScarletRed', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(21, 'Subaru', 2016, 'Sti-360', 'ScarletRed', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(22, 'Subaru', 2016, 'Sti-360', 'Striped Scarlet Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(24, 'Subaru', 2016, 'Sti-360', 'Striped Scarlet Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(25, 'subaru', 2016, 'sti', 'red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(26, 'Subaru', 2016, 'STI', 'Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(27, 'Subaru', 2016, 'STI', 'Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(28, 'Subaru', 2016, 'STi', 'red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(29, 'U-haul', 2011, '', 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(30, 'Subaru', 2016, 'Sti', 'red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(31, 'Budget', 2013, 'Godzilla', 'Scarlet Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(32, 'Subaru', 2016, 'STi', 'red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(33, 'Subaru', 2010, 'Sti', 'green', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car.jpg');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(34, 'Subaru', 2030, 'Sti', 'Scarlet Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(35, 'Subaru', 2016, 'Sti', 'Violet', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(36, 'Honda', 1990, 'Civic', 'black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(37, 'Honda', 1990, 'Civic', 'black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(38, 'Honda', 1990, 'Civic', 'Yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(39, 'honda', 2010, 'civic', 'brown', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(40, 'honda', 1950, 'noel', 'notColor', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(41, 'honda', 1950, 'noel', 'notColor', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(42, 'honda', 1950, 'noel', 'notColor', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(43, 'subaru', 2000, 'Sti', 'Chrome', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(44, 'subaru', 2013, 'sti', 'chrome', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(45, 'subaru', 2013, 'sti', 'chrome', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(46, 'subaru', 2010, 'sti', 'brown', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(47, 'subaru', 2010, 'sti', 'brown', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(48, 'subaru', 2030, 'sti', 'red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(49, 'subaru', 2030, 'sti', 'red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(50, 'Stahp', 2000, 'staph', 'staph', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(51, 'TruckinGo', 2020, 'Ducks', 'teal', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(52, 'BMW', 2016, 'X5 iPerformance', 'Beige', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(53, 'Dodge', 1970, 'Caravan', 'Rainbow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(54, 'DemonFang', 2030, 'Caravan', 'Rainbow', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(55, 'Toyota', 2015, 'Camry', 'Black', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(56, 'Toyota', 2015, 'Camry', 'Black', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(57, 'Toyota', 2015, 'Camry', 'Black', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(58, 'Toyota', 2015, 'Camry', 'Black', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(59, 'Ford', 2030, 'Accord', 'green', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(60, 'Ford', 2030, 'Accord', 'green', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(61, 'NotAMan', 2040, 'Donnie', 'Purple', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(62, 'Toyota', 2011, 'Corolla', 'silver', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(63, 'Toyota', 2016, 'Camry', 'Black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(64, 'Honda', 2014, 'Accord', 'Black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(65, 'Honda', 2014, 'Accord', 'Black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(66, 'Honda', 2014, 'Accord', 'Black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(67, 'Honda', 2014, 'Accord', 'Black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(68, 'Honda', 2014, 'Accord', 'Black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(70, 'Honda', 2014, 'Accord', 'Black', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(71, 'bmw', 2016, 'BMX-X19', 'yellow', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(72, 'Toyota', 2020, 'Corolla', 'Striped Scarlet Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(73, 'U-haul', 2020, 'Godzilla', 'White', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(74, 'U-haul', 2020, 'Ducks', 'Scarlet Red', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(75, 'Volvo', 1999, 'LV63', 'Yellow', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(76, 'Volvo', 1999, 'LV63', 'Yellow', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(80, 'Volvo', 1999, 'L2KS', 'yellow', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(81, 'audi', 1992, 'sadasd', 'orange', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(82, 'audi', 1991, 'sdfa', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(83, 'honda', 1991, 'asd', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(84, 'audi', 1994, 'asdf', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(85, 'audi', 1994, 'asdf', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(86, 'audi', 1994, 'asdf', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(87, 'audi', 1994, 'asdf', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(88, 'audi', 1994, 'asdf', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(89, 'audi', 1994, 'asdf', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(90, 'audi', 1994, 'asdf', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(91, 'honda', 1991, 'asdf', 'orange', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(92, 'honda', 1991, 'asdf', 'orange', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(93, 'honda', 1991, 'asdf', 'orange', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(94, 'honda', 1991, 'asdf', 'orange', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(95, 'audi', 1991, 'asdasd', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(96, 'honda', 1992, 'tesla', 'green', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(97, 'honda', 1992, 'tesla', 'green', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(98, 'honda', 1992, 'tesla', 'green', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(99, 'audi', 1990, '123', 'orange', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(100, 'audi', 1991, 'Testla', 'yellow', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(101, 'honda', 1993, 'TESLAX', 'yellow', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(102, 'honda', 1993, 'TESLAX', 'yellow', 'for sale', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(103, 'audi', 1992, '123', 'orange', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(104, 'audi', 1992, '123', 'orange', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(105, 'audi', 1992, '123', 'orange', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');
INSERT INTO `vehicle` (`vehicle_id`, `manufacturer`, `v_year`, `model`, `color`, `sale_status`, `path`) VALUES(106, 'audi', 1992, '123', 'orange', 'for rent', 'http://superrent.tk/DIVA/public/images/vehicles/cars/van-car');

-- Create the database first (This one is optional; Need to have CREATE privilges)
CREATE DATABASE 'DIVA_MAIN'

-- If the database already exists, execute the following code:
-- create the User table 
CREATE TABLE users (
	id_number SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	phone BIGINT(13) NOT NULL,
	email VARCHAR(20),
	account_uName VARCHAR(20) NOT NULL,
	account_password VARCHAR(20) NOT NULL
);

-- create a branch table
CREATE TABLE branches(
	br_num TINYINT(2) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	street_num SMALLINT UNSIGNED NOT NULL,
	street_name VARCHAR(10) NOT NULL,
	city VARCHAR(10) NOT NULL,
	province SET('AB', 'BC', 'MB', 'NB', 'NL', 'NS', 'NT', 'NU', 'ON', 'PE', 'QC', 'SK', 'YT') NOT NULL DEFAULT 'BC',
	zip_code VARCHAR(8) NOT NULL
);

-- create the employee table
CREATE TABLE employees (
	emp_id SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
	FOREIGN KEY (emp_id) REFERENCES users(id_number)
);

-- create the customer table
CREATE TABLE customers(
	cus_id SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
	standing SET('Good','Probation', 'Suspended') NOT NULL DEFAULT 'Good',
	cc_Num BIGINT(16),
	name_on_cCard VARCHAR(20),
	FOREIGN KEY (cus_id) REFERENCES users(id_number)
);

-- table for super customers
CREATE TABLE super_customers(
	cus_id SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
	points SMALLINT DEFAULT 500,
	FOREIGN KEY (cus_id) REFERENCES customers(cus_id)
);

-- A table for Clerks
CREATE TABLE clerks (
	emp_id SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
	works_at TINYINT(2) UNSIGNED NOT NULL,
	FOREIGN KEY (emp_id) REFERENCES employees(emp_id),
	FOREIGN KEY (works_at) REFERENCES branches(br_num)
);

-- A table for branch managers
CREATE TABLE managers (
	emp_id SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
	manages TINYINT(2) UNSIGNED NOT NULL,
	FOREIGN KEY (emp_id) REFERENCES clerks(emp_id),
	FOREIGN KEY (manages) REFERENCES clerks(works_at)
);

-- A table of System administrators
CREATE TABLE system_admins (
	emp_id SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
	FOREIGN KEY (emp_id) REFERENCES employees(emp_id)
);

-- Create equipment table
CREATE TABLE equipments(
	serial_num SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	rental_price FLOAT(6,2) UNSIGNED NOT NULL,
	location TINYINT(2) UNSIGNED NOT NULL,
	eq_type ENUM('ski rack', 'child safety seat', 'lift gate', 'car-towing eq') NOT NULL,
	FOREIGN KEY (location) REFERENCES branches(br_num)
);

-- Create equipment_reservation table
CREATE TABLE equipment_reservations(
	reservation_id MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	customer SMALLINT UNSIGNED NOT NULL,
	equipment SMALLINT UNSIGNED NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	FOREIGN KEY (customer) REFERENCES customers(cus_id),
	FOREIGN KEY (equipment) REFERENCES equipments(serial_num)
);

-- Create equipment_rental table
CREATE TABLE equipment_rentals(
	rental_id MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	customer SMALLINT UNSIGNED NOT NULL,
	equipment SMALLINT UNSIGNED NOT NULL,
	payment FLOAT(6,2) UNSIGNED NOT NULL,
	return_date DATE NOT NULL,
	FOREIGN KEY (customer) REFERENCES customers(cus_id),
	FOREIGN KEY (equipment) REFERENCES equipments(serial_num)
);

-- Create Vehicles table
CREATE TABLE vehicles(
	serial_num MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	location TINYINT(2) UNSIGNED NOT NULL,
	license_plate_number VARCHAR(20) NOT NULL,
	manufacturer VARCHAR(20) NOT NULL,
	year_model CHAR(20),
	color VARCHAR(20),
	hourly_rate FLOAT(6,2) NOT NULL,
	daily_rate FLOAT(6,2) NOT NULL,
	perKM_rate FLOAT(6,2) NOT NULL,
	hourly_insurance_rate FLOAT(6,2) NOT NULL,
	daily_insurance_rate FLOAT(6,2) NOT NULL,
	weekly_insurance_rate FLOAT(6,2) NOT NULL,
	capacity TINYINT(3) NOT NULL,
	vtype ENUM('car', 'truck') NOT NULL,
	sale_status ENUM('sold', 'for sale', 'for rent') DEFAULT 'for rent',
	FOREIGN KEY (location) REFERENCES branches(br_num)
);

-- Create vehicle reservation table
CREATE TABLE vehicle_reservations(
	reservation_id MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	customer SMALLINT UNSIGNED NOT NULL,
	vehicle MEDIUMINT UNSIGNED NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	FOREIGN KEY (customer) REFERENCES customers(cus_id),
	FOREIGN KEY (vehicle) REFERENCES vehicles(serial_num)
);
-- create vehicle rental table
CREATE TABLE vehicle_rentals(
	rental_id MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	customer SMALLINT UNSIGNED NOT NULL,
	vehicle SMALLINT UNSIGNED NOT NULL,
	payment FLOAT(6,2) UNSIGNED NOT NULL,
	return_date DATE NOT NULL,
	FOREIGN KEY (customer) REFERENCES customers(cus_id),
	FOREIGN KEY (vehicle) REFERENCES equipments(serial_num)
);

-- create report
CREATE TABLE reports(
	report_num MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	report_type ENUM('damage','inspection') NOT NULL,
	reporting_clerk  SMALLINT UNSIGNED NOT NULL,
	rental MEDIUMINT UNSIGNED NOT NULL,
	comments TEXT(500), 
	FOREIGN KEY (reporting_clerk) REFERENCES clerks(emp_id),
	FOREIGN KEY (rental) REFERENCES vehicle_rentals(rental_id)
);


-- If the database already exists, execute the following code:
-- create the User table 
CREATE TABLE users (
	id_number SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	phone BIGINT(13) NOT NULL,
	email VARCHAR(20),
	account_uName VARCHAR(20),
	account_password VARCHAR(20)
);

-- create a account balance table 
CREATE TABLE account_balance(
	id_number SMALLINT UNSIGNED PRIMARY KEY,
    balance DECIMAL(6,2) DEFAULT 0,
    FOREIGN KEY (id_number) REFERENCES users(id_number)
);

-- create a payment log table
CREATE TABLE payment_log(
	id_number SMALLINT UNSIGNED PRIMARY KEY,
	amount DECIMAL(10,2) NOT NULL,
    p_date DATE NOT NULL,
	reason VARCHAR(200),
    FOREIGN KEY (id_number) REFERENCES users(id_number)
);

-- create a branch table
CREATE TABLE branch(
	br_num TINYINT(2) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	street_num SMALLINT UNSIGNED NOT NULL,
	street_name VARCHAR(10) NOT NULL,
	city VARCHAR(10) NOT NULL,
	province SET('AB', 'BC', 'MB', 'NB', 'NL', 'NS', 'NT', 'NU', 'ON', 'PE', 'QC', 'SK', 'YT') NOT NULL DEFAULT 'BC',
	zip_code VARCHAR(8) NOT NULL
);

-- create the employee table
CREATE TABLE employee (
	id_number SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
    works_at TINYINT(2) UNSIGNED NOT NULL,
    e_type ENUM('Clerk','Manager','SystemAdmin'),
    FOREIGN KEY (works_at) REFERENCES branch(br_num),
	FOREIGN KEY (id_number) REFERENCES users(id_number)
);

-- create the customer table
CREATE TABLE customer(
	id_number SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
	standing SET('Good','Probation', 'Suspended') NOT NULL DEFAULT 'Good',
	cc_Num BIGINT(16),
	name_on_cCard VARCHAR(20),
	FOREIGN KEY (id_number) REFERENCES users(id_number)
);

-- table for super customers
CREATE TABLE super_customer(
	id_number SMALLINT UNSIGNED PRIMARY KEY NOT NULL,
	points SMALLINT DEFAULT 500,
	FOREIGN KEY (id_number) REFERENCES customer(id_number)
);

-- Create Equipment Price table
CREATE TABLE equipment_price(
	eq_type ENUM('ski rack', 'child safety seat', 'lift gate', 'car-towing eq') NOT NULL PRIMARY KEY,
    perWeek DECIMAL(5,2) NOT NULL,
    perDay DECIMAL(5,2) NOT NULL,
    perHour DECIMAL(5,2) NOT NULL
);

-- Create vehicle price table
CREATE TABLE car_price(
	class ENUM('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van') NOT NULL PRIMARY KEY,
    perHour DECIMAL(5,2) NOT NULL,
    perDay DECIMAL(5,2) NOT NULL,
    perWeek DECIMAL(5,2) NOT NULL,
    perMonth DECIMAL(6,2) NOT NULL,
    perKM DECIMAL (3,2) NOT NULL
);

-- Create vehicle price table
CREATE TABLE truck_price(
	class ENUM('24-foot','15-foot','12-foot','box-truck') NOT NULL PRIMARY KEY,
    perHour DECIMAL(5,2) NOT NULL,
    perDay DECIMAL(5,2) NOT NULL,
    perWeek DECIMAL(5,2) NOT NULL,
    perMonth DECIMAL(6,2) NOT NULL,
    perKM DECIMAL (3,2) NOT NULL
);

-- Create table insurance_car_price
CREATE TABLE insurance_car_price(
	class ENUM('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van') NOT NULL PRIMARY KEY,
    perHour DECIMAL(5,2) NOT NULL,
    perDay DECIMAL(5,2) NOT NULL,
    perWeek DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (class) REFERENCES car_price(class)
);

-- Create table insurance_truck_price
CREATE TABLE insurance_truck_price(
	class ENUM('24-foot','15-foot','12-foot','box-truck') NOT NULL PRIMARY KEY,
    perHour DECIMAL(5,2) NOT NULL,
    perDay DECIMAL(5,2) NOT NULL,
    perWeek DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (class) REFERENCES truck_price(class)
);

-- Create equipment table
CREATE TABLE equipment(
	serial_num SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	location TINYINT(2) UNSIGNED NOT NULL,
	eq_type ENUM('ski rack', 'child safety seat', 'lift gate', 'car-towing eq') NOT NULL,
    description VARCHAR(50),
	FOREIGN KEY (location) REFERENCES branch(br_num),
	FOREIGN KEY (eq_type) REFERENCES equipment_price(eq_type)
);

-- Create rental table
CREATE TABLE rental(
	reservation_id MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	customer SMALLINT UNSIGNED NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL ,
    start_branch TINYINT(2) UNSIGNED NOT NULL,
    end_branch TINYINT(2) UNSIGNED NOT NULL,
    state ENUM('reserved','in-rent','complete'),
	FOREIGN KEY (customer) REFERENCES customer(id_number),
	FOREIGN KEY (start_branch) REFERENCES branch(br_num), 
    FOREIGN KEY (end_branch) REFERENCES branch(br_num),
	CONSTRAINT chk_dates CHECK (end_date > start_date)
);

-- Create rental equipment table
CREATE TABLE rented_equipment(
	reservation_id MEDIUMINT UNSIGNED,
    equipment_id SMALLINT UNSIGNED PRIMARY KEY,
    FOREIGN KEY (reservation_id) REFERENCES rental(reservation_id),
    FOREIGN KEY (equipment_id) REFERENCES equipment(serial_num)
);

-- Create Vehicles table
CREATE TABLE vehicle(
	vehicle_id MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	manufacturer VARCHAR(20) NOT NULL,
	v_year DATE NOT NULL,
    model VARCHAR(20),
	color VARCHAR(20),
	sale_status ENUM('sold', 'for sale', 'for rent') DEFAULT 'for rent'
);

-- Create car table
CREATE TABLE car(
	vehicle_id MEDIUMINT UNSIGNED PRIMARY KEY,
	class ENUM('economy','compact','midsized','standard','fullsized','premium','luxury','SUV','van') NOT NULL,
    baggage TINYINT(1) UNSIGNED NOT NULL,
    door TINYINT(1) UNSIGNED NOT NULL,
    transmission BOOL DEFAULT FALSE,
    air_condition BOOL DEFAULT FALSE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id),
    FOREIGN KEY (class) REFERENCES car_price(class)
);

-- Create truck table
CREATE TABLE truck(
	vehicle_id MEDIUMINT UNSIGNED PRIMARY KEY,
	class ENUM('24-foot','15-foot','12-foot','box-truck') NOT NULL,
    seats TINYINT(2) UNSIGNED NOT NULL,
    clearance DECIMAL(3,1) UNSIGNED NOT NULL,
    interior_b_l DECIMAL(3,1) UNSIGNED NOT NULL,
    interior_b_w DECIMAL(3,1) UNSIGNED NOT NULL,
    interior_b_h DECIMAL(3,1) UNSIGNED NOT NULL,
    length DECIMAL(3,1) UNSIGNED NOT NULL,
    width DECIMAL(3,1) UNSIGNED NOT NULL,
    height DECIMAL(3,1) UNSIGNED NOT NULL,
    payload_weight_kg DECIMAL(4) UNSIGNED NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id),
    FOREIGN KEY (class) REFERENCES truck_price(class)
);

-- Create vehicle_sale_price table
CREATE TABLE vehicle_sale_price(
	vehicle_id MEDIUMINT UNSIGNED PRIMARY KEY,
	price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id)
);

-- Create branch vehicle table
CREATE TABLE branch_vehicle(
	vehicle_id MEDIUMINT UNSIGNED PRIMARY KEY,
	location TINYINT(2) UNSIGNED NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id),
	FOREIGN KEY (location) REFERENCES branch(br_num)
);

-- create report
CREATE TABLE report(
	report_num MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	report_type ENUM('damage','inspection') NOT NULL,
	reporting_clerk  SMALLINT UNSIGNED NOT NULL,
	rental MEDIUMINT UNSIGNED NOT NULL,
	comments TEXT(500), 
	FOREIGN KEY (reporting_clerk) REFERENCES employee(id_number),
	FOREIGN KEY (rental) REFERENCES rental(reservation_id)
);

ALTER TABLE vehicle
ADD path VARCHAR(30);

ALTER TABLE branch
MODIFY COLUMN street_name VARCHAR(30) NOT NULL;

ALTER TABLE users
MODIFY COLUMN phone VARCHAR(13);

ALTER TABLE users
MODIFY COLUMN email VARCHAR(40);

ALTER TABLE account_balance
MODIFY COLUMN balance DECIMAL(10,2);

ALTER TABLE car
MODIFY COLUMN door VARCHAR(3);
ALTER TABLE car
MODIFY COLUMN transmission BIT DEFAULT 1;
ALTER TABLE car
MODIFY COLUMN air_condition BIT DEFAULT 1;
ALTER TABLE car
ADD capacity DECIMAL(1);

DROP TABLE truck;
CREATE TABLE truck(
	vehicle_id MEDIUMINT UNSIGNED PRIMARY KEY,
	class ENUM('24-foot','15-foot','12-foot','box-truck') NOT NULL,
    interior_b_l DECIMAL(4,2) UNSIGNED NOT NULL,
    interior_b_w DECIMAL(4,2) UNSIGNED NOT NULL,
    interior_b_h DECIMAL(4,2) UNSIGNED NOT NULL,
    capacity_kg DECIMAL(5) UNSIGNED NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id),
    FOREIGN KEY (class) REFERENCES truck_price(class)	
);

ALTER TABLE equipment
DROP COLUMN description;

ALTER TABLE users
MODIFY COLUMN phone VARCHAR(13) NOT NULL;

ALTER TABLE branch
MODIFY COLUMN street_name VARCHAR (40) NOT NULL;

ALTER TABLE branch
DROP COLUMN street_num;

ALTER TABLE branch
MODIFY COLUMN city VARCHAR(25) NOT NULL;

ALTER TABLE users
MODIFY COLUMN account_uName VARCHAR(20) NOT NULL;

ALTER TABLE users
MODIFY COLUMN account_password VARCHAR(20) NOT NULL;

ALTER TABLE report
ADD COLUMN r_date DATE NOT NULL;

ALTER TABLE customer
ADD COLUMN street_name VARCHAR(40) NOT NULL,
ADD COLUMN city VARCHAR(25) NOT NULL,
ADD COLUMN province SET('AB','BC','MB','NB','NL','NS','NT','NU','ON','PE','QC','SK','YT') NOT NULL,
ADD COLUMN zipcode VARCHAR(6);

ALTER TABLE users
MODIFY COLUMN email VARCHAR(40) NOT NULL UNIQUE;

ALTER TABLE branch
MODIFY COLUMN zip_code VARCHAR(6) NOT NULL UNIQUE;

ALTER TABLE rental
ADD COLUMN vehicle_id MEDIUMINT UNSIGNED NOT NULL;

ALTER TABLE rental
ADD FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id);

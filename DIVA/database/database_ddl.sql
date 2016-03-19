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
CREATE TABLE System_Admins (
	Emp_ID BIGINT(20) PRIMARY KEY REFERENCES Employees(Emp_ID),
);

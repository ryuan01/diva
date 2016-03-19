-- Create the database first (This one is optional; Need to have CREATE privilges)
CREATE DATABASE 'DIVA_MAIN'

-- If the database already exists, execute the following code:
-- create the User table 
CREATE TABLE User (
	ID_Number BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	First_Name CHAR(20),
	Last_Name CHAR(20),
	Phone_Num BIGINT(20),
	Email VARCHAR(20),
	Account_uName VARCHAR(20),
	Account_password VARCHAR(20)
);

-- create a branch table
CREATE TABLE Branch(
	Br_Num INT(5) PRIMARY KEY AUTO_INCREMENT,
	Street_Num INT(10),
	Street_Name CHAR(10),
	City CHAR(10),
	Province SET('AB', 'BC', 'MB', 'NB', 'NL', 'NS', 'NT', 'NU', 'ON', 'PE', 'QC', 'SK', 'YT'),
	Zip_code VARCHAR(5)
);

-- create the employee table
CREATE TABLE Employees (
	Emp_ID BIGINT(20) PRIMARY KEY REFERENCES User(ID_Number)
);

-- create the customer table
CREATE TABLE Customers(
	Cus_Id BIGINT(20) PRIMARY KEY REFERENCES User(ID_Number),
	Standing SET('Good','Probation', 'Suspended') DEFAULT 'Good',
	CC_Num BIGINT(15),
	Name_on_cCard CHAR(20)
);

-- table for super customers
CREATE TABLE Super_Customers(
	Cus_ID BIGINT(20) PRIMARY KEY REFERENCES Customers(Cus_ID),
	Points INT(10) DEFAULT 0
);

-- A table for Clerks
CREATE TABLE Clerks (
	Emp_ID BIGINT(20) PRIMARY KEY REFERENCES Employees(Emp_ID),
	Works_at INT(5) REFERENCES Branch(Br_Num)
);

-- A table for branch managers
CREATE TABLE Managers (
	Emp_ID BIGINT(20) PRIMARY KEY REFERENCES Clerks(Emp_ID),
	Manages INT(5) REFERENCES Clekrs(Works_at)
);

-- A table of System administrators
CREATE TABLE System_Admins (
	Emp_ID BIGINT(20) PRIMARY KEY REFERENCES Employees(Emp_ID),
);

-- Populate branch
-- this one is head-quarter
INSERT INTO branch VALUES
(1,'100 Manitoba Street','Vancouver','BC','V5Y2Z6');
-- these ones are branches for renting and saling
INSERT INTO branch VALUES
(2,'3211 Grant McConachie Way','Richmond','BC','V7B 0A4');
INSERT INTO branch VALUES
(3,'757 Hornby Street','Vancouver','BC','V6Z1S2');

-- Populate users
-- three customers
INSERT INTO users VALUES
(1,'John','Doe','7780000000','joedoe@example.com','jdoe01','admin');
INSERT INTO users VALUES
(2,'Marry','Jane','7780000001','marryjane@example.com','mjane01','admin');
INSERT INTO users VALUES
(3,'James','Kurt','7780000003','jameskurt@example.com','jkurt01','admin');
-- five employees 
INSERT INTO users VALUES
(4,'Steward','Freeman','7780000004','stewardfreeman@example.com','sfreeman01','admin');
INSERT INTO users VALUES
(5,'Luke','Phillips','7780000005','lukephillips@example.com','lphillips01','admin');
INSERT INTO users VALUES
(6,'Noah','Johnson','7780000006','noahjohnson@example.com','njohnson01','admin');
INSERT INTO users VALUES
(7,'Omar','Barnes','7780000007','omarbarnes@example.com','obarnes01','admin');
INSERT INTO users VALUES
(8,'Elizabeth','Hunter','7780000008','ehunter@example.com','ehunter01','admin');

-- define customers with account
INSERT INTO customer VALUES
(1, 'good', null,null);
INSERT INTO customer VALUES
(2, 'good', null, null);

-- define super customer
INSERT INTO super_customer (cus_id) VALUES
(1);

-- define employees
INSERT INTO employee VALUES
(4,2,'Clerk'); 
INSERT INTO employee VALUES
(5,2,'Manager'); 
INSERT INTO employee VALUES
(6,3,'Clerk'); 
INSERT INTO employee VALUES
(7,3,'Manager'); 
INSERT INTO employee VALUES
(8,1,'SystemAdmin'); 

-- give each account some balance 0.0
INSERT INTO account_balance (account_id) VALUES
(1);
INSERT INTO account_balance (account_id) VALUES
(2);
INSERT INTO account_balance (account_id) VALUES
(3);
INSERT INTO account_balance (account_id) VALUES
(4);
INSERT INTO account_balance (account_id) VALUES
(5);
INSERT INTO account_balance (account_id) VALUES
(6);
INSERT INTO account_balance (account_id) VALUES
(7);
INSERT INTO account_balance (account_id) VALUES
(8);

-- add a few vehicles, just 3 cars and 2 trucks for now
INSERT INTO vehicle VALUES
(1,'Chevrolet','2010-01-01','Spark','Green','for rent',null);
INSERT INTO vehicle VALUES
(2,'Chevrolet','2010-01-01','Sonic','White','for rent',null);
INSERT INTO vehicle VALUES
(3,'Chrysler','2010-01-01','200','Dark Blue','for rent',null);
INSERT INTO vehicle VALUES
(4,'U-Haul','2010-01-01',null,'White','for rent',null);
INSERT INTO vehicle VALUES
(5,'U-Haul','2010-01-01',null,'White','for rent',null);

-- add car_price
INSERT INTO car_price VALUES
('economy', 3.00, 15.00, 80.00, 300.00, 0.25);
INSERT INTO car_price VALUES
('compact', 3.10, 15.99, 90.00, 520.00, 0.30);
INSERT INTO car_price VALUES
('midsized', 3.50, 18.00, 100.00, 680.00, 0.35);
INSERT INTO car_price VALUES
('standard', 3.60, 20.00, 140.00, 950.00, 0.40);
INSERT INTO car_price VALUES
('fullsized', 3.99, 25.00, 175.00, 1125.00,0.50);
INSERT INTO car_price VALUES
('premium', 4.25, 30.00, 210.00, 1300.00, 0.55);
INSERT INTO car_price VALUES
('luxury', 10.00, 80.00, 500.00, 1800.00, 0.88);
INSERT INTO car_price VALUES
('SUV', 4.25, 30.00, 210.00, 1300.00, 0.55);
INSERT INTO car_price VALUES
('van', 4.25, 30.00, 210.00, 1300.00, 0.55);

-- add cars
INSERT INTO car VALUES
(1, 'economy', 2, '3/5', 1,1,5);
INSERT INTO car VALUES
(2, 'compact', 1, '3/5', 1,1,5);
INSERT INTO car VALUES
(3, 'midsized', 2, '4', 1,1,5);

-- add truck_price
INSERT INTO truck_price VALUES
('24-foot', 8.00, 45.00, 300.00, 1100.00, 0.66);
INSERT INTO truck_price VALUES
('15-foot', 7.00, 40.00, 270.00, 1000.00, 0.60);
INSERT INTO truck_price VALUES
('12-foot', 6.50, 35.00, 250.00, 900.00, 0.55);
INSERT INTO truck_price VALUES
('box-truck', 6.00, 30.00, 220.00, 800.00, 0.50);

-- add trucks
INSERT INTO truck VALUES
(4,'15-foot',7.08,8,15,1150);
INSERT INTO truck VALUES
(5,'24-foot',8.5,8,24,3200);

-- add branch_vehicle, put them all in branch 2
INSERT INTO branch_vehicle VALUES
(1,2);
INSERT INTO branch_vehicle VALUES
(2,2);
INSERT INTO branch_vehicle VALUES
(3,2);
INSERT INTO branch_vehicle VALUES
(4,2);
INSERT INTO branch_vehicle VALUES
(5,2);

-- add equipment_price
INSERT INTO equipment_price VALUES
('ski rack', 50.00, 10.00, 2.00);
INSERT INTO equipment_price VALUES
('child safety seat', 50.00, 10.00, 2.00);
INSERT INTO equipment_price VALUES
('lift gate', 60.00, 12.00, 3.00);
INSERT INTO equipment_price VALUES
('car-towing eq', 100.00, 18.00, 5.00);

-- add quipment
INSERT INTO equipment VALUES
(1,2,'ski rack');
INSERT INTO equipment VALUES
(2,2,'child safety seat');


-- to be done: insurance_car_price,
-- insurance_truck_price, payment_log, rental, rental_equipment,
-- report, vehicle_sale_price
-- For question 1
CREATE TABLE customer_purchases (
    customer_id INT,
    purchase_date DATE,
    purchase_amount DECIMAL(10, 2)
);

INSERT INTO customer_purchases (customer_id, purchase_date, purchase_amount) VALUES (1, '2024-01-01', 100.00);
INSERT INTO customer_purchases (customer_id, purchase_date, purchase_amount) VALUES (1, '2024-01-10', 150.00);
INSERT INTO customer_purchases (customer_id, purchase_date, purchase_amount) VALUES (1, '2024-01-15', 200.00);
INSERT INTO customer_purchases (customer_id, purchase_date, purchase_amount) VALUES (2, '2024-02-01', 300.00);
INSERT INTO customer_purchases (customer_id, purchase_date, purchase_amount) VALUES (2, '2024-02-10', 350.00);
INSERT INTO customer_purchases (customer_id, purchase_date, purchase_amount) VALUES (3, '2024-03-01', 400.00);
INSERT INTO customer_purchases (customer_id, purchase_date, purchase_amount) VALUES (3, '2024-03-05', 450.00);
INSERT INTO customer_purchases (customer_id, purchase_date, purchase_amount) VALUES (3, '2024-03-20', 500.00);

-- For question 2
CREATE TABLE employee_performance (
    emp_id INT,
    emp_name VARCHAR(50),
    department VARCHAR(50),
    project_id INT,
    hours_worked INT,
    revenue_generated INT,
    evaluation_date DATE
);

INSERT INTO employee_performance VALUES (1, 'Alice', 'Sales', 101, 120, 20000, '2024-01-01');
INSERT INTO employee_performance VALUES (2, 'Bob', 'Sales', 101, 100, 18000, '2024-01-03');
INSERT INTO employee_performance VALUES (3, 'Charlie', 'Sales', 102, 110, 22000, '2024-01-05');
INSERT INTO employee_performance VALUES (4, 'David', 'IT', 201, 130, 25000, '2024-01-10');
INSERT INTO employee_performance VALUES (5, 'Eve', 'IT', 201, 150, 30000, '2024-01-15');
INSERT INTO employee_performance VALUES (6, 'Frank', 'IT', 202, 140, 27000, '2024-01-20');
INSERT INTO employee_performance VALUES (7, 'Grace', 'HR', 301, 80, 10000, '2024-02-01');
INSERT INTO employee_performance VALUES (8, 'Hank', 'HR', 301, 70, 12000, '2024-02-10');
INSERT INTO employee_performance VALUES (9, 'Ivy', 'HR', 302, 90, 9000, '2024-02-15');
INSERT INTO employee_performance VALUES (10, 'Jack', 'Finance', 401, 100, 40000, '2024-02-20');
INSERT INTO employee_performance VALUES (11, 'Karen', 'Finance', 401, 110, 42000, '2024-03-01');
INSERT INTO employee_performance VALUES (12, 'Leo', 'Finance', 402, 95, 38000, '2024-03-05');
INSERT INTO employee_performance VALUES (13, 'Mia', 'Sales', 103, 130, 21000, '2024-03-10');
INSERT INTO employee_performance VALUES (14, 'Nina', 'IT', 203, 145, 31000, '2024-03-15');
INSERT INTO employee_performance VALUES (15, 'Oscar', 'HR', 303, 60, 8000, '2024-03-20');
INSERT INTO employee_performance VALUES (16, 'Paul', 'Finance', 403, 90, 35000, '2024-03-25');
INSERT INTO employee_performance VALUES (17, 'Quinn', 'Sales', 104, 140, 24000, '2024-03-30');
INSERT INTO employee_performance VALUES (18, 'Rachel', 'IT', 204, 160, 33000, '2024-04-01');
INSERT INTO employee_performance VALUES (19, 'Steve', 'HR', 304, 85, 11000, '2024-04-05');
INSERT INTO employee_performance VALUES (20, 'Tina', 'Finance', 404, 105, 36000, '2024-04-10');

INSERT INTO employee_performance VALUES (17, 'Quinn', 'Sales', 104, 100, 15000, '2023-03-30');
INSERT INTO employee_performance VALUES (17, 'Quinn', 'Sales', 104, 120, 12000, '2024-04-30');


-- Drop if you want to rerun quickly
-- DROP TABLE sales_txn;

CREATE TABLE sales_txn (
  txn_id      INT PRIMARY KEY,
  txn_date    DATE NOT NULL,
  region      VARCHAR(20) NOT NULL,
  salesperson VARCHAR(30) NOT NULL,
  product_cat VARCHAR(20) NOT NULL,
  amount      DECIMAL(10,2) NOT NULL,
  returned_fg CHAR(1) DEFAULT 'N',
  CHECK (returned_fg IN ('Y','N'))
);

INSERT INTO sales_txn VALUES
(1001, '2026-01-03', 'NORTH', 'Mona',   'LAPTOP',  1200, 'N'),
(1002, '2026-01-04', 'NORTH', 'Mona',   'PHONE',    650, 'N'),
(1003, '2026-01-07', 'NORTH', 'Omar',   'PHONE',    900, 'N'),
(1004, '2026-01-10', 'NORTH', 'Omar',   'ACCESS',   180, 'Y'),
(1005, '2026-01-12', 'NORTH', 'Salma',  'LAPTOP',  1600, 'N'),
(1006, '2026-01-15', 'NORTH', 'Salma',  'ACCESS',   220, 'N'),
(1007, '2026-01-05', 'SOUTH', 'Youssef','PHONE',    700, 'N'),
(1008, '2026-01-09', 'SOUTH', 'Youssef','LAPTOP',  1400, 'N'),
(1009, '2026-01-11', 'SOUTH', 'Nour',   'ACCESS',   260, 'N'),
(1010, '2026-01-16', 'SOUTH', 'Nour',   'PHONE',    800, 'Y'),
(1011, '2026-01-18', 'SOUTH', 'Kareem', 'LAPTOP',  1100, 'N'),
(1012, '2026-01-22', 'SOUTH', 'Kareem', 'ACCESS',   150, 'N'),
(1013, '2026-01-02', 'EAST',  'Hana',   'PHONE',    500, 'N'),
(1014, '2026-01-06', 'EAST',  'Hana',   'LAPTOP',  1700, 'N'),
(1015, '2026-01-13', 'EAST',  'Ali',    'ACCESS',   240, 'N'),
(1016, '2026-01-17', 'EAST',  'Ali',    'PHONE',    950, 'N'),
(1017, '2026-01-20', 'EAST',  'Dina',   'LAPTOP',  1300, 'Y'),
(1018, '2026-01-23', 'EAST',  'Dina',   'PHONE',    620, 'N'),
(1019, '2026-01-01', 'WEST',  'Tarek',  'LAPTOP',  1250, 'N'),
(1020, '2026-01-08', 'WEST',  'Tarek',  'ACCESS',   210, 'N'),
(1021, '2026-01-14', 'WEST',  'Rana',   'PHONE',    780, 'N'),
(1022, '2026-01-19', 'WEST',  'Rana',   'LAPTOP',  1550, 'N'),
(1023, '2026-01-21', 'WEST',  'Sameh',  'ACCESS',   190, 'Y'),
(1024, '2026-01-24', 'WEST',  'Sameh',  'PHONE',    880, 'N');


create table family ( 
    name varchar(100), 
    father varchar(100) 
); 

insert into family (name) values ('fathy'); 
insert into family (name, father) values ('ahmed', 'fathy'); 
insert into family (name, father) values ('amira', 'fathy'); 
insert into family (name, father) values ('naema', 'fathy'); 
insert into family (name, father) values ('hassan', 'fathy'); 
insert into family (name, father) values ('mohamed', 'ahmed'); 
insert into family (name, father) values ('yossef', 'ahmed'); 
insert into family (name, father) values ('mostafa', 'ahmed'); 
insert into family (name, father) values ('magdy', 'hassan'); 
insert into family (name, father) values ('khaled', 'hassan');

COMMIT;
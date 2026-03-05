-- 1.	Display the Department id, name and id and the name of its manager.
SELECT dnum, dname, mgrssn, fname
FROM department JOIN employee ON mgrssn = ssn

-- 2.	Display the name of the departments and the name of the projects under its control.
SELECT dname, pname
FROM department d JOIN project p ON d.dnum = p.dnum

-- 3.	Display the full data about all the dependence associated with the name of the employee they depend on him/her.
SELECT essn, dependent_name, d.bdate, fname
FROM dependent d JOIN employee e ON e.ssn = d.essn

-- 4.	Display the full names and gender of all the employees, union with the names and genders of the dependents.
SELECT CONCAT(fname, ' ', lname) AS 'Full Name', e.gender
FROM employee e
UNION
SELECT dependent_name, gender
FROM dependent

-- 5.	Display the Id, name and location of the projects in Cairo or Alex city.
SELECT pname, pnumber, plocation
FROM project
WHERE city IN ('Cairo', 'Alex')

-- 6.	Display the Projects full data of the projects with a name starts with "a" letter.
SELECT *
FROM project
WHERE pname like 'A%' 

-- 7.	display all the employees in department 30 whose salary from 1000 to 2000 LE monthly
SELECT CONCAT(fname, ' ', lname) AS 'Full Name'
FROM employee
WHERE dno = 30 and salary between 1000 and 2000 

-- 8.	Retrieve the names of all employees in department 20 who work more than or equal to 10 hours per week on "Al Rawdah" project.
SELECT CONCAT(fname, ' ', lname) AS 'Full Name'
FROM employee e JOIN works_on w ON e.ssn = w.essn JOIN project p ON p.pnumber = w.pno 
WHERE p.dnum = 20 and p.pname = 'Al Rawdah' and w.weekly_hours >= 10 

-- 9.	Find the names of the employees who directly supervised with Amr Omran.
SELECT CONCAT(fname, ' ', lname) AS 'Full Name'
FROM employee
WHERE superssn = (SELECT ssn FROM employee WHERE fname = 'Amr' AND lname = 'Omran')

-- 10.	For each project, list the project name and the total hours per week (for all employees) spent on that project.
SELECT pname, sum(weekly_hours)
FROM project
JOIN works_on ON pnumber = pno GROUP BY pno

-- 11.	Retrieve the names of all employees and the names of the projects they are working on, sorted by the project name.
SELECT CONCAT(fname, ' ', lname) AS 'Full Name', pname FROM employee e JOIN department d ON e.dno = d.dnum JOIN project p ON d.dnum = p.dnum ORDER BY p.pname

-- 12.	Display all the data of the department which has the smallest employee ID over all employees' ID.
SELECT * FROM department LEFT JOIN employee ON dnum = dno WHERE ssn = (SELECT min(ssn) FROM employee)

-- 13.	For each department, retrieve the department name and the maximum, minimum and average salary of its employees.
SELECT dname, max(salary), min(salary), avg(salary)
FROM department JOIN employee ON dno = dnum
GROUP BY dname

-- 14.	List the last name of all managers who have no dependents.
SELECT distinct lname FROM employee e JOIN department d ON e.ssn = d.mgrssn JOIN dependent de ON d.mgrssn <> de.essn

-- 15.	For each department-- if its average salary is less than the average salary of all employees-- display its number, name and number of its employees.
SELECT dname, dnum, count(ssn) FROM department JOIN employee e ON dnum = e.dno GROUP BY dnum
having AVG(e.salary) < (SELECT AVG(salary) FROM employee)

-- 16.	Retrieve a list of employees and the projects they are working on ordered by department and within each department, ordered alphabetically by last name, first name.
SELECT CONCAT(fname, ' ', lname) AS 'Full Name', pname FROM employee e JOIN department d ON e.dno = d.dnum JOIN project p ON d.dnum = p.dnum ORDER BY d.dnum, fname, lname

-- 17.	For each project located in Cairo City, find the project number, the controlling department name, the department manager’s last name, address, and birthdate.
SELECT lname, p.pname, d.dname FROM employee e JOIN department d ON e.ssn = d.mgrssn JOIN project p ON d.dnum = p.dnum WHERE p.city = 'Cairo' ORDER BY d.dnum, fname, lname

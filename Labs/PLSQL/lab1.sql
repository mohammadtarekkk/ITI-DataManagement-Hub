-- 1.     Write a query that displays the first three letters of the employee full name, and the length of his full name.

select substr(first_name, 1, 3) as Three_letters, length(first_name)+length(last_name) as len
from employees

-- 2.    Display all employees whose emp id is odd.

select * 
from employees
where mod(employee_id, 2) <> 0

/* 3.    Write a query that print only now time in 24 Hours 
 Ex : 18:20:33 and in 12 Hours Ex : 06:20:33 pm
*/

select to_char(sysdate, 'hh24:mi:ss') as time_24,  to_char(sysdate, 'hh12:mi:ss') as time_12
from dual;

-- 4.    Write a Query that get number of years, months between today date and employees hire date

select trunc(months_between(sysdate, hire_date) / 12) as yearbetween, mod(trunc(months_between(sysdate, hire_date)), 12) as monthsbetween
from employees;

/* 5.    Write a Query that get the date of the First Sun day in the next month
 Print it in format   like 14-december-2020
*/

select to_char(next_day(last_day(sysdate), 'Sunday'), 'dd-month-yyyy')
from dual;


/* 6.    Write a Query that get the last day date after 3 months from today
 Print it in format   like 14-december-2020
*/

select to_char(last_day(add_months(sysdate, 3)), 'dd-month-yyyy')
from dual;

-- 7.    Display the employee’s name, hire date and salary review date, which is the first Monday after six months of service. Label the column Review. Format the dates to appear in the format similar to “Sunday, the Seventh of September, 1981 “.


select first_name, hire_date, to_char(next_day(add_months(hire_date, 3), 'Monday'), 'fmDay, "the" Ddspth "of" Month, YYYY') as salary_review_date
from employees




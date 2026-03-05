/*
1.    Create plsql block and to check for employee with id = 105; and update his commission_pct based on his salary
SALARY < 7000  :                    COMM = 0.1
7000 <= SALARY < 10000      COMM = 0.15
10000 <= SALARY < 15000    COMM = 0.2
15000 <= SALARY                      COMM = 0.25
*/

select commission_pct from employees where employee_id = 105;
set serveroutput on
declare
    v_salary employees.salary%type;
    v_comm number(3);
    v_final_salary number(10, 2);
    v_emp_id employees.employee_id%type := 105;
begin
    select nvl(salary, 0) into v_salary
    from employees
    where employee_id = v_emp_id; 

    if v_salary < 7000 then v_comm := 0.1;
    elsif v_salary < 10000 then v_comm := 0.15;
    elsif v_salary < 15000 then v_comm := 0.2;
    else v_comm := 0.25;
    end if;
    
    v_final_salary := v_salary + v_salary * v_comm;
    dbms_output.put_line('Salary = '||v_salary);
    dbms_output.put_line('Comm % = '||v_comm);
    dbms_output.put_line('Final Salary  = '||v_final_salary);
    
    Update employees
    set commission_pct = v_comm
    where employee_id = v_emp_id;
end;

select commission_pct from employees where employee_id = 105;

----------------------------------------------------------------

-- 2.    Create plsql block to calculate the retired salary for the employee no = 105, Retired salary = no of working months * 10 % of his current salary

declare
    v_salary employees.salary%type;
    v_emp_id employees.employee_id%type := 105;
    v_ret_salary number(10, 2);
    v_no_month number(10);
  
begin
    select nvl(salary, 0) into v_salary
    from employees
    where employee_id = v_emp_id; 
    
    select trunc(months_between(sysdate, hire_date)) into v_no_month
    from employees
    where employee_id = v_emp_id; 
    
    v_ret_salary := 10/100 * v_no_month * v_salary;
    dbms_output.put_line('Final Retired salary  = '||v_ret_salary);
    
end;

--------------------------------------------------------------------------

-- 3.    Create plsql block to print last name, department name, city, country name for employee whose id = 105 ( without using join | sub query )
declare
    v_dep_id number(10);
    v_emp_id employees.employee_id%type := 105;
    v_city locations.city%type;
    v_country countries.country_name%type;
    v_last_name EMPLOYEES.LAST_NAME%type;
    v_dep_name DEPARTMENTS.DEPARTMENT_NAME%type;
    v_loc_id DEPARTMENTS.LOCATION_ID%type;
    v_coun_name COUNTRIES.COUNTRY_NAME%type;
    v_coun_id COUNTRIES.COUNTRY_id%type;
    
  
begin
    select last_name into v_last_name
    from employees
    where employee_id = v_emp_id; 
    
    select DEPARTMENT_ID into v_dep_id
    from employees
    where employee_id = v_emp_id; 
    
    select DEPARTMENT_NAME into v_dep_name
    from departments
    where DEPARTMENT_ID = v_dep_id; 
    
    select location_id into v_loc_id
    from departments
    where DEPARTMENT_ID = v_dep_id;
    
    select city into v_city
    from locations
    where location_id = v_loc_id;
    
    select country_id into v_coun_id
    from locations
    where location_id = v_loc_id;
    
    select country_name into v_coun_name
    from countries
    where country_id = v_coun_id;
    
    
    dbms_output.put_line('Last Name  = '||v_last_name);
    dbms_output.put_line('Department Name  = '||v_dep_name);
    dbms_output.put_line('City  = '||v_city);
    dbms_output.put_line('Country  = '||v_coun_name);
    
end;

-------------------------------------------------------------
-- 4.    Create a PL/SQL block to calculate the bonus for employee number = 102. Bonus = 5% of current salary.


declare
    v_salary employees.salary%type;
    v_emp_id employees.employee_id%type := 102;
    v_Bonus number(10, 3) := 0.05;
    v_final_salary number(10, 2);  
    
begin

    select nvl(salary, 0) into v_salary
    from employees
    where employee_id = v_emp_id; 
    
    v_final_salary := v_salary + v_salary * v_Bonus;
    
    dbms_output.put_line('Final Salary  = '||v_final_salary);
end;

--------------------------------------------
-- 5.    Create a PL/SQL block to calculate the total salary of all employees.

declare

    v_total_salary number(20, 2);  
    
begin

    select sum(salary) into v_total_salary
    from employees;
   
    dbms_output.put_line('Total Salary for all employees  = '||v_total_salary);
end;
set serveroutput on
select * from employees;
declare
    cursor emp_cursor is
         select employees.*
         from employees, departments
         where employees.department_id = departments.department_id 
         and departments.department_name = 'IT' and to_char(employees.hire_date, 'yyyy') < 2015
         For Update;
begin
    For v_emp_record in emp_cursor Loop 
       update employees
       set salary = v_emp_record.salary + v_emp_record.salary * 0.2
       where employee_id = v_emp_record.employee_id;
    end Loop;
end;
select * from employees;
select employee_id, job_id, case job_id
        when 'AD_ASST' then 'A'
        when 'IT_PROG' then 'B'
        when 'SA_REP'  then 'C'
        when 'FI_MGR'  then 'D'
        else 'F'
    end as GRADE
 from employees
 
 
 select employee_id, nvl(to_char(commission_pct), 'no commission') as commission
 from employees
 
 select (max(salary)-min(salary)) as diff
 from employees
 
 select d.department_name, l.city, count(e.employee_id) as num_of_emp, round(avg(e.salary), 2) as avg_sal
 from departments d, locations l, employees e
 where d.location_id = l.location_id and d.department_id = e.department_id
 group by d.department_name, l.city
 
 select employee_id, first_name, salary
 from employees
 where salary > (select avg(salary) from employees)
 
 
 select e.employee_id as emp#, e.first_name as employee, E2.MANAGER_ID as Mgr# , E2.FIRST_NAME as manager
 from employees e left join employees e2
 on E.MANAGER_ID = E2.EMPLOYEE_ID
 order by E.EMPLOYEE_ID
 
select EMPLOYEE_ID, FIRST_NAME, salary
from employees
where salary > (select max(salary) 
                        from employees e 
                        where E.JOB_ID = 'IT_PROG')
 order by salary desc
 
 select E.MANAGER_ID, min(e.salary) min_sal
 from employees e
 where E.MANAGER_ID is not null
 group by E.MANAGER_ID
 having min(E.SALARY) >= 1000
 order by min_sal desc
 
 
 
 
 
select d.department_id, min(salary) as  min_salary
from employees e, departments d
where E.DEPARTMENT_ID = D.DEPARTMENT_ID 
group by D.DEPARTMENT_ID
having min(e.salary) > (select min(salary) from employees )
order by min_salary

 
 
 
 
 
 
 
 
 

 
 
 
 
 
 
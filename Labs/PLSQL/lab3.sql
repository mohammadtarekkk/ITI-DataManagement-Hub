create table emp2 as 
select * from employees
where 1 = 2

insert into emp2
select * from employees
where department_id = 20

select * from emp2




create table department (ID number(7) default 1, NAME varchar2(25) default 'Not available')

insert into department (ID, NAME)
select department_id, department_name
from departments;

alter table department add Location varchar2(100)
select * from department
truncate table department

create table employee_bkp as
select employee_id, last_name, email, salary, department_id
from employees

select * from employee_bkp

alter table employee_bkp add constraints pk primary key(employee_id)
alter table employee_bkp add constraints unq unique(email)


create view EMP_VU
as select employee_id, last_name as title_name, department_id
from employees


create sequence DEPT_ID_SEQ 
start with 400
maxvalue 1000
increment by 10

insert into departments(department_id, department_name)
values(DEPT_ID_SEQ.nextval, 'Data Management')


create public synonym EMP_VU_syn for EMP_VU


SELECT synonym_name, table_owner, table_name 
FROM all_synonyms 
WHERE synonym_name = 'EMP_VU_syn' AND owner = 'PUBLIC';
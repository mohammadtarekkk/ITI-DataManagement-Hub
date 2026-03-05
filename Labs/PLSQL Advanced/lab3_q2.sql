create table emp_audit (
    employee_id number(8, 2),
    user_name varchar2(50),
    upd_time date,
    old_sal number(8, 2),
    new_sal number(8, 2)
    );
    
create or replace procedure emp_audit_proc (
    employee_idd number,
    user_namee   varchar2,
    upd_timee    date,
    old_sall     number,
    new_sall     number
) is
begin
    insert into emp_audit (employee_id, user_name, upd_time, old_sal, new_sal)
    values (employee_idd, user_namee, upd_timee, old_sall, new_sall);
end;

create or replace trigger emp_trigg
after update of salary on employees
for each row
begin
    emp_audit_proc(:old.employee_id, :old.first_name, sysdate, :old.salary, :new.salary);
end;

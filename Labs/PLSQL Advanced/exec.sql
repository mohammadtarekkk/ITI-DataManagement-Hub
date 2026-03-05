drop function GET_LOC
drop function Query_LOC
drop procedure ADD_LOC

set serveroutput on;
exec LOC_PKG.ADD_LOC(4100, 'st. name', 168948, 'city', 'stat', 'EG');
set serveroutput on;
exec LOC_PKG.ADD_LOC('helwan');


select DEPT_PKG.GET_DEPT(10) from dual;

select DEPT_PKG.GET_DEPT('IT') from dual;


create or replace function GET_DEPT (dept_name varchar2)
             return departments%rowtype
      is
            dep_row departments%rowtype;
      begin 
          select * into dep_row from departments where department_name = dept_name;
          return dep_row;
end;

select GET_DEPT('IT') from dual;

set serveroutput on;
declare
    dept_row departments%rowtype;
begin
    dept_row := DEPT_PKG.GET_DEPT('IT');
    DBMS_OUTPUT.PUT_LINE(dept_row.department_id || dept_row.department_name || dept_row.manager_id || dept_row.location_id);
end;

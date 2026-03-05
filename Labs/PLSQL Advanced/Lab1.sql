-- 1.
create or replace procedure ADD_LOC (Loc_id number, Str_addr varchar2, post_code number, city varchar2, state_prov varchar2, country_id varchar2)
is
begin
    insert into Locations (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID)
    values (Loc_id, Str_addr, post_code, city, state_prov, country_id);
end;
----------------
set serveroutput on
declare
    wrng_count_id_exeption exception;
    pragma exception_init(wrng_count_id_exeption, -2291);
begin
ADD_LOC(3800, 'street 15', '265478', '15th of may', 'Cairo', 'd5');
exception when wrng_count_id_exeption then
        dbms_output.put_line('PLease enter a valid country_id');
end;
select * from Locations where location_id = 3800
-------------------------------------------

--2. 
create or replace function Query_loc  (location_idd number)
return varchar2
is
    result varchar2(1000);
begin
    select r.region_name || ', ' ||
           c.country_name || ', ' ||
           l.location_id || ', ' ||
           l.street_address || ', ' ||
           l.postal_code || ', ' ||
           l.city
   into result
    from locations l
    join countries c on l.country_id = c.country_id
    join regions r   on c.region_id = r.region_id
    where  l.location_id = location_idd;
    return result;
end;
show errors
-----------------------
set serveroutput on;
declare
result varchar2(1000);
begin
    result := Query_loc(3200);
    dbms_output.put_line(result);
end;
--------------------------------------------------------------
-- 3.
create or replace function GET_LOC (location_idd number, cityy out varchar2)
return varchar2
is
    str_add varchar2(100);
begin
    select street_address, city
    into  str_add, cityy
    from locations
    where location_id = location_idd;
    return  str_add;
end;
----------------------
set serveroutput on;
declare
    city varchar(100);
    street varchar(100);
begin
    street := GET_LOC(3100, city);
    dbms_output.put_line(street);
    dbms_output.put_line(city);
end;
----------------------------------------------
-- 4.
create or replace function GET_ANNUAL_COMP(salaryy number, comm number)
return number
is
    result number(8, 2);
begin
    result := (salaryy*12) + (comm*salaryy*12);
    return result;
end;
-----------
select GET_ANNUAL_COMP(7000, 0.15) from employees
-----------------------------
-- 5.
alter table employees add retired number(1);

create or replace function CHECK_RETIRED(V_EMP_ID NUMBER, V_MAX_HIRE_YEAR NUMBER)
return number
is
    hire_datee date;
    years number;
begin
    select hire_date into hire_datee from employees
    where employee_id = V_EMP_ID;

    
    years := trunc(months_between(sysdate, hire_datee) / 12);
    if years >= V_MAX_HIRE_YEAR then
        return 1;
    else
        return 0;
    end if;
end;
show errors
-------------------------------------
select * from employees;
declare
    retiredd number;
    cursor emp_ret is select employee_id from employees;
begin
    for roww in  emp_ret loop
        retiredd := CHECK_RETIRED(roww.employee_id, 20);
        if retiredd = 1 then
            update employees set retired = 1
            where employee_id = roww.employee_id;
        else
            update employees set retired = 0
            where employee_id = roww.employee_id;
        end if;
    end loop;
end;
select * from employees;

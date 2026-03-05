create or replace package body DEPT_PKG
is
    procedure ADD_DEPT (dept_id number, dept_name varchar2, manager_id  number, location_id number )
    is
    begin
        insert into departments (department_id, department_name, manager_id, location_id)
        values (dept_id, dept_name, manager_id, location_id);
    end;

    procedure UPD_DEPT (dept_id number , dept_name varchar2, manager_id  number, location_id number)
    is
    begin
        update departments
        set department_name = dept_name, manager_id = manager_id, location_id = location_id
        where department_id = dept_id;
    end;

    procedure DEL_DEPT (dept_id number)
    is
    begin
        delete from departments where department_id = dept_id;
    end;
    
    function GET_DEPT (dept_id number)
         return varchar2
     is
        dept_name varchar2(100);
     begin
        select department_name into dept_name
        from departments where department_id = dept_id;
        return dept_name;
end;
    
     function GET_DEPT (dept_name varchar2)
             return departments%rowtype
      is
            dep_row departments%rowtype;
      begin 
          select * into dep_row from departments where department_name = dept_name;
          return dep_row;
end;
end;
show errors
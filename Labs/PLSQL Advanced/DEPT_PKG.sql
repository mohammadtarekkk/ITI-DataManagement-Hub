create or replace package DEPT_PKG
is
    procedure ADD_DEPT (dept_id     number, dept_name   varchar2, manager_id  number, location_id number );

    procedure UPD_DEPT (dept_id number , dept_name   varchar2, manager_id  number, location_id number);

    procedure DEL_DEPT (dept_id number);

    function GET_DEPT (dept_id number)
         return varchar2;
     function GET_DEPT (dept_name varchar2)
         return departments%rowtype;
end;
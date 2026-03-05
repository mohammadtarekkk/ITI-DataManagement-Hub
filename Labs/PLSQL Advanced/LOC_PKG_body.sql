create or replace package body LOC_PKG
is
    function GET_LOC (location_idd number, cityy out varchar2)
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

    procedure ADD_LOC (Loc_id number, Str_addr varchar2, post_code number, city varchar2, state_prov varchar2, country_id varchar2)
    is
    begin
        insert into Locations (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID)
        values (Loc_id, Str_addr, post_code, city, state_prov, country_id);
    end;
    
    procedure ADD_LOC (city varchar2)
    is
        loc_id number;
    begin
        select LOCATIONS_SEQ.nextval into loc_id from dual;
        insert into Locations (LOCATION_ID, city)
        values (Loc_id, city);
    end;
    
    function Query_loc  (location_idd number)
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
    
end;
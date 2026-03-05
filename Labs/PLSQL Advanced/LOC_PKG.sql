create or replace package LOC_PKG
is
    procedure ADD_LOC (Loc_id number, Str_addr varchar2, post_code number, city varchar2, state_prov varchar2, country_id varchar2);
    procedure ADD_LOC (city varchar2);
    function Query_loc  (location_idd number)
        return varchar2;
    function GET_LOC (location_idd number, cityy out varchar2)
        return varchar2;

end;
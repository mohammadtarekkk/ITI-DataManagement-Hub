create or replace trigger emp_trigg2
before update of salary on employees
for each row
declare
    min_salaryy jobs.min_salary%type;
    max_salaryy jobs.max_salary%type;
begin
    select min_salary, max_salary into min_salaryy, max_salaryy
    from jobs
    where job_id = :new.job_id;
    
    if :new.salary not between min_salaryy and max_salaryy then
        RAISE_APPLICATION_ERROR (-20205, 'You have to enter value between min and max salary');
  END IF;
end;
show error
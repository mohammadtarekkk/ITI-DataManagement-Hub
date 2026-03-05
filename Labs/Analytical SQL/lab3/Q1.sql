-- SELECT * FROM `iti-analyticalsql`.family;

-- 1) Write a query to find each one in family, has how many fathers, using recursive CTE

with recursive family_t as (
    select name, father, 0 as lvl
    from family
    where father is null
    union all
    select f.name, f.father, ft.lvl + 1
    from family f
    inner join family_t ft on f.father = ft.name
)
select * from family_t;


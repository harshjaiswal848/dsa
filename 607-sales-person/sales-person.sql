# Write your MySQL query statement below

select 
    s.name 
from SalesPerson s
where not exists(
    select 1
    from Orders o
    join Company c on o.com_id = c.com_id
    where c.name = 'RED'
        and o.sales_id = s.sales_id
);
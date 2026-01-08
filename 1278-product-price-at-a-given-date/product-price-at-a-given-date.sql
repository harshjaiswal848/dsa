# Write your MySQL query statement below

select product_id,10 as price from products group by product_id having min(change_date)>'2019-08-16'
union all select p.product_id,p.new_price as price from products P inner join(
    select product_id,max(change_date) as max_date from products where change_date<='2019-08-16'
    group by product_id
) as R on P.product_id=R.product_id and P.change_date = R.max_date;
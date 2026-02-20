# Write your MySQL query statement below
select user_id, action, streak_length, start_date, end_date
from (
        select user_id, action, count(action) as streak_length, min(action_date) as start_date, max(action_date) as end_date, rank() over (partition by user_id order by count(action) desc) as ranks
        from activity
        group by user_id, action
        having datediff(end_date, start_date)= streak_length - 1 and streak_length>=5
        order by streak_length desc, user_id
) as temp
where ranks=1
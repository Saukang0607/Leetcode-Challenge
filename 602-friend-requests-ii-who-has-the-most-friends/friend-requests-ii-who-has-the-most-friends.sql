# Write your MySQL query statement below
WITH users as(
    SELECT requester_id AS id FROM RequestAccepted
    UNION ALL
    select accepter_id AS id FROM RequestAccepted
)
SELECT id, COUNT(*) as num
from users
group by id
ORDER BY num desc
LIMIT 1;


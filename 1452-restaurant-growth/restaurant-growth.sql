# Write your MySQL query statement below
with DailySum as (
    SELECT visited_on, SUM(amount) AS amountSum FROM Customer Group by visited_on
)
    SELECT * FROM (
        SELECT
    visited_on,
    SUM(amountSum) OVER (
        ORDER BY visited_on
        ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
    ) as amount,
    round(AVG(amountSum) OVER (
        ORDER BY visited_on
        ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
    ),2) as average_amount
    from DailySum)
     AS t
    WHERE visited_on >=(
        SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY) from Customer
    )
    ORDER BY visited_on;
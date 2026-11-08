# Write your MySQL query statement below
SELECT ROUND(SUM(tiv_2016),2) as tiv_2016 FROM Insurance
WHERE tiv_2015 in(
    SELECT tiv_2015 FROM Insurance
    group by tiv_2015
    HAVING count(tiv_2015) > 1
)
AND (lat, lon) in(
    SELECT lat,lon FROM Insurance
    GROUP BY lat,lon
    HAVING COUNT(*) = 1
)
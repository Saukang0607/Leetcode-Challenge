# Write your MySQL query statement below
select product_name, sum(unit) as unit from Products p
right join Orders o 
on p.product_id = o.product_id
where order_date < '2020-03-01' and order_date >= '2020-02-01'
group by o.product_id
having sum(unit) >= 100

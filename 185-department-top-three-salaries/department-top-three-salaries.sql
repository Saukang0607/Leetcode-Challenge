# Write your MySQL query statement below
with RankedSalary as (
    select departmentId,
    name as Employee,
    salary as Salary,
    DENSE_RANK() OVER(
        PARTITION BY departmentId
        order by salary DESC
    ) as rk
    from Employee
)
select d.name as Department, r.Employee, r.Salary
from RankedSalary r
left join Department d on r.departmentId = d.id
where rk < 4;
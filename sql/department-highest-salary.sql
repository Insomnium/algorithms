-- https://leetcode.com/problems/department-highest-salary/
select d.name Department, e.name Employee, e.salary Salary
from (select max(e.salary) salary, e.departmentid
      from employee e
               inner join department d on e.departmentid = d.id
      group by e.departmentid) max
         inner join department d on max.departmentid = d.id
         inner join employee e on e.salary = max.salary and e.departmentid = d.id
order by e.salary desc;

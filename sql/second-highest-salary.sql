-- https://leetcode.com/problems/second-highest-salary/submissions/1388482029/

select max(salary) as "SecondHighestSalary"
from employee
where salary < (select max(salary) from employee);

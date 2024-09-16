-- https://leetcode.com/problems/rising-temperature/description/

select origin.id
from weather origin
full outer join weather prev
    on origin.recorddate = prev.recorddate + 1
where origin.temperature > prev.temperature;

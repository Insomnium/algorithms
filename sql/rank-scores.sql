-- https://leetcode.com/problems/rank-scores/submissions/1388614026/
select score, dense_rank() over (ORDER BY score desc) as rank
from scores
order by score desc;

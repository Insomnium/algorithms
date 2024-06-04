-- https://leetcode.com/problems/delete-duplicate-emails

delete
from person
where id not in (select min(id) as smallest_unique_person_id
                 from person
                 group by email);

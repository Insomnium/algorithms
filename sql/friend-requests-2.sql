-- https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/

select cte.person_id id, cte.total_friends num
from (
with
    acceptor as (select accepter_id person_id, count(1) cnt from requestaccepted group by accepter_id),
    requestor as (select requester_id person_id, count(1) cnt from requestaccepted group by requester_id)
select
    coalesce(acceptor.person_id, requestor.person_id) person_id, (coalesce(acceptor.cnt, 0) + coalesce(requestor.cnt, 0)) total_friends
from acceptor
    full outer join requestor on acceptor.person_id = requestor.person_id) cte
order by total_friends desc
limit 1 offset 0;

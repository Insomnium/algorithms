-- https://leetcode.com/problems/investments-in-2016/description/

-- dumb solution
with tiv_matches as (select tiv_2015, count(1) as cnt
                     from insurance
                     group by tiv_2015),
     unique_location_pids as (select pid
                              from insurance
                              where lat::text || lon::text not in (select lat::text || lon::text
                                                                   from insurance
                                                                   group by lat, lon
                                                                   having count(1) > 1))

select round(sum(tiv_2016)::numeric, 2) as tiv_2016
from insurance i1
where
    i1.tiv_2015 in (select tiv_2015 from tiv_matches where cnt > 1)
    and i1.pid in (select pid from unique_location_pids);


-- optimized
with
    dup_tivs as (select tiv_2015 from insurance group by tiv_2015 having count(tiv_2015) > 1),
    dup_locs as (select lat, lon from insurance group by lat, lon having count(1) > 1)
select round(sum(ins.tiv_2016)::numeric, 2) as tiv_2016
from insurance ins
where
    tiv_2015 in (select tiv_2015 from dup_tivs)
    and (lat, lon) not in (select lat, lon from dup_locs)



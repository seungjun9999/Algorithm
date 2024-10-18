with RECURSIVE hours as(
select 0 as hour
union all
select hour + 1 from hours where hour<23)

SELECT h.hour, count(o.animal_id)
from hours h
left join animal_outs o on hour(o.datetime) = h.hour 
group by h.hour
order by h.hour asc

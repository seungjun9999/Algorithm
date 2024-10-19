SELECT hour(DATETIME) as hour, count(*) as COUNT
from animal_outs o
where hour(datetime) between 9 and 19
group by hour
order by 1


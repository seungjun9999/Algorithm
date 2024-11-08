select count(f.fish_type) as FISH_COUNT, n.fish_name
from FISH_INFO f
join FISH_NAME_INFO n on f.fish_type = n.fish_type
group by n.fish_name
order by FISH_COUNT desc
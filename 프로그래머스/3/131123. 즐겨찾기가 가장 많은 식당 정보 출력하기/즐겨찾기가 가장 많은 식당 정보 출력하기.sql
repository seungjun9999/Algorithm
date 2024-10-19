

SELECT i.FOOD_TYPE,i.REST_ID,i.REST_NAME,i.FAVORITES
from rest_info i
join (select food_type, max(FAVORITES) as max2
from REST_INFO
group by FOOD_TYPE) i2 on i2.max2 = i.FAVORITES and i2.food_type = i.food_type
order by food_type desc
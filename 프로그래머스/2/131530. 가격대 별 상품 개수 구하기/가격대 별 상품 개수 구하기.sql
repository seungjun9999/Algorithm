SELECT FLOOR(price/10000)*10000 as PRICE_GROUP, count(p.product_id) as products
from product p
group by 1
order by 1

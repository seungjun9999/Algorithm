select PRODUCT_CODE, sum(price* sales_amount) as sales
from product p
join offline_sale s on p.product_id = s.product_id
group by p.product_code
order by sales desc, p.product_code asc
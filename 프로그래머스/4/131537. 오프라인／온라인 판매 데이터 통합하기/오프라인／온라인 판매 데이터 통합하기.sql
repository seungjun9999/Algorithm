SELECT date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE,	PRODUCT_ID,	USER_ID	,SALES_AMOUNT
from ONLINE_SALE n
where SALES_DATE like "2022-03%"
union all
SELECT SALES_DATE,	PRODUCT_ID, null as USER_ID,SALES_AMOUNT
from OFFLINE_SALE f
where SALES_DATE like "2022-03%"
order by SALES_DATE, product_id,user_id
# SELECT *
# from OFFLINE_SALE f
# where f.SALES_DATE like "2022-03%"
select b.category as CATEGORY, sum(s.sales) as TOTAL_SALES
# select *
from book b
join book_sales s on b.book_id = s.book_id
where s.SALES_DATE like "2022-01%"
group by category
order by category
select sum(g.score) as SCORE, e.EMP_NO,	e.EMP_NAME,e.POSITION,e.EMAIL
from HR_EMPLOYEES e
join hr_grade g on e.EMP_NO = g.EMP_NO
group by g.EMP_NO
order by 1 desc
limit 1
# group by e.EMP_NAME
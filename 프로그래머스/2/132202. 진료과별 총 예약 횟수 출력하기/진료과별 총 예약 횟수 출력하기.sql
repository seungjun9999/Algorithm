SELECT MCDP_CD as 진료과코드 , count(*) as 5월예약건수
FROM APPOINTMENT
where APNT_YMD like "2022-05%"
group by 1
order by 2, 1
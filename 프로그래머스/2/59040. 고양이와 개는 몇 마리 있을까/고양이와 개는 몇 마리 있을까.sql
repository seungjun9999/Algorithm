SELECT ANIMAL_TYPE,	COUNT(ANIMAL_ID) AS "count"
from ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY 1
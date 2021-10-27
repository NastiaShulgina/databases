-- 1
SELECT * FROM income_o
WHERE inc >= 5000 AND inc <= 10000
ORDER BY inc;

-- 2
SELECT distinct date FROM pass_in_trip AS seat_num
WHERE place < '2a';

-- 3
SELECT maker, product.model, price FROM product JOIN pc ON product.model=pc.model
WHERE pc.price < 600;

-- 4
SELECT distinct maker FROM product 
WHERE model IN (SELECT model FROM pc);

-- 5
SELECT s.class FROM outcomes AS o JOIN ships AS s ON s.name=o.ship
WHERE o.result='sunk'
GROUP BY s.class HAVING count(*) >= 1
UNION
SELECT c.class FROM outcomes AS o LEFT JOIN classes AS c ON c.class=o.ship
WHERE o.result='sunk';

-- 6
select CONCAT("row: ",SUBSTRING(place, 1, 1)) as 'row', CONCAT("seat: ",SUBSTRING(place, 2, 1)) as 'seat'
from pass_in_trip;

-- 7
SELECT distinct maker, price FROM product JOIN printer ON product.model=printer.model
WHERE price = ( SELECT MIN(price) FROM printer);

-- 8
SELECT maker, MAX(price) AS highest_price FROM product JOIN pc ON product.model=pc.model
GROUP BY maker;

-- 9 
SELECT maker, 
CASE WHEN COUNT(print.model) > 0 THEN CONCAT('yes(', COUNT(print.model), ')') 
ELSE 'no' 
END AS printer
FROM product LEFT JOIN printer AS print  ON product.model = print.model
GROUP BY maker;

-- 10
SELECT classes.class, COUNT(*) AS ships_amount FROM classes
LEFT JOIN ships ON ships.class = classes.class
GROUP BY classes.class HAVING COUNT(*)<=2;
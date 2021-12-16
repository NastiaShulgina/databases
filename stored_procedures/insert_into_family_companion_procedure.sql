USE Shulgina_7_48;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_into_family_companion //
CREATE PROCEDURE `insert_into_family_companion` (
    IN name VARCHAR(45),
    IN surname VARCHAR(45),
    IN birth_date DATE,
    IN death_date DATE,
    IN birth_place VARCHAR(60),
    IN death_place VARCHAR(60),
    IN marriage_date DATE,
    IN gender CHAR(1))
BEGIN
	INSERT INTO family_companion(name, surname, birth_date, death_date, birth_place, death_place, marriage_date, gender) 
    VALUES(name, surname, birth_date, death_date, birth_place, death_place, marriage_date, gender);
END //
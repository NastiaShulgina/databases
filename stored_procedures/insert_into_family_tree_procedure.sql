USE Shulgina_7_48;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_into_family_tree //
CREATE PROCEDURE `insert_into_family_tree` (
	IN name VARCHAR(45),
    IN surname VARCHAR(45),
    IN birth_date DATE,
    IN death_date DATE,
    IN birth_place VARCHAR(60),
    IN death_place VARCHAR(60),
    IN credit_card_number VARCHAR(19),
    IN companion_id INT,
    IN gender CHAR(1),
    IN parent_tree_id INT)
BEGIN
	INSERT INTO family_tree(name, surname, birth_date, death_date, birth_place, death_place, 
    credit_card_number, companion_id, gender, parent_tree_id ) 
    VALUES(name, surname, birth_date, death_date, birth_place, death_place, credit_card_number, 
    companion_id, gender, parent_tree_id);
END //
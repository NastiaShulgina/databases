USE Shulgina_7_48;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_companion_input //
CREATE TRIGGER before_family_companion_input
BEFORE INSERT 
ON family_companion FOR EACH ROW
BEGIN 
	IF new.gender NOT IN (SELECT gender FROM gender) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such gender found in gender.gender for family_companion.gender";
	END IF;
END //
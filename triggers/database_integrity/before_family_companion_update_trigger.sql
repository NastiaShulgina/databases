USE Shulgina_7_48;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_companion_update //
CREATE TRIGGER before_family_companion_update
BEFORE UPDATE
ON family_companion FOR EACH ROW
BEGIN 
	IF new.gender != old.gender THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Immutability error. Gender column cannot be updated";
	END IF;
END //
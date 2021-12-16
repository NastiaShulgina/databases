USE Shulgina_7_48;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_companion_delete //
CREATE TRIGGER before_family_companion_delete
BEFORE DELETE
ON family_companion FOR EACH ROW
BEGIN 
	IF  old.id IN (SELECT id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in family_tree connected with this data, you can't delete it";
	END IF;
END //
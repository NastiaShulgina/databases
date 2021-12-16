USE Shulgina_7_48;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_has_family_value_update //
CREATE TRIGGER before_family_tree_has_family_value_update
BEFORE UPDATE
ON family_tree_has_family_value FOR EACH ROW
BEGIN 
	IF new.family_value_id NOT IN (SELECT id FROM family_value) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such id found in family_value.id
        for family_tree_has_family_value.family_value_id";
	END IF;
    
    IF new.family_tree_id NOT IN (SELECT id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such id found in family_tree.id
        for family_tree_has_family_value.family_tree_id";
	END IF;
END //
USE Shulgina_7_48;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_update //
CREATE TRIGGER before_family_tree_update
BEFORE UPDATE
ON family_tree FOR EACH ROW
BEGIN 
	IF new.gender != old.gender THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Immutability error. Gender column cannot be updated";
	END IF;
    
    IF new.companion_id NOT IN (SELECT id FROM family_companion) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such id found in family_companion.id
        for family_tree.companion_id";
	END IF;
    
    IF (old.parent_tree_id IS NULL) AND (new.parent_tree_id NOT IN (SELECT id FROM family_tree)) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such id found in family_tree.id
        for family_tree.parent_tree_id";
	END IF;
    
    IF (old.parent_tree_id IS NOT NULL) AND (new.parent_tree_id != old.parent_tree_id) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Immutability error. Not null parent_tree_id column cannot be updated";
	END IF;
END //
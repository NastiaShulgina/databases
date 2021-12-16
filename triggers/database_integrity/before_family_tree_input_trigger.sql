USE Shulgina_7_48;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_input //
CREATE TRIGGER before_family_tree_input
BEFORE INSERT 
ON family_tree FOR EACH ROW
BEGIN 
	IF new.gender NOT IN (SELECT gender FROM gender) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such gender found in gender.gender for family_companion.gender";
	END IF;
    
    IF new.companion_id NOT IN (SELECT id FROM family_companion) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such id found in family_companion.id
        for family_tree.companion_id";
	END IF;
    
    IF (new.parent_tree_id IS NOT NULL) AND (new.parent_tree_id NOT IN (SELECT id FROM family_tree)) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such id found in family_tree.id
        for family_tree.parent_tree_id";
	END IF;
END //
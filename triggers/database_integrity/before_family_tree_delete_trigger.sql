USE Shulgina_7_48;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_delete //
CREATE TRIGGER before_family_tree_delete
BEFORE DELETE
ON family_tree FOR EACH ROW
BEGIN 
	IF  old.id IN (SELECT family_tree_id FROM family_tree_has_family_value) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in family_tree_has_family_value
        connected with this data, you can't delete it";
	END IF;
    
    IF  old.id IN (SELECT parent_tree_id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in family_tree.parent_tree_id connected with this data, you can't delete it";
	END IF;
END //
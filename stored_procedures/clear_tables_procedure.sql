USE Shulgina_7_48;

DELIMITER //
DROP PROCEDURE IF EXISTS clear_tables //
CREATE PROCEDURE clear_tables()
BEGIN
    DELETE FROM family_tree_has_family_value;
	DELETE FROM family_tree ORDER BY id DESC;
	DELETE FROM family_companion;
	DELETE FROM family_value;

	ALTER TABLE family_tree AUTO_INCREMENT = 1;
	ALTER TABLE family_companion AUTO_INCREMENT = 1;
	ALTER TABLE family_value AUTO_INCREMENT = 1;
	ALTER TABLE family_tree_has_family_value AUTO_INCREMENT = 1;
END //
USE Shulgina_7_48;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_into_family_value //
CREATE PROCEDURE `insert_into_family_value` (
    IN name VARCHAR(100),
    IN estimated_cost DECIMAL(10,1) UNSIGNED,
    IN max_cost DECIMAL(10,1) UNSIGNED,
    IN min_cost DECIMAL(10,1),
    IN code_in_catalog_of_value VARCHAR(100))
BEGIN
	INSERT INTO family_value(name, estimated_cost, max_cost,  min_cost, code_in_catalog_of_value) 
    VALUES(name, estimated_cost, max_cost,  min_cost, code_in_catalog_of_value);
END //
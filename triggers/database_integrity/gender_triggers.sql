USE Shulgina_7_48;

DELIMITER //
DROP TRIGGER IF EXISTS before_gender_input //
CREATE TRIGGER before_gender_input
BEFORE INSERT 
ON gender FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "Immutability error. gender table is immutable";
END //

DROP TRIGGER IF EXISTS before_gender_update //
CREATE TRIGGER before_gender_update
BEFORE UPDATE
ON gender FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "Immutability error. Gender table is immutable";
END //

DROP TRIGGER IF EXISTS before_gender_delete //
CREATE TRIGGER before_gender_delete
BEFORE DELETE
ON gender FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "Immutability error. Gender table is immutable";
END //
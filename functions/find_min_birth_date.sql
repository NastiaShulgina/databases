USE Shulgina_7_48;

SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS find_min_birth_date;

DELIMITER //
CREATE FUNCTION find_min_birth_date() RETURNS INT
BEGIN
    RETURN (SELECT MIN(birth_date) FROM family_companion);
END //
DELIMITER ;

SELECT * FROM family_companion WHERE birth_date = find_min_birth_date();


USE Shulgina_7_48;

SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS get_birth_date;
DELIMITER // 
CREATE FUNCTION get_birth_date(
companion_id INT
)
RETURNS VARCHAR(45)
BEGIN
RETURN(
    SELECT concat(family_companion.surname , family_companion.birth_date)
        from family_companion 
        where id = (select companion_id from family_tree where id = companion_id)
       
);
END //  
DELIMITER ;
    
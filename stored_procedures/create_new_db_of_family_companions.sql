USE Shulgina_7_48;

drop procedure if exists create_new_db_of_family_companions; 
DELIMITER //
CREATE PROCEDURE create_new_db_of_family_companions ()
BEGIN
	DECLARE name varchar(45);
	DECLARE done int DEFAULT false;
    DECLARE random int;
	
    DECLARE cursor1 CURSOR FOR SELECT name from family_companion;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
	OPEN cursor1;
    loop1: LOOP 
		set random = (FLOOR( RAND() * (9-1) + 1));
		FETCH cursor1 INTO name;
        IF done=true THEN LEAVE loop1;
        END IF;

		SET @tmp_query0 = CONCAT('drop database if exists ',name,';');
        PREPARE myquery FROM @tmp_query0;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;
        
        SET @tmp_query = CONCAT('CREATE DATABASE IF NOT EXISTS ',name,';');
        PREPARE myquery FROM @tmp_query;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;

        
       WHILE random > 0 do
            set random = random - 1;
            
			SET @tmp_query2 = CONCAT('use ',name,';');
			PREPARE statement0 FROM @tmp_query2;
			EXECUTE statement0;
			DEALLOCATE PREPARE statement0;
            
            
            SET @tmp_query3 = CONCAT('drop table if exists ',name,';');
			PREPARE statement1 FROM @tmp_query3;
			EXECUTE statement1;
			DEALLOCATE PREPARE statement1;
            
            
			SET @tmp_query4 = CONCAT(
            'CREATE TABLE IF NOT EXISTS `',CONCAT(name,random), '` 
			(
			`id` INT,
			`name` VARCHAR(45), 
			PRIMARY KEY (`id`)
			);'
			);
			PREPARE statement FROM @tmp_query4;
			EXECUTE statement;
			DEALLOCATE PREPARE statement;
            
        end while;
    END LOOP;
    CLOSE cursor1;

END //
DELIMITER ;

-- drop procedure if exists create_new_db_of_family_companions;
-- DELIMITER //
-- CREATE PROCEDURE create_new_db_of_family_companions ()
-- BEGIN
-- 	DECLARE nameC varchar(90);
-- 	DECLARE done int DEFAULT false;
--     DECLARE random int;
-- 	
--     DECLARE cursor1 CURSOR FOR SELECT name from family_companion;
--     DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
-- 	OPEN cursor1;
--     loop1: LOOP 
-- 		set random = (FLOOR( RAND() * (9-1) + 1));
-- 		FETCH cursor1 INTO nameC;
--         IF done=true THEN LEAVE loop1;
--         END IF;

-- 		SET @tmp_query0 = CONCAT('drop database if exists ',nameC,';');
--         PREPARE myquery FROM @tmp_query0;
--         EXECUTE myquery;
--         DEALLOCATE PREPARE myquery;
--         
--         SET @tmp_query = CONCAT('CREATE DATABASE IF NOT EXISTS ',nameC,';');
--         PREPARE myquery FROM @tmp_query;
--         EXECUTE myquery;
--         DEALLOCATE PREPARE myquery;

--         
--        WHILE random > 0 do
--             set random = random - 1;
--             
-- 			SET @tmp_query2 = CONCAT('use ',nameC,';');
-- 			PREPARE statement0 FROM @tmp_query2;
-- 			EXECUTE statement0;
-- 			DEALLOCATE PREPARE statement0;
--             
--             
--             SET @tmp_query3 = CONCAT('drop table if exists ',nameC,';');
-- 			PREPARE statement1 FROM @tmp_query3;
-- 			EXECUTE statement1;
-- 			DEALLOCATE PREPARE statement1;
--             
--             
-- 			SET @tmp_query4 = CONCAT(
--             'CREATE TABLE IF NOT EXISTS `',CONCAT(nameC,random), '` 
-- 			(
-- 			`id` INT,
-- 			`name` VARCHAR(45), 
-- 			PRIMARY KEY (`id`)
-- 			);'
-- 			);
-- 			PREPARE statement FROM @tmp_query4;
-- 			EXECUTE statement;
-- 			DEALLOCATE PREPARE statement;
--             
--         end while;
--     END LOOP;
--     CLOSE cursor1;

-- END //
-- DELIMITER ;

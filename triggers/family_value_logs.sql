USE Shulgina_7_48;

DROP TRIGGER IF EXISTS family_value_logs;

CREATE TABLE family_value_journal (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    timestamp TIMESTAMP,
    PRIMARY KEY(id)
);

DELIMITER //
CREATE TRIGGER family_value_logs
BEFORE UPDATE
ON family_value FOR EACH ROW
BEGIN
	INSERT INTO family_value_journal(name, timestamp) VALUES 
		(new.name, current_timestamp());
END //
DELIMITER ;
USE Shulgina_7_48;

DROP TRIGGER IF EXISTS provide_code_format;
DELIMITER //
CREATE TRIGGER provide_code_format
    before INSERT
    on family_value
    for EACH ROW
BEGIN
    if (new.code_in_catalog_of_value not rlike '[A-Za-z^F]{1}[0-9]{3}\\/[A-Za-z]{2}') then
        signal sqlstate '45000'
            set message_text = 'Code in catalog of value doesn\'t match regex';
    end if;
end //
DELIMITER ;
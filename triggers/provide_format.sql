USE Shulgina_7_48;

DROP TRIGGER IF EXISTS provide_format;
DELIMITER //
CREATE TRIGGER provide_format
    before INSERT
    on family_companion
    for EACH ROW
BEGIN
    if (new.surname not rlike '^[^ A][^ ін]$|[^ іна]$') then
        signal sqlstate '45000'
            set message_text = 'Surname in catalog doesn\'t match regex';
    end if;
end //
DELIMITER ;
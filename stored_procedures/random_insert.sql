USE Shulgina_7_48;

drop procedure if exists set_default_genders;
DELIMITER //
CREATE PROCEDURE set_default_genders ()
begin
	declare str VARCHAR(80);
	declare counter int;
	set counter=0, str='NoName';
while counter<10 do
	set counter = counter+1;
		insert into gender(gender, gender_full ) values (concat(str,counter), counter);
end while;
END //
DELIMITER ;
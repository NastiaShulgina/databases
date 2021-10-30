-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Shulgina
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Shulgina
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Shulgina` DEFAULT CHARACTER SET utf8 ;
USE `Shulgina` ;

-- -----------------------------------------------------
-- Table `Shulgina`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shulgina`.`location`;
CREATE TABLE `Shulgina`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(30) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `office` VARCHAR(45) NOT NULL,
  `room_number` INT NULL,
  `workplace_number` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shulgina`.`application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shulgina`.`application`;
CREATE TABLE IF NOT EXISTS `Shulgina`.`application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `time` TIME NULL,
  `status` ENUM('new', 'in processing', 'processed', 'postponed') NOT NULL DEFAULT 'new',
  `priority` ENUM('critical', 'high', 'medium', 'low') NOT NULL DEFAULT 'low',
  `location_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NOT NULL,
  `signature` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `date_UNIQUE` (`date` ASC),
  UNIQUE INDEX `time_UNIQUE` (`time` ASC),
  INDEX `fk_application_location1_idx` (`location_id` ASC),
  CONSTRAINT `fk_application_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `Shulgina`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shulgina`.`problem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shulgina`.`problem`;
CREATE TABLE `Shulgina`.`problem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `non_working_equipment` VARCHAR(100) NULL,
  `damaged_eqipment` VARCHAR(100) NULL,
  `obsolete_software` VARCHAR(100) NULL,
  `damaged_software` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shulgina`.`responsible_worker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shulgina`.`responsible_worker`;
CREATE TABLE `Shulgina`.`responsible_worker` (
  `login` VARCHAR(45) NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `middle_name` VARCHAR(30) NULL,
  `surname` VARCHAR(30) NOT NULL,
  `age` INT NULL,
  `post` VARCHAR(45) NULL,
  `working_experience` INT NULL,
  `application_has_problem_id` INT NOT NULL,
  PRIMARY KEY (`login`),
  INDEX `fk_responsible_worker_application_has_problem_idx` (`application_has_problem_id` ASC),
  CONSTRAINT `fk_responsible_worker_application_has_problem_id1`
    FOREIGN KEY (`application_has_problem_id`)
    REFERENCES `Shulgina`.`application_has_problem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shulgina`.`solution`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shulgina`.`solution`;
CREATE TABLE `Shulgina`.`solution` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `equipment_to_replace` VARCHAR(100) NULL,
  `equipment_to_fix` VARCHAR(100) NULL,
  `software_to_update` VARCHAR(100) NULL,
  `software_to_fix` VARCHAR(100) NULL,
  `amount_of_new_items_needed` INT NULL,
  `amount_of_items_to_fix` INT NULL,
  `application_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_solution_application1_idx` (`application_id` ASC),
  CONSTRAINT `fk_solution_application1`
    FOREIGN KEY (`application_id`)
    REFERENCES `Shulgina`.`application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shulgina`.`application_has_problem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shulgina`.`application_has_problem`;
CREATE TABLE `Shulgina`.`application_has_problem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `application_id` INT NOT NULL,
  `problem_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_application_has_problem_problem1_idx` (`problem_id` ASC) VISIBLE,
  INDEX `fk_application_has_problem_application1_idx` (`application_id` ASC) VISIBLE,
  CONSTRAINT `fk_application_has_problem_application1`
    FOREIGN KEY (`application_id`)
    REFERENCES `Shulgina`.`application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_has_problem_problem1`
    FOREIGN KEY (`problem_id`)
    REFERENCES `Shulgina`.`problem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- problem

INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (1,'pc',NULL,'Access','Computer driver');
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (2,'pc',NULL,'Firefox',NULL);
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (3,'printer',NULL,NULL,'Discord');
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (4,'laptop',NULL,NULL,NULL);
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (5,'printer',NULL,'Windows media player','MySQL');
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (6,'remote control','air conditioner',NULL,NULL);
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (7,NULL,'printer','Windows',NULL);
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (8,NULL,'pc','PowerPoint',NULL);
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (9,'pc','laptop','Access','MySQL');
INSERT INTO `Shulgina`.problem (`id`,`non_working_equipment`,`damaged_eqipment`,`obsolete_software`,`damaged_software`) VALUES (10,NULL,'air conditioner','Excel',NULL);

-- solution

INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (1,'pc',NULL,'Access','Computer driver',1,2,1);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (2,'pc',NULL,'Firefox',NULL,1,1,2);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (3,'printer',NULL,NULL,'Discord',1,1,3);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (4,'laptop',NULL,NULL,NULL,1,0,4);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (5,'printer',NULL,'Windows media player','MySQL',1,2,5);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (6,'remote control','air conditioner',NULL,NULL,1,1,6);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (7,NULL,'printer','Windows',NULL,0,2,7);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (8,NULL,'pc','PowerPoint',NULL,0,2,8);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (9,'pc','laptop','Access','MySQL',1,3,9);
INSERT INTO `Shulgina`.solution (`id`,`equipment_to_replace`,`equipment_to_fix`,`software_to_update`,`software_to_fix`,`amount_of_new_items_needed`,`amount_of_items_to_fix`,`application_id`) VALUES (10,NULL,'air conditioner','Excel',NULL,0,2,10);

-- location

INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (1,'Lviv','Teatralna','25',2,15);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (2,'Kharkiv','Shevchenka','11',5,16);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (3,'Kyiv','Khoryva','33',4,12);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (4,'New York','Wall Street','17',8,1);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (5,'Krakiw','Malopolska','90',7,17);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (6,'Lviv','Chervonoyi Kalyny','7',7,2);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (7,'Lviv','Danylyshyna','10',7,3);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (8,'Lviv','Voronogo','8',1,6);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (9,'Lviv','Voronogo','8',1,11);
INSERT INTO `Shulgina`.location (`id`,`city`,`street`,`office`,`room_number`,`workplace_number`) VALUES (10,'Kyiv','Khoryva','33',6,1);

-- application_has_problem

INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (1,10,1);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (2,9,2);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (3,8,3);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (4,7,4);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (5,6,5);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (6,5,6);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (7,4,7);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (8,3,8);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (9,2,9);
INSERT INTO `Shulgina`.application_has_problem (`application_id`,`problem_id`,`id`) VALUES (10,1,10);

-- responsible_worker

INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('nastia.shulgina912@gmail.com','Zenoviy','Yevgenovych','Veres',NULL,'boss',NULL,10);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('petro777@gmail.com','Petro',NULL,'Tsoy',25,'manager',2,1);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('g1a2l3y4n5a6@gmail.com','Galyna','Petrivna','Balandyuk',30,'programmer',6,2);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('anonymous003@ukr.net','Ross',NULL,'Gellar',27,'programmer',5,3);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('vasyl1223@ukr.net','Vasyl','Mykhailovych','Muran',20,'programmer',0,4);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('nazarenko.nazar1112@ukr.net','Nazar','Artemovych','Shevchenko',44,'manager',12,5);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('teacher.cool88@ukr.net','Oksana','Arsenivna','Vintonyak',51,'manager',15,6);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('andrusevych13@gmail.com','Kateryna','Bogdanivna','Luzhna',NULL,'programmer',2,7);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('petrusevych222@gmail.com','Yuriy','Olegovych','Pushkin',NULL,'programmer',NULL,8);
INSERT INTO `Shulgina`.responsible_worker (`login`,`name`,`middle_name`,`surname`,`age`,`post`,`working_experience`,`application_has_problem_id`) VALUES ('olesya.buryak@gmail.com','Olesya',NULL,'Buryak',21,'programmer',NULL,9);


-- application

INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (1,'2021-10-06.','15:00','new','critical',8,'Petro','Petrovych','Petrenko',1);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (2,'2021-05-09','17:01','processed','high',3,'Anastasia','Oleksandrivna','Shulgina',1);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (3,'2020-12-12','10:30','postponed','medium',1,'Oleg','Sergiyovych','Stetsiv',0);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (4,'2019-01-06','12:15','in processing','critical',2,'Olesya','Volodymyrivna','Buryak',1);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (5,'2021-09-06','13:20','processed','low',7,'Dmytro',NULL,'Dmytrov',0);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (6,'2021-03-17','12:00','postponed','critical',5,'John',NULL,'Johnson',1);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (7,'2020-11-27','09:45','processed','medium',10,'Emma','Petrivna','Watson',1);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (8,'2021-08-30','08:50','in processing','high',4,'Julia','Markivna','Gnatyuk',0);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (9,'2018-12-31','10:00','processed','low',6,'Monica','Chandlerivna','Galler',1);
INSERT INTO `Shulgina`.application (`id`,`date`,`time`,`status`,`priority`,`location_id`,`name`,`middle_name`,`surname`,`signature`) VALUES (10,'2021-10-30','11:10','new','high',9,'Phoebe','Joeyivna','Buffay',0);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

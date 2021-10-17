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
CREATE TABLE IF NOT EXISTS `Shulgina`.`location` (
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
  UNIQUE INDEX `date_UNIQUE` (`date` ASC) VISIBLE,
  UNIQUE INDEX `time_UNIQUE` (`time` ASC) VISIBLE,
  INDEX `fk_application_location1_idx` (`location_id` ASC) VISIBLE,
  CONSTRAINT `fk_application_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `Shulgina`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shulgina`.`problem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shulgina`.`problem` (
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
CREATE TABLE IF NOT EXISTS `Shulgina`.`responsible_worker` (
  `login` VARCHAR(45) NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `middle_name` VARCHAR(30) NULL,
  `surname` VARCHAR(30) NOT NULL,
  `age` INT NULL,
  `post` VARCHAR(45) NULL,
  `working_experience` INT NULL,
  `application_id` INT NOT NULL,
  PRIMARY KEY (`login`),
  INDEX `fk_responsible_worker_application1_idx` (`application_id` ASC) VISIBLE,
  CONSTRAINT `fk_responsible_worker_application1`
    FOREIGN KEY (`application_id`)
    REFERENCES `Shulgina`.`application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shulgina`.`solution`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shulgina`.`solution` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `equipment_to_replace` TINYINT NULL,
  `equipment_to_fix` TINYINT NULL,
  `software_to_update` TINYINT NULL,
  `software_to_fix` TINYINT NULL,
  `amount_of_new_items_needed` INT NULL,
  `amount_of_items_to_fix` INT NULL,
  `application_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_solution_application1_idx` (`application_id` ASC) VISIBLE,
  CONSTRAINT `fk_solution_application1`
    FOREIGN KEY (`application_id`)
    REFERENCES `Shulgina`.`application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shulgina`.`application_has_problem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shulgina`.`application_has_problem` (
  `application_id` INT NOT NULL,
  `problem_id` INT NOT NULL,
  PRIMARY KEY (`application_id`, `problem_id`),
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

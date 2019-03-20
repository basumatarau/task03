-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema task03
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `task03` ;

-- -----------------------------------------------------
-- Schema task03
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `task03` DEFAULT CHARACTER SET utf8 ;
USE `task03` ;

-- -----------------------------------------------------
-- Table `task03`.`newsCategories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `task03`.`newsCategories` (
  `idCategory` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(80) NOT NULL,
PRIMARY KEY (`idCategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task03`.`newsItems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `task03`.`newsItems` (
  `idNewsItem` INT NOT NULL AUTO_INCREMENT,
  `newsCategory_idCategory` INT NOT NULL,
  `title` VARCHAR(200) NOT NULL,
`publicationDate` TIMESTAMP NOT NULL,
`intro` VARCHAR(200) NOT NULL,
`body` VARCHAR(2000) NOT NULL,
PRIMARY KEY (`idNewsItem`),
INDEX `fk_newsItems_newsCategory1_idx` (`newsCategory_idCategory` ASC),
CONSTRAINT `fk_newsItems_newsCategory1`
FOREIGN KEY (`newsCategory_idCategory`)
REFERENCES `task03`.`newsCategories` (`idCategory`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task03`.`tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `task03`.`tags` (
  `idTag` INT NOT NULL AUTO_INCREMENT,
  `tag` VARCHAR(45) NULL,
PRIMARY KEY (`idTag`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task03`.`authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `task03`.`authors` (
  `idAuthor` INT NOT NULL AUTO_INCREMENT,
  `author` VARCHAR(45) NULL,
PRIMARY KEY (`idAuthor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task03`.`newsItems_has_authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `task03`.`newsItems_has_authors` (
  `newsItems_idNewsItem` INT NOT NULL,
  `authors_idAuthor` INT NOT NULL,
  PRIMARY KEY (`newsItems_idNewsItem`, `authors_idAuthor`),
INDEX `fk_newsItems_has_authors_authors1_idx` (`authors_idAuthor` ASC),
INDEX `fk_newsItems_has_authors_newsItems1_idx` (`newsItems_idNewsItem` ASC),
CONSTRAINT `fk_newsItems_has_authors_newsItems1`
FOREIGN KEY (`newsItems_idNewsItem`)
REFERENCES `task03`.`newsItems` (`idNewsItem`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
CONSTRAINT `fk_newsItems_has_authors_authors1`
FOREIGN KEY (`authors_idAuthor`)
REFERENCES `task03`.`authors` (`idAuthor`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task03`.`newsItems_has_tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `task03`.`newsItems_has_tags` (
  `newsItems_idNewsItem` INT NOT NULL,
  `tags_idTag` INT NOT NULL,
  PRIMARY KEY (`newsItems_idNewsItem`, `tags_idTag`),
INDEX `fk_newsItems_has_tags_tags1_idx` (`tags_idTag` ASC),
INDEX `fk_newsItems_has_tags_newsItems1_idx` (`newsItems_idNewsItem` ASC),
CONSTRAINT `fk_newsItems_has_tags_newsItems1`
FOREIGN KEY (`newsItems_idNewsItem`)
REFERENCES `task03`.`newsItems` (`idNewsItem`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
CONSTRAINT `fk_newsItems_has_tags_tags1`
FOREIGN KEY (`tags_idTag`)
REFERENCES `task03`.`tags` (`idTag`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

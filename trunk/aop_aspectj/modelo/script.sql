SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `fiap` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `fiap` ;

-- -----------------------------------------------------
-- Table `fiap`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiap`.`cliente` ;

CREATE  TABLE IF NOT EXISTS `fiap`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(255) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

DROP TABLE IF EXISTS `fiap`.`log_erro` ;

CREATE  TABLE IF NOT EXISTS `fiap`.`log_erro` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(255) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fiap`.`produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiap`.`produto` ;

CREATE  TABLE IF NOT EXISTS `fiap`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(255) NOT NULL ,
  `valorUnitario` DOUBLE NULL ,
  `quantidade` INT NULL ,
  `desconto` DOUBLE NULL ,
  `total` DOUBLE NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fiap`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiap`.`pedido` ;

CREATE  TABLE IF NOT EXISTS `fiap`.`pedido` (
  `id_compra` INT(11) NOT NULL AUTO_INCREMENT ,
  `data_compra` DATE NOT NULL ,
  `cliente_id` INT NOT NULL ,
  `produto_id` INT NOT NULL ,
  PRIMARY KEY (`id_compra`) ,
  INDEX `fk_pedido_cliente_idx` (`cliente_id` ASC) ,
  INDEX `fk_pedido_produto1_idx` (`produto_id` ASC) ,
  CONSTRAINT `fk_pedido_cliente`
    FOREIGN KEY (`cliente_id` )
    REFERENCES `fiap`.`cliente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_produto1`
    FOREIGN KEY (`produto_id` )
    REFERENCES `fiap`.`produto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `fiap` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `fiap`.`cliente` (`nome`) VALUES ('Carlos Barbero');
INSERT INTO `fiap`.`cliente` (`nome`) VALUES ('Jose Roberto');
INSERT INTO `fiap`.`produto` (`descricao`, `valorUnitario`, `quantidade`) VALUES ('Programando em Aspecto usando AspectJ e Spring AOP', '10', '10');
INSERT INTO `fiap`.`produto` (`descricao`, `valorUnitario`, `quantidade`) VALUES ('Java Como Programar', '10', '10');



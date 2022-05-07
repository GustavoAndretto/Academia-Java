-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Biblioteca
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Biblioteca` ;

-- -----------------------------------------------------
-- Schema Biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `Biblioteca` ;

-- -----------------------------------------------------
-- Table `Biblioteca`.`Editora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Editora` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Editora` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Categoria` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tipoCategoria` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Livro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Livro` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Livro` (
  `isbn` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `ano` INT UNSIGNED NOT NULL,
  `Categoria_id` INT UNSIGNED NOT NULL,
  `Editora_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`isbn`, `Editora_id`, `Categoria_id`),
  UNIQUE INDEX `id_UNIQUE` (`isbn` ASC) VISIBLE,
  INDEX `fk_Livro_Categoria_idx` (`Categoria_id` ASC) VISIBLE,
  INDEX `fk_Livro_Editora_idx` (`Editora_id` ASC) VISIBLE,
  CONSTRAINT `fk_Livro_Categoria`
    FOREIGN KEY (`Categoria_id`)
    REFERENCES `Biblioteca`.`Categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Livro_Editora`
    FOREIGN KEY (`Editora_id`)
    REFERENCES `Biblioteca`.`Editora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Autor` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Autor` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `nacionalidade` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`LivroAutor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`LivroAutor` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`LivroAutor` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Livro_isbn` INT UNSIGNED NOT NULL,
  `Autor_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `Livro_isbn`, `Autor_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_LivroAutor_Livro_idx` (`Livro_isbn` ASC) VISIBLE,
  INDEX `fk_LivroAutor_Autor_idx` (`Autor_id` ASC) VISIBLE,
  CONSTRAINT `fk_LivroAutor_Livro`
    FOREIGN KEY (`Livro_isbn`)
    REFERENCES `Biblioteca`.`Livro` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LivroAutor_Autor`
    FOREIGN KEY (`Autor_id`)
    REFERENCES `Biblioteca`.`Autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Biblioteca`.`Editora`
-- -----------------------------------------------------
START TRANSACTION;
USE `Biblioteca`;
INSERT INTO `Biblioteca`.`Editora` (`id`, `nome`) VALUES (1, 'Rocco');
INSERT INTO `Biblioteca`.`Editora` (`id`, `nome`) VALUES (2, 'Wmf Martins Fontes');
INSERT INTO `Biblioteca`.`Editora` (`id`, `nome`) VALUES (3, 'Casa da Palavra');
INSERT INTO `Biblioteca`.`Editora` (`id`, `nome`) VALUES (4, 'Belas Letras');
INSERT INTO `Biblioteca`.`Editora` (`id`, `nome`) VALUES (5, 'Matrix');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Biblioteca`.`Categoria`
-- -----------------------------------------------------
START TRANSACTION;
USE `Biblioteca`;
INSERT INTO `Biblioteca`.`Categoria` (`id`, `tipoCategoria`) VALUES (1, 'Literatura Juvenil');
INSERT INTO `Biblioteca`.`Categoria` (`id`, `tipoCategoria`) VALUES (2, 'Ficção Científica');
INSERT INTO `Biblioteca`.`Categoria` (`id`, `tipoCategoria`) VALUES (3, 'Humor');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Biblioteca`.`Livro`
-- -----------------------------------------------------
START TRANSACTION;
USE `Biblioteca`;
INSERT INTO `Biblioteca`.`Livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) VALUES (129834798, 'Garota Desdobrável', 2015, 3, 4);
INSERT INTO `Biblioteca`.`Livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) VALUES (298345729, 'O Papai é Pop', 2015, 2, 3);
INSERT INTO `Biblioteca`.`Livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) VALUES (316546479, 'Harry Potter e A Pedra Filosofal', 2000, 1, 1);
INSERT INTO `Biblioteca`.`Livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) VALUES (347623486, 'Pior Que Ta Não Fica', 2016, 2, 2);
INSERT INTO `Biblioteca`.`Livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) VALUES (348976599, 'Harry Potter e O Prisioneiro de Azkaban', 2004, 1, 2);
INSERT INTO `Biblioteca`.`Livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) VALUES (765687567, 'As Crónicas de Nárnia', 2009, 2, 2);
INSERT INTO `Biblioteca`.`Livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) VALUES (808028923, 'O Espadachim de Carvão', 2013, 3, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Biblioteca`.`Autor`
-- -----------------------------------------------------
START TRANSACTION;
USE `Biblioteca`;
INSERT INTO `Biblioteca`.`Autor` (`id`, `nome`, `nacionalidade`) VALUES (1, 'J.K. Rowling', 'Inglaterra');
INSERT INTO `Biblioteca`.`Autor` (`id`, `nome`, `nacionalidade`) VALUES (2, 'Clives Staples Lewis', 'Inglaterra');
INSERT INTO `Biblioteca`.`Autor` (`id`, `nome`, `nacionalidade`) VALUES (3, 'Affonso Solano', 'Brasil');
INSERT INTO `Biblioteca`.`Autor` (`id`, `nome`, `nacionalidade`) VALUES (4, 'Marcos Piangers', 'Brasil');
INSERT INTO `Biblioteca`.`Autor` (`id`, `nome`, `nacionalidade`) VALUES (5, 'Ciro Botelho', 'Brasil');
INSERT INTO `Biblioteca`.`Autor` (`id`, `nome`, `nacionalidade`) VALUES (6, 'Bianca Mól', 'Brasil');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Biblioteca`.`LivroAutor`
-- -----------------------------------------------------
START TRANSACTION;
USE `Biblioteca`;
INSERT INTO `Biblioteca`.`LivroAutor` (`id`, `Livro_isbn`, `Autor_id`) VALUES (1, 316546479, 1);
INSERT INTO `Biblioteca`.`LivroAutor` (`id`, `Livro_isbn`, `Autor_id`) VALUES (2, 765687567, 2);
INSERT INTO `Biblioteca`.`LivroAutor` (`id`, `Livro_isbn`, `Autor_id`) VALUES (3, 808028923, 3);
INSERT INTO `Biblioteca`.`LivroAutor` (`id`, `Livro_isbn`, `Autor_id`) VALUES (4, 298345729, 4);
INSERT INTO `Biblioteca`.`LivroAutor` (`id`, `Livro_isbn`, `Autor_id`) VALUES (5, 347623486, 5);
INSERT INTO `Biblioteca`.`LivroAutor` (`id`, `Livro_isbn`, `Autor_id`) VALUES (6, 129834798, 6);
INSERT INTO `Biblioteca`.`LivroAutor` (`id`, `Livro_isbn`, `Autor_id`) VALUES (7, 348976599, 1);

COMMIT;
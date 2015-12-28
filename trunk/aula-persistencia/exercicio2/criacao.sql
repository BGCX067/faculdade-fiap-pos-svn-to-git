

CREATE TABLE `tb_categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8$$




CREATE TABLE `tb_editora` (
  `idEditora` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idEditora`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8$$




CREATE TABLE `tb_livro` (
  `isbn` varchar(10) NOT NULL DEFAULT '',
  `titulo` varchar(100) DEFAULT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `idEditora` int(11) DEFAULT NULL,
  `idCategoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$
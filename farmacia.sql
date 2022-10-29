-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 29, 2022 at 11:02 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `farmacia`
--

-- --------------------------------------------------------

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `contacto` varchar(13) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  PRIMARY KEY (`contacto`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fornecedor`
--

INSERT INTO `fornecedor` (`contacto`, `nome`, `email`, `endereco`) VALUES
('844155161', 'Great khans', 'manny@greatkhan.com', 'Red Mountain'),
('846969420', 'Caesar\'s Legion', 'vulpes@caesar.com', 'The Fort'),
('', 'ROBCO Meds', 'info@robco.com', 'New Vegas '),
('871831318', 'Folower\'s of The Apocalipse', 'Arcade@folowers.com', 'Old Mormon Fort, Freeside'),
('812345678', 'asjd', 'kdf', 'skdk'),
('824682170', 'ECOMOZ Farma', '', '2HGF+R2V, Bairo de Zimpeto, Maputo');

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `idFuncionario` varchar(50) NOT NULL,
  `pNome` varchar(50) NOT NULL,
  `apelido` varchar(50) NOT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `contacto` char(9) NOT NULL,
  PRIMARY KEY (`idFuncionario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `pNome`, `apelido`, `data_nascimento`, `email`, `contacto`) VALUES
('1', 'Vulpes', 'Inculta', '3977-09-02', 'vulpesfumentari@legion.com', '856638515');

-- --------------------------------------------------------

--
-- Table structure for table `ingredientemedicamento`
--

DROP TABLE IF EXISTS `ingredientemedicamento`;
CREATE TABLE IF NOT EXISTS `ingredientemedicamento` (
  `batchNo` varchar(30) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `quantidade` int(7) NOT NULL,
  PRIMARY KEY (`batchNo`,`nome`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
CREATE TABLE IF NOT EXISTS `medicamento` (
  `batchNo` varchar(30) NOT NULL,
  `nome_comercial` varchar(50) NOT NULL,
  `nome_genérico` varchar(50) NOT NULL,
  `validade` date NOT NULL,
  `preco_compra` int(7) NOT NULL,
  `preco_venda` int(7) NOT NULL,
  `classificacao` varchar(50) NOT NULL,
  `contacto_fornecedor` varchar(13) NOT NULL,
  `descricao` varchar(1000) NOT NULL,
  `quantidade` int(5) NOT NULL,
  `stock` int(5) NOT NULL,
  PRIMARY KEY (`batchNo`),
  KEY `Fk_contacto` (`contacto_fornecedor`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicamento`
--

INSERT INTO `medicamento` (`batchNo`, `nome_comercial`, `nome_genérico`, `validade`, `preco_compra`, `preco_venda`, `classificacao`, `contacto_fornecedor`, `descricao`, `quantidade`, `stock`) VALUES
('G106007', 'GRIPCOLD', '', '2024-01-25', 30, 4000, '', '844155161', '', 100, 0),
('G106087', 'GRIPCOLD', '', '2024-01-25', 30, 4000, '', '844155161', '', 30, 0);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(3) NOT NULL,
  `nome` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `nome`) VALUES
(1, 'Clifton'),
(2, 'Delcio'),
(3, 'Mario');

-- --------------------------------------------------------

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `idVenda` int(13) NOT NULL,
  `data` date NOT NULL,
  `valor_total` int(7) NOT NULL,
  `desconto` int(7) NOT NULL,
  `valor_pago` int(7) NOT NULL,
  PRIMARY KEY (`idVenda`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vendamedicamento`
--

DROP TABLE IF EXISTS `vendamedicamento`;
CREATE TABLE IF NOT EXISTS `vendamedicamento` (
  `batchNo` varchar(30) NOT NULL,
  `idVenda` varchar(30) NOT NULL,
  `quantidade` int(4) NOT NULL,
  PRIMARY KEY (`batchNo`,`idVenda`),
  KEY `Fk_idVenda` (`idVenda`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

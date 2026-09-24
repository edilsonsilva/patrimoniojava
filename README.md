# 📦 Sistema de Gerenciamento de Patrimônio

Um sistema robusto e estruturado desenvolvido em **Java** para gerenciar os ativos patrimoniais de uma Instituição de Educação Profissional. O projeto tem como foco o controle preciso de bens, suas alocações, movimentações e baixas, garantindo a organização física e contábil da instituição.

## 🚀 Tecnologias Utilizadas

*   **Linguagem:** Java
*   **Banco de Dados:** MySQL
*   **Paradigma:** Orientação a Objetos
*   **Design de Software:** Princípios **SOLID**

## 🏗️ Arquitetura e Estrutura de Pacotes

O projeto foi organizado visando a separação de responsabilidades (Single Responsibility Principle do SOLID), facilitando a manutenção e escalabilidade do código. A estrutura de pacotes é dividida em:

*   📂 **`POJO` (Plain Old Java Object):** Contém as classes de modelo/entidade que representam as tabelas do banco de dados (ex: Usuario, Patrimonio, Local). São classes puras, contendo apenas atributos, construtores e métodos Getters/Setters.
*   📂 **`DAO` (Data Access Object):** Responsável por toda a persistência de dados. Aqui ficam as classes que realizam a conexão com o MySQL e executam as operações de CRUD (Create, Read, Update, Delete), isolando a lógica de banco de dados do resto da aplicação.
*   📂 **`Janela`:** Contém as classes responsáveis pela Interface Gráfica do Usuário (GUI). Responsável por capturar as interações do usuário e exibir as informações processadas pelo sistema.
*   📂 **`Imagens`:** Diretório de recursos estáticos (assets) que armazena ícones, logotipos e outras imagens utilizadas nas janelas do sistema.

## 🗄️ Estrutura do Banco de Dados

O banco de dados do projeto (nomeado `squash_db`) foi modelado para atender todos os fluxos de um controle patrimonial completo. Ele é composto pelas seguintes tabelas:

1.  **`usuarios`**: Gerenciamento de acesso ao sistema (administradores, operadores, etc).
2.  **`categorias`**: Classificação dos bens (ex: Informática, Mobiliário, Laboratório).
3.  **`cursos`**: Cadastro dos cursos ofertados pela instituição, permitindo associar bens e locais a necessidades específicas.
4.  **`locais`**: Espaços físicos da instituição (ex: Sala 101, Laboratório de TI, Biblioteca).
5.  **`patrimonios`**: Tabela principal com o registro central de todos os bens (número de tombo, descrição, estado de conservação, valor).
6.  **`movimentacoes`**: Histórico de transferências de um patrimônio entre diferentes locais ou responsáveis.
7.  **`baixas_patrimoniais`**: Registro de bens que foram retirados de circulação (por descarte, doação, quebra, etc).

``` sql
CREATE DATABASE  IF NOT EXISTS `squash_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `squash_db`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: squash_db
-- ------------------------------------------------------
-- Server version	26.7.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'ee020c31-a081-11f1-85da-b24213b9b77e:1-33';

--
-- Table structure for table `baixas_patrimoniais`
--

DROP TABLE IF EXISTS `baixas_patrimoniais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baixas_patrimoniais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_baixa` enum('Descarte','Venda','Doação','Furto/Roubo','Extravio') NOT NULL,
  `motivo` text NOT NULL,
  `valor_recuperado` decimal(10,2) DEFAULT '0.00',
  `documento_comprobatorio` varchar(100) DEFAULT NULL,
  `data_baixa` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `baixas_patrimoniais_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `baixas_patrimoniais_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baixas_patrimoniais`
--

LOCK TABLES `baixas_patrimoniais` WRITE;
/*!40000 ALTER TABLE `baixas_patrimoniais` DISABLE KEYS */;
INSERT INTO `baixas_patrimoniais` VALUES (1,1,1,'Venda','Obsoleto',6000.00,'Recibo','2026-08-25 13:48:36');
/*!40000 ALTER TABLE `baixas_patrimoniais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Computador','Computador Desktop'),(52,'Informática','Equipamentos de informática em geral');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Técnico em Informática','TI',1,'2026-08-25 12:52:05'),(52,'Técnico em Informática','TI',53,'2026-09-09 12:56:05');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locais`
--

DROP TABLE IF EXISTS `locais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `locais_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locais`
--

LOCK TABLES `locais` WRITE;
/*!40000 ALTER TABLE `locais` DISABLE KEYS */;
INSERT INTO `locais` VALUES (1,'Sala 13','Sala 13 - Laboratório de Informática no primeiro andar',1,'2026-08-25 12:56:54'),(52,'Laboratório 18','Laboratório de Hardware, sala utilizada para as aula de montagem e manutenção de computadores e redes de internet',52,'2026-09-10 11:26:45');
/*!40000 ALTER TABLE `locais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacoes`
--

DROP TABLE IF EXISTS `movimentacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimentacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_movimentacao` enum('Empréstimo','Devolução','Envio Manutenção','Retorno Manutenção','Transferência de Local','Baixa') NOT NULL,
  `responsavel_destino` varchar(150) DEFAULT NULL,
  `documento_responsavel` varchar(50) DEFAULT NULL,
  `data_saida` datetime DEFAULT CURRENT_TIMESTAMP,
  `data_prevista_retorno` datetime DEFAULT NULL,
  `data_retorno_efetivo` datetime DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`id`),
  KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `movimentacoes_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `movimentacoes_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacoes`
--

LOCK TABLES `movimentacoes` WRITE;
/*!40000 ALTER TABLE `movimentacoes` DISABLE KEYS */;
INSERT INTO `movimentacoes` VALUES (1,1,1,'Empréstimo','Nova sala','recibo','2026-08-25 13:47:07','2026-09-10 00:00:00','2026-09-10 00:00:00','Nenhuma');
/*!40000 ALTER TABLE `movimentacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrimonios`
--

DROP TABLE IF EXISTS `patrimonios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patrimonios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_tombamento` varchar(50) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `descricao` text,
  `curso_id` int DEFAULT NULL,
  `local_id` int DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  `status` enum('Disponível','Emprestado','Em Manutenção','Baixado/Inativo') DEFAULT 'Disponível',
  `valor_aquisicao` decimal(10,2) DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `criado_por` int NOT NULL,
  `atualizado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_tombamento` (`numero_tombamento`),
  KEY `curso_id` (`curso_id`),
  KEY `local_id` (`local_id`),
  KEY `categoria_id` (`categoria_id`),
  KEY `criado_por` (`criado_por`),
  KEY `atualizado_por` (`atualizado_por`),
  CONSTRAINT `patrimonios_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_2` FOREIGN KEY (`local_id`) REFERENCES `locais` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_3` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_4` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `patrimonios_ibfk_5` FOREIGN KEY (`atualizado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrimonios`
--

LOCK TABLES `patrimonios` WRITE;
/*!40000 ALTER TABLE `patrimonios` DISABLE KEYS */;
INSERT INTO `patrimonios` VALUES (1,'718964','Computador Lenovo ThinkPad','Computador Lenovo Thinkpad',1,1,1,'Disponível',15000.00,'2025-12-10',1,1,'2026-08-25 13:04:09','2026-08-25 13:04:09'),(52,'7745484','Monitor 22','Monitor Gamer 22 Polegadas FHD 100Hz 5ms é a escolha ideal para quem busca um monitor compacto e versátil!\nSua tela Full HD proporciona imagens nítidas, excelentes para tarefas como navegação, edição de documentos e estudos. \nO brilho de 250cd/m² proporciona uma visibilidade \nadequada para ambientes internos, e a redução de luz azul evita o cansaço causado por longas horas de uso.',1,52,52,'Disponível',500.00,'2025-12-10',53,NULL,'2026-09-15 12:55:50','2026-09-15 12:58:24');
/*!40000 ALTER TABLE `patrimonios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha_hash` varchar(255) NOT NULL,
  `perfil` enum('Administrador','Coordenador','Assistente') DEFAULT 'Assistente',
  `ativo` tinyint(1) DEFAULT '1',
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'roberto','roberto@gmail.com','123456','Coordenador',1,'2026-08-25 12:50:27','2026-08-25 12:50:27'),(52,'edilson','edilson@yahoo.com.br','1112241515','Administrador',1,'2026-09-04 11:13:06','2026-09-04 11:13:06'),(53,'vanessa','vanessa@gmai.com','123','Administrador',1,'2026-09-04 12:35:10','2026-09-04 12:35:10'),(54,'joel','jo@uol.com.br','123','Administrador',1,'2026-09-04 13:02:46','2026-09-04 13:02:46');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-24  9:31:59


```




## ⚙️ Como executar o projeto

### Pré-requisitos
*   Java Development Kit (JDK) instalado (Recomendado versão 11 ou superior).
*   Servidor MySQL rodando localmente ou em nuvem.
*   Driver JDBC do MySQL incluído no classpath do projeto.

### Passos
1.  Faça o clone do repositório:
    ```bash
    git clone https://github.com/seu-usuario/nome-do-repositorio.git
    ```
2.  Importe o banco de dados:
    *   Crie um banco de dados chamado `squash_db` no seu MySQL.
    *   Execute o script SQL (se disponível na pasta do projeto) para criar e popular as tabelas iniciais.
3.  Configure a conexão:
    *   Acesse a classe de conexão dentro do pacote `DAO` e atualize as credenciais de acesso ao banco (usuário e senha do MySQL).
4.  Execute a aplicação a partir da classe principal (geralmente localizada no pacote `Janela` ou na raiz do projeto).

## 🤝 Como contribuir

1. Faça um **Fork** do projeto.
2. Crie uma nova branch com a sua feature: `git checkout -b minha-feature`
3. Salve suas alterações e crie uma mensagem de commit contando o que você fez: `git commit -m "feature: Minha nova feature"`
4. Envie as suas alterações: `git push origin minha-feature`
5. Abra um **Pull Request**.

---
*Desenvolvido para fins de gestão acadêmica e profissional.*
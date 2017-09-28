-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Jeu 28 Septembre 2017 à 11:11
-- Version du serveur :  5.7.19-0ubuntu0.17.04.1
-- Version de PHP :  7.0.22-0ubuntu0.17.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gstion_formation`
--

-- --------------------------------------------------------

--
-- Structure de la table `ecf`
--

CREATE TABLE `ecf` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) DEFAULT NULL,
  `id_module` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `id` int(11) NOT NULL,
  `libelle` varchar(256) DEFAULT NULL,
  `description` text,
  `nbr_heures` int(11) DEFAULT NULL,
  `lieu` varchar(256) DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `id_formateur` int(11) DEFAULT NULL,
  `codeFormation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `gestionECF`
--

CREATE TABLE `gestionECF` (
  `idStagiaire` int(11) NOT NULL,
  `idEcf` int(11) NOT NULL,
  `note` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `gestionFormation`
--

CREATE TABLE `gestionFormation` (
  `idStagiaire` int(11) NOT NULL,
  `idFormation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `gestionModule`
--

CREATE TABLE `gestionModule` (
  `formation_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `gestionSequence`
--

CREATE TABLE `gestionSequence` (
  `idModule` int(11) NOT NULL,
  `idSequence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `id` int(11) NOT NULL,
  `libelle` varchar(25) DEFAULT NULL,
  `description` text,
  `duree` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `user` varchar(255) NOT NULL,
  `MDP` varchar(255) DEFAULT NULL,
  `role` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personnel`
--

INSERT INTO `personnel` (`id`, `nom`, `prenom`, `user`, `MDP`, `role`, `email`) VALUES
(1, 'Giraud', 'Alex', 'Alex Kidd', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE `sequence` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `stagiaire`
--

CREATE TABLE `stagiaire` (
  `id` int(11) NOT NULL,
  `nom` varchar(256) DEFAULT NULL,
  `prenom` varchar(256) DEFAULT NULL,
  `adresse` varchar(256) DEFAULT NULL,
  `CP` int(11) DEFAULT NULL,
  `ville` varchar(256) DEFAULT NULL,
  `mail` varchar(256) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `stagiaire`
--

INSERT INTO `stagiaire` (`id`, `nom`, `prenom`, `adresse`, `CP`, `ville`, `mail`, `telephone`) VALUES
(2, 'Malezieux', 'James', 'Kerduraison', 22300, 'Ploumilliau', 'mail@mail.com', 769177283);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `ecf`
--
ALTER TABLE `ecf`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_stagiaire` (`id_module`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_formateur` (`id_formateur`);

--
-- Index pour la table `gestionECF`
--
ALTER TABLE `gestionECF`
  ADD KEY `idStagiaire` (`idStagiaire`),
  ADD KEY `idEcf` (`idEcf`),
  ADD KEY `note` (`note`);

--
-- Index pour la table `gestionFormation`
--
ALTER TABLE `gestionFormation`
  ADD KEY `idStagiaire` (`idStagiaire`),
  ADD KEY `idFormation` (`idFormation`);

--
-- Index pour la table `gestionModule`
--
ALTER TABLE `gestionModule`
  ADD PRIMARY KEY (`formation_id`,`module_id`),
  ADD KEY `module_id` (`module_id`);

--
-- Index pour la table `gestionSequence`
--
ALTER TABLE `gestionSequence`
  ADD KEY `idModule` (`idModule`),
  ADD KEY `idSequence` (`idSequence`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `sequence`
--
ALTER TABLE `sequence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `ecf`
--
ALTER TABLE `ecf`
  ADD CONSTRAINT `ecf_ibfk_1` FOREIGN KEY (`id_module`) REFERENCES `module` (`id`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_1` FOREIGN KEY (`id_formateur`) REFERENCES `personnel` (`id`);

--
-- Contraintes pour la table `gestionECF`
--
ALTER TABLE `gestionECF`
  ADD CONSTRAINT `gestionECF_ibfk_1` FOREIGN KEY (`idStagiaire`) REFERENCES `stagiaire` (`id`),
  ADD CONSTRAINT `gestionECF_ibfk_2` FOREIGN KEY (`idEcf`) REFERENCES `ecf` (`id`);

--
-- Contraintes pour la table `gestionFormation`
--
ALTER TABLE `gestionFormation`
  ADD CONSTRAINT `gestionFormation_ibfk_1` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`id`),
  ADD CONSTRAINT `gestionFormation_ibfk_2` FOREIGN KEY (`idStagiaire`) REFERENCES `stagiaire` (`id`);

--
-- Contraintes pour la table `gestionModule`
--
ALTER TABLE `gestionModule`
  ADD CONSTRAINT `gestionModule_ibfk_1` FOREIGN KEY (`formation_id`) REFERENCES `formation` (`id`),
  ADD CONSTRAINT `gestionModule_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`);

--
-- Contraintes pour la table `gestionSequence`
--
ALTER TABLE `gestionSequence`
  ADD CONSTRAINT `gestionSequence_ibfk_1` FOREIGN KEY (`idModule`) REFERENCES `module` (`id`),
  ADD CONSTRAINT `gestionSequence_ibfk_2` FOREIGN KEY (`idSequence`) REFERENCES `sequence` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

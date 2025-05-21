[![Java CI](https://github.com/calulazone/LibraryProject/actions/workflows/maven.yml/badge.svg)](https://github.com/calulazone/LibraryProject/actions/workflows/maven.yml)

# Projet Java : Gestion de Bibliothèque

Ce projet Java simple permet de gérer une collection de livres via une application basique.  
La gestion du cycle de vie (compilation, tests, exécution) est assurée par Maven.

---

## Structure du projet

- **Book.java** : représente un livre (titre, auteur, année de publication)  
- **Library.java** : gère une bibliothèque avec ajout, suppression et recherche de livres  
- **LibraryTest.java** : tests unitaires  
- **LibraryFunctionalTest.java** : tests fonctionnels simulant des scénarios complets  
- **pom.xml** : configuration Maven du projet  

---

## Prérequis

- Java JDK 21 ou version supérieure  
- Maven installé et accessible via la commande `mvn`  
- Un IDE compatible Java/Maven (IntelliJ IDEA recommandé)  

---

## Compilation du projet

Ouvre un terminal à la racine du projet (là où se trouve `pom.xml`) puis lance :

```bash
mvn compile
```

## Compilation des tests

Dans le terminal, placez-vous à la racine du projet (là où se trouve `pom.xml`) et exécutez :

```bash
mvn test
````

---

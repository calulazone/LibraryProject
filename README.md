# Projet Java : Gestion de Bibliothèque

Ce projet est une application simple en Java qui permet de gérer une collection de livres.  
Il utilise Maven pour la gestion du cycle de vie (compilation, test, exécution, etc.).

---

## Structure

- `Book.java` : classe représentant un livre (titre, auteur, année)
- `Library.java` : classe représentant une bibliothèque avec ajout, suppression et recherche de livres
- `LibraryTest.java` : classe de test unitaire
- `LibraryFunctionalTest.java` : classe de test fonctionnel
- `pom.xml` : fichier de configuration Maven

---

## Prérequis

- Java JDK 21 ou supérieur
- Maven (installé et accessible via la commande `mvn`)
- IntelliJ IDEA ou un autre IDE compatible Java/Maven

---

## Compilation du projet

Dans le terminal, placez-vous à la racine du projet (là où se trouve `pom.xml`) et exécutez :

```bash
mvn compile
````

## Compilation des tests

Dans le terminal, placez-vous à la racine du projet (là où se trouve `pom.xml`) et exécutez :

```bash
mvn test
````

---
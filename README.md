# Gestion de Planning

Ce projet est une application de gestion de planning utilisant Java et PostgreSQL. Il permet aux utilisateurs d'ajouter, d'afficher, de modifier et de supprimer des tâches, tout en suivant leur statut et leur priorité.

## Fonctionnalités

- Ajouter une tâche : Saisissez un titre, une description et une priorité pour ajouter une nouvelle tâche.
- Afficher les tâches : Consultez la liste de toutes les tâches, y compris leurs détails.
- Modifier le statut d'une tâche : Changez le statut d'une tâche en fonction de son avancement (par exemple : 'En cours', 'Terminé').
- Supprimer une tâche : Retirez une tâche de la liste en spécifiant son ID.
- Tri des tâches : Les tâches peuvent être triées par statut (terminé, en cours, non commencé).
  
## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :

- Java JDK : Version 8 ou supérieure.
- PostgreSQL : Version 9.5 ou supérieure.
- PostgreSQL JDBC Driver : Téléchargez la version `postgresql-42.5.0.jar` et placez-la dans le dossier `lib` de votre projet.

## Installation

1. Clonez ce dépôt sur votre machine :

   bash
   git clone https://github.com/votre-utilisateur/gestion-de-taches.git
   cd gestion-de-taches
   

2. Assurez-vous que PostgreSQL est en cours d'exécution et créez une base de données nommée `gestion_planning` :

   sql
   CREATE DATABASE gestion_planning;
   

3. Créez la table `taches` dans votre base de données :

   sql
   DROP TABLE IF EXISTS taches;
   CREATE TABLE taches (
       id SERIAL PRIMARY KEY,
       titre TEXT NOT NULL,
       description TEXT NOT NULL,
       priorite INT NOT NULL,
       statut TEXT NOT NULL DEFAULT 'Non commencé'
   );
   

4. Compilez le projet :

   bash
   javac -cp "lib/postgresql-42.5.0.jar" -d bin src/*.java
   

5. Exécutez l'application :

   bash
   java -cp "bin:lib/postgresql-42.5.0.jar" Main
   

## Utilisation

1. Une fois l'application lancée, vous verrez le menu principal.
2. Suivez les instructions pour ajouter, afficher, modifier ou supprimer des tâches.
   - Exemple : Pour modifier le statut d'une tâche, sélectionnez l'option correspondante et suivez les instructions à l'écran.
3. Pour quitter l'application, sélectionnez l'option "Quitter".

## Contribution

Les contributions sont les bienvenues ! Si vous souhaitez contribuer à ce projet, veuillez suivre ces étapes :

1. Forkez le projet.
2. Créez une nouvelle branche (`git checkout -b feature/nouvelle-fonctionnalite`).
3. Faites vos modifications et committez (`git commit -m 'Ajout d'une nouvelle fonctionnalité'`).
4. Poussez la branche (`git push origin feature/nouvelle-fonctionnalite`).
5. Ouvrez une pull request.
# Plugins

Par Balde et lemaire

## Nature du projet

Ce projet est un éditeur de texte basique auquel on peut ajouter des extensions (plugins)
et en retirer sans interrompre le programme.

## Instructions d'installation

Après avoir télécharger le projet sur gitlab placez vous à la racine du projet et lancez la commande :

`mvn package`

cette commande compile le projet, lance les tests et génère la documentation du projet (à l’aide de l’outil javacdoc).

##Lancement du programme

Le jar produit par **mvn package** se trouve dans le dossier. `target/` et s'appelle **coo-donjon-1.0.jar**, pour l'exécuter depuis la racine du projet
il faut lancer la commande : 
`java -jar target/plugin-1.0.jar`


## Documentation

La Javadoc se trouve dans le dossier `target/apidocs/` au format HTML.

## Tests unitaires

Les tests du projet néccessitent JUnit 4 pour fonctionner, ils se trouvent dans le répertoire `src/main/test/`

## Améliorations possibles

Le projet manque clairement de tests unitaires, une bonne amélioration consisterait à en ajouter.

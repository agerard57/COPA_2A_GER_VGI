# TD4 CPOA GERARD - GIANGRECO


This TD is directly following the previous one.
This "project" is a ugly pullover shop and, thanks to a DataBase, you can add, delete or modify :
  - Clients
  - Products
  - Orders
 
Attention ! : We started to make the interface from the project, so don't mind the pages like menu.fxml or menu_produit.fxml

# Description

----
Créer un nouveau projet JavaFX, et tester votre application
- charger le fichier fxml
- lier le composant racine (la Vbox) à la scène
- lancer et corriger votre code jusqu'à ce que la fenêtre apparaisse
- Votre programme doit :
1) utiliser les champs de saisie pour créer une instance du modèle (Produit) lorsqu'on clique
sur Créer
2) utiliser la méthode toString() du modèle pour compléter le label du bas, ou utiliser ce label
pour afficher (en rouge), les exceptions éventuellement lancées par les setters du modèle (titre
ou description vide) ou les erreurs détectées au niveau du contrôleur (champ de tarif non
numérique, pas de choix de catégorie).
Pour réaliser cette partie, il faut :
- déclarer en variable d'instance les 5 composants à qui vous avez donné un fx:id
- écrire la méthode creerModele appelée au clic sur le bouton Créer
Bonus : réaliser une insertion dans la base de données au clic sur le bouton de création.
---

## Trello
We've made a Trello board. You can easily access it by clicking  __[HERE](https://trello.com/invite/b/DcAjprl2/13a303fce6c355e2e568927e7705c048/cpoa2020gerardgiangreco)__.

## JAR Used / Scene builder

  We used an external JAR for this project :
[MySql Connector /J 8.0.21](https://dev.mysql.com/downloads/connector/j/8.0.html)
- This JAR makes the link between the MySql DataBase and the JAVA code. 

Also, we now used Scene Builder to make the interface.

# What's working

We made the project (all be it with some errors that we will mention down there) with most functions working on this project :

- The page now automatically retrieves from "liste memoire" the content of "Categorie", which displays it in a ComboBox


### How to use it

For now, the available interface for this TD is only : -menu --> -menu_produit--> add_produit
You can then fill out details of the new product. In the end, press "accept" and the system will display a message.

### Repli.it

[![Run on Repl.it](https://repl.it/badge/github/agerard57/GERARD_GIANGRECO_CPOA_TD1_2020)](https://repl.it/github/agerard57/GERARD_GIANGRECO_CPOA_TD1_2020)

### To Do

We finished the First TD late, so we quickly had to finish it before tackling on the next one; We've almost done the second one but there still some things to be done :

We will be soon implementing:
 - Improving "MenuCommande" and "MenuLigneDeCommande"
 - Overall redesign of the code and improvement of the packages

License
----
MIT


**Software gratuit, forcément...**


   

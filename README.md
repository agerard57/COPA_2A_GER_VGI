# TD2 CPOA GERARD - GIANGRECO


This TD is directly following the previous one.
This "project" is a ugly pullover shop and, thanks to a DataBase, you can add, delete or modify :
  - Clients
  - Products
  - Orders
 
# Description
----
- Créer les objets métiers (POJO) pour les tables à gérer
- Les lignes de commande doivent être gérées dans une HashMap<K, V>
- Produire un DAO niveau 2 (MySQL, ListeMémoire). Implémenter d'abord l'architecture globale, puis la
partie SQL, puis la partie ListeMemoire
- Le menu du td1 doit être complété pour que toute action soit répercutée en base de données, grâce à
un appel à la DAOFactory (pas d'appel direct à une classe DAO mySQL ou ListeMemoire !)
- Ce menu a également une option permettant de passer de mySQL à ListeMemoire
ListeMemoireDAO : simulation de données en mémoire, gérées sous forme d'ArrayList<T>, permettant de
faire des tests sans connexion avec une base de données. Voir ListeMemoireCategorieDAO sur Arche
comme exemple de ce qu'il faut faire.

A rendre via github avant jour td+13 17h. Une version doit être enregistrée sur github avant la fin du TD
de la semaine du 14/09.

Votre github doit être associé à un Trello décrivant précisément les tâches effectuées par chaque
membre du binôme. Gérer au moins trois listes : à faire, en cours, terminé. Ce trello doit être
communiqué à votre enseignant de TD.
---
## Trello
We've made a Trello board. You can easily access it by clicking  __[HERE](https://trello.com/invite/b/DcAjprl2/13a303fce6c355e2e568927e7705c048/cpoa2020gerardgiangreco)__.

## JAR Used

  We used an external JAR for this project :
[MySql Connector /J 8.0.21](https://dev.mysql.com/downloads/connector/j/8.0.html)
- This JAR makes the link between the MySql DataBase and the JAVA code. 

# What's working

We made the project (all be it with some errors that we will mention down there) with most functions working on this project :

- There's a fully functionnal multi-layer menu using commands. (with return options)
- You can edit/delete/add the client's list
- You can edit/delete/add the products's list
- You can edit/delete/add the orders's list
- You can edit/delete/add the category's list
- Also featuring "Commande" and "LigneDeCommande" (to be finished tho...)


### How to use it

This program is simple to use : you can go through the menus using the numeric keypad (1-4);
Trying something different from what is proposed will result in an error message.

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


   

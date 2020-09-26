# TD1 CPOA GERARD - GIANGRECO


This first TD has been made with JAVA.
This "project" is a ugly pullover shop and, thanks to a DataBase, you can add, delete or modify :
  - Clients
  - Products
  - Orders
 
# Description
----
>Afin d’égailler Noël prochain, nous allons créer une boutique de vente de «pulls moches » et autres
produits. Il y a plusieurs catégories de produits (tous en taille unique). Chaque produit a en plus de sa
catégorie : un nom, une description, un tarif et un visuel (lien vers un fichier image). Les catégories ont un
titre et un visuel. On stocke les clients avec les informations classiques. Les commandes sont faites à une
date par un client. Chaque commande contient plusieurs lignes, sur chaque ligne : un produit, une
quantité. Pour des raisons fiscales, on stocke le tarif unitaire du produit au moment de la commande.
En conséquence, on vous demande de développer un logiciel permettant de
saisir/modifier/supprimer/visualiser les données pour l'ensemble des produits vendus, des catégories, des clients et des commandes
---
## Trello
We've made a Trello board. You can easily access it by clicking  __[HERE](https://trello.com/invite/b/DcAjprl2/13a303fce6c355e2e568927e7705c048/cpoa2020gerardgiangreco)__.

## JAR Used

  We used an external JAR for this project :
[MySql Connector/J 8.0.21](https://dev.mysql.com/downloads/connector/j/8.0.html)
- This JAR makes the link between the MySql DataBase and the JAVA code. 

# What's working

We made the project (all be it with some errors that we will mention down there) with most functions working on this project :

- There's a fully functionnal multi-layer menu using commands. (with return options)
- You can edit/delete/add the client's list
- You can edit/delete/add the products's list
- You can edit/delete/add the orders's list


## Problems faced

We are deeply sorry for any bugs and coding errors, we had several problems during the project, which makes it unstable and *incomplete* :
- 6 days was a short period of time for us
- One of us was sick during that span
- We encountered bugs with the linking of the DB with the code, so even if not "linked", the DataBase support could still possibly work (we mainly tested with "Client")

# Using git

During the project, we learnt some commands on how to use git :
```sh
$ git add .
$ git commit -m "message"
$ git push origin master
```


### How to use it

This program is simple to use : you can go through the menus using the numeric keypad (1-4);
Trying something different from what is proposed will result in an error message.


### To Do

We want to improve on this course, that is why we will start by continuing the project during our free time;
We will be implementing:
 - Fixes for what is already 
 - Overall redesign of the code and improvement of the packages
 - View lists

License
----

MIT


**Software gratuit, forcément...**


   

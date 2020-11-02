"Bienvenue dans l'application de vente des (meilleurs) pulls moches de Noël !"

----------------------------------------------------------------------------------------------------------------------------------------------------
Développée par GERARD Alexandre / GIANGRECO Vincent, il y est proposé beaucoups de fonctionnalités
citées ci dessous.
----------------------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------------------
Gabarit---------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------

Le gabarit est la page qui est lancé par le main, elle contient simplement la barre en haut de l'application
ainsi que un pannel qui sera automatiquement initialisé avec le fxml "menu.fxml".

------------------------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------------------------------------------------------------------------------------
Barre de menu------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------

La barre de menu de notre application  remplace totalement celle de Windows/Linux par défaut.
On peut l'utiliser pour bouger d'un clic enfoncé la page (drag).
Différentes icônes s'y trouvent :
- Home : Permet de revenir au menu principal
- Settings : Permet d'accéder au menu paramètres
- Réduire : Minimise l'application
- Fermer : Ferme complétement l'application

--------------------------------------------------------------------------------------------------------------------------------------


--------------------------------------------------------------------------------------------------------------------------------------
Menu-------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------

Une fois l'application lancée, on se retrouve face au choix du sous menu: gestion des catégories, 
des clients, des commandes ou des produits.
Lorsce qu'on passe la souris sur une catégorie, le label en bas de l'application change pour
donner le titre de ce dernier.

---------------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------------------------------------------------------------------------------------------------------------
Réglages---------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------

Dans ce menu, il y'a 3 onglets :

- En rapport avec Menu on peut choisir soit Liste Mémoire soit Base de Données, pour décider de 
travailler en ligne ou non.

- La page thèmes permet de changer le thème (sombre ou clair).
Les fichiers CSS des deux thèmes existent mais pour le moment, il est impossible d'utiliser les radioButton
pour pouvoir alterner.

- La dernière page quand à elle a été créée pour afficher un lien vers notre trello, nous ayant aidé 
lors de la conception du projet, ainsi qu'un lien vers notre github.

--------------------------------------------------------------------------------------------------------------------------------------



----------------------------------------------------------------------------------------------------------------------------------------------------
Client---------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------

En rapport avec Client, on peut le visualiser, l'ajouter, le supprimer, le modifier, le trier par Nom/Prénom/ville, 
ou encore le rechercher par nom ou nom et prénom.

Tout fonctionne comme désiré.

-----------------------------------------------------------------------------------------------------------------------------------------------------



----------------------------------------------------------------------------------------------------------------------------------------------------
Produit---------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------

En rapport avec Produit, on peut en ajouter, en supprimer, en modifier, les trier par nom/catégorie/tarif,  
ou encore rechercher par nom.
Chaque produit possède un visuel qui lui est propre.

Tout fonctionne comme désiré à l'exception d'un seul label dans AjouterProduit (Commandé x fois).

------------------------------------------------------------------------------------------------------------------------------------------------------



----------------------------------------------------------------------------------------------------------------------------------------------------
Catégorie---------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------

En rapport avec Catégorie, il est possible de visualiser, ajouter, supprimer, modifier, trier
par nom, ou encore de rechercher par nom toutes les catégories
Chaque catégorie possède un visuel qui lui est propre.

Par ailleurs, pour Catégorie ET Produit, il est possible d'importer sa propre image via un fileChooser.

Tout fonctionne comme désiré pour Catégorie.

----------------------------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------------------------------------------------------------------------------------------------------
Commande-------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------

En rapport avec Commande, il est possible de visualiser, ajouter, supprimer, modifier, trier
par IdCommande, Date et IdClient, ou encore rechercher par date toutes les commandes.


Ici, les seules choses ne fonctionnant pas sont les labels Qte et Tarif pour menu et 
IdProduit, Tarif et Qte pour ajouterCommande

-----------------------------------------------------------------------------------------------------------------------------------------------------
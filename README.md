# project_android_Marty_Guerin

# Auteurs

* Léo Marty
* Léo Guérin

# Résumé

Ce projet consiste en une application android développée en Kotlin sous Android Studio.
Cette application permet d'accéder à une API de recette.

# Fonctionnalités développées

## Page d'accueil 

* photo de recette aléatoire
* accès à la recette en photo
* possibilité de charger une nouvelle recette aléatoire
* possibilité d'accéder à la liste des catégories
* possibilité d'accéder à la liste des régions culinaires
* possibilité d'accéder à la recherche par nom
* possibilité d'accéder à la recherche par ingrédients

## Page de non connexion

* en cas de réponse infructueuse sur une url l'application bascule sur cette page
* possibilité d'effectuer en refresh qui rammènera à la page échouée en cas de reconnexion
* possibilité de retourner sur la page d'accueil

## Page de la liste des catégories

* liste des catégories
* possibilité d'accéder à la liste des recettes pour une catégorie sélectionnée

## Page de la liste des régions culinaires

* liste des régions culinaires
* possibilité d'accéder à la liste des recettes pour une région culinaires sélectionnée

## Page de la recherche par nom

* possibilité de rechercher les recettes correspondant au nom de la recette

## Page de la recherche par ingrédient

* possibilité de rechercher les recettes contenant un certain ingrédient

## Page de liste des recettes

* possibilité d'accéder à une recette en particulier

## Page recette

* photo du plat
* liste des ingrédients et de leur quantité
* un lien youtube (si présent) pour faire la recette
* les explication pour faire le plat en question

## bouton retour

* possibilité de revenir en arrière

# Difficultés rencontrées

## Refresh sur les requêtes échouées

Nous avons rencontré des difficultés sur la capacité à pouvoir revenir sur une page qui avait échoué, depuis le page de non connexion, car il fallait récupérer les bons urls et demander au refresh de l'activité de relancer la recherche qui avait échouée. Mais nous sommes parvenus à une solution
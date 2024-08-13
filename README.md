Dans la 1er page ill y a 2 menu un qui va ouvrir la recherche de mot à l'aide du dictionnaire fourni pour le projet (fichier liste_de_mots ) 
![image](https://github.com/user-attachments/assets/6a179ba1-323f-4b53-bafc-b0d096b0048a)


Sur la page recherche plusieurs option sont disponible 
on a une liste pour selectionné la longueur des mots recherché 
on a une liste pour sélectionné la 1er lettre des mots recherché 
pour finir on a une zone de texte où il faut rentré un mot à trou 
comme indiqué sur le label du menu on remplace les lettres qu'on ne connait pas par des "_" 
et on écrit les lettre qu'on connait 

 je ne connais que le g et le t 
Exemple gateau => g_t___

pour validé le/les choix cliqué sur valider Recherche

![image](https://github.com/user-attachments/assets/d64084af-bc4f-46a7-a40d-ddf3d6c97bfc)

une fois qu'on a entré une lettre on a les mots commençant par celle-ci 
on peut ajouté un nombre pour compléter la recherche et cliquer sur valider Recherche.

un label est rattaché aux variable sélectionné.
![image](https://github.com/user-attachments/assets/51c6d4a1-a891-4aae-946d-09083c3a81b5)


pour changer la recherche il faut cliquer sur Reset avant. 

![image](https://github.com/user-attachments/assets/ea79c4b5-1bd3-4b8c-b76f-75f7519d2374)

Sur l'autre menu on sélectione d'abbord si la grille et carré ou rectangulaire 


![image](https://github.com/user-attachments/assets/db19f9da-2d15-4666-a636-9ffdecf362c9)

Le code pour les grille Rectangulaire n'es pas à jour.

on va donc choisir grille Carré et tomber sur cette page.

On peut choisir la taille de la grille après quoi on clique sur Afficher Grille pour qu'elle  apparaisse.

![image](https://github.com/user-attachments/assets/a4dbde3f-8bec-4219-bdc6-b615e7e2cb70)


Ici, je n'ai compléter toute les fonctionnalité que pour la grille 5x5 donc on choisis celle-ci.

![image](https://github.com/user-attachments/assets/bfa116b6-7aaf-43e1-b777-347f4f66f1e3)

On peut maintenant voir le bouton pour générer aléatoirement les définition et les mot danns la grille

Tant que la grille est vierge on peut ajouter à la main les definition jusqu'à 8 fois 

![image](https://github.com/user-attachments/assets/16d1c621-44a6-4542-b49c-a8bad62ed7bf)

une fois la case où ajouter la definition choisi on re-clique dessus pour choisir dans quelle direction doit partir le mot liéé.

![image](https://github.com/user-attachments/assets/4c7a0cac-4a4e-4067-ab6b-4c9d65cd3c9f)


On a donc une définition qui est créer, et avec ça le menu contextuelle liée à la case changer on peut supprimé la definition présente sur la case ou en ajouté une 2e.

La suppression des flèche n'a pas été faites par consequent supprimer une definition laissera malheureusement la flèche liée visible.

Si on ajoute on constate 2 définition dans la même case et le menu contextuelle liée qui change à nouveau.
(on doit cliquer une 2e fois également pour choisir la direction)
Je n'ai pas réussi à liée le menu à la case entière pour avoir le menu il faut cliqué sur la partie haut (definition du dessus)
on a alors le menu qui propose de supprimer la definition 1 (en haut ) la definition 2 (en bas) ou de supprimer toutes les definition.

![image](https://github.com/user-attachments/assets/a5d8a78e-29b5-4bca-9aef-327feafeeef1)
![image](https://github.com/user-attachments/assets/0c9b8656-495b-4b75-8771-5adb85e3aff4)

On peut faire de même sur toute les tailles de grille mais comme dis precedement les flèche ne se retire pas.

Le boutton Génération aléatoire qui apparaît uniquement après avoir afficher une grille ne marche unique que si on choisi 
la grille 5x5.

la génération est sensé être aléatoire grâce à des patterns prédéfinie que je devais paramétrer moi même et un nombre aléatoire générer qui allais choisir un de ses pattern.

n'ayant eu le temps que de faire 1 seul pattern le boutton ne génère qu'une grille complète poissible.

les définitions ont gardé le nom par défaut car je n'ai pas réussi à afficher une definition liéer au mot.

![image](https://github.com/user-attachments/assets/82efab51-8d33-4d88-81b6-308db341e660)




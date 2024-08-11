package com.projet.mot_fleche.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCoordonate {

    private int grilleSize;
    private List<int[]> coordinates;

    public void RandomCoordinates(int grilleSize) {
        this.grilleSize = grilleSize;
        this.coordinates = new ArrayList<>();

        // Remplissez la liste avec toutes les coordonnées possibles
        for (int i = 0; i < grilleSize; i++) {
            for (int j = 0; j < grilleSize; j++) {
                coordinates.add(new int[]{i, j});
            }
        }

        // Mélangez les coordonnées pour les rendre aléatoires
        Collections.shuffle(coordinates);
    }

    public RandomCoordonate(int largeur) {
        this.grilleSize = largeur;
        RandomCoordinates(this.grilleSize);
    }

    public int[] getNextRandomCoordinate() {
        if (coordinates.isEmpty()) {
            throw new IllegalStateException("Toutes les coordonnées ont été générées.");
        }

        // Retourne la prochaine coordonnée aléatoire unique
        return coordinates.remove(0);
    }
}

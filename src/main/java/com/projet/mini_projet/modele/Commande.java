package com.projet.mini_projet.modele;

import java.util.ArrayList;

public class Commande {

    private Client clientObj;
    private Article ArticleObj;
    private int id_commande;
    private String intitule;
    private String etat;

    public Commande(Client clientObj, Article articleObj, int id_commande, String intitule, String etat) {
        this.clientObj = clientObj;
        ArticleObj = articleObj;
        this.id_commande = id_commande;
        this.intitule = intitule;
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public Client getClientObj() {
        return clientObj;
    }

    public Article getArticleObj() {
        return ArticleObj;
    }

    public int getId_commande() {
        return id_commande;
    }

    public String getIntitule() {
        return intitule;
    }
}

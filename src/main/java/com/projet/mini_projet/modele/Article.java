package com.projet.mini_projet.modele;
import exceptionFile.ArticleException;
public class Article {
    private int id_article;
    private String nomArticle;
    private int quantite;
    private int stock;

    private double prix;
    public Article (String nom,int kod, double price) throws ArticleException {
        //test sur la quantité kod
        if( kod <= 0 || price <= 0.0 ){
            throw  new ArticleException("Quantité ou prix invalide assurer vous bien que la quantité ou le prix ne soit pas négative ou nulle.");
        }else {
            this.quantite = kod;
        }
        this.nomArticle = complete(nom);

        this.prix = price;
    }

    public int getQuantite() {
        return quantite;
    }
    public double getPrix() {
        return prix;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public int getStock() {
        return stock;
    }

    public int getId_article() {
        return id_article;
    }
    public double getPrixTotal(){
        return getPrix() * getQuantite();
    }
    public String getNom() {
        return this.nomArticle;
    }
    private String complete(String texte) {
        StringBuffer texteFormate = new StringBuffer("");
        texteFormate.append(texte);
        int longTotal = 20;
        int nbEspaces = longTotal - texteFormate.length();
        for (int i = 0; i < nbEspaces - 1; i++)
            texteFormate.append(" ");
        return texteFormate.toString();
    }
}
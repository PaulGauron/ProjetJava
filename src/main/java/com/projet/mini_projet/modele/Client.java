package com.projet.mini_projet.modele;

public class Client {

    private int id_client;
    private String nom_cli;
    private String prenom_cli;
    private String adresse_livraison_cli;
    private String adresse_fact_cli;
    private static Client ClientActuelle;


    public Client(int id_client, String nom_cli, String prenom_cli, String adresse_livraison_cli, String adresse_fact_cli) {
        this.id_client = id_client;
        this.nom_cli = nom_cli;
        this.prenom_cli = prenom_cli;
        this.adresse_livraison_cli = adresse_livraison_cli;
        this.adresse_fact_cli = adresse_fact_cli;
    }

    public static void setClientActuelle(Client client){
        ClientActuelle = client;
    }

    public int getId_client() {
        return id_client;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public String getPrenom_cli() {
        return prenom_cli;
    }

    public String getAdresse_livraison_cli() {
        return adresse_livraison_cli;
    }

    public String getAdresse_fact_cli() {
        return adresse_fact_cli;
    }
}

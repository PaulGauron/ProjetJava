package com.projet.mini_projet.modele;
import com.projet.mini_projet.exceptionFile.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Facture {
    private int numeroFacture;
    List<Article> contenu = new ArrayList<>();
    private boolean isvalide = false;
    private String etat = null;
    private String sep =
            String.format("%n*************************************************************************%n");

    public Facture(List<Article> contenu, boolean isvalide, String etat) {
        this.contenu = contenu;
        this.isvalide = isvalide;
        this.etat = etat;
    }

    /**
     *
     * @param art
     * @throws FactureException
     */
    public void add(Article art) throws FactureException {
        if (this.isvalide) {
            throw new FactureException("la facture est déja validée");
        } else if (art == null) {
            throw new FactureException("l'article ajouté est vide");
        } else {
            this.contenu.add(art);
        }
    }

    public String getEtat() {
        return etat;
    }

    public void valide() throws FactureException {
        if (this.countArticles() == 0) {
            throw new FactureException("pas possible valider une facture vide");
        }
        this.isvalide = true;
    }
    public double getTotal() {
        double total = 0;
        for (Article a : this.contenu) {
            total = total + a.getPrixTotal();
        }
        return total;
    }
    public int countArticles() {
        int nombre = 0;
        for (Article a : this.contenu) {
            nombre = nombre + a.getQuantite();
        }
        return nombre;
    }
    boolean isValide() {
        return this.isvalide;
    }
    @Override
    public String toString() {
        DecimalFormat dfPrix = new DecimalFormat("0000.00");
        DecimalFormat dfqte = new DecimalFormat("00");
        int compteur = 0;
        String result = sep + complete(String.format("Facture %d", numeroFacture)) + sep;
        for (Article a : this.contenu) {
            String prixU = dfPrix.format(a.getPrix());
            String qte = dfqte.format(a.getQuantite());
            String prixT = dfPrix.format(a.getPrixTotal());
            String ligne = "";
            ligne = ligne.concat(String.format("n°%d %s: prixU = %s : nb = %s : prixT = %s", +

                    +compteur,a.getNom(),prixU, qte, prixT));
            ligne = complete(ligne);
            result = result.concat(ligne);
        }
        result = result.concat(sep);
        String ligne = "";
        ligne = ligne.concat(String.format("%d articles, prix total : %.2f", this.countArticles(),

                this.getTotal()));

        ligne = complete(ligne);
        result = result.concat(ligne);
        result = result.concat(sep);
        return result;
    }
    private String complete(String texte) {
        StringBuffer texteFormate = new StringBuffer("* ");
        texteFormate.append(texte);
        int longTotal = sep.length() - 4; // 2 fois %n
        int nbEspaces = longTotal - texteFormate.length();
        for (int i = 0; i < nbEspaces - 1; i++)
            texteFormate.append(" ");
        texteFormate.append("*");
        return String.format("%s%n", texteFormate.toString());
    }
}
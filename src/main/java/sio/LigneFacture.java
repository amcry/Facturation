package sio;

import java.util.ArrayList;
import java.util.List;

public class LigneFacture {

    private List<Produit> produits = new ArrayList<>();
    private int qteProduit;
    // private double prixTotalTTCProduit;
    private Produit produit;
    private int compteur = 0;

    public LigneFacture(Produit produit, int qteProduit) {
        this.produit = produit;
        this.qteProduit = qteProduit;
    }

    public double getPrixTTCParQuantite() {
        double prixTotalTTCProduit = produit.getPrixTTC() * qteProduit;
        return prixTotalTTCProduit;
    }

    public double getPrixHTParQuantite() {
        double prixTotalHTProduit = produit.getPrixHT() * qteProduit;
        return prixTotalHTProduit;
    }

    public void afficherLigneFacture() {
        produit.afficherProduit();
        System.out.println("quantité produit : " + qteProduit);

    }

    public int getQuantiteProduit() {
        return qteProduit;
    }

}

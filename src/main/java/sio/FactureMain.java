package sio;

import java.time.LocalDate;

public class FactureMain {
    public static void main(String[] args) {

        Catego_Produit tva = new Catego_Produit("Alimentaire", 10);
        Catego_Produit tva2 = new Catego_Produit("Electroique", 10);
        Catego_Produit tva3 = new Catego_Produit("Fourniture", 10);
        int prixHT = 100;
        int prixHT2 = 200;
        int prixHT3 = 50;
        Produit p = new Produit("1", "produit", prixHT, tva);
        Produit p2 = new Produit("2", "produit2", prixHT2, tva2);
        Produit p3 = new Produit("3", "produit3", prixHT3, tva3);
        LigneFacture produit = new LigneFacture(p, 3);
        LigneFacture produit2 = new LigneFacture(p2, 1);
        LigneFacture produit3 = new LigneFacture(p3, 2);
        Facture facture = new Facture(1, LocalDate.now());
        facture.ajouterProduit(produit);
        facture.ajouterProduit(produit2);
        facture.ajouterProduit(produit3);
        facture.afficheListe();

    }
}

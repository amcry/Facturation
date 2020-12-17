package sio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Facture {

    private int idFacture;
    private LocalDate date;
    private List<LigneFacture> produits = new ArrayList<>();
    private Produit produitNom;

    public Facture(int idFacture, LocalDate date) {
        this.idFacture = idFacture;
        this.date = date;
    }

    public int calculerPrixTotal() {
        int prixTotalTTC = 0;
        for (LigneFacture produit : produits) {
            prixTotalTTC += produit.getPrixTTCParQuantite();
        }
        return prixTotalTTC;
    }

    public int calculerPrixTotalHT() {
        int prixTotalHT = 0;
        for (LigneFacture produit : produits) {
            prixTotalHT += produit.getPrixHTParQuantite();
        }
        return prixTotalHT;
    }

    public void ajouterProduit(LigneFacture produit) {
        produits.add(produit);
    }

    public void retirerProduit(LigneFacture produit) {
        produits.remove(produit);
    }

    public void afficheListe() {
        for (LigneFacture produit : produits) {
            produit.afficherLigneFacture();

            System.out.println("\n");
        }
        System.out.println("prix total HT :" + calculerPrixTotalHT());
        System.out.println("prix total TTC :" + calculerPrixTotal());

    }
}

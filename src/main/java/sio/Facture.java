package sio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Facture {

    private int idFacture;
    private LocalDate date;
    private List<LigneFacture> ligneProduits = new ArrayList<>();
    private Produit produitNom;

    public Facture(int idFacture, LocalDate date) {
        this.idFacture = idFacture;
        this.date = date;
    }

    public int calculerPrixTotalTTC() {
        int prixTotalTTC = 0;
        for (LigneFacture produit : ligneProduits) {
            prixTotalTTC += produit.getPrixTTCParQuantite();
        }
        return prixTotalTTC;
    }

    public int calculerPrixTotalHT() {
        int prixTotalHT = 0;
        for (LigneFacture produit : ligneProduits) {
            prixTotalHT += produit.getPrixHTParQuantite();
        }
        return prixTotalHT;
    }

    public void ajouterProduit(LigneFacture produit) {
        ligneProduits.add(produit);
    }

    public void supprimerProduit(LigneFacture produit) {
        ligneProduits.remove(produit);
    }

    public void afficheListe() {
        for (LigneFacture produit : ligneProduits) {
            produit.afficherLigneFacture();

            System.out.println("\n");
        }
        System.out.println("prix total HT :" + calculerPrixTotalHT());
        System.out.println("prix total TTC :" + calculerPrixTotalTTC());

    }

    public int getNbLigneProduits() {
        int compteur = 0;
        for (LigneFacture ligneproduit : ligneProduits) {
            compteur++;
        }
        return compteur;

    }

    public int getNbProduitTotal() {
        int produitTotal = 0;
        for (LigneFacture ligneProduit : ligneProduits) {
            produitTotal += ligneProduit.getQuantiteProduit();
        }
        return produitTotal;
    }

}

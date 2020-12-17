package sio;

import org.junit.jupiter.api.Test;

import jdk.internal.jline.internal.TestAccessible;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
class FactureTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testAjouterProduits() {

        // ARRANGE
        Catego_Produit tva = new Catego_Produit("alimentaire", 10);
        int prixHT = 100;
        Produit p = new Produit("1", "produit", prixHT, tva);
        LigneFacture produit = new LigneFacture(p, 9);

        // ACTS
        int res = (int) produit.getPrixTTCParQuantite();

        // ASSERT
        assertEquals(12, res, "devrait renvoyer un nombre de produit superieur a 9");

    }

    @Test
    void testPrix_total_TTC_PourTousLesProduits() {

        // ARRANGE
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

        // ACTS
        int res = facture.calculerPrixTotal();

        // ASSERT
        assertEquals(660, res, "Devrait renvoyer le prix Total TTC");

    }
}
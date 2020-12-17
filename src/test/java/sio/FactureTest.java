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
        int res = facture.calculerPrixTotalTTC();

        // ASSERT
        assertEquals(660, res, "Devrait renvoyer le prix Total TTC");

    }

    @Test
    void testPrixTotalHTapresUneSuppresisonDuProduit() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 10);
        Catego_Produit tva2 = new Catego_Produit("electronique", 10);
        Catego_Produit tva3 = new Catego_Produit("fourniture", 10);
        int prixHT = 100;
        int prixHT2 = 2;
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
        facture.supprimerProduit(produit);

        // acts

        int res = facture.calculerPrixTotalHT();

        // assert

        assertEquals(102, res, "erreur");
    }

    @Test
    void testSupprimerProduitNombreDeLigneProduit() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 10);
        Catego_Produit tva2 = new Catego_Produit("electronique", 10);
        Catego_Produit tva3 = new Catego_Produit("fourniture", 10);
        int prixHT = 100;
        int prixHT2 = 2;
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

        // acts

        facture.supprimerProduit(produit);
        int res = facture.getNbLigneProduits();

        // assert

        assertEquals(2, res, "erreur");
    }

    @Test
    void testSupprimerProduitNombreProduitsTotal() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 10);
        Catego_Produit tva2 = new Catego_Produit("electronique", 10);
        Catego_Produit tva3 = new Catego_Produit("fourniture", 10);
        int prixHT = 100;
        int prixHT2 = 2;
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

        // acts

        facture.supprimerProduit(produit);
        int res = facture.getNbProduitTotal();

        // assert

        assertEquals(3, res, "erreur");
    }

    @Test
    void testSupprimerProduitAvecZeroProduitAuDepart() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 10);
        Catego_Produit tva2 = new Catego_Produit("electronique", 10);
        Catego_Produit tva3 = new Catego_Produit("fourniture", 10);
        int prixHT = 100;
        int prixHT2 = 2;
        int prixHT3 = 50;
        Produit p = new Produit("1", "produit", prixHT, tva);
        Produit p2 = new Produit("2", "produit2", prixHT2, tva2);
        Produit p3 = new Produit("3", "produit3", prixHT3, tva3);
        LigneFacture produit = new LigneFacture(p, 3);
        LigneFacture produit2 = new LigneFacture(p2, 1);
        LigneFacture produit3 = new LigneFacture(p3, 2);
        Facture facture = new Facture(1, LocalDate.now());
        facture.ajouterProduit(produit);

        // acts

        int res = facture.getNbProduitTotal();

        // assert

        assertEquals(3, res, "erreur");
    }

    @Test
    void testPrixTotauxHTAvecZeroProduit() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 10);
        Catego_Produit tva2 = new Catego_Produit("electronique", 10);
        Catego_Produit tva3 = new Catego_Produit("fourniture", 10);
        int prixHT = 100;
        int prixHT2 = 2;
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
        facture.supprimerProduit(produit);
        facture.supprimerProduit(produit2);
        facture.supprimerProduit(produit3);

        // acts

        int res = facture.calculerPrixTotalHT();

        // assert

        assertEquals(0, res, "erreur");
    }

    @Test
    void testPrixTotauxTTCAvecZeroProduit() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 10);
        Catego_Produit tva2 = new Catego_Produit("electronique", 10);
        Catego_Produit tva3 = new Catego_Produit("fourniture", 10);
        int prixHT = 100;
        int prixHT2 = 2;
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
        facture.supprimerProduit(produit);
        facture.supprimerProduit(produit2);
        facture.supprimerProduit(produit3);
        // acts

        int res = facture.calculerPrixTotalTTC();

        // assert

        assertEquals(0, res, "erreur");
    }

    @Test
    void testAjouterProduit() {
        // average
        Catego_Produit tva = new Catego_Produit("alimentation", 10);
        Catego_Produit tva2 = new Catego_Produit("electronique", 10);
        Catego_Produit tva3 = new Catego_Produit("fourniture", 10);
        int prixHT = 100;
        int prixHT2 = 2;
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

        // acts

        int res = facture.getNbProduitTotal();

        // assert

        assertEquals(6, res, "erreur");
    }
}

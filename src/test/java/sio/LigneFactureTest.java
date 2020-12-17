package sio;

import org.junit.jupiter.api.Test;

import jdk.internal.jline.internal.TestAccessible;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class LigneFactureTest {
    /**
     * Rigorous Test.
     */
    @Test

    void testApp() {
        assertEquals(1, 1);
    }

    @Test

    void testPrix_total_TTC_PourUnProduitParQuantite() {

        // ARRANGE
        Catego_Produit tva = new Catego_Produit("alimentaire", 10);
        int prixHT = 100;
        Produit p = new Produit("1", "produit", prixHT, tva);
        LigneFacture produit = new LigneFacture(p, 5);

        // ACTS
        int res = (int) produit.getPrixTTCParQuantite();

        // ASSERT
        assertEquals(550, res, "Devrait renvoyer le prix Toute Taxe Comprise d'une ligne de produit par sa quantité");

    }

}

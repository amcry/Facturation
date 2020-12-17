package sio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class ProduitTest {

    @Test
    void testPrixPrixTTCAvecTva() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 20);
        int prixHT = 100;
        Produit p = new Produit("1", "produit", prixHT, tva);

        // acts

        int res = (int) p.getPrixTTC();

        // assert

        assertEquals(120, res, "oh non");
    }

    @Test
    void testPrixPrixTTCSansTva() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 0);
        int prixHT = 100;
        Produit p = new Produit("1", "produit", prixHT, tva);

        // acts

        int res = (int) p.getPrixTTC();

        // assert

        assertEquals(100, res, "on est pas bon");
    }

    @Test
    void testPrixPrixHT() {
        // average

        Catego_Produit tva = new Catego_Produit("alimentation", 20);
        int prixHT = 100;
        Produit p = new Produit("1", "produit", prixHT, tva);

        // acts

        int res = (int) p.getPrixHT();

        // assert

        assertEquals(100, res, "on est pas bon du tout");
    }
}

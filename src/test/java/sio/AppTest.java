package sio;

import org.junit.jupiter.api.Test;

import jdk.internal.jline.internal.TestAccessible;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test

    void testApp() {
        assertEquals(1, 1);
    }

    @Test

    void produitSansTVA_getPrixTTC_renvoiePrixHT() {

        // ARRANGE
        Catego_Produit tva = new Catego_Produit("alimentaire", 10);
        int prixHT = 100;
        Produit p = new Produit("1", "produit", prixHT,tva );

        // ACTS
        double res = p.getPrixTTC();

        // ASSERT
        assertEquals(110, res, "Devrait renvoyer le prix Hors Taxe");

    }
}

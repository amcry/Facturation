package sio;

public class Produit {

    private String codeProduit;
    private String nomProduit;
    private int prixHT;
    private Catego_Produit type;

    public Produit(String codeProduit, String nomProduit, int prixHT, Catego_Produit type) {
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.prixHT = prixHT;
        this.type = type;
    }

    public int getPrixTTC() {
        double tva = type.getTVA();
        double prixTTC = prixHT + (prixHT * (tva / 100));
        return (int) prixTTC;
    }

    public int getPrixHT() {
        return prixHT;
    }

    public void afficherProduit() {
        type.afficherCatego();
        System.out.println("nom du produit :" + nomProduit);
        System.out.println("prix HT :" + prixHT);
    }
}

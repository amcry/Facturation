package sio;

public class Catego_Produit {

    private double tva;
    private String nomCategorie;

    public Catego_Produit(String nomCategorie, double tva) {
        this.tva = tva;
        this.nomCategorie = nomCategorie;
    }

    public double getTVA() {
        return tva;
    }

    public void afficherCatego() {
        System.out.println("categorie :" + nomCategorie);
    }
}

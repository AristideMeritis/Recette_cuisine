package cook.organization;

import java.util.UUID;

public class Ingredient
{

    private UUID id;
    private String nom;
    private int quantite;

    public Ingredient( String nom, int quantite)
    {
        this.id = UUID.randomUUID();
        this.nom =  nom;
        this.quantite = quantite;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getID(){
        return this.id.toString();
    }


}

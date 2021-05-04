package domain.model;

public class Product {
    private String naam, voornaam, productnaam;
    private double prijs;

    public Product(){
    }

    public Product(String naam, String voornaam, String productnaam, double prijs) {
        setNaam(naam);
        setVoornaam(voornaam);
        setProductnaam(productnaam);
        setPrijs(prijs);
    }

    public boolean heeftPrijsEnProductnaam(String productnaam, double prijs) {
        return productnaam.equals(this.productnaam) && prijs == this.prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isBlank()) throw new IllegalArgumentException("Vul een naam in");
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if (voornaam == null || voornaam.isBlank()) throw new IllegalArgumentException("Vul een voornaam in");
        this.voornaam = voornaam;
    }

    public String getProductnaam() {
        return productnaam;
    }

    public void setProductnaam(String productnaam) {
        if (productnaam == null || productnaam.isBlank()) throw new IllegalArgumentException("Vul een productnaam in");
        this.productnaam = productnaam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        if (prijs <= 0) throw new IllegalArgumentException("Prijs moet groter dan 0 zijn");
        this.prijs = prijs;
    }

    public String toString() {
        return getNaam() + " " + getVoornaam() + " " + getProductnaam() + " " + getPrijs() + " euro";
    }
}

package domain.model;

public class Product {
    private String naam, voornaam, productnaam;
    private double prijs;

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
        if (naam.isBlank()) throw new IllegalArgumentException();
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if (voornaam.isBlank()) throw new IllegalArgumentException();
        this.voornaam = voornaam;
    }

    public String getProductnaam() {
        return productnaam;
    }

    public void setProductnaam(String productnaam) {
        if (productnaam.isBlank()) throw new IllegalArgumentException();
        this.productnaam = productnaam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        if (prijs < 0) throw new IllegalArgumentException();
        this.prijs = prijs;
    }

    public String toString(String naam, String voornaam, String productnaam, double prijs) {
        return getNaam() + " " + getVoornaam() + " " + getProductnaam() + " " + getPrijs() + " euro";
    }
}

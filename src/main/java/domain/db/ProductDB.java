package domain.db;

import domain.model.Product;

import java.util.ArrayList;

public class ProductDB {
    ArrayList<Product> producten;

    public ProductDB() {
        producten = new ArrayList<>();
        /*Product product1 = new Product("Mensaert", "Jarno", "muis", 14.00);
        Product product2 = new Product("Mensaert", "Mathias", "toetsenbord", 45.00);*/
    }

    public void voegToe(Product product) {
        for (Product p : producten) {
            if (p.getProductnaam().equalsIgnoreCase(product.getProductnaam())) throw new IllegalArgumentException("Er mogen geen 2 producten met dezelfde naam verkocht worden");
        }
        producten.add(product);
    }

    public ArrayList<Product> getProducten() {
        if (producten.size() == 0) return null;
        return this.producten;
    }

    public void verwijder(String naam, String voornaam, String productnaam, double prijs) {
        for (int i = 0; i != producten.size(); i++) {
            if (producten.get(i).getNaam().equals(naam) && producten.get(i).getVoornaam().equals(voornaam) && producten.get(i).getProductnaam().equals(productnaam) && producten.get(i).getPrijs() == prijs) {
                producten.remove(i);
                break;
            }
        }
    }

    public Product vindProduct (String naam, String voornaam, String productnaam, double prijs) {
        for (Product product : producten) {
            if (product.getNaam().equals(naam) && product.getVoornaam().equals(voornaam) && product.getProductnaam().equals(productnaam) && product.getPrijs() == prijs) {
                return product;
            }
        }
        return null;
    }

    public Product vindProduct (Product product) {
        for (Product p : producten) {
            if (product.getNaam().equals(p.getNaam()) && product.getVoornaam().equals(p.getVoornaam()) && product.getProductnaam().equals(p.getProductnaam()) && product.getPrijs() == p.getPrijs()) {
                return product;
            }
        }
        return null;
    }

}

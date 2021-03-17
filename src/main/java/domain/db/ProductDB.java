package domain.db;

import domain.model.Product;

import java.util.ArrayList;

public class ProductDB {
    ArrayList<Product> producten;

    public ProductDB() {
        producten = new ArrayList<>();
        Product product1 = new Product("Mensaert", "Jarno", "muis", 14.00);
        Product product2 = new Product("Mensaert", "Mathias", "toetsenbord", 45.00);
    }

    public void voegToe(Product product) {
        producten.add(product);
    }

    public ArrayList<Product> getProducten() {
        return this.producten;
    }

    public void verwijder(String naam, String voornaam, String productnaam) {
        for (int i = 0; i != producten.size(); i++) {
            if (producten.get(i).getNaam().equals(naam) && producten.get(i).getVoornaam().equals(voornaam) && producten.get(i).getProductnaam().equals(productnaam)) {
                producten.remove(i);
                break;
            }
        }
    }

    public Product vindProduct (String productnaam, double prijs) {
        for (Product product : producten) {
            if (product.heeftPrijsEnProductnaam(productnaam,prijs)) {
                return product;
            }
        }
        return null;
    }

}

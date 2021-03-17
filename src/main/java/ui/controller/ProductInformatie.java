package ui.controller;

import domain.db.ProductDB;
import domain.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProductInformatie")
public class ProductInformatie extends HttpServlet {
    private ProductDB db = new ProductDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = "";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination;
        switch (command) {
            case "home" :
                destination = home(request, response);
                break;
            case "overzicht" :
                destination = overzicht(request, response);
                break;
            case "voegToe" :
                destination = voegToe(request, response);
                break;
            case "verwijder" :
                destination = verwijder(request, response);
                break;
            case "zoekProduct" :
                destination = zoekProduct(request, response);
                break;
            default :
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("producten", db.getProducten());
        return "productOverzicht.jsp";
    }

    private String voegToe(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");
        String voornaam = request.getParameter("voornaam");
        String productnaam = request.getParameter("productnaam");
        String prijsString = request.getParameter("prijs");

        if (naam != null && voornaam != null && productnaam != null) {
            double prijs = Double.parseDouble(prijsString);
            Product product = new Product(naam, voornaam, productnaam, prijs);
            db.voegToe(product);
            return overzicht(request, response);
        }
        else {
            return "productForm.jsp";
        }
    }

    private String verwijder(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");
        String voornaam = request.getParameter("voornaam");
        String productnaam = request.getParameter("productnaam");

        db.verwijder(naam, voornaam, productnaam);
        return overzicht(request, response);
    }

    private String zoekProduct(HttpServletRequest request, HttpServletResponse response) {
        String productnaam = request.getParameter("productnaam");
        String prijsString = request.getParameter("prijs");

        if (productnaam == null || prijsString == null) {
            return "nietGevonden.jsp";
        }
        else {
            double prijs = Double.parseDouble(prijsString);
            Product product = db.vindProduct(productnaam, prijs);
            if (product == null) {
                return "nietGevonden.jsp";
            }
            else {
                request.setAttribute("product", product);
                return "gevonden.jsp";
            }
        }
    }
}

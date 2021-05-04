package ui.controller;

import domain.db.ProductDB;
import domain.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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
            case "verwijderBevestiging" :
                destination = verwijderBevestiging(request, response);
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
        ArrayList<String> errors = new ArrayList<String>();

        Product product = new Product();
        setNaam(product, request, errors);
        setVoornaam(product, request, errors);
        setProductnaam(product, request, errors);
        setPrijs(product, request, errors);

        if (errors.size() == 0) {
            try {
                db.voegToe(product);
                return overzicht(request, response);
            }
            catch (IllegalArgumentException exc) {
                request.setAttribute("error", exc.getMessage());
                return "productForm.jsp";
            }
        }
        else {
            request.setAttribute("errors", errors);
            return "productForm.jsp";
        }

        /*if (naam != null && voornaam != null && productnaam != null) {
            double prijs = Double.parseDouble(prijsString);
            Product product = new Product(naam, voornaam, productnaam, prijs);
            db.voegToe(product);
            return overzicht(request, response);
        }
        else {
            return "productForm.jsp";
        }*/
    }

    private String verwijder(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");
        String voornaam = request.getParameter("voornaam");
        String productnaam = request.getParameter("productnaam");
        String prijsString = request.getParameter("prijs");
        double prijs = Double.parseDouble(prijsString);

        request.setAttribute("naam", naam);
        request.setAttribute("voornaam", voornaam);
        request.setAttribute("productnaam", productnaam);
        request.setAttribute("prijs", prijs);
        return "verwijderBevestiging.jsp";
    }

    private String verwijderBevestiging(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");
        String voornaam = request.getParameter("voornaam");
        String productnaam = request.getParameter("productnaam");
        String prijsString = request.getParameter("prijs");
        double prijs = Double.parseDouble(prijsString);
        if (request.getParameter("bevestiging") == null) {
            return overzicht(request, response);
        }
        else {
            db.verwijder(naam, voornaam, productnaam, prijs);
            return overzicht(request, response);
        }
    }

    private String zoekProduct(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();

        Product product = new Product();
        setNaam(product, request, errors);
        setVoornaam(product, request, errors);
        setProductnaam(product, request, errors);
        setPrijs(product, request, errors);

        if (errors.size() == 0) {
            try {
                if (db.vindProduct(product) != null) {
                    return "gevonden.jsp";
                }
                else {
                    return "nietGevonden.jsp";
                }
            }
            catch (IllegalArgumentException exc) {
                request.setAttribute("error", exc.getMessage());
                return "zoekForm.jsp";
            }
        }
        else {
            request.setAttribute("errors", errors);
            return "zoekForm.jsp";
        }

        /*String naam = request.getParameter("naam");
        String voornaam = request.getParameter("voornaam");
        String productnaam = request.getParameter("productnaam");
        String prijsString = request.getParameter("prijs");

        if (productnaam == null || prijsString == null || naam == null || voornaam == null) {
            return "nietGevonden.jsp";
        }
        else {
            double prijs = Double.parseDouble(prijsString);
            Product product = db.vindProduct(naam, voornaam, productnaam, prijs);
            if (product == null) {
                return "nietGevonden.jsp";
            }
            else {
                request.setAttribute("naam", naam);
                request.setAttribute("voornaam", voornaam);
                request.setAttribute("productnaam", productnaam);
                request.setAttribute("prijs", prijs);
                return "gevonden.jsp";
            }
        }*/
    }

    public void setNaam(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String naam = request.getParameter("naam");
        try {
            product.setNaam(naam);
            request.setAttribute("naamClass", "has-succes");
            request.setAttribute("naamPreviousValue", naam);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("naamClass", "has-error");
        }
    }

    public void setVoornaam(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String voornaam = request.getParameter("voornaam");
        try {
            product.setVoornaam(voornaam);
            request.setAttribute("voornaamClass", "has-succes");
            request.setAttribute("voornaamPreviousValue", voornaam);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("voornaamClass", "has-error");
        }
    }

    public void setProductnaam(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String productnaam = request.getParameter("productnaam");
        try {
            product.setProductnaam(productnaam);
            request.setAttribute("productnaamClass", "has-succes");
            request.setAttribute("productnaamPreviousValue", productnaam);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("productnaamClass", "has-error");
        }
    }

    private void setPrijs(Product product, HttpServletRequest request, ArrayList<String> errors) {
        double prijs;
        if(request.getParameter("prijs").isBlank()){
            prijs = -1;
        }else{
            prijs = Double.parseDouble(request.getParameter("prijs"));
        }
        try {
            product.setPrijs(prijs);
            request.setAttribute("prijsClass", "has-success");
            request.setAttribute("prijsPreviousValue", prijs);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("prijsClass", "has-error");
        }
    }
}

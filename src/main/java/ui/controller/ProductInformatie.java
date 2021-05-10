package ui.controller;

import domain.db.ProductDB;
import domain.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
            case "showEnglish" :
                destination = switchLanguage(request, response, "EN");
                break;
                // We vinden de case showEnglish en gaan naar de methode switchLanguage en geven request, response en language mee
            case "showNederlands" :
                destination = switchLanguage(request, response, "NL");
                break;
            case "zoek" :
                destination = zoek(request, response);
                break;
            case "verkoop" :
                destination = verkoop(request, response);
                break;
            case "logboek" :
                destination = makeListLogboek(request, response);
                break;
            case "logboekOverzicht" :
                destination = logboekOverzicht(request, response);
                break;
            case "update" :
                destination = update(request, response);
                break;
            case "updateKeuze" :
                destination = updateKeuze(request, response);
                break;
            case "updateGegevens" :
                destination = updateGegevens(request, response);
                break;
            default :
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookieWithKey(request, "language");
        // In de variable cookie, komt de cookie die we zoeken met gegeven request object en key (language)
        if (cookie == null || cookie.getValue().equals("NL")) {
            // Als de waarde van de gevonden cookie leeg is of gelijk is aan NL, dan gaan we naar de nederlandse index.jsp
            // De waarde van de cookie kan null zijn als de persoon nog niet van taal heeft verandert, dan wordt er niet beroep gedaan op de switchLanguage methode
            if (db.getProducten() == null || db.getProducten().size() == 0) {
                request.setAttribute("gemiddelde", null);
            }
            else {
                request.setAttribute("gemiddelde", gemiddeldePrijs(db.getProducten()));
            }
            return "index.jsp";
        } else {
            if (db.getProducten() == null || db.getProducten().size() == 0) {
                request.setAttribute("gemiddelde", null);
            }
            else {
                request.setAttribute("gemiddelde", gemiddeldePrijs(db.getProducten()));
            }
            return "indexEN.jsp";
        }
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("producten", db.getProducten());
        Cookie cookie = getCookieWithKey(request, "language");
        // Zelfde uitleg als in home methode
        if (cookie == null || cookie.getValue().equals("NL")) {
            return "productOverzicht.jsp";
        } else {
            return "productOverzichtEN.jsp";
        }
    }

    private String verkoop(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookieWithKey(request, "language");
        // Zelfde uitleg als in home methode
        if (cookie == null || cookie.getValue().equals("NL")) {
            return "productForm.jsp";
        } else {
            return "productFormEN.jsp";
        }
    }

    private String voegToe(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();

        Cookie cookie = getCookieWithKey(request, "language");
        // Als de value van de cookie NL is, gaan we de setter methodes gebruiken die de error berichten in het nederlands geven
        if (cookie == null || cookie.getValue().equals("NL")) {
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
        }
        else {
            // Als de value van de cookie EN is, gaan we de setter methodes gebruiken die de error berichten in het engels geven
            Product product = new Product();
            setNaamEN(product, request, errors);
            setVoornaamEN(product, request, errors);
            setProductnaamEN(product, request, errors);
            setPrijsEN(product, request, errors);
            if (errors.size() == 0) {
                try {
                    db.voegToe(product);
                    return overzicht(request, response);
                }
                catch (IllegalArgumentException exc) {
                    request.setAttribute("error", exc.getMessage());
                    return "productFormEN.jsp";
                }
            }
            else {
                request.setAttribute("errors", errors);
                return "productFormEN.jsp";
            }
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
        Cookie cookie = getCookieWithKey(request, "language");
        // Zelfde uitleg als in home methode
        if (cookie == null || cookie.getValue().equals("NL")) {
            return "verwijderBevestiging.jsp";
        } else {
            return "verwijderBevestigingEN.jsp";
        }
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

    private String zoek(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookieWithKey(request, "language");
        // Zelfde uitleg als in home methode
        if (cookie == null || cookie.getValue().equals("NL")) {
            return "zoekForm.jsp";
        } else {
            return "zoekFormEN.jsp";
        }
    }

    private String zoekProduct(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();

        Cookie cookie = getCookieWithKey(request, "language");
        // Als de value van de cookie NL is, gaan we de setter methodes gebruiken die de error berichten in het nederlands geven
        if (cookie == null || cookie.getValue().equals("NL")) {
            Product product = new Product();
            setNaam(product, request, errors);
            setVoornaam(product, request, errors);
            setProductnaam(product, request, errors);
            setPrijs(product, request, errors);
            if (errors.size() == 0) {
                try {
                    if (db.vindProduct(product) != null) {
                        HttpSession session = request.getSession();
                        ArrayList<String> productenLogboek = (ArrayList<String>) session.getAttribute("productnamen");
                        if (productenLogboek == null) {
                            return "gevonden.jsp";
                        }
                        productenLogboek.add(product.getProductnaam());
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
        }
        else {
            // Als de value van de cookie EN is, gaan we de setter methodes gebruiken die de error berichten in het engels geven
            Product product = new Product();
            setNaamEN(product, request, errors);
            setVoornaamEN(product, request, errors);
            setProductnaamEN(product, request, errors);
            setPrijsEN(product, request, errors);
            if (errors.size() == 0) {
                try {
                    if (db.vindProduct(product) != null) {
                        HttpSession session = request.getSession();
                        ArrayList<String> productenLogboek = (ArrayList<String>) session.getAttribute("productnamen");
                        if (productenLogboek == null) {
                            return "gevondenEN.jsp";
                        }
                        productenLogboek.add(product.getProductnaam());
                        return "gevondenEN.jsp";
                    }
                    else {
                        return "nietGevondenEN.jsp";
                    }
                }
                catch (IllegalArgumentException exc) {
                    request.setAttribute("error", exc.getMessage());
                    return "zoekFormEN.jsp";
                }
            }
            else {
                request.setAttribute("errors", errors);
                return "zoekFormEN.jsp";
            }
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

    public String switchLanguage(HttpServletRequest request, HttpServletResponse response, String language) {
        String destination;

        Cookie c = new Cookie("language", language);
        // We maken een cookie aan met naam language en waarde language die we in de case hebben doorgegeven
        response.addCookie(c);
        // We voegen de cookie die we net gemaakt hebben aan de HTTP-header

        if (language == null || language.equals("NL")) {
            // Als de language NL is, dan gaan we naar de nederlandse index.jsp
            request.setAttribute("requestCookie", "NL");
            destination = "index.jsp";
        } else {
            // Als de language EN is, dan gaan we naar de engelse indexEN.jsp
            request.setAttribute("requestCookie", "EN");
            destination = "indexEN.jsp";
        }
        return destination;
    }

    private String makeListLogboek(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookieWithKey(request, "language");
        // Zelfde uitleg als in home methode
        if (cookie == null || cookie.getValue().equals("NL")) {
            if (request.getParameter("bevestiging") == null) {
                return home(request, response);
            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute("productnamen", new ArrayList<String>());
                return home(request, response);
            }
        }
        else {
            if (request.getParameter("bevestiging") == null) {
                return home(request, response);
            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute("productnamen", new ArrayList<String>());
                return home(request, response);
            }
        }
    }

    private String logboekOverzicht(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookieWithKey(request, "language");
        // Zelfde uitleg als in home methode
        if (cookie == null || cookie.getValue().equals("NL")) {
            return "logboek.jsp";
        } else {
            return "logboekEN.jsp";
        }
    }

    public void voegToe(Product product, HttpServletRequest request, ArrayList<String> errors) {
        try {
            db.voegToe(product);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("productClass", "has-error");
        }
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        String productnaam = request.getParameter("productnaam");
        Product product = null;
        for (Product p : db.getProducten()) {
            if (p.getProductnaam().equalsIgnoreCase(productnaam)) {
                product = p;
            }
        }
        Cookie cookie = getCookieWithKey(request, "language");
        if (cookie == null || cookie.getValue().equals("NL")) {
            request.setAttribute("product", product);
            return "updateKeuze.jsp";
        }
        else {
            request.setAttribute("product", product);
            return "updateKeuzeEN.jsp";
        }
    }

    public String updateKeuze(HttpServletRequest request, HttpServletResponse response) {
        /*String productnaam = request.getParameter("productnaam");
        Product product = db.vindProduct(productnaam);
        String naam = request.getParameter("naam");
        String voornaam = request.getParameter("voornaam");
        String prijsString = request.getParameter("prijs");
        double prijs = Double.parseDouble(prijsString);
        request.setAttribute("naam", naam);
        request.setAttribute("voornaam", voornaam);
        request.setAttribute("prijs", prijs);*/
        Cookie cookie = getCookieWithKey(request, "language");
        // Als de value van de cookie NL is, gaan we de nederlandse versie van de pagina laten zien
        if (cookie == null || cookie.getValue().equals("NL")) {
            return "updateGegevens.jsp";
        }
        else {
            return "updateGegevensEN.jsp";
        }
    }

    public String updateGegevens(HttpServletRequest request, HttpServletResponse response) {
        String productnaam = request.getParameter("productnaam");
        String nieuweNaam = request.getParameter("naam");
        String nieuweVoornaam = request.getParameter("voornaam");
        String nieuwePrijsString = request.getParameter("prijs");
        double nieuwePrijs = 0;
        ArrayList<String> errors = new ArrayList<String>();
        if (nieuwePrijsString != null) {
            nieuwePrijs = Double.parseDouble(nieuwePrijsString);
        }
        Product product = db.vindProduct(productnaam);
        Cookie cookie = getCookieWithKey(request, "language");
        // Als de value van de cookie NL is, gaan we de setter methodes gebruiken die de error berichten in het nederlands geven
        if (cookie == null || cookie.getValue().equals("NL")) {
            if (nieuweNaam != null) {
                setNaam(product, request, errors);
            }
            if (nieuweVoornaam != null) {
                setVoornaam(product, request, errors);
            }
            if (nieuwePrijs > 0) {
                setPrijs(product, request, errors);
            }
            if (errors.size() == 0) {
                return overzicht(request, response);
            }
            else {
                request.setAttribute("errors", errors);
                return "updateGegevens.jsp";
            }
        }
        else {
            // Als de value van de cookie EN is, gaan we de setter methodes gebruiken die de error berichten in het engels geven
            if (nieuweNaam != null) {
                setNaamEN(product, request, errors);
            }
            if (nieuweVoornaam != null) {
                setVoornaamEN(product, request, errors);
            }
            if (nieuwePrijs > 0) {
                setPrijsEN(product, request, errors);
            }
            if (errors.size() == 0) {
                return overzicht(request, response);
            }
            else {
                request.setAttribute("errors", errors);
                return "updateGegevensEN.jsp";
            }
        }
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

    public void setNaamEN(Product product, HttpServletRequest request, ArrayList<String> errors) {
        // Methode die error berichten van NL naar EN vertaalt
        String naam = request.getParameter("naam");
        try {
            product.setNaam(naam);
            request.setAttribute("naamClass", "has-succes");
            request.setAttribute("naamPreviousValue", naam);
        }
        catch (IllegalArgumentException exc) {
            if (exc.getMessage().equals("Vul een naam in")) {
                errors.add("Put in a last name");
            }
            request.setAttribute("naamClass", "has-error");
        }
    }

    public void setVoornaamEN(Product product, HttpServletRequest request, ArrayList<String> errors) {
        // Methode die error berichten van NL naar EN vertaalt
        String voornaam = request.getParameter("voornaam");
        try {
            product.setVoornaam(voornaam);
            request.setAttribute("voornaamClass", "has-succes");
            request.setAttribute("voornaamPreviousValue", voornaam);
        }
        catch (IllegalArgumentException exc) {
            if (exc.getMessage().equals("Vul een voornaam in")) {
                errors.add("Put in a first name");
            }
            request.setAttribute("voornaamClass", "has-error");
        }
    }

    public void setProductnaamEN(Product product, HttpServletRequest request, ArrayList<String> errors) {
        // Methode die error berichten van NL naar EN vertaalt
        String productnaam = request.getParameter("productnaam");
        try {
            product.setProductnaam(productnaam);
            request.setAttribute("productnaamClass", "has-succes");
            request.setAttribute("productnaamPreviousValue", productnaam);
        }
        catch (IllegalArgumentException exc) {
            if (exc.getMessage().equals("Vul een productnaam in")) {
                errors.add("Put in a product name");
            }
            request.setAttribute("productnaamClass", "has-error");
        }
    }

    private void setPrijsEN(Product product, HttpServletRequest request, ArrayList<String> errors) {
        // Methode die error berichten van NL naar EN vertaalt
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
            if (exc.getMessage().equals("Prijs moet groter dan 0 zijn")) {
                errors.add("Price needs to be greater than 0");
            }
            request.setAttribute("prijsClass", "has-error");
        }
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        // We gaan de cookie uit de request header halen
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            // Als er geen cookie is returnen we null
            return null;
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(key))
                // Als de naam van de cookie gelijk is aan de key, dan returnen we de cookie die we zochten
                return cookie;
        }
        return null;
    }

    private double gemiddeldePrijs(ArrayList<Product> producten) {
        int aantal = producten.size();
        int totaal = 0;
        for (Product p : producten) {
            totaal += p.getPrijs();
        }
        return totaal / aantal;
    }
}

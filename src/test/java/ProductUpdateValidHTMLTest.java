import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductUpdateValidHTMLTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/Mensaert_Jarno/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mensa\\Documents\\School\\Web2\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test_Als_naam_persoon_van_product_wordt_vervangen_Dan_toont_overzicht_met_aangepaste_naam() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        driver.findElement(By.id("update")).click();
        driver.findElement(By.id("naam")).sendKeys("Steegmans");
        driver.findElement(By.id("voornaam")).sendKeys("Jarno");
        driver.findElement(By.id("prijs")).sendKeys("14.00");
        driver.findElement(By.id("updateProduct")).click();
        assertEquals("Overzicht producten", driver.getTitle());
        assertEquals("Producten te koop", driver.findElement(By.id("overzichttekoop")).getText());
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Steegmans"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Jarno"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "muis"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "14.0"));
        driver.findElement(By.id("verwijder")).click();
        driver.findElement(By.id("zeker")).click();
    }

    @Test
    public void test_Als_naam_persoon_van_product_wordt_niet_vervangen_en_error_bericht_wordt_gegeven() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        driver.findElement(By.id("update")).click();
        driver.findElement(By.id("naam")).sendKeys("Steegmans");
        driver.findElement(By.id("voornaam")).sendKeys("");
        driver.findElement(By.id("prijs")).sendKeys("14.00");
        driver.findElement(By.id("updateProduct")).click();
        assertEquals("Vul een voornaam in", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        driver.get(url + "ProductInformatie?command=overzicht");
        driver.findElement(By.id("verwijder")).click();
        driver.findElement(By.id("zeker")).click();
    }

    @Test
    public void test_Gevonden_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/gevonden.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_GevondenEN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/gevondenEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Index_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/index.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_IndexEN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/indexEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Logboek_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/logboek.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Logboek_EN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/logboekEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Niet_gevonden_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/nietGevonden.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Niet_gevondenEN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/nietGevondenEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_ProductForm_EN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/productFormEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_ProductOverzicht_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/productOverzicht.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_ProductOverzicht_EN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/productOverzichtEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Update_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/update.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Update_EN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/updateEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Verwijder_Bevestiging_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/verwijderBevestiging.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_VerwijderBevestiging_EN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/verwijderBevestigingEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Zoek_Form_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/zoekForm.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void test_Zoek_Form_EN_pagina_in_validator_Geeft_true() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Mensaert_Jarno%20archive/zoekFormEN.jsp");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector("#validate-by-uri > form > p.submit_button > a"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    private void voegProductToe(String naam, String voornaam, String productnaam, double prijs) {
        driver.findElement(By.id("naam")).sendKeys(naam);
        driver.findElement(By.id("voornaam")).sendKeys(voornaam);
        driver.findElement(By.id("productnaam")).sendKeys(productnaam);
        driver.findElement(By.id("prijs")).sendKeys(prijs + "");
        driver.findElement(By.id("bewaar")).click();
    }

    private boolean paginaBevatTdMetText(List<WebElement> tds, String tekst) {
        for (WebElement td : tds) {
            if (td.getText().equals(tekst)) {
                return true;
            }
        }
        return false;
    }
}

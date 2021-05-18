import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductVoegToeTest {
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
    public void test_ProductForm_alles_invullen_gaat_naar_overzicht_en_toont_nieuw_product() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        assertEquals("Overzicht producten", driver.getTitle());
        assertEquals("Producten te koop", driver.findElement(By.id("overzichttekoop")).getText());
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Mensaert"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Jarno"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "muis"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "14.0"));
    }

    @Test
    public void test_Als_leeg_product_wordt_toegevoegd_Dan_terug_naar_productForm() {
        driver.get(url + "productForm.jsp");
        voegProductToe("","","", 0);
        assertEquals("Gamingproduct toevoegen", driver.getTitle());
    }

    @Test
    public void test_Alle_velden_ingevuld_correct_behalve_naam_returned_foutmelding_en_laat_juiste_values_bij_toevoeging() {
        driver.get(url + "productForm.jsp");
        voegProductToe("","Jarno", "muis", 14.00);
        assertEquals("Gamingproduct toevoegen", driver.getTitle());
        assertEquals("Vul een naam in", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        assertEquals("Jarno", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("muis", driver.findElement(By.id("productnaam")).getAttribute("value"));
        assertEquals("14.0", driver.findElement(By.id("prijs")).getAttribute("value"));
    }

    @Test
    public void test_Alle_velden_ingevuld_correct_behalve_voornaam_returned_foutmelding_en_laat_juiste_values_bij_toevoeging() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","", "muis", 14.00);
        assertEquals("Gamingproduct toevoegen", driver.getTitle());
        assertEquals("Vul een voornaam in", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        assertEquals("Mensaert", driver.findElement(By.id("naam")).getAttribute("value"));
        assertEquals("muis", driver.findElement(By.id("productnaam")).getAttribute("value"));
        assertEquals("14.0", driver.findElement(By.id("prijs")).getAttribute("value"));
    }

    @Test
    public void test_Alle_velden_ingevuld_correct_behalve_productnaam_returned_foutmelding_en_laat_juiste_values_bij_toevoeging() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "", 14.00);
        assertEquals("Gamingproduct toevoegen", driver.getTitle());
        assertEquals("Vul een productnaam in", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        assertEquals("Jarno", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("Mensaert", driver.findElement(By.id("naam")).getAttribute("value"));
        assertEquals("14.0", driver.findElement(By.id("prijs")).getAttribute("value"));
    }

    @Test
    public void test_Alle_velden_ingevuld_correct_behalve_prijs_returned_foutmelding_en_laat_juiste_values_bij_toevoeging() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 0);
        assertEquals("Gamingproduct toevoegen", driver.getTitle());
        assertEquals("Prijs moet groter dan 0 zijn", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        assertEquals("Jarno", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("Mensaert", driver.findElement(By.id("naam")).getAttribute("value"));
        assertEquals("muis", driver.findElement(By.id("productnaam")).getAttribute("value"));
    }

    @Test
    public void test_Alle_velden_maar_al_bestaand_object_geeft_error() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        assertEquals("Er mogen geen 2 producten met dezelfde productnaam verkocht worden", driver.findElement(By.xpath("/html/body/main/li")).getText());
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

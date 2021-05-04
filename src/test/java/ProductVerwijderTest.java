import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductVerwijderTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/mensaert_jarno_war/";

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
    public void test_Verwijder_product_met_op_toch_niet_te_clicken_verwijdert_product_niet_en_gaat_terug_naar_overzicht() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        driver.findElement(By.id("verwijder")).click();
        driver.findElement(By.id("tochniet")).click();
        assertEquals("Overzicht producten", driver.getTitle());
        assertEquals("Producten te koop", driver.findElement(By.id("overzichttekoop")).getText());
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Mensaert"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Jarno"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "muis"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "14.0"));
    }

    @Test
    public void test_Verwijder_product_met_op_zeker_te_clicken_verwijdert_produc_en_gaat_terug_naar_overzicht() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        driver.findElement(By.id("verwijder")).click();
        driver.findElement(By.id("zeker")).click();
        assertEquals("Overzicht producten", driver.getTitle());
        assertEquals("Producten te koop", driver.findElement(By.id("overzichttekoop")).getText());
        assertFalse(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Mensaert"));
        assertFalse(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Jarno"));
        assertFalse(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "muis"));
        assertFalse(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "14.0"));
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

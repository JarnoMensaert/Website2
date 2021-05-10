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

public class ProductUpdateTest {
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
    public void test_Als_naam_persoon_van_product_wordt_vervangen_Dan_toont_overzicht_met_aangepaste_naam() {
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        driver.findElement(By.id("update")).click();
        driver.findElement(By.id("naam")).click();
        driver.findElement(By.id("bevestig")).click();
        driver.findElement(By.id("naam")).sendKeys("Steegmans");
        driver.findElement(By.id("verander")).click();
        assertEquals("Overzicht producten", driver.getTitle());
        assertEquals("Producten te koop", driver.findElement(By.id("overzichttekoop")).getText());
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Steegmans"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Jarno"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "muis"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "14.0"));
    }

    // NOG TEST VOOR ALS FAALT, MAAR EERST SERVER VALIDATIE BIJ FALEN VAN UPDATE OPLOSSEN

    // HOE HTML VALIDATIE TEST MAKEN, WANT MIJN JSTL IS ALTIJD FOUT

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

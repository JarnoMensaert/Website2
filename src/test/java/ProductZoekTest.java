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

public class ProductZoekTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/mensaert_jarno_war/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mensa\\Documents\\School\\Web2\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test_Vind_product_gegeven_correcte_informatie() {
        driver.get(url + "zoekForm.jsp");
        driver.findElement(By.id("naam")).sendKeys("Mensaert");
        driver.findElement(By.id("voornaam")).sendKeys("Jarno");
        driver.findElement(By.id("productnaam")).sendKeys("muis");
        driver.findElement(By.id("prijs")).sendKeys("14.0");
        driver.findElement(By.id("zoek")).click();
        assertEquals("Gevonden!", driver.findElement(By.id("gevonden")).getText());
    }

    private void voegProductToe(String naam, String voornaam, String productnaam, double prijs) {
        driver.findElement(By.id("naam")).sendKeys(naam);
        driver.findElement(By.id("voornaam")).sendKeys(voornaam);
        driver.findElement(By.id("productnaam")).sendKeys(productnaam);
        driver.findElement(By.id("prijs")).sendKeys(prijs + "");
        driver.findElement(By.id("bewaar")).click();
    }
}

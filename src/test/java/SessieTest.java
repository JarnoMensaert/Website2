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

public class SessieTest {
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
    public void test_index_aangeduid_als_actual() {
        driver.get(url + "ProductInformatie?command=home");
        WebElement link = driver.findElement(By.id("actual"));
        assertEquals("HOME", link.getText());
    }

    @Test
    public void test_zoekForm_aangeduid_als_actual() {
        driver.get(url+"ProductInformatie?command=zoek");
        WebElement link = driver.findElement(By.id("actual"));
        assertEquals("ZOEK EEN PRODUCT", link.getText());
    }

    @Test
    public void test_Opgezochte_product_wordt_toegevoegd_aan_logboek_Als_gebruiker_logboek_heeft_toegestaan() {
        driver.get(url + "ProductInformatie?command=home");
        driver.findElement(By.id("jalogboek")).click();
        driver.get(url + "productForm.jsp");
        voegProductToe("Mensaert","Jarno", "muis", 14.00);
        driver.get(url + "ProductInformatie?command=zoek");
        driver.findElement(By.id("naam")).sendKeys("Mensaert");
        driver.findElement(By.id("voornaam")).sendKeys("Jarno");
        driver.findElement(By.id("productnaam")).sendKeys("muis");
        driver.findElement(By.id("prijs")).sendKeys("14.00");
        driver.findElement(By.id("zoek")).click();
        driver.get(url + "ProductInformatie?command=logboekOverzicht");
        assertEquals("muis", driver.findElement(By.xpath("/html/body/main/div/table/tbody/tr[2]/td")).getText() );
    }

    // TEST VOOR 2DE BROWSER DIE SESSIE VAN EERSTE NIET GEBRUIKT

    private void voegProductToe(String naam, String voornaam, String productnaam, double prijs) {
        driver.findElement(By.id("naam")).sendKeys(naam);
        driver.findElement(By.id("voornaam")).sendKeys(voornaam);
        driver.findElement(By.id("productnaam")).sendKeys(productnaam);
        driver.findElement(By.id("prijs")).sendKeys(prijs + "");
        driver.findElement(By.id("bewaar")).click();
    }

    private boolean containsWebElementWithText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                return true;
            }
        }
        return false;
    }
}

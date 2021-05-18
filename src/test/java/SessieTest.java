import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessieTest {
    private WebDriver driver, driver1;
    private String url = "http://localhost:8080/Mensaert_Jarno/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mensa\\Documents\\School\\Web2\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver1 = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        driver1.quit();
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
    public void test_Opgezochte_product_wordt_toegevoegd_aan_logboek() {
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
        driver1.get(url + "ProductInformatie?command=logboekOverzicht");
        assertEquals("Je hebt nog geen producten opgezocht die succesvol waren.", driver1.findElement(By.xpath("/html/body/main/p")).getText());
    }

    private void voegProductToe(String naam, String voornaam, String productnaam, double prijs) {
        driver.findElement(By.id("naam")).sendKeys(naam);
        driver.findElement(By.id("voornaam")).sendKeys(voornaam);
        driver.findElement(By.id("productnaam")).sendKeys(productnaam);
        driver.findElement(By.id("prijs")).sendKeys(prijs + "");
        driver.findElement(By.id("bewaar")).click();
    }
}

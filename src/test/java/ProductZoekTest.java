import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductZoekTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/Mensaert_Jarno/";

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

    @Test
    public void test_Vind_product_niet_omdat_niet_in_database_zit_en_geeft_nietgevonden_pagina_terug() {
        driver.get(url + "zoekForm.jsp");
        driver.findElement(By.id("naam")).sendKeys("Mensaert");
        driver.findElement(By.id("voornaam")).sendKeys("Jarno");
        driver.findElement(By.id("productnaam")).sendKeys("toetsenbord");
        driver.findElement(By.id("prijs")).sendKeys("14.0");
        driver.findElement(By.id("zoek")).click();
        assertEquals("Niet gevonden...", driver.findElement(By.id("nietgevonden")).getText());
    }

    @Test
    public void test_Alle_velden_ingevuld_correct_behalve_naam_returned_foutmelding_en_laat_juiste_values() {
        driver.get(url + "zoekForm.jsp");
        driver.findElement(By.id("naam")).sendKeys("");
        driver.findElement(By.id("voornaam")).sendKeys("Jarno");
        driver.findElement(By.id("productnaam")).sendKeys("toetsenbord");
        driver.findElement(By.id("prijs")).sendKeys("14.0");
        driver.findElement(By.id("zoek")).click();
        assertEquals("Zoek een product", driver.findElement(By.id("zoekProduct")).getText());
        assertEquals("Vul een naam in", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        assertEquals("Jarno", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("toetsenbord", driver.findElement(By.id("productnaam")).getAttribute("value"));
        assertEquals("14.0", driver.findElement(By.id("prijs")).getAttribute("value"));
    }

    @Test
    public void test_Alle_velden_ingevuld_correct_behalve_voornaam_returned_foutmelding_en_laat_juiste_values() {
        driver.get(url + "zoekForm.jsp");
        driver.findElement(By.id("naam")).sendKeys("Mensaert");
        driver.findElement(By.id("voornaam")).sendKeys("");
        driver.findElement(By.id("productnaam")).sendKeys("toetsenbord");
        driver.findElement(By.id("prijs")).sendKeys("14.0");
        driver.findElement(By.id("zoek")).click();
        assertEquals("Zoek een product", driver.findElement(By.id("zoekProduct")).getText());
        assertEquals("Vul een voornaam in", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        assertEquals("Mensaert", driver.findElement(By.id("naam")).getAttribute("value"));
        assertEquals("toetsenbord", driver.findElement(By.id("productnaam")).getAttribute("value"));
        assertEquals("14.0", driver.findElement(By.id("prijs")).getAttribute("value"));
    }

    @Test
    public void test_Alle_velden_ingevuld_correct_behalve_productnaam_returned_foutmelding_en_laat_juiste_values() {
        driver.get(url + "zoekForm.jsp");
        driver.findElement(By.id("naam")).sendKeys("Mensaert");
        driver.findElement(By.id("voornaam")).sendKeys("Jarno");
        driver.findElement(By.id("productnaam")).sendKeys("");
        driver.findElement(By.id("prijs")).sendKeys("14.0");
        driver.findElement(By.id("zoek")).click();
        assertEquals("Zoek een product", driver.findElement(By.id("zoekProduct")).getText());
        assertEquals("Vul een productnaam in", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        assertEquals("Jarno", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("Mensaert", driver.findElement(By.id("naam")).getAttribute("value"));
        assertEquals("14.0", driver.findElement(By.id("prijs")).getAttribute("value"));
    }

    @Test
    public void test_Alle_velden_ingevuld_correct_behalve_prijs_returned_foutmelding_en_laat_juiste_values() {
        driver.get(url + "zoekForm.jsp");
        driver.findElement(By.id("naam")).sendKeys("Mensaert");
        driver.findElement(By.id("voornaam")).sendKeys("Jarno");
        driver.findElement(By.id("productnaam")).sendKeys("toetsenbord");
        driver.findElement(By.id("prijs")).sendKeys("0");
        driver.findElement(By.id("zoek")).click();
        assertEquals("Zoek een product", driver.findElement(By.id("zoekProduct")).getText());
        assertEquals("Prijs moet groter dan 0 zijn", driver.findElement(By.xpath("/html/body/main/div/ul/li")).getText());
        assertEquals("Jarno", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("Mensaert", driver.findElement(By.id("naam")).getAttribute("value"));
        assertEquals("toetsenbord", driver.findElement(By.id("productnaam")).getAttribute("value"));
    }

    private void voegProductToe(String naam, String voornaam, String productnaam, double prijs) {
        driver.findElement(By.id("naam")).sendKeys(naam);
        driver.findElement(By.id("voornaam")).sendKeys(voornaam);
        driver.findElement(By.id("productnaam")).sendKeys(productnaam);
        driver.findElement(By.id("prijs")).sendKeys(prijs + "");
        driver.findElement(By.id("bewaar")).click();
    }
}

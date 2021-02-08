package rs.ac.metropolitan.se321.example1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

    @Test
    public void testUniversityNameGoogleSearch() throws Exception {

        //Registrovanje drajvera
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //Kreiranje instance
        WebDriver driver = new ChromeDriver();

        //Pozivanje GOOGLE pretrazivaca
        driver.get("https://www.google.com/");
        //Pauza od 5 sekundi radi boljeg pregleda
        Thread.sleep(5000);
        //Uzimanje search box elementa po imenu
        WebElement searchBox = driver.findElement(By.name("q"));

        //Prosledjivanje unosa za pretragu
        searchBox.sendKeys("Univerzitet Metropolitan");
        //Pauza od 3 sekunde radi lakseg pracenja stanja
        Thread.sleep(3000);
        //Prosledjivanje unosa
        searchBox.submit();
        //Pauza od 5 sekundi radi lakseg pregleda rezultata pretrage
        Thread.sleep(5000);

        //Zatvaranje browsera i zavrsavanje kreirane sesije
        driver.quit();
    }

}

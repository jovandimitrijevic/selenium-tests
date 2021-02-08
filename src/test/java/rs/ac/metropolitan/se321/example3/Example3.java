package rs.ac.metropolitan.se321.example3;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example3 {

    @Test
    public void testMetropolitanUniversityInfo() throws Exception {
        System.out.println("Starting testMetropolitanUniversityInfo");

        // Registrovanje drajvera i kreiranje instance
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Uvecanje prozora
        driver.manage().window().maximize();

        // Ocekivani url
        String url = "https://www.metropolitan.ac.rs/";
        driver.get(url);

        // Pauza od 5 sekundi radi boljeg pregleda
        Thread.sleep(5000);

        // Uzimanje naziva Univerziteta
        String title = driver.getTitle();
        // Duzina naziva Univeziteta
        int titleLength = title.length();
        System.out.println("Title of the page is: " + title);
        System.out.println("Length of the title is: " + titleLength);

        // Trenutni url
        String actualUrl = driver.getCurrentUrl();

        // Provera da li trenutni url odgovara ocekivanom
        if (actualUrl.equals(url)) {
            System.out.println("Verification successful - The correct page is opened");
            System.out.println("Actual URL: " + actualUrl);
            System.out.println("Expected URL: " + url);
        } else {
            System.out.println("Verification failed - An incorrect url is opened");
            System.out.println("Actual URL: " + actualUrl);
            System.out.println("Expected URL: " + url);
        }

        // Izvorni kod stranice Univerziteta
        String pageSource = driver.getPageSource();
        // Broj karaktera izvornog koda stranice
        int pageSourceLength = pageSource.length();
        System.out.println("Total length of the page source is " + pageSourceLength);

        System.out.println("Ending testMetropolitanUniversityInfo");

        // Kraj testa i zatvaranje browsera
        driver.quit();
    }

}

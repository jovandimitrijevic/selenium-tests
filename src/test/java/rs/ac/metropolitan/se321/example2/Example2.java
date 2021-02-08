package rs.ac.metropolitan.se321.example2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

    @Test
    public void testSuccessfulLogin() throws Exception {
        System.out.println("Starting testSuccessfulLogin:");

        // Registrovanje drajvera i kreiranje instance
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Pauza od 3 sekunde 
        sleep(3000);

        // Uvecavanje prozora
        driver.manage().window().maximize();

        //Otvaranje stranice za logovanje
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened.");

        // Pauza od 2 sekunde radi boljeg pregleda
        sleep(2000);

        // Pronalazak username polja sa forme
        WebElement username = driver.findElement(By.id("username"));

        // Username koji se prosledjuje putem forme
        username.sendKeys("tomsmith");

        //Pauza u trajanju od 1 sekunde radi realne simulacije
        sleep(1000);

        // Pronalazak password polja sa forme
        WebElement password = driver.findElement(By.name("password"));
        // Password koji se prosledjuje putem forme
        password.sendKeys("SuperSecretPassword!");
        // Pauza od 3 sekunde radi boljeg pregleda
        sleep(3000);

        // Pronalazak login dugmeta
        WebElement logInButton = driver.findElement(By.tagName("button"));
        // Prosledjivanje forme
        logInButton.click();

        // Pauza od 5 sekundi radi boljeg pregleda
        sleep(5000);

        // Ocekivani url
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        // Trenutni url
        String actualUrl = driver.getCurrentUrl().toString();
        System.out.println("Expected url: " + expectedUrl);
        System.out.println("Actual url: " + actualUrl);
        // Provera da li je trenutni url identican ocekivanom
        Assert.assertEquals(expectedUrl, actualUrl);

        // Pronalazak logout dugmeta na novoj stranici
        WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        System.out.println("Is logout button displayed? " + logOutButton.isDisplayed());
        boolean expectedResult = true;
        // Provera da li je logout dugme prisutno na novoj stranici
        Assert.assertEquals(logOutButton.isDisplayed(), expectedResult);

        // Pronalazak poruke dobrodoslice na novoj stranici
        WebElement successMessage = driver.findElement(By.xpath("//h4[@class='subheader']"));
        // Ocekivana poruka
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        System.out.println("Expected message: " + expectedMessage);

        // Dobijena poruka
        String actualMessage = successMessage.getText();
        System.out.println("Actual message: " + actualMessage);

        // Provera da li je dobijena poruka identicna onoj koju ocekujemo
        Assert.assertEquals(expectedMessage, actualMessage);

        System.out.println("Ending testSuccessfulLogin");

        // Kraj testa i zatvaranje browsera
        driver.quit();

    }

    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

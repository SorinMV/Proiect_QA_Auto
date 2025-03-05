package example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import net.sourceforge.tess4j.TesseractException;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.time.Duration;


public class TestulPatru {
    WebDriver driver;
    elementeComunePom dismiss;
    elementeComunePom search;
    elementeComunePom liniaSearch;
    captchaReader captcha;
    elementeComunePom submit;


    public static void asteapta(int n) {

        try {

            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        dismiss = new elementeComunePom(driver);
        search = new elementeComunePom(driver);
        liniaSearch = new elementeComunePom(driver);
        captcha = new captchaReader(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }


    @Test
    public void start() throws IOException, TesseractException {

            driver.get("https://www.amazon.com/");
        //captcha.cptcha();
            dismiss.dismiss();

            WebElement deals = driver.findElement(By.cssSelector("#nav-xshop>a:nth-child(2)"));
            deals.click();

            WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        assertTrue(logo.isDisplayed());
            if(logo.isDisplayed()){
                System.out.println("Logo ul este vizibil");}
            else {System.out.println("Logo ul nu este vizibil");}

            logo.click();


        String currentUrl = driver.getCurrentUrl();
        assertEquals("Testul nu a trecut! Pagina gresita","https://www.amazon.com/ref=nav_logo",currentUrl);
        asteapta(2);
        System.out.println("Test a trecut! Redirected to the homepage.");

        Actions actions = new Actions(driver);
        WebElement language = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[1]/span"));
        actions.moveToElement(language).perform();
        asteapta(2);
        WebElement esp = driver.findElement(By.xpath("//*[@id=\"nav-flyout-icp\"]/div[2]/a[2]/span/i"));
        esp.click();
        asteapta(2);

        WebElement languageS = driver.findElement(By.cssSelector("#icp-touch-link-language>span.icp-color-base"));
        assertTrue(driver.getCurrentUrl().contains("es"));
        if (languageS.getText().contains("Español")) {
            System.out.println("Limba a fost schimbata cu succes la : " + languageS.getText());
        }


        language = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[1]/span"));
        actions.moveToElement(language).perform();
        asteapta(3);
        WebElement deu = driver.findElement(By.xpath("//*[@id=\"nav-flyout-icp\"]/div[2]/a[4]/span/i"));
        deu.click();
        asteapta(2);

        languageS = driver.findElement(By.cssSelector("#icp-touch-link-language>span.icp-color-base"));
        assertTrue(driver.getCurrentUrl().contains("de"));
        if (languageS.getText().contains("Deutsch")) {
            System.out.println("Limba a fost schimbata cu succes la : " + languageS.getText());
        }


        language = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[1]/span"));
        actions.moveToElement(language).perform();
        asteapta(2);
        WebElement por = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div[18]/div[2]/a[7]/span/i"));
        por.click();
        asteapta(2);

        languageS = driver.findElement(By.cssSelector("#icp-touch-link-language>span.icp-color-base"));
        assertTrue(driver.getCurrentUrl().contains("pt"));
        if (languageS.getText().contains("Português")) {
            System.out.println("Limba a fost schimbata cu succes la : " + languageS.getText());
        }

        language = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[1]/span"));
        actions.moveToElement(language).perform();
        asteapta(2);
        WebElement kor = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div[18]/div[2]/a[6]/span/i"));
        kor.click();
        asteapta(2);
        languageS = driver.findElement(By.cssSelector("#icp-touch-link-language>span.icp-color-base"));
               assertTrue(driver.getCurrentUrl().contains("ko"));
        if (languageS.getText().contains("한국어")) {
            System.out.println("Limba a fost schimbata cu succes la : " + languageS.getText());
        }


    }
}
package example;


import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import net.sourceforge.tess4j.TesseractException;


import java.time.Duration;

import java.io.IOException;


public class TestulUnu {

    WebDriver driver;
    captchaReader captcha;
    adaugareCos adaugaInCos;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        captcha = new captchaReader(driver);
        adaugaInCos = new adaugareCos(driver);
    }

    @Test
    public void start() throws IOException, TesseractException {
        driver.get("https://www.amazon.com/");

        try {
            adaugaInCos.adugaCos();
        } catch (Exception e) {
            System.out.println("Captcha detected. Handling captcha and retrying.");
            try {
                captcha.cptcha(); // Handle captcha
                adaugaInCos.adugaCos(); // Try again
            } catch (Exception ex) {
                System.out.println("Failed to add to cart after handling captcha.");
            }
        } finally {
            if (driver != null) {
               // driver.quit();
            }

            //  adaugaInCos.adugaCos();


        }
    }
}


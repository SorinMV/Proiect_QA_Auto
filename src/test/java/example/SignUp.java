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


public class TestulCinci {
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

        Actions actions = new Actions(driver);
        WebElement elem1 = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
        actions.moveToElement(elem1).perform();
        asteapta(2);
        WebElement login = driver.findElement(By.cssSelector("#nav-flyout-ya-newCust > a"));
        login.click();
        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Harisson");
        WebElement mail = driver.findElement(By.id("ap_email"));
        mail.sendKeys("abcd@gmail.com");
        WebElement pass = driver.findElement(By.id("ap_password"));
        pass.sendKeys("123");
        WebElement pass1 = driver.findElement(By.id("ap_password_check"));
        pass1.sendKeys("123");
        WebElement next = driver.findElement(By.id("continue"));
        next.click();

        WebElement error = driver.findElement(By.xpath("//*[@id=\"auth-password-invalid-password-alert\"]/div/div"));
        if (error.getText().contains("Minimum 6 characters required"))
        {System.out.println("Eroare asteptata, prea putine caractere : " + error.getText());}
        else {System.out.println("De ce a trecut peste?!");}
        asteapta(3);

        pass1.sendKeys("4");
        next.click();

        WebElement error1 = driver.findElement(By.xpath("//*[@id=\"auth-password-mismatch-alert\"]/div/div"));

        if (error1.getText().contains("Passwords must match"))
            {System.out.println("Eroare asteptata, parola nu e identica : " + error1.getText());}
        else {System.out.println("De ce a trecut peste?!");}
        asteapta(3);

        for (int i = 0; i < 10; i++) {
            mail.sendKeys(Keys.BACK_SPACE);
        }
        next.click();

        WebElement error2 = driver.findElement(By.xpath("//*[@id=\"auth-email-invalid-claim-alert\"]/div/div"));
        if (error2.getText().contains("Wrong or Invalid email address or mobile phone number. Please correct and try again.")){
            System.out.println("Eroare asteptata, mailul nu e corect : " + error2.getText());}
        else {System.out.println("De ce a trecut peste?!");}
        asteapta(3);


        mail.sendKeys("@gmail.com");
        pass.sendKeys("456");
        pass1.sendKeys("56");
        next.click();
        WebElement error3 = driver.findElement(By.xpath("//*[@id=\"register-mase-inlineerror\"]/div/div"));
        assertEquals("e bine","There's already an account with this email. Sign in or learn more.",error3.getText());
        System.out.println("Eroare asteptata, mailul exista : " + error3.getText());

        mail = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
       // for (int i = 0; i < 10; i++) {
         //   mail.sendKeys(Keys.BACK_SPACE);
        //}

        mail.sendKeys("asdlku92378723");
        asteapta(3);
        pass = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        pass.sendKeys("123456");
        pass1 = driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]"));
        pass1.sendKeys("123456");
        next = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        next.click();

        asteapta(5);

        
        if (driver.getTitle().contains("Authentication required")){
          System.out.println("Am continuat cu succes catre a crea un cont");
        }



        }

    }

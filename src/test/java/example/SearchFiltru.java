package example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import net.sourceforge.tess4j.TesseractException;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;


public class TestulDoi {
    WebDriver driver;
    elementeComunePom dismiss;
    elementeComunePom search;
    elementeComunePom submit;
    captchaReader captcha;
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
        submit = new elementeComunePom(driver);
        captcha = new captchaReader(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    @Test
    public void start() throws IOException, TesseractException {
        try {

        driver.get("https://www.amazon.com/");


        dismiss.dismiss();
        search.search("t-shirt");
        submit.submitClick();

        WebElement men = driver.findElement(By.cssSelector("#p_n_feature_thirty-two_browse-bin\\/121075132011 > span > a > div > label > i"));
        men.click();
        WebElement marimeaL = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div/span/div/div[2]/div[4]/ul/span/span[5]/li/span/a/span/span/button"));
        marimeaL.click();
        asteapta(2);
        asteapta(3);
        WebElement selectgalben = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[2]/ul/span/span[9]/li/span/a/span/div"));
        selectgalben.click();
        asteapta(2);
        WebElement tricoul = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div[1]/span/a/div"));
        tricoul.click();

         WebElement galben = driver.findElement(By.cssSelector("#variation_color_name>div>span"));
         WebElement large = driver.findElement(By.cssSelector("#dropdown_selected_size_name>span>span>span"));

     assertTrue(galben.getText().contains("Yellow"));

        if (galben.getText().contains("Yellow")) {
            System.out.println("The text contains 'Yellow'.");
        } else {
            System.out.println("The text does not contain 'Yellow'.");
        }
        assertTrue(large.getText().contains("Large"));

        if (large.getText().contains("Large")) {
            System.out.println("Elementul selectat este L");}
        else {
            System.out.println("Elementul selectat nu constine marimea potrivita");
        }
        String pageText = driver.findElement(By.tagName("body")).getText();
        String wordToFind = "Men";

        assertTrue("The element does not contain the word: " + wordToFind, pageText.contains(wordToFind));

        System.out.println("The element contains the word: " + wordToFind);

        } catch (Exception e) {
            System.out.println("Captcha detected. Handling captcha and retrying.");
            try {
                captcha.cptcha();
                driver.get("https://www.amazon.com/");


                dismiss.dismiss();
                search.search("t-shirt");
                submit.submitClick();

                WebElement men = driver.findElement(By.cssSelector("#p_n_feature_thirty-two_browse-bin\\/121075132011 > span > a > div > label > i"));
                men.click();
                WebElement marimeaL = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div/span/div/div[2]/div[4]/ul/span/span[5]/li/span/a/span/span/button"));
                marimeaL.click();
                asteapta(2);
                asteapta(3);
                WebElement selectgalben = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[2]/ul/span/span[9]/li/span/a/span/div"));
                selectgalben.click();
                asteapta(2);
                WebElement tricoul = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div[1]/span/a/div"));
                tricoul.click();

                WebElement galben = driver.findElement(By.cssSelector("#variation_color_name>div>span"));
                WebElement large = driver.findElement(By.cssSelector("#dropdown_selected_size_name>span>span>span"));

                assertTrue(galben.getText().contains("Yellow"));

                if (galben.getText().contains("Yellow")) {
                    System.out.println("The text contains 'Yellow'.");
                } else {
                    System.out.println("The text does not contain 'Yellow'.");
                }
                assertTrue(large.getText().contains("Large"));

                if (large.getText().contains("Large")) {
                    System.out.println("Elementul selectat este L");}
                else {
                    System.out.println("Elementul selectat nu constine marimea potrivita");
                }
                String pageText = driver.findElement(By.tagName("body")).getText();
                String wordToFind = "Men";

                assertTrue("The element does not contain the word: " + wordToFind, pageText.contains(wordToFind));

                System.out.println("The element contains the word: " + wordToFind);


            } catch (Exception ex) {
                System.out.println("Failed to add to cart after handling captcha.");
            }
        }




    }

    }

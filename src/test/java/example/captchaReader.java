package example;

import com.asprise.ocr.Ocr;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class pOM2 {
    WebDriver driver;

    public pOM2(WebDriver driver) {
        this.driver = driver;
    }
    public void cptcha() throws IOException, TesseractException {

       // driver.get("https://www.amazon.com/");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\Soin\\Desktop\\Tesseraact\\Tess4J\\tessdata");
        tesseract.setLanguage("eng");

        boolean dacatrece = false;

        while (!dacatrece) {

            Ocr.setUp();
            Ocr ocr = new Ocr();
            ocr.startEngine("eng", Ocr.SPEED_SLOW);

                try {
                    WebElement poza = driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div[1]/div/div/div[1]/img"));
                    if (poza != null) {


                        String imageUrl = poza.getAttribute("src");

                        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.open()");


                        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                        driver.switchTo().window(tabs.get(1));


                        driver.get(imageUrl);
                        System.out.println(imageUrl);
                        driver.switchTo().window(tabs.get(0));


                        URL imagine2 = new URL(imageUrl);
                        InputStream inputStream = imagine2.openStream();
                        BufferedImage image = ImageIO.read(inputStream);


                        String result = tesseract.doOCR(image);
                        System.out.println("Textul : " + result);


                        WebElement scriem = driver.findElement(By.id("captchacharacters"));
                        scriem.sendKeys(result);


                        if (driver.getCurrentUrl().contains("Captcha")) {
                            System.out.println("mai incearca...");
                        } else {
                            System.out.println("gata");
                            dacatrece = true;
                        }
                    }
                }
                    catch (NoSuchElementException e){}


        }
    }



}
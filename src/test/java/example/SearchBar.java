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

import java.io.IOException;
import java.time.Duration;


public class TestulTrei {
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
        try {
            driver.get("https://www.amazon.com/");
            dismiss.dismiss();


            //  WebElement cautare = driver.findElement(By.cssSelector("#sac-suggestion-row-1-cell-1>div.s-suggestion-image-container.left"));
            // cautare.click();

            String ceCautam = "head";
            for (int i = 1; i <= ceCautam.length(); i++) {
                WebElement searchbarul = driver.findElement(By.id("twotabsearchtextbox"));
                searchbarul.clear();
                search.search(ceCautam.substring(0, i));

                liniaSearch.liniaSearch();


                asteapta(3);

                String titlu = driver.getTitle();
                assertTrue(ceCautam.substring(0, i), titlu.contains(ceCautam.substring(0, i)));
                if (titlu.contains(ceCautam.substring(0, i))) {
                    System.out.println("Ce cautam noi : " + ceCautam.substring(0,i));
                    System.out.println("Ce a cautat : " + titlu);
                    System.out.println("E bine");
                } else {
                    System.out.println("Ceva nu a mers");
                }
                driver.navigate().back();


                asteapta(2);
            }
            } catch(Exception e){
                System.out.println("Captcha detected. Handling captcha and retrying.");
                try {
                    captcha.cptcha();
                    driver.get("https://www.amazon.com/");
                    dismiss.dismiss();


                    //  WebElement cautare = driver.findElement(By.cssSelector("#sac-suggestion-row-1-cell-1>div.s-suggestion-image-container.left"));
                    // cautare.click();

                    String ceCautam = "head";
                    for (int i = 1; i <= ceCautam.length(); i++) {
                        WebElement searchbarul = driver.findElement(By.id("twotabsearchtextbox"));
                        searchbarul.clear();
                        search.search(ceCautam.substring(0, i));

                        liniaSearch.liniaSearch();


                        asteapta(3);

                        String titlu = driver.getTitle();
                        assertTrue(ceCautam.substring(0, i), titlu.contains(ceCautam.substring(0, i)));
                        if (titlu.contains(ceCautam.substring(0, i))) {
                            System.out.println("Ce cautam noi : " + ceCautam.substring(0,i));
                            System.out.println("Ce a cautat : " + titlu);
                            System.out.println("E bine");
                        } else {
                            System.out.println("Ceva nu a mers");
                        }
                        driver.navigate().back();


                        asteapta(2);}

                } catch (Exception ex) {
                    System.out.println("Failed after handling captcha.");
                }
            }

            //  String titlu = driver.getTitle();
            //  assertEquals("Cautarea e corecta", "");


        }
    }



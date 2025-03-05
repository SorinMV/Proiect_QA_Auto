package example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class pom1 {
    WebDriver driver;

    public pom1(WebDriver driver) {
        this.driver = driver;
    }
    public void adugaCos() {

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("samsung s24");



        WebElement damClick = driver.findElement(By.id("nav-search-submit-button"));
        damClick.click();

        WebElement dissmis = driver.findElement(By.cssSelector("#nav-flyout-anchor > div.a-section.glow-toaster.glow-toaster-theme-default.glow-toaster-slot-default.nav-coreFlyout.nav-flyout > div > div.glow-toaster-footer > span.a-button.a-spacing-top-base.a-button-base.glow-toaster-button.glow-toaster-button-dismiss > span > input"));
        dissmis.click();

        String title = driver.getTitle();
        assertEquals("Nu este cautarea corecta","Amazon.com : samsung s24",title);


        WebElement telefon = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/a"));
        telefon.click();

       WebElement tocart = driver.findElement(By.cssSelector("#add-to-cart-button"));
       tocart.click();
       WebElement gotocart = driver.findElement(By.cssSelector("#sw-gtc > span > a"));
        gotocart.sendKeys(Keys.RETURN);

        WebElement number = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[1]/span[1]/div/div[2]/span[2]"));
        WebElement price1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/div[1]/div/div[1]/div/span/span/span[2]"));
        WebElement price2 = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-buybox\"]/span"));
        assertEquals("nu este bine","1",number.getText());
        assertEquals("nu e bine",price1.getText(),price2.getText());

        System.out.println("numarul : " + number.getText());
        System.out.println("preturile :" + price1.getText() +"\n" + price2.getText());
        System.out.println();
        System.out.println("Testul a trecut!");
    }


}
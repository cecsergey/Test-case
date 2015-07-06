import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;


/**
 * Created by Sergey on 6/29/2015.
 */
public class login {
    private WebDriver driver;

    public static void main(String  args[]){
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://picsart.com/");

        WebElement element;
        String text;

        element = driver.findElement(By.xpath("/html/body/nav/div/div[3]/ul[2]/li/a"));
        element.click();

        //Wait until login pop-up appear
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/div/div")));

        //fill the username field
        element = driver.findElement(By.id("signin_username_input"));
        element.sendKeys("geokam373@gmail.com");

        //fill the password field
        element = driver.findElement(By.id("signin_password_input"));
        element.sendKeys("Picsart123!");

        //click on sign in button
        element = driver.findElement(By.id("sign_in_box"));
        element.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile")));



        element = driver.findElement(By.xpath("/html/body/nav/div/div[3]/ul[2]/li/a"));
        element.click();

        //wait until load geokam.picsart.com user page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[1]/div/div[3]/div[2]/div")));

        //Verify the appropriate user is logged in
        text=driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[1]/div/div[3]/div[2]/div/a")).getText();
        assertTrue("You are login to GeoKam account",text.contains("@geokam"));

        //Verify My Network page appears.
        text=driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[1]/div/div[4]/a[4]")).getText();
        assertTrue("The My network tab is exist",text.contains("My Network"));


        driver.close();
        driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase {

    By fistNameInput = By.xpath("//*[@id='form-name']");
    By lastNameInput = By.xpath("//*[@id='form-lastName']");
    By aboutInput = By.xpath("//*[@id='form-about']");
    By saveButton = By.xpath("//*[@class='btn btn-primary']");
    By addContactMenuLink = By.xpath("//ul[@class='navbar-nav mr-auto']/li[last()]");
    By fistNameField = By.xpath("//div[@id='contact-first-name']");
    By lastNameField = By.xpath("//div[@id='contact-last-name']");
    By contactDescriptionField = By.xpath("//div[@id='contact-description']");

    public void getAuth() {
        driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail']")).clear();
        driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).clear();
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@class='btn btn-info my-1 btn-block']")).click();
    }

    public void getAuth2() {
        driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail']")).clear();
        driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).clear();
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@class='btn btn-info my-1 btn-block']")).click();
    }

    @Test
    public void addNewContactTest() {
        String firsName = "Peter";
        String lastName = "Bolt";
        String about = "Peter is my friend";
        getAuth();
        driver.findElement(addContactMenuLink).click();
        driver.findElement(fistNameInput).clear();
        driver.findElement(fistNameInput).sendKeys(firsName);
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(aboutInput).clear();
        driver.findElement(aboutInput).sendKeys(about);
        driver.findElement(saveButton).click();

        Assert.assertEquals(driver.findElement(fistNameField).getText(), firsName);
        Assert.assertEquals(driver.findElement(lastNameField).getText(), lastName);
        Assert.assertEquals(driver.findElement(contactDescriptionField).getText(), about);

    }

    @Test
    public void loginTest() {
        getAuth();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='navbar-nav mr-auto']/li[last()]")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "http://phonebook.telran-edu.de:8080/contacts");
    }

}

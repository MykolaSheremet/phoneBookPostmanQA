import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PhoneBookFirstTest {
    // 1. Создать класс PhoneBookFirstTest
    // 2. Внутри класса создать before method:
    //        - инициализировать driver
    //        - развернуть окно браузера на весь экран
    //        - установить ожидания
    //        - открыть страницу авторизации приложения phonebook

    // 3. Создать after method с методом, который закрывает браузер

    // 4. Написать тест, проверяющий корректный title страницы авторизации приложения phonebook

    WebDriver driver;
    String title;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void shouldBeRightTitle() {
        title = driver.getTitle();
        Assert.assertEquals(title, "PhonebookUi", "The page contains a wrong title");
    }

    @Test
    public void searchChecking() {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("test@gmail.com");
        driver.findElement(By.className("btn")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Bakanov')]")).isDisplayed();

        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(), 'Bakanov')]")).isDisplayed());
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DemoQaPage;

public class DemoQaLoginTest extends TestBaseLogin{

    String userName = "userName";
    String password = "7453HURU";
    String actualErrorMessage;
    String expectedErrorMessage = "Invalid username or password!";

    DemoQaPage demoQaPage;

    @Test
    public void demoQaLoginTest() {
        demoQaPage = new DemoQaPage(driver);
        demoQaPage.getLogin(userName, password);
        actualErrorMessage = demoQaPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Фактический текст сообщения не соответствует ожидаемому");
    }

}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest {

    private static final String HOME_PAGE_URL = "https://www.facebook.com/";

    private static WebDriver driver;

    @BeforeAll
    public static void classSetup(){
        driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown(){
        SharedDriver.closeDriver();
    }

    @AfterEach
    public void testTearDown(){
        driver.get(HOME_PAGE_URL);
    }

    @Test
    public void homePageURLTest(){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualUrl, "URLs Don't Match!");
    }

    @Test
    public void findEmailFieldTest(){
//        WebElement element = driver.findElement(By.id("email"));
//        WebElement element = driver.findElement(By.name("email"));
//        WebElement element = driver.findElement(By.linkText("Create a Page"));
//        WebElement element = driver.findElement(By.partialLinkText("Create a"));
//        WebElement element = driver.findElement(By.cssSelector("#email"));
//        WebElement element = driver.findElement(By.className("inputtext"));
        List<WebElement> element = driver.findElements(By.className("inputtext"));
        System.out.println(element.size());
        assertNotNull(element);
    }

    @Test
    public void findElementByXpathTest(){
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid = 'royal_pass' ]"));
        assertNotNull(passwordElement);
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type = 'submit']"));
        assertNotNull(loginButtonElement);
        WebElement forgotPassElement = driver.findElement(By.xpath("//a[text() = 'Forgot password?']"));
        assertNotNull(forgotPassElement);
        WebElement createNewAccountButton = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccountButton);
    }

    @Test
    public void loginScreenTest(){
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("maximgladkov@hotmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("maximgladkov@hotmail.com", emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid = 'royal_pass' ]"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("Huambo_1988");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("Huambo_1988", passwordValue);

        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type = 'submit']"));
        assertNotNull(loginButtonElement);
        loginButtonElement.click();
    }

}

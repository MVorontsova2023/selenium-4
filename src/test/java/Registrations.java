import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class Registrations {
    ChromeDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Tmp\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");

    }

    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void successfulRegAllFields() throws  InterruptedException{
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Sidoroff");
        WebElement emailInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("John@google.com");
        WebElement phoneInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        phoneInputField.sendKeys("100");
        WebElement addressInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        addressInputField.sendKeys("London, 1-2-3");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
//        sleep(10000);
        WebElement headerSuccsess =
                driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!"
                ,headerSuccsess.getText());
        assertTrue(headerSuccsess.getText().contains("Congratulations!"));
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("registration_result"));
    }
    @Test
    public void successfulRegReqFields() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Sidoroff");
        WebElement emailInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("John@google.com");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement headerSuccsess =
                driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!"
                ,headerSuccsess.getText());
    }

    @Test
    public void withoutFirstName() {

        WebElement lastNameInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Sidoroff");
        WebElement emailInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("John@google.com");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        assertEquals("Заполните это поле.",firstNameInputField.getAttribute("validationMessage"));
    }

    @Test
    public void withoutLastName() {

        WebElement firstNameInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        firstNameInputField.sendKeys("John");
        WebElement emailInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("John@google.com");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        assertEquals("Заполните это поле.",lastNameInputField.getAttribute("validationMessage"));
    }

    @Test
    public void withoutEmail() {

        WebElement firstNameInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Sidoroff");
                WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        assertEquals("Заполните это поле.",emailInputField.getAttribute("validationMessage"));
    }

    @Test
    public void invalidedEmail() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Sidoroff");
        WebElement emailInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("Johngoogle.com");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement headerSuccsess =
                driver.findElement(By.tagName("h1"));
        assertNotEquals("Congratulations! You have successfully registered!"
                ,headerSuccsess.getText());
    }
}


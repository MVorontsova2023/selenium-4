import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTest {
    @Test
    public void googleOpen() {
        System.setProperty("webdriver.chrome.driver","D:\\Tmp\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("bicycle");
    }

}

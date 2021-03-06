import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class synhronization {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\myWork\\project assets\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

        driver.findElement(By.xpath("//a[contains(text(), 'Click to load get data via Ajax!')]")).click();
        WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(5));
        d.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'This response has been loaded via the Ajax')]")));
        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'This response has been loaded via the Ajax')]")).getText());
}

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class nestedFrames {
        public static void main(String[] args) throws InterruptedException {


            System.setProperty("webdriver.chrome.driver", "C:\\myWork\\project assets\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("https://the-internet.herokuapp.com");
            driver.findElement(By.linkText("Nested Frames")).click();

            driver.switchTo().frame("frame-top");
            driver.switchTo().frame(driver.findElement(By.xpath("//frameset[1]/frame[2]")));
            System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());




        }
}

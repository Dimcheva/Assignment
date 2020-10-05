import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class multipleWindow2 {
    public static void main(String[] args) throws  InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\myWork\\project assets\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        Set<String> allwind = driver.getWindowHandles(); // get all the open windows
        Iterator<String> itr = allwind.iterator();//set the iterator
        String currentwind = itr.next();
        String childwind = itr.next();
        driver.switchTo().window(childwind);
        String childh = driver.findElement(By.xpath("//div/h3")).getText();
        Assert.assertEquals(childh,"New Window");
        driver.switchTo().window(currentwind);
        String parenth = driver.findElement(By.xpath("//div/h3[contains(text(),'Opening a new window')]")).getText();
        Assert.assertEquals(parenth,"Opening a new window");

    }
}


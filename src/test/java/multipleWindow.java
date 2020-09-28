import javafx.stage.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class multipleWindow {

    public static void main(String[] args) throws  InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\myWork\\project assets\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://aptsys.net/contact-us");
        String partitle = driver.getTitle();
        driver.findElement(By.xpath("//img[@class='AddressMap_AddressImage__22Wef']")).click();
        Set<String> allwind = driver.getWindowHandles(); // get all the open windows
        Iterator <String> itr = allwind.iterator();//set the iterator
        String currentwind = itr.next();
        String childwind = itr.next();
        driver.switchTo().window(childwind);
        String chiltitle = driver.getTitle();
        Assert.assertEquals(chiltitle,"ул. „11-ти август“ 1 – Google Карти");
        driver.switchTo().window(currentwind);
        Assert.assertEquals(partitle,"Contact us");

    }
}

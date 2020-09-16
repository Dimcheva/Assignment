import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;


public class CheckBox {
    public static void main(String[] args) throws  InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\myWork\\project assets\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();
        //System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click(); //uncheck
        //System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
        int count =driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        Assert.assertEquals(count,3);
        System.out.println(count);
        driver.close();


    }

}
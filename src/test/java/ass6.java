import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ass6 {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\myWork\\project assets\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        WebElement myoptn = driver.findElement(By.id("checkBoxOption3"));
        myoptn.click();
        String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[3]")).getText();
        // System.out.println(driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[3]")).getText());
        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByVisibleText(opt);
        driver.findElement(By.name("enter-name")).sendKeys(opt);
        driver.findElement(By.id("alertbtn")).click();
        String alrtext = driver.switchTo().alert().getText();

        if (alrtext.contains(opt)) {
            System.out.println("Test is passed, alert is correct");
        } else {
            System.out.println("Please, check for errors");
        }


        driver.switchTo().alert().accept();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class ClearTrip {

    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver", "C:\\myWork\\project assets\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cleartrip.com/");

        driver.findElement(By.id("OneWay")).click();
        driver.findElement(By.xpath("//div[@class='span span15 datePicker'] //input[@type='text']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click(); //calendar current day

        Select adults = new Select (driver.findElement(By.id("Adults")));
        adults.selectByVisibleText("3");
        Select children = new Select (driver.findElement(By.id("Childrens")));
        children.selectByVisibleText("4");
        Select infants = new Select(driver.findElement(By.id("Infants")));
        infants.selectByVisibleText("1");

        driver.findElement(By.id("MoreOptionsLink")).click(); //click on the link more options

        Select clas = new Select(driver.findElement(By.id("Class")));
        clas.selectByVisibleText("Premium Economy");

        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Wizz");
        driver.findElement(By.cssSelector("input[id='SearchBtn']")).click();

        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());










    }
}
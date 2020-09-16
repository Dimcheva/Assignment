import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\myWork\\project assets\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();//select one way

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='JAI']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AIP']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) //way to check if element is disabled
        {
            System.out.println("it's disabled");
            Assert.assertTrue(true);
        }
        else{
            Assert.assertFalse(false);
        }

        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();//radio button
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());//verify the radio button is selected

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);

        //multi click on "+" button increase the adults
        for(int i=1;i<5;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        //static dropdown using select
        Select s = new Select (driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        s.selectByVisibleText("USD");

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }
}
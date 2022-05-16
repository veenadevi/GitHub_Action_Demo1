package learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class LT_PlayGround_RadioTest {

    public RemoteWebDriver driver;
    private String Status = "failed";

//    @BeforeMethod(alwaysRun = false)
//    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
//        String username = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
//        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");
//        ;
//        String hub = "@hub.lambdatest.com/wd/hub";
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "MacOS Catalina");
//        caps.setCapability("browserName", "Safari");
//        caps.setCapability("version", "latest");
//        caps.setCapability("build", "TestNG With Java");
//        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
//        caps.setCapability("plugin", "git-testng");
//
//        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
//        caps.setCapability("tags", Tags);
//
//        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
//
//    }

    @Test
    public void CheckBootstarpModal(){

        WebDriverManager.chromedriver().setup();




        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo");
        try{
            driver.findElement(By.cssSelector("[data-target='#myModal']")).click();
            //driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().activeElement();

            WebElement modalContainer=driver.findElement(By.cssSelector("#myModal"));
            System.out.println("modalContainer "+modalContainer.getTagName());
            System.out.println("ModelWindow visible status "+ modalContainer.isDisplayed());
           String text=  modalContainer.findElement(By.tagName("p")).getText();
            System.out.println("ModelWindow text "+text);

            System.out.println("added to check ");
            System.out.println("added to check latest ");




        }
        catch ( NoSuchElementException | ElementNotInteractableException e){
            System.out.println("Limited page");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }
}

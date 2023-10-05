import models.Helper;
import models.RealEstate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static models.Helper.driver;

public class aruodasTests {

    @Test
    public void addAdvert() {
         RealEstate r = new RealEstate ( "Vilnius", "Vilniaus m.", "Antakalnis",
                "Aido", "Houses to buy",
                "A residential house with a sauna building is for sale in a very beautiful and quiet place in Vilnius",
                "300000", "60100000", "agnejascaite@gmail.com");
        r.fill();
    }


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Helper.acceptCookies();
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://en.aruodas.lt/ideti-skelbima/?obj=10");
    }
}

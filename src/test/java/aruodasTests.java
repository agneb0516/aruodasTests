import models.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

import static models.Helper.driver;

public class aruodasTests {

    @Test
    public void addAdvert() {
         SearchRE r = new SearchRE ( "Vilnius", "Vilniau", "Baj",
                "Gustai", "Houses to buy",
                "A residential house with a sauna building is for sale in a very beautiful and quiet place in Vilnius",
                "300000", "60100000", "agnejascaite@gmail.com", "housePhoto.jpg");
        r.fill();
        r.checkboxes();
    }

    @Test
    public void addGarageAdvert(){
        Garage garage = new Garage(
                "Vilnius",
                "Vilniau",
                "Baj",
                "Gustai",
                "Spacious garage.",
                "300000",
                "60100000",
                "agnejascaite@gmail.com",
                "GaragePhoto.jpg",
                "5",
                "555555555555",
                "12",
                "Stone",
                "3");
        garage.fill();
    }

    @Test
    public void addPlotAdvert(){
        Plot plot = new Plot(
                "Vilnius",
                "Vilniau",
                "Baj",
                "Gustai",
                "Spacious area.",
                "25000",
                "60100000",
                "agnejascaite@gmail.com",
                "PlotPhoto.jpg",
                "5",
                "555555555555",
                "12",
                "Residential land");
        plot.fill();
    }

    @Test
    public void addPremisesAdvert(){
        Premises premises = new Premises(
                "Vilnius",
                "Vilniau",
                "Baj",
                "Gustai",
                "Spacious premises.",
                "50000",
                "60100000",
                "agnejascaite@gmail.com",
                "PremisesPhoto.jpg",
                "5",
                "55",
                "1258555566668888",
                "500",
                "2",
                "2020",
                "Fully equipped",
                "Office");
        premises.fill();
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

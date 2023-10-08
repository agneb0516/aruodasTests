package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RealEstate {

    public WebDriver driver;
    public String region;
    public String settlement;
    public String microdistrict;
    public String street;
    public String description;
    public String price;
    public String phone;
    public String email;

    public String photoPath;

    public RealEstate(String region, String settlement, String microdistrict, String street,
                      String description, String price, String phone,
                      String email, String photoPath) {
        this.region = region.toLowerCase();
        this.settlement = settlement.toLowerCase();
        this.microdistrict = microdistrict.toLowerCase();
        this.street = street.toLowerCase();
        this.description = description;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.photoPath = photoPath;
        this.driver = Helper.driver;
    }

    public void fill() {
        setLocation(0, region);
        setLocation(1, settlement);
        setLocation(2, microdistrict);
        setLocation(3, street);
        description();
        uploadPhoto(this.photoPath);
        price();
        phone();
        email();
//        submit();
    }

    public void setLocation(int pos, String location) {
        try {
            WebElement span = driver.findElements(By.className("input-style-dropdown")).get(pos);
            Thread.sleep(500);
            span.findElement(By.className("dropdown-input-value-title")).click();
            WebElement ul = span.findElement(By.className("dropdown-input-values-address"));
            if (ul.findElements(By.tagName("input")).isEmpty()) {
                for (WebElement li : ul.findElements(By.tagName("li"))) {
                    if (li.getText().toLowerCase().contains(location)) {
                        li.click();
                        break;
                    }
                }
            } else {
                int count = ul.findElements(By.tagName("li")).size();
                ul.findElement(By.tagName("input")).sendKeys(location);
                while (true) {
                    List<WebElement> lis = ul.findElements(By.tagName("li"));
                    if (count != lis.size()) {
                        lis.get(lis.size() - 1).click();
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void selectObjectType(String value) {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click();
        driver.findElement(By.xpath("//li[contains(text(), \"" + value + "\")]")).click();
    }

    public void description() {
        driver.findElement(By.name("notes_lt")).sendKeys(this.description);
    }

    public void uploadPhoto(String photo) {
        String imagePath = "C:\\Users\\eduard.butkevic\\Desktop\\IT\\IdeaProjects\\aruodasTests\\pictures\\" + photo;
        driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(imagePath);
    }

    public void price() {
        driver.findElement(By.id("priceField")).sendKeys(this.price);
    }

    public void phone() {
        driver.findElement(By.name("phone")).sendKeys(this.phone);
    }

    public void email() {
        driver.findElement(By.name("email")).sendKeys(this.email);
    }

    public void checkboxes() {
        driver.findElement(By.xpath("//label[@for =\"cbdont_show_in_ads\"]/span")).click();
        driver.findElement(By.xpath("//label[@for =\"cbdont_want_chat\"]/span")).click();
        driver.findElement(By.xpath("//label[@for =\"cbagree_to_rules\"]/span")).click();
    }

    public void submit() {
        driver.findElement(By.id("submitFormButton")).click();
    }
}

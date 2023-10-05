package models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RealEstate {

    public WebDriver driver;
    public String region;
    public String settlement;
    public String microdistrict;
    public String street;
    public String objectType;
    public String description;
    public String price;
    public String phone;
    public String email;

    public RealEstate (String region, String settlement, String microdistrict, String street,
                         String objectType, String description, String price, String phone,
                         String email) {
        this.region = region;
        this.settlement = settlement;
        this.microdistrict = microdistrict;
        this.street = street;
        this.objectType = objectType;
        this.description = description;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.driver = Helper.driver;
    }
    public void fill() {
        selectDropDown("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/input[2]", this.region);
        selectDropDown("//*[@id=\"district\"]/span", this.settlement);
        selectDropDown("//*[@id=\"quartalField\"]/span[1]/span[2]", this.microdistrict);
        selectDropDown("//*[@id=\"streetField\"]/span[1]/span[2]", this.street);
        selectObjectType(this.objectType);
        driver.findElement(By.name("notes_lt")).sendKeys(this.description);
        driver.findElement(By.id("priceField")).sendKeys(this.price);
        driver.findElement(By.name("phone")).sendKeys(this.phone);
        driver.findElement(By.name("email")).sendKeys(this.email);
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/span/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[24]/div/div/div/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[1]/div/div/label/span")).click();
        String photo = "housePhoto.jpg";
        uploadPhoto(photo);
//        driver.findElement(By.id("submitFormButton")).click();

    }

    public void selectDropDown(String xpath, String value)  {
        driver.findElement(By.xpath(xpath)).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(value).sendKeys(Keys.ENTER).perform();
    }

    public void selectObjectType(String value) {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click();
        driver.findElement(By.xpath("//li[contains(text(), \"" + value + "\")]")).click();

    }
    public void uploadPhoto(String photo) {
        String imagePath = "C:\\Users\\eduard.butkevic\\Desktop\\IT\\IdeaProjects\\aruodasTests\\pictures\\" + photo;
        driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(imagePath);
    }
}

package models;

import org.openqa.selenium.By;

public class Garage extends RealEstate{
    public String garageNumber;
    public String uniqueNumber;
    public String area;
    public String garageType;
    public String numberOfCars;
    public Garage(String region, String settlement, String microdistrict, String street, String description,
                  String price, String phone, String email, String  photoPath, String garageNumber,
                  String uniqueNumber, String area, String garageType, String numberOfCars) {
        super(region, settlement, microdistrict, street, description, price, phone, email, photoPath);
        this.garageNumber = garageNumber;
        this.uniqueNumber = uniqueNumber;
        this.area = area;
        this.garageType = garageType;
        this.numberOfCars = numberOfCars;
    }

    @Override
    public void fill(){
        Helper.driver.get("https://en.aruodas.lt/ideti-skelbima/?obj=13&offer_type=1");
        super.fill();
        fillNumber();
        fillUniqueNumber();
        fillArea();
        chooseType();
        chooseNumberOfCars();
        super.checkboxes();
    }

    public void fillNumber(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[8]/span[1]/input")).sendKeys(this.garageNumber);
    }

    public void fillUniqueNumber(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[12]/div[1]/input")).sendKeys(this.uniqueNumber);
    }

    public void fillArea(){
        driver.findElement(By.xpath("//*[@id=\"fieldFAreaOverAll\"]")).sendKeys(this.area);
    }

    public void chooseType(){
        driver.findElement(By.xpath("//div[@data-title = \"" + garageType + "\"]")).click();
    }

    public void chooseNumberOfCars(){
        driver.findElement(By.xpath("//div[@data-title = \"" + numberOfCars + "\"]")).click();
    }
}

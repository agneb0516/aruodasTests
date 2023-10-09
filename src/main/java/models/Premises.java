package models;

import org.openqa.selenium.By;

public class Premises extends RealEstate{
    public String houseNumber;
    public String premisesNumber;
    public String uniqueNumber;
    public String area;
    public String floor;
    public String yearBuilt;
    public String equipment;
    public String purpose;

    public Premises(String region, String settlement, String microdistrict, String street, String description,
                    String price, String phone, String email, String photoPath, String houseNumber,
                    String premisesNumber, String uniqueNumber, String area, String floor, String yearBuilt,
                    String equipment, String purpose) {
        super(region, settlement, microdistrict, street, description, price, phone, email, photoPath);
        this.houseNumber = houseNumber;
        this.premisesNumber = premisesNumber;
        this.uniqueNumber = uniqueNumber;
        this.area = area;
        this.floor = floor;
        this.yearBuilt = yearBuilt;
        this.equipment = equipment;
        this.purpose = purpose;
    }

    @Override
    public void fill(){
        Helper.driver.get("https://en.aruodas.lt/ideti-skelbima/?obj=3");
        super.fill();
        fillHouseNumber();
        fillPremisesNumber();
        fillUniqueNumber();
        fillArea();
        fillFloor();
        yearBuilt();
        chooseEquipment();
        setPurpose();
        super.checkboxes();
    }

    public void fillHouseNumber(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/input")).sendKeys(this.houseNumber);
    }

    public void fillPremisesNumber(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[8]/span[1]/input")).sendKeys(this.premisesNumber);
    }

    public void fillUniqueNumber(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[12]/div[1]/input")).sendKeys(this.uniqueNumber);
    }

    public void fillArea(){
        driver.findElement(By.xpath("//*[@id=\"fieldFAreaOverAll\"]")).sendKeys(this.area);
    }

    public void fillFloor(){
        driver.findElement(By.xpath("//*[@id=\"fieldRow_FFloor\"]/div/span[2]/input")).sendKeys(this.floor);
    }

    public void yearBuilt(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/div[1]/span[1]/span/input")).sendKeys(this.yearBuilt);
    }

    public void chooseEquipment(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/div/div[1]/div[2]")).click();
    }

    public void setPurpose(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[1]/label")).click();
    }
}

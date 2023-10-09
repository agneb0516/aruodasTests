package models;

import org.openqa.selenium.By;

public class ShortTermRent extends RealEstate{
    public String houseNumber;
    public String area;
    public String type;
    public String markdetails;
    public String numberOfRooms;
    public String beds;
    public String additionalInfo;

    public ShortTermRent(String region, String settlement, String microdistrict, String street, String description,
                         String price, String phone, String email, String photoPath, String houseNumber,
                         String area, String type, String markdetails, String numberOfRooms, String beds,
                         String additionalInfo) {
        super(region, settlement, microdistrict, street, description, price, phone, email, photoPath);
        this.houseNumber = houseNumber;
        this.area = area;
        this.type = type;
        this.markdetails = markdetails;
        this.numberOfRooms = numberOfRooms;
        this.beds = beds;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public void fill(){
        Helper.driver.get("https://en.aruodas.lt/ideti-skelbima/?obj=12");
        super.fill();
        fillHouseNumber();
        fillArea();
        chooseType();
        pushMarkDetails();
        fillNumberOfRooms();
        quantityOfBeds();
        chooseAdditionalInfo();
        super.checkboxes();
    }

    public void fillHouseNumber(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/input")).sendKeys(this.houseNumber);
    }

    public void fillArea(){
        driver.findElement(By.xpath("//*[@id=\"fieldFAreaOverAll\"]")).sendKeys(this.area);
    }

    public void chooseType (){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[12]/div/div[2]/div[2]")).click();
    }

    public void pushMarkDetails (){
        driver.findElement(By.xpath("//*[@id=\"showMoreFields\"]/span")).click();
    }

    public void fillNumberOfRooms(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[4]/div[2]")).click();
    }

    public void quantityOfBeds(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/span[1]/input")).sendKeys(this.beds);
    }

    public void chooseAdditionalInfo (){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[19]/div/div[10]/label")).click();
    }
}

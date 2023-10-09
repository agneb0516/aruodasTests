package models;

import org.openqa.selenium.By;

public class Plot extends RealEstate {

    public String houseNumber;
    public String uniqueNumber;
    public String area;
    public String purpose;

    public Plot(String region, String settlement, String microdistrict, String street, String description,
                String price, String phone, String email, String photoPath, String houseNumber,
                String uniqueNumber, String area, String purpose) {
        super(region, settlement, microdistrict, street, description, price, phone, email, photoPath);
        this.houseNumber = houseNumber;
        this.uniqueNumber = uniqueNumber;
        this.area = area;
        this.purpose = purpose;
    }

    @Override
    public void fill(){
        Helper.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        super.fill();
        fillHouseNumber();
        fillUniqueNumber();
        fillArea();
        setPurpose();
        super.checkboxes();
    }

    public void fillHouseNumber(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/input")).sendKeys(this.houseNumber);
    }

    public void fillUniqueNumber(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/div[1]/input")).sendKeys(this.uniqueNumber);
    }

    public void fillArea(){
        driver.findElement(By.xpath("//*[@id=\"fieldFAreaOverAll\"]")).sendKeys(this.area);
    }

    public void setPurpose(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/label")).click();
    }
}
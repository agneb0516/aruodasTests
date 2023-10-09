package models;

import org.openqa.selenium.By;

public class REObject extends RealEstate {
    public String objectType;

    public REObject(String region, String settlement, String microdistrict, String street, String objectType,
                    String description, String price, String phone, String email, String  photoPath) {
        super(region, settlement, microdistrict, street, description, price, phone, email, photoPath);
        this.objectType = objectType;
    }

    @Override
    public void fill(){
        Helper.driver.get("https://en.aruodas.lt/ideti-skelbima/?obj=10b");
        super.fill();
        selectObjectType(this.objectType);
    }

    public void selectObjectType(String value) {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click();
        driver.findElement(By.xpath("//li[contains(text(), \"" + value + "\")]")).click();
    }
}

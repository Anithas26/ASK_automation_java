package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Teachers_homePage {
    WebDriver driver;
    public By lnk_Home=By.xpath("//mat-list[@class='mat-list']/descendant::h5[text()='Home']");
    public By lnk_LogOut=By.xpath("//mat-list[@class='mat-list']/descendant::h5[text()='Log Out']");

    public Teachers_homePage(WebDriver driver){
        this.driver=driver;
    }

    public void clickHomeLink(){
        driver.findElement(lnk_Home).click();
    }

    public void clickLogout(){
        driver.findElement(lnk_LogOut).click();
    }
}

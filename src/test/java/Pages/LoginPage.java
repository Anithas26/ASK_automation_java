package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
   WebDriver driver;
   public By txt_email=By.xpath("//input[@formcontrolname='email']");
   public By txt_password=By.xpath("//input[@formcontrolname='password']");
   public By btn_signIn=By.xpath("//span[text()='Sign In']");
   public By btn_registerNow=By.xpath("//span[text()='Register Now']");
   public By lnk_forgotMyPassword=By.xpath("//a[text()='I forgot my password']");
   public By err_msg_invalidCredentials=By.xpath("//simple-snack-bar[contains(text(),'Authentication failed.')]");
   WebDriverWait wait;

   public LoginPage(WebDriver driver){
      this.driver=driver;
   }

   public void enterEmail(String email){
      driver.findElement(txt_email).sendKeys(email);
   }

   public void enterPassword(String password){
      driver.findElement(txt_password).sendKeys(password);
   }

   public void clickSignIn(){
      driver.findElement(btn_signIn).click();
   }

   public void waitUntilLocated(int time,By locator){
      wait=new WebDriverWait(driver,Duration.ofSeconds(time));
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }
}

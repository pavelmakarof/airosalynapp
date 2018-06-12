package ai.rosalyn.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class GeneralPage {
    WebDriver driver;

    public GeneralPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='name']")
    public WebElement supportEmailInput;

    @FindBy(xpath = ".//app-general-email/div/form/button")
    public WebElement saveSupportEmailButton;

    public WebElement getSupportEmailInput() {
        return supportEmailInput;
    }

    public WebElement getSaveSupportEmailButton() {
        return saveSupportEmailButton;
    }
}

package ai.rosalyn.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class SignUpPage {
    public WebDriver driver;

    public SignUpPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getNeworgname() {
        return neworgname;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getOrgEmail() {
        return orgEmail;
    }

    public WebElement getOrgPass() {
        return orgPass;
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getSuccessSignUpText() {
        return successSignUpText;
    }

    public String getNeworgpubl() {
        return neworgpubl;
    }

    @FindBy(xpath = "/html//input[@id='organizationName']")
    public WebElement neworgname;

    @FindBy(xpath = "/html//input[@id='name']")
    public WebElement firstName;

    @FindBy(xpath = "/html//input[@id='surname']")
    public WebElement lastName;

    @FindBy(xpath = "/html//input[@id='email']")
    public WebElement orgEmail;

    @FindBy(xpath = "/html//input[@id='password']")
    public WebElement orgPass;

    @FindBy(css = ".states-opacity.db")
    public WebElement signupButton;

    @FindBy(css = ".w4")
    public WebElement continueButton;

    @FindBy(css = ".forgot_email")
    public WebElement successSignUpText;

    public String neworgpubl;



}

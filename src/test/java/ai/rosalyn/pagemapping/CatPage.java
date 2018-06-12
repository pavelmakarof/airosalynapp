package ai.rosalyn.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

public class CatPage {
    public WebDriver driver;

    public CatPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Name("CAT title")
    @FindBy(xpath = ".//app-cat//h1[contains(text(),'Custom Scoring Scale')]")
    private WebElement catTitle;

    @Name("Counter of displayed CAT")
    @FindBy(xpath = ".//app-cat/div/app-list/div/div/div[1]/span")
    private WebElement counterOfDisplayingCats;

    @Name("New CAT button")
    @FindBy(xpath = ".//app-cat//a[contains(@href,\"/home/cat/manage\")]")
    private WebElement newCatButton;

    @Name("List Of Inactive Cats")
    @FindBy(xpath = ".//app-cat//tbody//span[contains(text(),'Inactive')]")
    private List<WebElement> listOfInactiveCats;

    @Name("CAT names of Inactive elements")
    @FindBy(xpath = ".//tbody/tr/td//span[text()='Inactive']/ancestor::*/td[1]//div/div")
    private List<WebElement> catNamesOfInactiveElements;

    @Name("Rubric names of Active elements")
    @FindBy(xpath = ".//tbody/tr/td//span[text()='Active']/ancestor::*/td[1]//div/div")
    private List<WebElement> rubricNamesOfActiveElements;

    @Name("New CAT - Name")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Enter the name of your scoring scale\")]")
    private WebElement newCatName;

    @Name("New CAT - Description")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Enter your description here..\")]")
    private WebElement newCatDescription;

    @Name("New CAT - Maximum Raw Score")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Enter maximum scores\")]")
    private WebElement newCatMaximumRawScore;

    @Name("New CAT - Add Tier Button")
    @FindBy(xpath = ".//button[text()=\"Add\"]")
    private WebElement newCatAddTierButton;

    @Name("New CAT - Scoring Tier - Name")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@formcontrolname,\"name\")]")
    private List<WebElement> newCatTierName;

    @Name("New CAT - Scoring Tier - Staring Raw Score")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Staring Raw Score\")]")
    private List<WebElement> newCatTierStaringRawScore;

    @Name("New CAT - Scoring Tier - Ending Raw Score")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Ending Raw Score\")]")
    private List<WebElement> newCatTierEndingRawScore;

    @Name("New CAT - Scoring Tier - Description")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@formcontrolname,\"description\")]")
    private List<WebElement> newCatTierDescription;

    @Name("New CAT - Scoring Tier - Checkbox Select Passing Tier")
    @FindBy(xpath = ".//label[contains(text(),\"Make this tier the passing score\")]")
    private List<WebElement> newCatTierCheckboxSelectPassingTier;

    @Name("New CAT - Show Certificate Preview")
    @FindBy(xpath = ".//button[contains(text(),\"Show Preview\")]")
    private List<WebElement> newCatShowCertificatePreview;


}

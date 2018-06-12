package ai.rosalyn.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

/**
 * Created by makarof on 14.05.2018.
 */
public class CommonThings {
    public WebDriver driver;

    public CommonThings(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Name("Loader")
    @FindBy(xpath = ".//div[@class=\"loader_holder loader__block alert-show\"]")
    private WebElement loader;

    @Name("Cancel Or No Button")
    @FindBy(xpath = ".//section//*[@id='idAlert']//a[@data-remodal-action=\"cancel\"]")
    private WebElement modalCancelButton;

    @Name("Confirm Or Yes Button")
    @FindBy(xpath = ".//section//*[@id='idAlert']//a[@data-remodal-action=\"confirm\"]")
    private WebElement modalConfirmButton;

    @Name("Delete Record Button")
    @FindBy(xpath = ".//*[@aria-label='Delete']//img")
    private WebElement deleteRecordButton;

    @Name("Edit Record Button")
    @FindBy(xpath = ".//*[@aria-label='Edit']//img")
    private WebElement editRecordButton;

    @Name("Duplicate Record Button")
    @FindBy(xpath = ".//*[@aria-label='Duplicate']//img")
    private WebElement duplicateRecordButton;

    @Name("Notification")
    @FindBy(xpath = ".//app-notifications//app-notifcation-item")
    private WebElement notification;

    @Name("Three Dots Button - multiple actions")
    @FindBy(xpath = ".//button[@class=\"btn-menu-all\"]")
    private WebElement threeDotsButton;

    @Name("Three Dots Button -> Delete Button")
    @FindBy(xpath = ".//menu-all/div/ul/li/span[text()='Delete']")
    private WebElement deleteSelectedElementsButton;

    @Name("Clear Filters Button")
    @FindBy(xpath = ".//*[@class='ng-star-inserted']//span[.='clear filters']")
    public WebElement clearFiltersButton;

    public WebElement getModalCancelButton() {
        return modalCancelButton;
    }

    public WebElement getModalConfirmButton() {
        return modalConfirmButton;
    }

    public WebElement getLoader() {
        return loader;
    }

    public WebElement getDeleteRecordButton() {
        return deleteRecordButton;
    }

    public WebElement getEditRecordButton() {
        return editRecordButton;
    }

    public WebElement getDuplicateRecordButton() {
        return duplicateRecordButton;
    }

    public WebElement getNotification() {
        return notification;
    }

    public WebElement getThreeDotsButton() {
        return threeDotsButton;
    }

    public WebElement getDeleteSelectedElementsButton() {
        return deleteSelectedElementsButton;
    }

    public WebElement getClearFiltersButton() {
        return clearFiltersButton;
    }

}

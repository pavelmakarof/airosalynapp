package ai.rosalyn.pagemapping;

import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

/**
 * Created by makarof on 23.04.2018.
 */
public class TagsPage {
    WebDriver driver;

    public TagsPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Name("Tags title")
    @FindBy(xpath = ".//manage-tags/div/div/div[1]/h1")
    public WebElement tagsTitle;

    @Name("Counter of displayed tags")
    @FindBy(xpath = ".//manage-tags/div/div/div[1]/span")
    public WebElement counterOfDisplayingTags;

    @Name("Counter of selected tags")
    @FindBy(xpath = ".//manage-tags/div/div/div[1]/span[2]")
    public WebElement counterOfSelectedTags;

    @Name("New Tag button")
    @FindBy(xpath = ".//*[@id='newTag']")
    public WebElement newTagButton;

    @Name("Select First Checkbox")
    @FindBy(xpath = ".//manage-tags/div/ng2-smart-table/table/tbody/tr[1]/td[1]/label")
    public WebElement selectFirstCheckbox;

    @Name("Select First Checkbox")
    @FindBy(xpath = ".//manage-tags/div/ng2-smart-table/table/tbody/tr[2]/td[1]/label")
    public WebElement selectSecondCheckbox;

    @Name("Select all Checkbox")
    @FindBy(xpath = ".//manage-tags//thead//label")
    public WebElement selectAllCheckbox;

    @Name("Search Field")
    @FindBy(css = ".input.ng-untouched.ng-pristine.ng-valid")
    public WebElement searchTagField;

    @Name("New Tag Name input")
    @FindBy(xpath = ".//input-editor/fieldset/input[@name='name']")
    public WebElement newTagNameInput;

    @Name("Validation message")
    @FindBy(xpath = ".//app-control-error-message/div[@class='error-color ng-star-inserted']")
    public WebElement tagNameValidationMessage;

    @Name("Cancel New Name Creation button")
    @FindBy(xpath = ".//ng2-st-actions/a/span[@aria-label='Cancel']/img")
    public WebElement cancelNewNameCreationButton;

    @Name("Apply New Name Creation button")
    @FindBy(xpath = ".//ng2-st-actions[@class='create-cancel-right']/button/span/img")
    public WebElement applyNewNameCreationButton;

    @Name("Active Update Tag Name Button")
    @FindBy(xpath = ".//ng2-st-tbody-create-cancel[@class='create-cancel-right']//button/span[@aria-label=\"Update\"]/img")
    public WebElement updateTagNameButton;

    @Name("Inactive Update Tag Name Button")
    @FindBy(xpath = ".//ng2-st-tbody-create-cancel[@class='create-cancel-right']//button/span[@aria-label=\"Update\"]/img[@src=\"assets/img/ok-inactive.svg\"]")
    public WebElement inactiveUpdateTagNameButton;

    @Name("Clear Filters Button")
    @FindBy(xpath = ".//manage-tags[@class='ng-star-inserted']//span[.='clear filters']")
    public WebElement clearFiltersButton;

    @Name("Erase search field - button cross")
    @FindBy(xpath = ".//img[@class='clear-input-img']")
    public WebElement clearInputButton;

    @Name("First Tag Record")
    @FindBy(xpath = ".//tr[1]//div[@class='ng-star-inserted']")
    public WebElement firstTagRecord;

    @Name("Delete Tag Button")
    @FindBy(xpath = ".//tbody[@class='scrollbar_cus scrollbar_cus_mh80']//span[@aria-label='Delete']/img")
    public WebElement deleteTagButton;

    @Name("Edit Tag Button")
    @FindBy(xpath = ".//tbody[@class='scrollbar_cus scrollbar_cus_mh80']//span[@aria-label='Edit']/img")
    public WebElement editTagButton;

    @Name("No Search Results On Tags Page")
    @FindBy(xpath = ".//manage-tags/div/ng2-smart-table/table/tbody/tr/td")
    public WebElement noSearchResultsOnTagsPage;

    public WebElement getTagsTitle() {
        return tagsTitle;
    }

    public WebElement getCounterOfDisplayingTags() {
        return counterOfDisplayingTags;
    }

    public WebElement getCounterOfSelectedTags() {
        return counterOfSelectedTags;
    }

    public WebElement getNewTagButton() {
        return newTagButton;
    }

    public WebElement getSelectFirstCheckbox() {
        return selectFirstCheckbox;
    }

    public WebElement getSelectSecondCheckbox() {
        return selectSecondCheckbox;
    }

    public WebElement getSelectAllCheckbox() {
        return selectAllCheckbox;
    }

    public WebElement getSearchTagField() {
        return searchTagField;
    }

    public WebElement getNewTagNameInput() {
        return newTagNameInput;
    }

    public WebElement getTagNameValidationMessage() {
        return tagNameValidationMessage;
    }

    public WebElement getCancelNewNameCreationButton() {
        return cancelNewNameCreationButton;
    }

    public WebElement getApplyNewNameCreationButton() {
        return applyNewNameCreationButton;
    }

    public WebElement getUpdateTagNameButton() {
        return updateTagNameButton;
    }

    public WebElement getInactiveUpdateTagNameButton() {
        return inactiveUpdateTagNameButton;
    }

    public WebElement getClearFiltersButton() {
        return clearFiltersButton;
    }

    public WebElement getClearInputButton() {
        return clearInputButton;
    }

    public WebElement getFirstTagRecord() {
        return firstTagRecord;
    }

    public WebElement getDeleteTagButton() {
        return deleteTagButton;
    }

    public WebElement getEditTagButton() {
        return editTagButton;
    }

    public WebElement getNoSearchResultsOnTagsPage() {
        return noSearchResultsOnTagsPage;
    }

}


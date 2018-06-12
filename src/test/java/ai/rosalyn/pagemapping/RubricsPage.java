package ai.rosalyn.pagemapping;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

public class RubricsPage {
    WebDriver driver;

    public RubricsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Name("Rubrics title")
    @FindBy(xpath = ".//rubrics/div/div/div[1]/h1")
    private WebElement rubricsTitle;

    @Name("Counter of displayed rubrics")
    @FindBy(xpath = ".//rubrics/div/div/div[1]/span")
    private WebElement counterOfDisplayingRubrics;

    @Name("Counter of selected rubrics")
    @FindBy(xpath = ".//rubrics/div/div/div[1]/span[2]")
    private WebElement counterOfSelectedRubrics;

    @Name("New Rubric button")
    @FindBy(xpath = ".//*[@id='newTag']")
    private WebElement newRubricButton;

    @Name("Select First Checkbox")
    @FindBy(xpath = ".//rubrics//tbody/tr[1]/td[1]/label")
    private WebElement selectFirstCheckbox;

    @Name("Select Second Checkbox")
    @FindBy(xpath = ".//rubrics//tbody/tr[2]/td[1]/label")
    private WebElement selectSecondCheckbox;

    @Name("Select all Checkbox")
    @FindBy(xpath = ".//rubrics//thead//label")
    private WebElement selectAllCheckbox;

    @Name("Search - Name Field")
    @FindBy(xpath = ".//thead//input[@placeholder=\"Name\"]")
    private WebElement searchRubricNameField;

    @Name("Search - Test Used In Field")
    @FindBy(xpath = ".//thead//input[@placeholder=\"Tests Used in\"]")
    private WebElement searchRubrictestsUsedInField;

    @Name("Search - Status Dropdown button")
    @FindBy(xpath = ".//thead//select-filter/div/button[@data-toggle=\"dropdown\"]")
    private WebElement searchSelectStatusDropdown;

    @Name("Active item in Status drop-down")
    @FindBy(xpath = ".//rubrics/div/ng2-smart-table/table/thead/tr/th[4]/ng2-smart-table-filter/div/select-filter/div/ul//a[text()='Active']")
    private WebElement activeInStatusDropdown;

    @Name("Inactive item in Status drop-down")
    @FindBy(xpath = ".//rubrics/div/ng2-smart-table/table/thead/tr/th[4]/ng2-smart-table-filter/div/select-filter/div/ul//a[text()='Inactive']")
    private WebElement inActiveInStatusDropdown;

    @Name("Status item in Status drop-down")
    @FindBy(xpath = ".//rubrics/div/ng2-smart-table/table/thead/tr/th[4]/ng2-smart-table-filter/div/select-filter/div/ul//a[text()='Status']")
    private WebElement statusItemInStatusDropdown;

    @Name("Create rubric page - title")
    @FindBy(xpath = ".//create-rubric/div/div[1]/div[1]")
    public WebElement createRubricPageTitle;

    @Name("Create rubric page - number of possible points")
    @FindBy(xpath = ".//create-rubric/div/div[1]/div[2]/span[1]")
    public WebElement createRubricPageNumberPossiblePoints;

    @Name("Create rubric page - Cancel Button")
    @FindBy(xpath = ".//create-rubric/div/div[1]/div[3]/div[1]/button")
    public WebElement createRubricPageCancelButton;

    @Name("Create rubric page - Save Button")
    @FindBy(xpath = ".//create-rubric/div/div[1]/div[3]/div[2]/button")
    public WebElement createRubricPageSaveButton;

    @Name("Create rubric page - Rubric Name Input")
    @FindBy(xpath = ".//create-rubric/div/div[2]/fieldset/input[@name=\"name\"]")
    public WebElement createRubricPageRubricNameInput;

    @Name("Create rubric page - Validation Message - Empty name")
    @FindBy(xpath = ".//app-control-error-message/div")
    public WebElement createRubricPageValidationMessageEmptyName;

    @Name("Create rubric page - Validation Message - Empty Table Fields")
    @FindBy(xpath = ".//create-rubric/div/div[2]/div/div/div/div[2]")
    public WebElement createRubricPageValidationMessageEmptyTableFields;

    @Name("Create rubric page - Add Level Button")
    @FindBy(xpath = ".//app-rubric-matrix//div[text()=\"+ Add Level\"]")
    public WebElement createRubricPageAddLevelButton;

    @Name("Create rubric page - Add Criteria Button")
    @FindBy(xpath = ".//app-rubric-matrix//div[text()=\"+ Add Criteria\"]")
    public WebElement createRubricPageAddCriteriaButton;

    @Name("Create rubric page - Levels And Criterias Description")
    @FindBy(xpath = ".//input[@formcontrolname=\"description\"]")
    public List<WebElement> createRubricPagelevelAndCriteriaDescriptions;

    @Name("Create rubric page - Level 1 Description")
    @FindBy(xpath = ".//app-rubric-matrix//div[2]//div[2]/div/div[1]//div/fieldset")
    public WebElement createRubricPageLevelOneDescription;

    @Name("Create rubric page - Level 2 Description")
    @FindBy(xpath = ".//app-rubric-matrix//div[3]//div[2]/div/div[1]//div/fieldset")
    public WebElement createRubricPageLevelTwoDescription;

    @Name("Create rubric page - Level 3 Description")
    @FindBy(xpath = ".//app-rubric-matrix//div[4]//div[2]/div/div[1]//div/fieldset")
    public WebElement createRubricPageLevelThreeDescription;

    @Name("Create rubric page - Level 4 Description")
    @FindBy(xpath = ".//app-rubric-matrix//div[5]//div[2]/div/div[1]//div/fieldset")
    public WebElement createRubricPageLevelFourDescription;

    @Name("Create rubric page - Level 5 Description")
    @FindBy(xpath = ".//app-rubric-matrix//div[6]//div[2]/div/div[1]//div/fieldset")
    public WebElement createRubricPageLevelFiveDescription;

    @Name("Create rubric page - Levels ponts")
    @FindBy(xpath = ".//input[@formcontrolname=\"points\"]")
    public List<WebElement> createRubricPageLevelPoints;

    @Name("Create rubric page - Level 1 Points")
    @FindBy(xpath = ".//app-rubric-matrix//div[2]//div[2]/div/div[1]//div/fieldset/input")
    public WebElement createRubricPageLevelOnePoints;

    @Name("Create rubric page - Level 2 Points")
    @FindBy(xpath = ".//app-rubric-matrix//div[3]//div[2]/div/div[2]//div/fieldset")
    public WebElement createRubricPageLevelTwoPoints;

    @Name("Create rubric page - Level 3 Points")
    @FindBy(xpath = ".//app-rubric-matrix//div[4]//div[2]/div/div[2]//div/fieldset")
    public WebElement createRubricPageLevelThreePoints;

    @Name("Create rubric page - Level 4 Points")
    @FindBy(xpath = ".//app-rubric-matrix//div[5]//div[2]/div/div[2]//div/fieldset")
    public WebElement createRubricPageLevelFourPoints;

    @Name("Create rubric page - Level 5 Points")
    @FindBy(xpath = ".//app-rubric-matrix//div[6]//div[2]/div/div[2]//div/fieldset")
    public WebElement createRubricPageLevelFivePoints;

    @Name("Create rubric page - Criteria 1 Description")
    @FindBy(xpath = ".//create-rubric//app-rubric-matrix//div[2]/div[2]//app-header-row-cell//div[2]/div/div/div")
    public WebElement createRubricPageCriteriaOneDescription;

    @Name("Create rubric page - Criteria 2 Description")
    @FindBy(xpath = ".//create-rubric//app-rubric-matrix//div[2]/div[3]//app-header-row-cell//div[2]/div/div/div")
    public WebElement createRubricPageCriteriaTwoDescription;

    @Name("Create rubric page - Criteria 3 Description")
    @FindBy(xpath = ".//create-rubric//app-rubric-matrix//div[2]/div[4]//app-header-row-cell//div[2]/div/div/div")
    public WebElement createRubricPageCriteriaThreeDescription;

    @Name("Create rubric page - Criteria 4 Description")
    @FindBy(xpath = ".//create-rubric//app-rubric-matrix//div[2]/div[5]//app-header-row-cell//div[2]/div/div/div")
    public WebElement createRubricPageCriteriaFourDescription;

    @Name("Create rubric page - Criteria 5 Description")
    @FindBy(xpath = ".//create-rubric//app-rubric-matrix//div[2]/div[6]//app-header-row-cell//div[2]/div/div/div")
    public WebElement createRubricPageCriteriaFiveDescription;

    @Name("Create rubric page - Rubric Descriptions")
    @FindBy(xpath = ".//textarea[@formcontrolname='description']")
    private List<WebElement> createRubricPageRubricDescriptions;

    @Name("View Rubric - Last description cell in rubric 10*10")
    @FindBy(xpath = ".//create-rubric//div[11]/div[11]")
    private WebElement rubricViewLastCell;

    @Name("List Of Inactive Rubrics")
    @FindBy(xpath = ".//rubrics//tbody//span[contains(text(),'Inactive')]")
    private List<WebElement> listOfInactiveRubrics;

    @Name("First Rubric Record")
    @FindBy(xpath = ".//rubrics//tbody/tr[1]/td[2]//table-cell-view-mode/div")
    public WebElement firstRubricRecord;


    @Name("Rubric names of Inactive elements")
    @FindBy(xpath = ".//tbody/tr/td//span[text()='Inactive']/ancestor::*/td[2]//table-cell-view-mode/div/div")
    private List<WebElement> rubricNamesOfInactiveElements;

    @Name("Rubric names of Active elements")
    @FindBy(xpath = ".//tbody/tr/td//span[text()='Active']/ancestor::*/td[2]//table-cell-view-mode/div/div")
    private List<WebElement> rubricNamesOfActiveElements;

    @Name("Table of Rubrics")
    @FindBy(xpath = ".//rubrics/div/ng2-smart-table/table/tbody")
    private WebElement tableOfRubrics;

    @Name("Confirm Delete Operation")
    @FindBy(xpath = ".//rubrics/div/ng2-smart-table/table//tr[1]//*[@id='idAlert']/div/div/div/div[3]/div/a[2]")
    public WebElement confirmDeleteOperation;

    @Name("Cancel Delete Operation")
    @FindBy(xpath = ".//rubrics/div/ng2-smart-table/table//tr[1]//*[@id='idAlert']/div/div/div/div[3]/div/a[1]")
    public WebElement cancelDeleteOperation;


    @Name("Inactive Delete Rubric Button")
    @FindBy(xpath = ".//options-view-component/app-options/div//div/img[@src=\"assets/img/delete-inactive.png\"]")
    public WebElement inactiveDeleteRubricButton;

    @Name("Inactive Edit Rubric Button")
    @FindBy(xpath = ".//options-view-component/app-options/div//div/img[@src=\"assets/svg/edit_default.svg\"]")
    public WebElement inactiveEditRubricButton;

    public List<WebElement> getListOfDisplayedRubricNames() {
        return listOfDisplayedRubricNames;
    }

    @Name("List Of Displayed Rubric Names")
    @FindBy(xpath = ".//tbody/tr/td//ancestor::*/td[2]//table-cell-view-mode/div/div")
    private List<WebElement> listOfDisplayedRubricNames;

    @Name("Message: Oops! You cannot delete a rubric that is actively assigned")
    @FindBy(xpath = ".//*[@id='idAlert']/div/div/div/div[2]/div[1]")
    private WebElement adminCannotDeleteActiveRubric;

    @Name("Sort Button - Tests Used In")
    @FindBy(xpath = ".//rubrics/div/ng2-smart-table/table/thead/tr/th[3]/ng2-smart-table-filter/div/app-grid-sort/div/span/img\n")
    private WebElement testsUsedInSortButton;

    @Name("First Rubric - Test Used In Name")
    @FindBy(xpath = ".//rubrics//tbody/tr[1]/td[3]//rubric-table-tests/div/div/div")
    private WebElement firstRubricTestsUsedInName;



    public WebElement getTableOfRubrics() {
        return tableOfRubrics;
    }

    public List<WebElement> getRubricNamesOfInactiveElements() {
        return rubricNamesOfInactiveElements;
    }

    public List<WebElement> getRubricNamesOfActiveElements() {
        return rubricNamesOfActiveElements;
    }

    public WebElement getInactiveDeleteRubricButton() {
        return inactiveDeleteRubricButton;
    }

    public WebElement getInactiveEditRubricButton() {
        return inactiveEditRubricButton;
    }

    public WebElement getConfirmDeleteOperation() {
        return confirmDeleteOperation;
    }

    public WebElement getCancelDeleteOperation() {
        return cancelDeleteOperation;
    }

//    @Name("Validation message")
//    @FindBy(xpath = ".//app-control-error-message/div[@class='error-color ng-star-inserted']")
//    public WebElement tagNameValidationMessage;
//
//    @Name("Cancel New Name Creation button")
//    @FindBy(xpath = ".//ng2-st-actions/a/span[@aria-label='Cancel']/img")
//    public WebElement cancelNewNameCreationButton;
//
//    @Name("Apply New Name Creation button")
//    @FindBy(xpath = ".//ng2-st-actions[@class='create-cancel-right']/button/span/img")
//    public WebElement applyNewNameCreationButton;
//
//    @Name("Active Update Tag Name Button")
//    @FindBy(xpath = ".//ng2-st-tbody-create-cancel[@class='create-cancel-right']//button/span[@aria-label=\"Update\"]/img")
//    public WebElement updateTagNameButton;
//
//    @Name("Erase search field - button cross")
//    @FindBy(xpath = ".//img[@class='clear-input-img']")
//    public WebElement clearInputButton;
//
//    @Name("GLOBAL - Cancel Delete Operation")
//    @FindBy(xpath = ".//*[@id='idAlert']//a[@data-remodal-action=\"cancel\"]")
//    public WebElement cancelDeleteOperation;
//
//    @Name("GLOBAL - Confirm Delete Operation")
//    @FindBy(xpath = ".//*[@id='idAlert']//a[@data-remodal-action=\"confirm\"]")
//    public WebElement confirmDeleteOperation;
//
//    @Name("No Search Results On Rubrics Page")
//    @FindBy(xpath = ".//rubrics/div/ng2-smart-table/table/tbody/tr/td")
//    public WebElement noSearchResultsOnRubricsPage;


    public WebElement getRubricsTitle() {
        return rubricsTitle;
    }

    public WebElement getCounterOfDisplayingRubrics() {
        return counterOfDisplayingRubrics;
    }

    public WebElement getCounterOfSelectedRubrics() {
        return counterOfSelectedRubrics;
    }

    public WebElement getNewRubricButton() {
        return newRubricButton;
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

    public WebElement getSearchRubricNameField() {
        return searchRubricNameField;
    }

    public WebElement getSearchRubrictestsUsedInField() {
        return searchRubrictestsUsedInField;
    }

    public WebElement getSearchSelectStatusDropdown() {
        return searchSelectStatusDropdown;
    }

    public WebElement getActiveInStatusDropdown() {
        return activeInStatusDropdown;
    }

    public WebElement getInActiveInStatusDropdown() {
        return inActiveInStatusDropdown;
    }

    public WebElement getStatusItemInStatusDropdown() {
        return statusItemInStatusDropdown;
    }

    public WebElement getCreateRubricPageTitle() {
        return createRubricPageTitle;
    }

    public WebElement getCreateRubricPageNumberPossiblePoints() {
        return createRubricPageNumberPossiblePoints;
    }

    public WebElement getCreateRubricPageCancelButton() {
        return createRubricPageCancelButton;
    }

    public WebElement getCreateRubricPageSaveButton() {
        return createRubricPageSaveButton;
    }

    public WebElement getCreateRubricPageRubricNameInput() {
        return createRubricPageRubricNameInput;
    }

    public WebElement getCreateRubricPageValidationMessageEmptyName() {
        return createRubricPageValidationMessageEmptyName;
    }

    public WebElement getCreateRubricPageValidationMessageEmptyTableFields() {
        return createRubricPageValidationMessageEmptyTableFields;
    }

    public WebElement getFirstRubricRecord() {
        return firstRubricRecord;
    }

    public WebElement getCreateRubricPageAddLevelButton() {
        return createRubricPageAddLevelButton;
    }

    public WebElement getCreateRubricPageAddCriteriaButton() {
        return createRubricPageAddCriteriaButton;
    }

    public List<WebElement> getCreateRubricPagelevelAndCriteriaDescriptions() {
        return createRubricPagelevelAndCriteriaDescriptions;
    }

    public WebElement getCreateRubricPageLevelOneDescription() {
        return createRubricPageLevelOneDescription;
    }

    public WebElement getCreateRubricPageLevelTwoDescription() {
        return createRubricPageLevelTwoDescription;
    }

    public WebElement getCreateRubricPageLevelThreeDescription() {
        return createRubricPageLevelThreeDescription;
    }

    public WebElement getCreateRubricPageLevelFourDescription() {
        return createRubricPageLevelFourDescription;
    }

    public WebElement getCreateRubricPageLevelFiveDescription() {
        return createRubricPageLevelFiveDescription;
    }

    public List<WebElement> getCreateRubricPageLevelPoints() {
        return createRubricPageLevelPoints;
    }

    public WebElement getCreateRubricPageLevelOnePoints() {
        return createRubricPageLevelOnePoints;
    }

    public WebElement getCreateRubricPageLevelTwoPoints() {
        return createRubricPageLevelTwoPoints;
    }

    public WebElement getCreateRubricPageLevelThreePoints() {
        return createRubricPageLevelThreePoints;
    }

    public WebElement getCreateRubricPageLevelFourPoints() {
        return createRubricPageLevelFourPoints;
    }

    public WebElement getCreateRubricPageLevelFivePoints() {
        return createRubricPageLevelFivePoints;
    }

    public WebElement getCreateRubricPageCriteriaOneDescription() {
        return createRubricPageCriteriaOneDescription;
    }

    public WebElement getCreateRubricPageCriteriaTwoDescription() {
        return createRubricPageCriteriaTwoDescription;
    }

    public WebElement getCreateRubricPageCriteriaThreeDescription() {
        return createRubricPageCriteriaThreeDescription;
    }

    public WebElement getCreateRubricPageCriteriaFourDescription() {
        return createRubricPageCriteriaFourDescription;
    }

    public WebElement getCreateRubricPageCriteriaFiveDescription() {
        return createRubricPageCriteriaFiveDescription;
    }

    public List<WebElement> getCreateRubricPageRubricDescriptions() {
        return createRubricPageRubricDescriptions;
    }

    public WebElement getRubricViewLastCell() {
        return rubricViewLastCell;
    }

    public List<WebElement> getListOfInactiveRubrics() {
        return listOfInactiveRubrics;
    }

    public WebElement getAdminCannotDeleteActiveRubric() {
        return adminCannotDeleteActiveRubric;
    }

    public WebElement getTestsUsedInSortButton() {
        return testsUsedInSortButton;
    }

    public WebElement getFirstRubricTestsUsedInName() {
        return firstRubricTestsUsedInName;
    }
}


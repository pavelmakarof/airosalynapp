package ai.rosalyn.tests;

import ai.rosalyn.blocks.CommonThings;
import ai.rosalyn.pagemapping.*;
import ai.rosalyn.steps.CommonSteps;
import ai.rosalyn.utils.BasicBeforeAfter;
import ai.rosalyn.utils.TestData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static ai.rosalyn.utils.TestData.*;
import static org.hamcrest.Matchers.not;

import java.util.ArrayList;
import java.util.Collections;

import static ai.rosalyn.utils.TestData.orgName;
import static ai.rosalyn.utils.TestData.randomValueMethod;

public class RubricsTest extends BasicBeforeAfter {
    SignInPage signInPage;
    DashboardPage dashboardPage;
    OrganizationSettings organizationSettings;
    SubOrganizationPage subOrganizationPage;
    GeneralPage generalPage;
    RubricsPage rubricsPage;
    CommonThings commonThings;
    CommonSteps commonSteps;

    @Before
    public void setupClass() {
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);
        organizationSettings = new OrganizationSettings(driver);
        subOrganizationPage = new SubOrganizationPage(driver);
        generalPage = new GeneralPage(driver);
        rubricsPage = new RubricsPage(driver);
        commonSteps = new CommonSteps(driver);
        commonThings = new CommonThings(driver);
        commonSteps.goToDashboardPage(signInPage);
        commonSteps.assertEquals(orgName(), dashboardPage.orgname);
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(organizationSettings.getRubricsButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
    }


    @Test
    @DisplayName("Add New Rubric To The System")
    public void addNewRubricToTheSystem001() throws InterruptedException {
        commonSteps.click(rubricsPage.getNewRubricButton());
        commonSteps.click(rubricsPage.getCreateRubricPageSaveButton());
        commonSteps.shouldSee(rubricsPage.getCreateRubricPageValidationMessageEmptyName());
        String tempRubricName = "Rubric Name " + randomValueMethod();
        commonSteps.textInput(rubricsPage.getCreateRubricPageRubricNameInput(), tempRubricName);
        for (int i = 0; i < 9; i++) {
            commonSteps.click(rubricsPage.getCreateRubricPageAddCriteriaButton());
            commonSteps.click(rubricsPage.getCreateRubricPageAddLevelButton());
        }
        commonSteps.click(rubricsPage.getCreateRubricPageSaveButton());
        commonSteps.shouldSee(rubricsPage.getCreateRubricPageValidationMessageEmptyTableFields());
        int totalPointsForRubric = 0;
        ArrayList possiblePointsArray = new ArrayList();
        for (WebElement levelPoint : rubricsPage.getCreateRubricPageLevelPoints()) {
            int tempPoints = (int) (Math.random() * 10);
            possiblePointsArray.add(tempPoints);
            commonSteps.click(levelPoint);
            commonSteps.textInput(levelPoint, String.valueOf((int) (Math.random() * 10)));
            totalPointsForRubric = 10 * Integer.valueOf(Collections.max(possiblePointsArray).toString());
        }

        for (WebElement levelAndCriteriaDescription : rubricsPage.getCreateRubricPagelevelAndCriteriaDescriptions()) {
            commonSteps.textInput(levelAndCriteriaDescription, randomValueMethod());
        }
        commonSteps.click(rubricsPage.getCreateRubricPageSaveButton());
        commonSteps.shouldSee(rubricsPage.getCreateRubricPageValidationMessageEmptyTableFields());
        String lastCellText;
        for (WebElement description : rubricsPage.getCreateRubricPageRubricDescriptions()) {
            lastCellText = randomValueMethod();
            commonSteps.textInput(description, lastCellText);
        }
        commonSteps.click(rubricsPage.getCreateRubricPageRubricNameInput());
        commonSteps.shouldNotSee(rubricsPage.getCreateRubricPageValidationMessageEmptyTableFields());
        commonSteps.click(rubricsPage.getCreateRubricPageSaveButton());
        commonSteps.assertEquals(tempRubricName, rubricsPage.getFirstRubricRecord());
        commonSteps.click(commonThings.getNotification());
        commonSteps.assertTrue("Status of just created rubric is not inactive", "Inactive".equals(commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getListOfInactiveRubrics(), 0))));
        commonSteps.click(rubricsPage.getFirstRubricRecord());
        commonSteps.assertTrue("Total points is incorrect", totalPointsForRubric == Integer.valueOf(commonSteps.getText(rubricsPage.getCreateRubricPageNumberPossiblePoints())));
        commonSteps.shouldSee(rubricsPage.getRubricViewLastCell());
        Thread.sleep(5000);
    }

    @Test
    @DisplayName("Rubric Name Should Be Uniqueness ")
    public void rubricNameShouldBeUniqueness002() throws InterruptedException {
        String tempUsedRubricName = commonSteps.getText(rubricsPage.getFirstRubricRecord());
        commonSteps.click(rubricsPage.getNewRubricButton());
        commonSteps.textInput(rubricsPage.getCreateRubricPageRubricNameInput(), tempUsedRubricName);
        commonSteps.click(rubricsPage.getCreateRubricPageSaveButton());
        commonSteps.shouldSee(rubricsPage.getCreateRubricPageValidationMessageEmptyName());
    }

    @Test
    @DisplayName("Admin Can Edit Inactive Rubric")
    public void adminCanEditInactiveRubric003() throws InterruptedException {
        commonSteps.hover(commonSteps.getElememtFromArray(rubricsPage.getListOfInactiveRubrics(), 0));
        commonSteps.click(commonThings.getEditRecordButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
//      commonSteps.assertTrue("The edit mode was not opened", editRubricTitle().equals(rubricsPage.getCreateRubricPageTitle()));
        String tempRubricName = "Rubric Name " + randomValueMethod();
        commonSteps.textInput(rubricsPage.getCreateRubricPageRubricNameInput(), tempRubricName);
        WebElement firstLevelPoint = commonSteps.getElememtFromArray(rubricsPage.getCreateRubricPageLevelPoints(), 0);
        commonSteps.click(firstLevelPoint);
        firstLevelPoint.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        int tempPoints = 10 + (int) (Math.random()*10);
        commonSteps.textInput(firstLevelPoint, String.valueOf(tempPoints));
//        commonSteps.click(rubricsPage.getCreateRubricPageLevelOneDescription());
//        commonSteps.click(rubricsPage.getCreateRubricPageLevelOneDescription());
//        commonSteps.click(rubricsPage.getCreateRubricPageLevelOneDescription());
//        rubricsPage.getCreateRubricPageLevelOneDescription().sendKeys(Keys.CONTROL+"a");
//        commonSteps.textInput(rubricsPage.getCreateRubricPageLevelOneDescription(),"TestLevel");
//        commonSteps.click(rubricsPage.getCreateRubricPageCriteriaOneDescription());
//        commonSteps.click(rubricsPage.getCreateRubricPageCriteriaOneDescription());
//        commonSteps.textInput(rubricsPage.getCreateRubricPageCriteriaOneDescription(),"TestCriteria");
        commonSteps.click(rubricsPage.getCreateRubricPageSaveButton());
        commonSteps.textInput(rubricsPage.getSearchRubricNameField(), tempRubricName);
        commonSteps.assertTrue("Something go wrong in edit mode", tempRubricName.equals(commonSteps.getText(rubricsPage.getFirstRubricRecord())));
        commonSteps.click(rubricsPage.getFirstRubricRecord());
        commonSteps.shouldNotSee(commonThings.getLoader());
//        commonSteps.assertTrue("Field Level wasn't edit", "TestLevel".equals(commonSteps.getText(rubricsPage.getCreateRubricPageLevelOneDescription())));
//        commonSteps.assertTrue("Field Criteria wasn't edit", "TestCriteria".equals(commonSteps.getText(rubricsPage.getCreateRubricPageCriteriaOneDescription())));
        commonSteps.assertTrue("Field Points wasn't edit", String.valueOf(tempPoints).equals(commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getCreateRubricPageLevelPoints(), 0))));
//        commonSteps.assertTrue("Field total points wasn't recalculate", "120".equals(commonSteps.getText(rubricsPage.getCreateRubricPageNumberPossiblePoints())));
    }

    @Test
    @DisplayName("Admin Can Delete Inactive Rubric")
    public void adminCanDeleteInactiveRubric004() throws InterruptedException {
        String tempRubricName = commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0));
        commonSteps.hover(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0));
        commonSteps.click(commonThings.getDeleteRecordButton());
        commonSteps.click(rubricsPage.getConfirmDeleteOperation());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(rubricsPage.getSearchRubricNameField());
        commonSteps.textInput(rubricsPage.getSearchRubricNameField(), tempRubricName);
        commonSteps.shouldNotSee(rubricsPage.getFirstRubricRecord());
    }

    @Test
    @DisplayName("Admin Can Cancel Delete Inactive Rubric")
    public void adminCanCancelDeleteInactiveRubric005() throws InterruptedException {
        String tempRubricName = commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0));
        commonSteps.hover(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0));
        commonSteps.click(commonThings.getDeleteRecordButton());
        commonSteps.click(rubricsPage.getCancelDeleteOperation());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.textInput(rubricsPage.getSearchRubricNameField(), tempRubricName);
        commonSteps.assertEquals(tempRubricName, rubricsPage.getFirstRubricRecord());
    }

    @Test
    @DisplayName("Admin Can Duplicate Inactive Rubric")
    public void adminCanDuplicateInactiveRubric006() throws InterruptedException {
        String tempRubricName = commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0));
        commonSteps.hover(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0));
        commonSteps.click(commonThings.getDuplicateRecordButton());
        Thread.sleep(4000);
        commonSteps.assertEquals("Copy of " + tempRubricName + " 1", rubricsPage.getFirstRubricRecord());
    }

    @Test
    @DisplayName("Admin Can Duplicate Active Rubric")
    public void adminCanDuplicateActiveRubric007() throws InterruptedException {
        commonSteps.click(rubricsPage.getSearchSelectStatusDropdown());
        commonSteps.click(rubricsPage.getActiveInStatusDropdown());
        String tempRubricName = commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfActiveElements(), 0));
        commonSteps.hover(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfActiveElements(), 0));
        commonSteps.click(commonThings.getDuplicateRecordButton());
        Thread.sleep(2000);
        commonSteps.click(rubricsPage.getSearchSelectStatusDropdown());
        commonSteps.click(rubricsPage.getStatusItemInStatusDropdown());
        Thread.sleep(2000);
        commonSteps.assertTrue("The name of duplicated rubric is incorrect", commonSteps.getText(rubricsPage.getFirstRubricRecord()).contains("Copy of " + tempRubricName));
    }

    @Test
    @DisplayName("Admin Cannot Edit/Delete Active Rubric")
    public void adminCanNotDeleteActiveRubric008() throws InterruptedException {
        commonSteps.click(rubricsPage.getSearchSelectStatusDropdown());
        commonSteps.click(rubricsPage.getActiveInStatusDropdown());
        commonSteps.hover(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfActiveElements(), 0));
        Thread.sleep(1000);
        commonSteps.shouldSee(rubricsPage.getInactiveDeleteRubricButton());
        commonSteps.shouldSee(rubricsPage.getInactiveEditRubricButton());
    }

    @Test
    @DisplayName("Admin can select several rubrics via checkboxes left-side of the records and delete it via three-dots menu")
    public void adminCanSelectSeveralRubrics009() throws InterruptedException {
        commonSteps.click(rubricsPage.getSearchSelectStatusDropdown());
        commonSteps.click(rubricsPage.getInActiveInStatusDropdown());
        commonSteps.shouldNotSee(commonThings.getLoader());
        String tempRubricName = commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0));
        commonSteps.click(rubricsPage.getSelectFirstCheckbox());
        commonSteps.click(rubricsPage.getSelectSecondCheckbox());
        commonSteps.assertEquals("2 selected", rubricsPage.getCounterOfSelectedRubrics());
        commonSteps.click(commonThings.getThreeDotsButton());
        Thread.sleep(2000);
        commonSteps.click(commonThings.getDeleteSelectedElementsButton());
        commonSteps.click(commonThings.getModalConfirmButton());
        Thread.sleep(3000);
        commonSteps.assertFalse("The rubrics was no deleted", tempRubricName.equals(commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0))));
    }

    @Test
    @DisplayName("Admin can select several rubrics via checkboxes left-side of the records and cancel delete it via three-dots menu")
    public void adminCanSelectSeveralRubricsAndCancelDelete010() throws InterruptedException {
        commonSteps.click(rubricsPage.getSearchSelectStatusDropdown());
        commonSteps.click(rubricsPage.getInActiveInStatusDropdown());
        commonSteps.shouldNotSee(commonThings.getLoader());
        String tempRubricName = commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0));
        commonSteps.click(rubricsPage.getSelectFirstCheckbox());
        commonSteps.click(rubricsPage.getSelectSecondCheckbox());
        commonSteps.assertEquals("2 selected", rubricsPage.getCounterOfSelectedRubrics());
        commonSteps.click(commonThings.getThreeDotsButton());
        Thread.sleep(2000);
        commonSteps.click(commonThings.getDeleteSelectedElementsButton());
        commonSteps.click(commonThings.getModalCancelButton());
        Thread.sleep(3000);
        commonSteps.assertTrue("The rubrics was deleted", tempRubricName.equals(commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getRubricNamesOfInactiveElements(), 0))));
    }

    @Test
    @DisplayName("Admin can select all displayed rubrics on this page by checkbox left side search string")
    public void adminCanSelectAllRubrics011() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", commonSteps.getElememtFromArray(rubricsPage.getListOfDisplayedRubricNames(), 14));
        Thread.sleep(4000);
        jse.executeScript("scroll(0, -250);");
        commonSteps.click(rubricsPage.getSelectAllCheckbox());
        commonSteps.assertEquals("30 selected", rubricsPage.getCounterOfSelectedRubrics());
    }

    @Test
    @DisplayName("Admin Cannot Delete Active Rubrics Via Three-Dots Delete Button")
    public void adminCannotDeleteActiveRubricsViaThreeDotsDeleteButton012() throws InterruptedException {
        commonSteps.click(rubricsPage.getSearchSelectStatusDropdown());
        commonSteps.click(rubricsPage.getActiveInStatusDropdown());
        commonSteps.shouldNotSee(commonThings.getLoader());
        String tempRubricName = commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getListOfDisplayedRubricNames(), 0));
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(rubricsPage.getSelectFirstCheckbox());
        commonSteps.click(rubricsPage.getSelectSecondCheckbox());
        commonSteps.assertEquals("2 selected", rubricsPage.getCounterOfSelectedRubrics());
        commonSteps.click(commonThings.getThreeDotsButton());
        Thread.sleep(2000);
        commonSteps.click(commonThings.getDeleteSelectedElementsButton());
        commonSteps.assertEquals(youCannotDeleteRubricThatIsActivelyAssigned(), rubricsPage.getAdminCannotDeleteActiveRubric());
        commonSteps.click(commonThings.getModalCancelButton());
        Thread.sleep(3000);
        commonSteps.assertTrue("The rubrics was deleted", tempRubricName.equals(commonSteps.getText(commonSteps.getElememtFromArray(rubricsPage.getListOfDisplayedRubricNames(), 0))));
    }

    @Test
    @DisplayName("Admin Can Search By Tests Used In And Can Clear Results By Clear Filters Button")
    public void adminCanSearchByTestsUsedIn013() throws InterruptedException {
        String tempFirstRubricName = commonSteps.getText(rubricsPage.getFirstRubricRecord());
        commonSteps.click(rubricsPage.getSearchSelectStatusDropdown());
        commonSteps.click(rubricsPage.getActiveInStatusDropdown());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(rubricsPage.getTestsUsedInSortButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        String tempTestUsedInName = commonSteps.getText(rubricsPage.getFirstRubricTestsUsedInName());
        commonSteps.textInput(rubricsPage.getSearchRubrictestsUsedInField(), tempTestUsedInName);
        commonSteps.assertTrue("Sort \"Test Used In\" works incorrect", commonSteps.getText(rubricsPage.getFirstRubricTestsUsedInName()).contains(tempTestUsedInName));
        commonSteps.click(commonThings.getClearFiltersButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.assertEquals(tempFirstRubricName,rubricsPage.getFirstRubricRecord());

    }
}
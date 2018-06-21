package ai.rosalyn.tests;

import ai.rosalyn.blocks.CommonThings;
import ai.rosalyn.pagemapping.*;
import ai.rosalyn.steps.CommonSteps;
import ai.rosalyn.utils.BasicBeforeAfter;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static ai.rosalyn.utils.TestData.*;

public class CatTest extends BasicBeforeAfter {
    SignInPage signInPage;
    DashboardPage dashboardPage;
    OrganizationSettings organizationSettings;
    SubOrganizationPage subOrganizationPage;
    GeneralPage generalPage;
    CatPage catPage;
    CommonThings commonThings;
    CommonSteps commonSteps;

    @Before
    public void setupClass() throws InterruptedException {
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);
        organizationSettings = new OrganizationSettings(driver);
        subOrganizationPage = new SubOrganizationPage(driver);
        generalPage = new GeneralPage(driver);
        catPage = new CatPage(driver);
        commonSteps = new CommonSteps(driver);
        commonThings = new CommonThings(driver);
        commonSteps.goToDashboardPage(signInPage);
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.assertEquals(orgName(), dashboardPage.getOrgname());
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(organizationSettings.getCatButton());
        Thread.sleep(15000);
        commonSteps.shouldNotSee(commonThings.getLoader());
    }


    @Test
    @DisplayName("Add New CAT To The System")
    public void addNewCatToTheSystem001() throws InterruptedException {
        commonSteps.click(catPage.getNewCatButton());
        String tempCatName = "CAT Name " + randomValueMethod();
        commonSteps.textInput(catPage.getNewCatName(), tempCatName);
        String tempCatDescript = oneHundredTwentyFourSymbolsMethod();
        commonSteps.textInput(catPage.getNewCatDescription(), tempCatDescript);
        int tempMaxRawScore = (int) (Math.random() * 10)+200;
        commonSteps.textInput(catPage.getNewCatMaximumRawScore(), String.valueOf(tempMaxRawScore));
        commonSteps.click(catPage.getNewCatAddTierButton());
        String tempCatTierName = "CAT Tier Name - First Tier - Best" + randomValueMethod();
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierName(), 0), tempCatTierName);
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierStaringRawScore(), 0), String.valueOf(tempMaxRawScore-50));
        commonSteps.assertTrue("Ending RAW score in first tier is not correct", commonSteps.getAttributeValue(commonSteps.getElememtFromArray(catPage.getNewCatTierEndingRawScore(),0),"valueAsNumber").equals(String.valueOf(tempMaxRawScore)));
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierDescription(), 0), "Description of " + tempCatTierName);

    }
}

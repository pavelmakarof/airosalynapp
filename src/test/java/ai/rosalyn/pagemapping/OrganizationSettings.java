package ai.rosalyn.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

/**
 * Created by makarof on 18.04.2018.
 */
public class OrganizationSettings {
    public WebDriver driver;
    public OrganizationSettings (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css=".dib.mb2")
    public WebElement organizationSettingsTitle;

    @Name("Button \"Sub-orgs\"")
    @FindBy(xpath = ".//app-horizontal-navbar/nav/ul//a/span[text() = \"Sub-orgs\"]")
    public WebElement subOrgsButton;

    @Name("Button \"Tags\"")
    @FindBy(xpath = ".//app-horizontal-navbar/nav/ul//a/span[text() = \"Tags\"]")
    public WebElement tagsButton;

    @Name("Button \"Rubrics\"")
    @FindBy(xpath = ".//app-horizontal-navbar/nav/ul//a/span[text() = \"Rubrics\"]")
    public WebElement rubricsButton;

    public WebElement getOrganizationSettingsTitle() {
        return organizationSettingsTitle;
    }

    public WebElement getSubOrgsButton() {
        return subOrgsButton;
    }

    public WebElement getTagsButton() {
        return tagsButton;
    }

    public WebElement getRubricsButton() {
        return rubricsButton;
    }


}

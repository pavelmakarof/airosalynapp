package ai.rosalyn.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class ScoringPage {
    WebDriver driver;

    public ScoringPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".lh-title.mb2")
    private WebElement scoringPageTitle;

    public WebElement getScoringPageTitle(){return scoringPageTitle;}
}

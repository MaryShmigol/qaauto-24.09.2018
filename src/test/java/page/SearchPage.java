package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class SearchPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchBar;


    /**
     * @param webDriver
     * Method which initiate web driver in this class and initiate web elements
     */
    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @return
     * Method which test is page loaded or not
     */
    public boolean isPageLoaded() {
    return webDriver.getCurrentUrl().contains("/search/results")
                         && webDriver.getTitle().contains(" | Поиск | LinkedIn")
                         && searchBar.isDisplayed();
     }

    /**
     * @return
     * Method which search term in list
     */
    public int getSearchResultsCount() {
        return searchResultList.size();
    }
    public List<String> getSearchResults(){
        List<String> searchResultStringList = new ArrayList<String>();
        for (WebElement searchResult : searchResultList){
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", searchResult);
            String searchResultText= searchResult.getText();
            searchResultStringList.add(searchResultText);
        }
        return searchResultStringList;
    }
}












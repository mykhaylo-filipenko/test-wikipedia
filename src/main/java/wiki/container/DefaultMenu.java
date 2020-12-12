package main.java.wiki.container;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import main.java.wiki.BasePage;
import org.junit.Assert;

import java.util.List;

public class DefaultMenu extends BasePage {

    private static final String SEARCH_CONTAINER = "search_container";
    private static final String SEARCH_FILED = "search_src_text";
    private static final String FIRST_ELEMENT_IN_DROPDOWN = "fragment_feed_header";
    private static final String ARTICLE_TITLE = "view_page_title_text";
    private static final String CATEGORY_HEADER = "view_card_header_title";
    private static final String MORE_BUTTON = "view_list_card_header_menu";
    private static final String MORE_POPUP_ELEMENT = "title";
    private static final String ARTICLE_MORE_BUTTON = "view_list_card_item_menu";
    private static final String GOT_IT_BUTTON = "onboarding_button";
    private static final String OK_BUTTON = "android:id/button1";
    private static final String READING_LIST_NAME_INPUT = "text_input";
    private static final String MY_LISTS = "My lists";
    private static final String READING_LIST_TITLE = "item_title";
    private static final String READING_LIST_TITLE_MORE_BUTTON = "page_list_item_action_primary";
    private static final String REMOVE_ITEM = "reading_list_item_remove_text";
    private static final String ALL_ITEMS_WAS_REMOVED_FROM_LIST = "reading_list_empty_text";

    public DefaultMenu(AndroidDriver driver) {
        super(driver);
    }

    public void clickOnSearchContainer() {
        driver.findElementById(SEARCH_CONTAINER).click();
    }

    public void enterSearchField(String input) {
        driver.findElementById(SEARCH_FILED).sendKeys(input);
    }

    public void clickOnFirstArticleOnDropdown() {
        driver.findElementById(FIRST_ELEMENT_IN_DROPDOWN).click();
    }

    public Boolean isArticleDisplayed() {
        return driver.findElementsById(ARTICLE_TITLE)
                .size() > 0;
    }

    public void waitForArticle() {
        waitForCondition(this::isArticleDisplayed);
    }

    public void verifyArticleIsDisplayed(String title) {
        Assert.assertEquals(
                driver.findElementById(ARTICLE_TITLE)
                        .getText(), title);
    }

    //TODO: possible to use api. Do not to hardcode value
    public Boolean isTrendingFirst() {
        waitForCondition(this::isMoreButtonDisplayed);
        List<MobileElement> items = driver.findElementsById(CATEGORY_HEADER);
        if (items.get(0).getText().equals("Trending")) return true;
        return false;
    }

    public Boolean isMorePopupDisplayed() {
        return driver.findElementsById(MORE_POPUP_ELEMENT)
                .size() > 0;
    }

    public void closeCategory() {
        if (!driver.findElementsById(MORE_BUTTON).isEmpty()) {
            List<MobileElement> elements = driver.findElementsById(MORE_BUTTON);
            elements.get(0).click();
            waitForCondition(this::isMorePopupDisplayed);
            driver.findElementById(MORE_POPUP_ELEMENT).click();
        }
    }

    public Boolean isMoreButtonDisplayed() {
        return driver.findElementsById(MORE_BUTTON).size() > 0;
    }

    public void closeCategoriesUpToTrending() {
        while (!isTrendingFirst()) {
            waitForCondition(this::isMoreButtonDisplayed);
            closeCategory();
        }
    }

    public void clickOnMoreButtonOfArticleByIndex(int index) {
        waitForCondition(this::isMorePopupDisplayed);
        List<MobileElement> items = driver.findElementsById(ARTICLE_MORE_BUTTON);
        items.get(index - 1).click();
    }

    public void clickOnAddToReadingListButton() {
        waitForCondition(this::isMorePopupDisplayed);
        List<MobileElement> items = driver.findElementsById(MORE_POPUP_ELEMENT);
        for (MobileElement item : items) {
            if (item.getText().equals("Add to reading list")) {
                item.click();
                break;
            }
        }
    }

    public Boolean isGotItButtonDisplayed() {
        return driver.findElementsById(GOT_IT_BUTTON).size() > 0;
    }

    public void clickOnGotItButton() {
        waitForCondition(this::isGotItButtonDisplayed);
        driver.findElementById(GOT_IT_BUTTON).click();
    }

    public Boolean isOKButtonDisplayed() {
        return driver.findElementsById(OK_BUTTON).size() > 0;
    }

    public Boolean isMyListsDisplayed() {
        return driver.findElementsById(READING_LIST_TITLE).size() > 0;
    }

    public void clickOnInputField() {
        driver.findElementById(READING_LIST_NAME_INPUT).click();
    }

    public void clickOnOKButton() {
        waitForCondition(this::isOKButtonDisplayed);
        driver.findElementById(OK_BUTTON).click();
    }

    public void clickOnMyListsButton() {
        waitForCondition(this::isMyListsDisplayed);
        driver.findElementByAccessibilityId(MY_LISTS).click();
    }

    public void clickOnReadingListTitle() {
        waitForCondition(this::isMyListsDisplayed);
        driver.findElementById(READING_LIST_TITLE).click();
    }

    public Boolean isMoreButtonOnReadingListDisplayed() {
        return driver.findElementsById(READING_LIST_TITLE_MORE_BUTTON).size() > 0;
    }

    public void clickOnArticleOnMyListsByIndex(int index) {
        waitForCondition(this::isMoreButtonOnReadingListDisplayed);
        List<MobileElement> items = driver.findElementsById(READING_LIST_TITLE_MORE_BUTTON);
        items.get(index - 1).click();
    }

    public Boolean isRemoveItemDisplayed() {
        return driver.findElementsById(REMOVE_ITEM).size() > 0;
    }

    public void clickOnRemoveItemFromReadingList() {
        waitForCondition(this::isRemoveItemDisplayed);
        driver.findElementById(REMOVE_ITEM).click();
    }

    public void verifyAllItemWasRemovedFromList() {
        Assert.assertEquals(
                driver.findElementById(ALL_ITEMS_WAS_REMOVED_FROM_LIST)
                        .isDisplayed(), true);
    }
}

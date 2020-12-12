package test.main;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import main.java.wiki.container.DefaultMenu;
import test.BaseMobileTest;

import java.net.MalformedURLException;

public class secondTest {

    public static void main(String args[]) throws MalformedURLException {

        AndroidDriver<AndroidElement> androidDriver = BaseMobileTest.getDriver();
        DefaultMenu defaultMenu = new DefaultMenu(androidDriver);


        defaultMenu.closeCategoriesUpToTrending();
        defaultMenu.clickOnMoreButtonOfArticleByIndex(1);
        defaultMenu.clickOnAddToReadingListButton();
        defaultMenu.clickOnGotItButton();
        defaultMenu.clickOnInputField();
        defaultMenu.clickOnOKButton();
        defaultMenu.clickOnMyListsButton();
        defaultMenu.clickOnReadingListTitle();
        defaultMenu.clickOnArticleOnMyListsByIndex(1);
        defaultMenu.clickOnRemoveItemFromReadingList();
        defaultMenu.verifyAllItemWasRemovedFromList();
    }
}

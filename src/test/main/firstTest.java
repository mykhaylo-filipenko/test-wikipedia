package test.main;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import main.java.wiki.container.DefaultMenu;
import test.BaseMobileTest;

import java.net.MalformedURLException;

public class firstTest {

    public static void main(String args[]) throws MalformedURLException {

        AndroidDriver<AndroidElement> androidDriver = BaseMobileTest.getDriver();
        DefaultMenu defaultMenu = new DefaultMenu(androidDriver);

        String inputField = "Selenium";

        defaultMenu.clickOnSearchContainer();
        defaultMenu.enterSearchField(inputField);
        defaultMenu.clickOnFirstArticleOnDropdown();
        defaultMenu.waitForArticle();
        defaultMenu.verifyArticleIsDisplayed(inputField);

        androidDriver.quit();
    }
}

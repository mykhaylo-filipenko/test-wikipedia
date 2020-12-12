package main.java.wiki;

import io.appium.java_client.android.AndroidDriver;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected AndroidDriver driver;
    long WAIT_FOR_CONDITION_TIMEOUT=10000;
    long WAIT_FOR_CONDITION_POLL_INTERVAL=500;

    public BasePage(AndroidDriver driver){
        this.driver = driver;
    }

    public Boolean waitForCondition(Callable<Boolean> condition) {
        try {
            Awaitility.await()
                    .timeout(
                            WAIT_FOR_CONDITION_TIMEOUT,
                            TimeUnit.MILLISECONDS
                    )
                    .pollInterval(
                            WAIT_FOR_CONDITION_POLL_INTERVAL,
                            TimeUnit.MILLISECONDS
                    )
                    .until(condition);
            return true;
        } catch (ConditionTimeoutException e) {
            return false;
        }
    }
}
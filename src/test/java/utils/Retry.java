package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
//We can retry once or twice!
    int counter = 0;
    int retryLimit = 2;

    /**
     * @param result-> result of the test
     * @return true if the test method has to be retried, false otherwise.
     */

    @Override
    public boolean retry(ITestResult result) {
        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}

package testNgTutorial;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {
	
	private int retryCount = 0;
	private int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if(retryCount < maxRetryCount){
			retryCount++;
			return true;
		}
		return false;
	}

}

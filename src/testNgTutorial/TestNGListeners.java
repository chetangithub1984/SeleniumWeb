package testNgTutorial;

import org.testng.*;

public class TestNGListeners implements ITestListener, ISuiteListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("About to begin test " + result.getName(), true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("test success " + result.getName(), true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStart(ISuite iSuite) {
		System.out.println("Hey   " +iSuite.getName());
	}

	@Override
	public void onFinish(ISuite iSuite) {

	}
}

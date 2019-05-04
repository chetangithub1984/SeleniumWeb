package testNgTutorial;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {
	

	
	@Test
	@Parameters({"Username", "Password"})
	
	
	public void parametersEx(@Optional("Chetan_User")String Username ,@Optional("Patel_pwd")String Password ) {
		System.out.println(Username + " " + Password);
	}

}

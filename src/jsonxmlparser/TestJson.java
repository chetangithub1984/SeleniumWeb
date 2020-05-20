package jsonxmlparser;

import java.io.IOException;

public class TestJson {

	public static void main(String[] args) throws IOException {


		
		JsonReader json = new JsonReader(System.getProperty("user.dir")+"\\TestData\\OR.json");
		System.out.println(json.getLocator("locators.homepage.username.css"));
	
	}

}

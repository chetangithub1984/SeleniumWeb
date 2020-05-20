package jsonxmlparser;

public class TestXML {

	public static void main(String[] args) {


		XMLReader xml = new XMLReader(System.getProperty("user.dir")+"\\TestData\\OR.xml");
		System.out.println(xml.getLocator("username.xpath"));

		
		//driver.findElement(By.xpath(xml.getLocator("homepage.header.username.css"))).sendKeys();
	}

}

package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class firefoxStandaloneTest {

	public static void main(String[] args) throws MalformedURLException {
		
		//Remote WebDriver Class because tests will not run on local machine!!!!
		URL url = new URL("http://localhost:4444/wd/hub"); //port number which docker is listening for
	
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());

	}
 
}

package remoteTesting.dockerValidation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firefoxTest2 {
	
	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException {
		startDocker s = new startDocker();
		s.start();
	}

	@Test
	public  void test2() throws MalformedURLException {
		
		//Remote WebDriver Class because tests will not run on local machine!!!!
		URL url = new URL("http://localhost:4444/wd/hub"); //port number which docker is listening for
	
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("http://yahoo.com");
		System.out.println(driver.getTitle());

	}
 
	@AfterTest
	public void stopDockerDeleteFile() throws IOException, InterruptedException {
		stopDocker st = new stopDocker();
		st.stop();
	}
	
}

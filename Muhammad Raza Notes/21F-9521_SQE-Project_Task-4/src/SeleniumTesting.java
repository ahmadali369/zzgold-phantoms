import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.*;

public class SeleniumTesting {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		
		// Creating object of EdgeDriver and open https://www.google.com on edge
		EdgeDriver driver = new EdgeDriver();
		// Test Case 1: Open https://www.google.com on edge
		driver.get("https://www.google.com");
		
		// Test Case 2: Search "Selenium testing with Edge" on google
		WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium testing with Edge");
        searchBox.submit();
	}
}
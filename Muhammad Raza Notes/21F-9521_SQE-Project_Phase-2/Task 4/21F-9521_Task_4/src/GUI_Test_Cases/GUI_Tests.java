package GUI_Test_Cases;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class GUI_Tests {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://localhost:3000");
		
		 // Scenario 1: Dashboard Creation
		WebElement dashboardNameField = driver.findElement(By.id("dashboardName"));
        dashboardNameField.sendKeys("New Dashboard");
        WebElement createButton = driver.findElement(By.id("createButton"));
        createButton.click();
        
        // Scenario 2: Dashboard Editing
        WebElement editButton = driver.findElement(By.id("editButton"));
        editButton.click();
        
        // Scenario 3: Visualization Types
        WebElement barChartButton = driver.findElement(By.id("barChartButton"));
        barChartButton.click();
        
        // Scenario 4: Dashboard Sharing
        WebElement shareButton = driver.findElement(By.id("shareButton"));
        shareButton.click();
        
     // Scenario 5: Navigate Between Dashboards
        WebElement otherDashboardLink = driver.findElement(By.id("otherDashboardLink"));
        otherDashboardLink.click();
        
        driver.quit();
	}

}

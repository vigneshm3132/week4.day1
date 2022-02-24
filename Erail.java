package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
	    driver.manage().window().maximize(); // Maximize the opened chrome browser window
	    driver.get("https://erail.in/"); // Loads the URL in the opened browser
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    WebElement from = driver.findElement(By.id("txtStationFrom"));
	    from.clear();
	    from.sendKeys("TPJ", Keys.TAB);
	    WebElement to = driver.findElement(By.id("txtStationTo"));
	    to.clear();
	    to.sendKeys("MDU", Keys.TAB);
	    driver.findElement(By.id("chkSelectDateOnly")).click();
	    
	    WebElement elementTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
	    
	    List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
	    
	    for (int i = 0; i < listRows.size(); i++) {
			WebElement currentRow = listRows.get(i);
			List<WebElement> listColumns = currentRow.findElements(By.tagName("td"));
			
			for (int j = 0; j < listColumns.size(); j++) {
				//System.out.println(listColumns.get(j).getText());
				
				String SF = listColumns.get(j).getText();
				
				if(SF.contains("SF"))
				{
					System.out.println(SF);
					System.out.println(listColumns.get(j-1).getText());
				}
				
			}
			
		
		}
	    

	}
	
}

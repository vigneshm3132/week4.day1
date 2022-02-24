package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// first get all the values of Name store in a List and Sort
		List<WebElement> values = driver.findElements(By.xpath("//tr//td[2]"));
		List<String> empName = new ArrayList<String>();
		
		for (WebElement eachName : values) {
			empName.add(eachName.getText());
		}
		
		Collections.sort(empName);
		System.out.println("Before Sorting: "+empName);
		
		driver.findElement(By.xpath("//tr//th[2]")).click();
		
		// Again get all the values and store in a list
		
		List<WebElement> values1 = driver.findElements(By.xpath("//tr//td[2]"));
		List<String> empName1 = new ArrayList<String>();
		
		for (WebElement eachName1 : values1) {
			empName1.add(eachName1.getText());
		}
		Collections.sort(empName1);
		System.out.println("After Sorting: "+empName1);
		
		if(empName.equals(empName1))
		{
			System.out.println("The values are sorted");
		}else
		{
			System.out.println("The values are not sorted");
		}
			
		
		
	}
}

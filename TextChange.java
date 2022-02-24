package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		File fileName1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./snaps/before.png");
		FileUtils.copyFile(fileName1, dest1);

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']")));
		File fileName2 = driver.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("./snaps/after.jpeg");
		FileUtils.copyFile(fileName2, dest2);
		String text = driver.findElement(By.xpath("//button[text()='Click ME!']")).getText();
		
		if (text.equals("Click ME!")) {
			System.out.println("Button appeared");
		}
		driver.findElement(By.xpath("//button[text()='Click ME!']")).click();

		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		System.out.println("Alert message is : " + msg);
		if (msg.equals("Click ME!")) {
			System.out.println("Correct alert displayed");
			alert.accept();
		} else {
			System.out.println("Incorrect alert");
		}
	}
}
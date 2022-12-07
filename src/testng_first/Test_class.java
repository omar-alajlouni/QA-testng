package testng_first;
import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;
import org.asynchttpclient.webdav.WebDavCompletionHandlerBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
public class Test_class {
	//public WebDriver driver1;
	public WebDriver driver;
	@BeforeTest
	public void login() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		//driver1 = new ChromeDriver();
		driver = new EdgeDriver();
		//driver1.get("http://google.com");
		driver.get("https://www.saucedemo.com");
		String username = "standard_user";
		String password = "secret_sauce";
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(2000);
	}
//	@Test(priority = 3)
//	public void sort_items_low_to_high() throws InterruptedException {
//		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
//		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
//		List<WebElement> thePricesList = driver.findElements(By.className("inventory_item_price"));
//		List<Double> newEditedList = new ArrayList<>();
//		for (int i = 0; i < thePricesList.size(); i++) {
//			String price = thePricesList.get(i).getText();
//			String editedPrice = price.replace("$", " ");
//			double val = Double.parseDouble(editedPrice.trim());
//			newEditedList.add(val);
//		}
//		for (int k = 0; k < newEditedList.size(); k++) {
//			boolean checkProcess = newEditedList.get(0) < newEditedList.get(newEditedList.size() - 1);
//			Assert.assertEquals(checkProcess, true);
//		}
//		System.out.println(newEditedList);
//	}
	@Test(priority = 1)
	public void sort_items_high_to_low() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
		List<WebElement> thePricesList = driver.findElements(By.className("inventory_item_price"));
		List<Double> newEditedList = new ArrayList<>();
		for (int i = thePricesList.size()-1; i > -1; i--) {
			String price = thePricesList.get(i).getText();
			String editedPrice = price.replace("$", " ");
			double val = Double.parseDouble(editedPrice.trim()); //trim to remove any space
			newEditedList.add(val);
		}
//		for (int k = 0; k < newEditedList.size(); k++) {
//			boolean checkProcess = newEditedList.get(0) < newEditedList.get(newEditedList.size() - 1);
//			Assert.assertEquals(checkProcess, true);
//		}
		System.out.println(newEditedList);
	}
}
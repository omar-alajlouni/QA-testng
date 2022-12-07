package testng_first;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
public class OpenSooq {
	public static WebDriver driver1;
	static SoftAssert assert_result = new SoftAssert();
	@BeforeTest()
	public void enterWebsite(){
		WebDriverManager.edgedriver().setup();
		driver1 = new EdgeDriver();
		driver1.manage().window().maximize();
		driver1.get("http://opensooq.com/");
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.findElement(By.xpath("//*[@id=\"header\"]/div/a[2]")).click();
	}
	@Test()
	public void check_result_mitsobishi() {
		driver1.findElement(By.xpath("//*[@id=\"mainContent\"]/div[6]/div/div[2]/ul/li[1]/div[2]/h3[1]/a")).click();
		driver1.findElement(By.xpath("//*[@id=\"Brand\"]/div")).click();
		driver1.findElement(By.xpath("//*[@id=\"Brand\"]/div[2]/p/input")).sendKeys("mitsu"+Keys.ARROW_DOWN+Keys.ENTER+Keys.ESCAPE);
		driver1.findElement(By.xpath("//*[@id=\"landingPostDynamicField\"]/div/button")).click();		
		Parameters.item_searsh();
	}
}=
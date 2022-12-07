package testng_first;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Parameters extends OpenSooq {
	static public void item_searsh() {
		List<WebElement> results = driver1.findElements(By.className("noEmojiText"));
		List<String> words = new ArrayList<>();
		for(int i=0; i<results.size()-3;i++) {
			String word = results.get(i).getText();
			words.add(word);
			assert_result.assertEquals(word.contains("Mitsubishi"), true);
			assert_result.assertAll(); 
			System.out.println(word.contains("Mitsubishi"));
		}
	}
}
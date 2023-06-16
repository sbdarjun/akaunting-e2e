package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class BaseClass {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.akaunting.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//		Assert the URL
		String curentURL = driver.getCurrentUrl();
		Assert.assertTrue(curentURL.contains("akaunting"));
		WebElement loginText = driver.findElement(By.className("text-lg"));
		String value = loginText.getText();
		assertEquals("Login to start your session", value);

		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("abc@gmail.com");
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("test1234");

//		WebElement captchCheck = driver.findElement(By.id("cf-stage"));
//		String text = captchCheck.getText();
//		assertEquals("Verify you are human", text);
		WebElement rememberCheckbox = driver.findElement(By.id("checkbox-remember"));
		rememberCheckbox.click();

		WebElement loginButton = driver.findElement(By.cssSelector("button"));
		loginButton.click();
//		driver.quit();
	}
}
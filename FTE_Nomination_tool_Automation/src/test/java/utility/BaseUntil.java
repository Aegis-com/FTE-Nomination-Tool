package utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseUntil {
	public static WebDriver driver;
	static Actions a;
	static Alert al;
	static Workbook w;


	public static void load_Url(String url) {
		driver.get(url);
	}

	public static String get_Title() {
		String title = driver.getTitle();
		return title;
	}

	public static String get_CurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void get_Text(WebElement e) {
		String text = e.getText();
		System.out.println(text);
	}

	public static void btn_Click(WebElement e) {
		e.click();
	}

	public static void send_Key(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static String get_Atrribute(WebElement e) {
		String text = e.getAttribute("value");
		return text;
	}

	public static void moveTo_Element(WebElement e) {
		a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	// public static void dragAndDrop(WebElement e) {
	// a.dragAndDrop(e, null).perform();
//}
	public static void double_Click(WebElement e) {
		a.doubleClick(e).perform();
	}

	public static void right_Click(WebElement e) {
		a.contextClick(e).perform();
	}

	public static void alert_Accept() {
		driver.switchTo().alert();
		al.accept();
	}

	public static void alert_Dismiss() {
		driver.switchTo().alert();
		al.dismiss();
	}

	public static void take_ScreenShot(String value) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		File desn = new File(value);
		FileUtils.copyFile(source, desn);
	}

	public static void selectVisible_Text(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByVisibleText(value);
	}
}

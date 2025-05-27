package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	/**
	 * @see The WebDriver instance used to interact with the browser
	 */
	public static WebDriver driver;

	/**
	 * @see Used to Sets up and returns a WebDriver instance based on the specified
	 *      browser type
	 * @param browserType
	 */
	public static void getDriver(String browserType) {

		switch (browserType) {
		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	/**
	 * @see Used to Loads a URL in the current browser window
	 * @param Url
	 */

	public static void loadUrl(String Url) {
		driver.get(Url);
	}

	public void setUpDriver() {
		System.setProperty("Webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	/**
	 * @see UsedClicks a WebElement after waiting for it to be clickable and
	 *      scrolling into view if necessary
	 * @param element
	 */
	public void click(WebElement element) {
		try {
			// Wait until the element is clickable (visible and enabled)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			// Scroll to the element if necessary
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			// Retry clicking if intercepted
			try {
				element.click();
			} catch (ElementClickInterceptedException e) {
				// Use JavaScript to click if normal click fails
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}

		} catch (org.openqa.selenium.json.JsonException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {

			throw new RuntimeException(e);
		} catch (NoSuchElementException e) {

			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see used to retrieve the title of the current web page
	 * @return String
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @see used to get the current url
	 * @return String
	 */
	public String getCurrentrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @see Used to Closes the current window on the browswe
	 */
	public void closeWindow() {
		driver.close();

	}

	/**
	 * @see used to quit the browser
	 */
	public void quitBrowser() {
		driver.quit();
	}

	/**
	 * @see Used to get the data from property
	 * @see Used to get directory path
	 * @return
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		String configFilePath = getProjectPath() + File.separator + "Config" + File.separator + "Config.properties";
		properties.load(new FileInputStream(configFilePath));
		return properties.getProperty(key);

	}

	/**
	 * @see used to capturing the webpage
	 * @return byte[]
	 */
	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}

	/**
	 * @see Use to navigates the Webpage
	 * @return Navigation object for chainable methods
	 */
	public Navigation navigate() {
		Navigation navigate = driver.navigate();
		return navigate;
	}

	/**
	 * @see Used to Switches the context to a different target, such as a window,
	 *      frame, or alert
	 * @return TargetLocator
	 */
	public TargetLocator switchTo() {
		TargetLocator switchTo = driver.switchTo();
		return switchTo;
	}

	/**
	 * @see Used to Handle the window
	 * 
	 * @return String
	 */
	public String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	/**
	 * @see Used to handle the multiple windows on the webpage
	 * 
	 * @return Set<String>
	 */

	public Set<String> getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public void switchToNextWindow() {
		Set<String> allWindows = getWindowHandles();
		String currentWindowHandle = getWindowHandle();

		for (String windowHandle : allWindows) {

			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	/**
	 * @see used to maximize the winndow on the webpage
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @see Used to maintain the Element visibility method
	 * @param element
	 */

	public void elementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * @see Used to insert the values on the webpage
	 * 
	 * @param element
	 * 
	 * @param data
	 */
	public void insertValue(WebElement element, String data) {
		elementVisibility(element);
		element.clear();
		element.sendKeys(data);
	}

	/**
	 * @see Used to Retrieves the text from the specified WebElement
	 *
	 * @param element
	 * 
	 * @return String
	 */
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @see Used to get the value from the webpage
	 * 
	 * @param element
	 * @param value
	 * 
	 * @return String
	 */
	public String getAttribute(WebElement element, String value) {
		elementVisibility(element);
		String attributeValue = element.getAttribute(value);
		return attributeValue != null ? attributeValue : "";
	}

	/**
	 * @see Used to check the WebElement is displayed or not
	 * 
	 * @param element
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	/**
	 * @see Used to check the WebElement is enabled or not
	 * 
	 * @param element
	 * 
	 * @return boolean
	 */
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	/**
	 * @see Used to check the WebElement is selected or not
	 * 
	 * @param element
	 * 
	 * @return boolean
	 */
	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	// Navigation
	/**
	 * @see Used to navigate the next webpage
	 * 
	 */
	public void forwardNavigation() {
		driver.navigate().forward();
	}

	/**
	 * @see Used to navigate into previous Webpage
	 * 
	 */
	public void backNavigation() {
		driver.navigate().back();

	}

	/**
	 * @see Used to Navigate the specified Url
	 * 
	 * @param url
	 */
	public void toNavigation(String url) {
		driver.navigate().to(url);
	}

	/**
	 * @see Used to refresh or reloads the current webpage
	 * 
	 */
	public void refreshNavigation() {
		driver.navigate().refresh();
	}

	/**
	 * @see Used to perform Keyboard and Mouse actions on the Webpage
	 * 
	 */
	public void performAction() {
		Actions actions = new Actions(driver);
		actions.perform();
	}

	/**
	 * @see Used to move the cursor to the WebElement
	 * 
	 * @param target The WebElement to move the cursor to
	 * 
	 */
	public void moveToElement(WebElement target) {
		Actions actions = new Actions(driver);
		elementVisibility(target);
		actions.moveToElement(target).pause(Duration.ofMillis(500)).perform();
	}

	/**
	 * @see Used to perform Rightclick on the Webpage
	 * 
	 * @param target The WebElement to perform the Rightclick on
	 * 
	 */
	public void contextClick(WebElement target) {
		new Actions(driver).contextClick(target).perform();
	}

	/**
	 * @see Used to perform doubleclick on the Webpage
	 * @param target
	 * 
	 */
	public void clickWithActions(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}

	public void doubleClick(WebElement target) {
		new Actions(driver).doubleClick(target).perform();
	}

	/**
	 * @see Used to perform drag-and-drop operation from the source element to the
	 *      target element
	 * 
	 * @param source The WebElement to drag
	 * @param target The WebElement to drop onto
	 * 
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		new Actions(driver).dragAndDrop(source, target).perform();
	}

	/**
	 * @see Used to perform keyboard action using keyUp
	 * @param key
	 * 
	 */
	public void keyUp(CharSequence key) {
		new Actions(driver).keyUp(key).perform();
	}

	/**
	 * @see Used to perform keyboard action using keyDown
	 * @param key
	 * 
	 */
	public void keyDown(CharSequence key) {
		new Actions(driver).keyDown(key).perform();
	}

	// Select
	/**
	 * @see Used to select the value by using index in dropDown
	 * 
	 * @param element, The WebElement dropdown element
	 * @param index,   The index value to be selected
	 * 
	 */
	public void selectByIndex(WebElement element, int index) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @see Used to selects an option in a dropdown its value
	 * 
	 * @param element The WebElement dropdown element
	 * @param value   The Value of option to be selected
	 */
	public void SelectByValue(WebElement element, String value) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @see Used to select the text by using Visible text in dropdown
	 * 
	 * @param element element The WebElement dropdown element
	 * @param text
	 */
	public void selectByVisibleText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @see Used to deselect the value by using index in dropDown
	 * 
	 * @param element, The WebElement dropdown element
	 * @param index,   The index value to be deselected
	 */
	public void deselectByIndex(WebElement element, int index) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	/**
	 * @see Used to deselects an option in a dropdown its value
	 * 
	 * @param element, The WebElement dropdown element
	 * @param value
	 */
	public void deselectByValue(WebElement element, String value) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	/**
	 * @see Used to select the text by using Visible text in dropdown
	 * 
	 * @param element, The WebElement dropdown element
	 * @param text
	 */
	public void deselectByVisibleText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	/**
	 * @see Used to deselect the all the values in dropdown
	 * @param element, The WebElement dropdown element
	 */
	public void deSelectAll(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * @see Used to get all the options referenced by a WebElement
	 * 
	 * @param element, The WebElement dropdown element
	 * @return The List of WebElements representing the options
	 */
	public List<WebElement> getOption(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		List<WebElement> option = select.getAllSelectedOptions();
		return option;
	}

	/**
	 * @see Used to check if the referenced webelement supports multiple selection
	 * 
	 * @param element, The WebElement dropdown element
	 * @return true if the element allows multiple selections, otherwise false
	 */
	public boolean isMultiple(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	/**
	 * @see Used to retrives all the selected option from the dropdown referenced by
	 *      a WebElement
	 * 
	 * @param element, The WebElement dropdown element
	 * @return The list of webEelments representing the selected options
	 */
	public List<WebElement> getAllSelectedOption(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;

	}

	/**
	 * @see Used to first selected option from the dropdown referenced by a
	 *      WebElement
	 * 
	 * @param element The WebElement dropdown element
	 * @return WebElement
	 */
	public WebElement getFirstSelectedOption(WebElement element) {
		elementVisibility(element);
		return new Select(element).getFirstSelectedOption();

	}

	/**
	 * @see Used to select the values by using selectOptionbyText in dropdown
	 * 
	 * @param element The WebElement dropdown element
	 * @param text
	 */
	public void selectOptionByText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// Alert

	/**
	 * @see Used to switch the control to popup notification
	 * 
	 * @return alert
	 */
	public Alert switchToAlert() {
		Alert alert = switchTo().alert();
		return alert;
	}

	/**
	 * @see Used to accept the alert popup notification on the webpage
	 * 
	 */
	public void acceptAlert() {
		switchToAlert().accept();
	}

	/**
	 * @see Used to dismiss the alert popup notification on the webpage
	 */
	public void dismissAlert() {
		switchToAlert().dismiss();
	}

	/**
	 * @see Used text input in popup box
	 * @param keysToSend
	 */
	public void alertSendKeys(String keysToSend) {
		switchToAlert().sendKeys(keysToSend);
	}

	/**
	 * @see Used to get the text from popup box
	 * @return String
	 */
	public String alertGetText() {
		String text = switchToAlert().getText();
		return text;
	}

	// Frames
	/**
	 * @see Used to navigate into the frames by using Name or Id
	 * @param nameOrId
	 */
	public void frameNameOrId(String nameOrId) {
		switchTo().frame(nameOrId);
	}

	/**
	 * @see Used to navigates into the frames by using Index
	 * @param index
	 */
	public void frameIndex(int index) {
		switchTo().frame(index);
	}

	/**
	 * @see used to navigate into frames referenced by a WebElement
	 * @param framelement
	 */
	public void frameWebElement(WebElement framelement) {
		switchTo().frame(framelement);
	}

	public void defaultContent() {
		switchTo().defaultContent();

	}

	// waits
	/**
	 * @see Used to maintain the waits method
	 */
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	// javaScriptExecutor

	/**
	 * @see Used to scrolls the page until specified element is in view
	 * 
	 * @param element The WebElement to scroll to
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * @see Used to scrolls the page until specified element is in view
	 * 
	 * @param element The WebElement to scroll up
	 */
	public void scrollUpToElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	/**
	 * @see clicks an element using javascriptExecutor
	 * @param element The WebElement to click
	 */
	public static void clickElementUsingJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	/**
	 * @see Used to sets the text into a webElement using javascriptExecutor
	 * 
	 * @param element, The WebElement where the text should be entered
	 * 
	 * @param text,    The text enter into the WebElement
	 */
	public void setTextUsingJS(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value', arguments[1])", element, text);
	}

	public void clearTextUsingjs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = ''; ", element);
	}

	public static void setValueById(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = String.format("document.getElementById('%s').value='%s';", element, value);
		jsExecutor.executeScript(script);
	}

	public String getData(String sheetName, int rowNum, int cellNum) throws IOException {
		String value = null;
		File file = new File("C:\\Users\\nloga\\eclipse-workspace\\Framework\\Base Class- Pharmacy.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);

		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				value = dateFormat.format(date);
			} else {
				value = String.valueOf((long) cell.getNumericCellValue());
			}
			break;
		default:
			break;
		}
		workbook.close(); // Close the workbook after use
		return value;
	}

	public String getExcelData(String sheetName, String rowName, String headerName) throws IOException {
		String value = null;
		File file = new File("C:\\Users\\nloga\\OneDrive - DataCaliper\\Desktop\\PFWR.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		try {
			Sheet sheet = workbook.getSheet(sheetName);
			int rowIndex = -1;

			// Find the row index where rowName matches
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					Cell cell = row.getCell(0);
					if (cell != null && cell.getCellType() == CellType.STRING
							&& cell.getStringCellValue().equals(rowName)) {
						rowIndex = i;
						break;
					}
				}
			}

			if (rowIndex == -1) {
				System.out.println("Row with name " + rowName + " not found.");
				return null;
			}
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				System.out.println("Header row is null.");
				return null;
			}

			int columnIndex = -1;
			for (Cell cell : headerRow) {
				if (cell != null && cell.getCellType() == CellType.STRING
						&& cell.getStringCellValue().equalsIgnoreCase(headerName)) {
					columnIndex = cell.getColumnIndex();
					break;
				}
			}

			if (columnIndex == -1) {
				// System.out.println("Header with name " + headerName + " not found.");
				return null;
			}

			// Get the cell value
			Row rowNum = sheet.getRow(rowIndex);
			if (rowNum == null) {
				// System.out.println("Row at index " + rowIndex + " is null.");
				return null;
			}

			Cell cell = rowNum.getCell(columnIndex);
			if (cell == null) {
				// System.out.println("Cell at column " + columnIndex + " is null.");
				return null;
			}

			// Handle different cell types
			CellType type = cell.getCellType();
			switch (type) {
			case STRING:
				value = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					value = dateFormat.format(date);
				} else {
					value = String.valueOf((long) cell.getNumericCellValue());
				}
				break;
			case BLANK:
				System.out.println("Cell is blank.");
				value = "";
				break;
			default:
				System.out.println("Unsupported cell type.");
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return value;
	}

	public static void clickElementWithWait(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
		} catch (TimeoutException | NoSuchElementException e) {
			System.err.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
			throw new RuntimeException("Error while interacting with element", e);
		}
	}

	public void getDetailPharmacyInformation(Map<String, String> keyValueMap, String text) {

		String[] lines = text.split("\\n");

		String currentKey = null;

		for (String line : lines) {
			line = line.trim();

			if (line.endsWith(":")) {
				currentKey = line.substring(0, line.length() - 1).trim();
			} else if (currentKey != null) {
				String value = keyValueMap.getOrDefault(currentKey, "") + line + " ";
				keyValueMap.put(currentKey, value.trim());
				currentKey = null;
			}
		}

	}

	/**
	 * Opens a document link and waits for the close button to be visible, then
	 * clicks it.
	 * 
	 * @param linkElement    The WebElement for the document link
	 * @param closeBtnXPath  The XPath locator for the close button
	 * @param timeoutSeconds Timeout in seconds to wait for the close button
	 */
	public void closeDocument(String closeBtnXPath, int timeoutSeconds) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
			WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closeBtnXPath)));
			clickElementUsingJavaScript(driver, closeBtn);
		} catch (TimeoutException | NoSuchElementException e) {

		} catch (Exception e) {

		}
	}

	/**
	 * @see clear text
	 * @param element
	 */
	public void clearTextField(WebElement element) {
		elementVisibility(element);
		element.clear();

	}

	/**
	 * @see Used to verify the Page title
	 * @param titleElement
	 * @param expectedTitle
	 */
	public void verifyPageTitle(WebElement titleElement, String expectedTitle) {
		refreshNavigation();
		String actualTitle = getText(titleElement);
		Assert.assertEquals("Verify the page title", expectedTitle, actualTitle);
	}

	/**
	 * @see Used to verify the alert message
	 * @param locator
	 * @param expectedMessage
	 */

	public void verifyAlertMessage(By locator, String expectedMessage) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String actualMessage = alertElement.getText();
		Assert.assertEquals("Verify the alert message ", expectedMessage, actualMessage);
	}

	/**
	 * @see Used to wait for element visibility
	 * @param elementLocator
	 */
	public void visibilityofElementLocated(WebElement elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOf(elementLocator));
	}

	/**
	 * @see wait element to be clickable
	 * @param element
	 */
	public void elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * @see Used to select from drop down
	 * @param driver
	 * @param dropdownLocator
	 * @param optionText
	 */
	public void selectOptionByDropDown(WebDriver driver, By dropdownLocator, String optionText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		click(dropdown);
		WebElement option = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//mat-option//span[normalize-space()='" + optionText + "']")));
		clickElementUsingJavaScript(driver, option);

	}

	public void selectOptionDropDown(WebElement dropdownElement, String optionText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		click(dropdownElement);
		WebElement option = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//mat-option//span[normalize-space()='" + optionText + "']")));
		clickElementUsingJavaScript(driver, option);
	}

	public void selectOptionDropDownByIndex(WebDriver driver, WebElement dropdownElement, int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		click(dropdownElement);
		String optionXPath = "(//mat-option//span)[" + index + "]";

		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXPath)));
		elementVisibility(option);
		clickElementUsingJavaScript(driver, option);
	}

	/**
	 * @see Used assert verification
	 * @param element
	 * @param expectedMessage
	 */
	public void assertEquals(WebElement element, String expectedMessage) {
		elementVisibility(element);
		String actualMessage = getText(element);
		Assert.assertEquals("Verify the message", expectedMessage, actualMessage);

	}

	/**
	 * @see Used to clicking radio button dynamically using label name
	 * @param rdbtnName
	 */
	public void clickRadioButton(String rdbtnName) {
		String xpath = "//label[normalize-space()='" + rdbtnName + "']//span[@class='checkmark']";
		// Waiting until the radio button is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		radioButton.click();
	}

	/**
	 * Waits for a WebElement to be visible and returns it.
	 *
	 * @param element          WebElement you want to wait for
	 * @param timeoutInSeconds how long to wait (in seconds)
	 * @return the WebElement once it becomes visible
	 */
	public WebElement waitForWebElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickWithWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		clickElementUsingJavaScript(driver, element);
	}

	/**
	 * Clears any existing text from the given element by sending Ctrl+A then
	 * Backspace. Works on Windows/Linux. On macOS you may need to use Keys.COMMAND
	 * instead of Keys.CONTROL.
	 */
	public void clearField(WebElement field) {
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		field.sendKeys(Keys.BACK_SPACE);
	}
}

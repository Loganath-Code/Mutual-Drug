package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class PageNotFoundPage extends BaseClass{
	public PageNotFoundPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='number_notfound']")
	private WebElement text404;
	
	@FindBy(xpath = "//p[@class='content_notfound']")
	private WebElement notFoundMessage;
	
	@FindBy(xpath = "//a[@class='home-btn']")
	private WebElement btnGoBack;

	public WebElement getText404() {
		return text404;
	}

	public WebElement getNotFoundMessage() {
		return notFoundMessage;
	}

	public WebElement getBtnGoBack() {
		return btnGoBack;
	}
	
	public void navigatesNonExistentPage(String url) {
		loadUrl(url);

	}
	
	public void clickGoBack() {
		click(getBtnGoBack());

	}
	
	
}

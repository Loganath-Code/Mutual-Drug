package com.pageManager;

import com.pages.CurrentOrderPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.NotificationPage;
import com.pages.OrdersPage;
import com.pages.ProductDetailPage;
import com.pages.ProductSearchPage;
import com.pages.ProductsCatalogPage;
import com.pages.ReturnsPage;
import com.pages.TemplatesPage;

public class PageObjectManager {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private CurrentOrderPage currentOrderPage;
	private ProductsCatalogPage productsCatalogPage;
	private ProductSearchPage productSearchPage;
	private ProductDetailPage productDetailPage;
	private NotificationPage notificationPage;
	private ReturnsPage returnsPage;
	private OrdersPage ordersPage;
	private TemplatesPage templatesPage;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public DashboardPage getDashboardPage() {
		return (dashboardPage == null) ? dashboardPage = new DashboardPage() : dashboardPage;
	}

	public CurrentOrderPage getCurrentOrderPage() {
		return (currentOrderPage == null) ? currentOrderPage = new CurrentOrderPage() : currentOrderPage;
	}

	public ProductsCatalogPage getProductsCatalogPage() {
		return (productsCatalogPage == null) ? productsCatalogPage = new ProductsCatalogPage() : productsCatalogPage;
	}

	public ProductSearchPage getProductSearchPage() {
		return (productSearchPage == null) ? productSearchPage = new ProductSearchPage() : productSearchPage;
	}

	public ProductDetailPage getProductDetailPage() {
		return (productDetailPage == null) ? productDetailPage = new ProductDetailPage() : productDetailPage;
	}

	public NotificationPage getNotificationPage() {
		return (notificationPage == null) ? notificationPage = new NotificationPage() : notificationPage;
	}

	public ReturnsPage getReturnsPage() {
		return (returnsPage == null) ? returnsPage = new ReturnsPage() : returnsPage;
	}

	public OrdersPage getOrdersPage() {
		return (ordersPage == null) ? ordersPage = new OrdersPage() : ordersPage;
	}

	public TemplatesPage getTemplatesPage() {
		return (ordersPage == null) ? templatesPage = new TemplatesPage() : templatesPage;
	}

}

package com.pageManager;

import com.adminUserPages.AdminDashboardPage;
import com.adminUserPages.AdminOrderTemplatesPage;
import com.adminUserPages.BannerMetricsPage;
import com.adminUserPages.BannersPage;
import com.adminUserPages.DetailsPage;
import com.adminUserPages.PlanogramsPage;
import com.adminUserPages.RolesPage;
import com.adminUserPages.UsersPage;
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
import com.pages.UserProfilePage;

public class PageObjectManager {

	private LoginPage loginPage;
	private UserProfilePage userProfilePage;
	private DashboardPage dashboardPage;
	private CurrentOrderPage currentOrderPage;
	private ProductsCatalogPage productsCatalogPage;
	private ProductSearchPage productSearchPage;
	private ProductDetailPage productDetailPage;
	private NotificationPage notificationPage;
	private ReturnsPage returnsPage;
	private OrdersPage ordersPage;
	private TemplatesPage templatesPage;
	private AdminDashboardPage adminDashboardPage;
	private AdminOrderTemplatesPage adminOrderTemplatesPage;
	private DetailsPage detailsPage;
	private UsersPage usersPage;
	private RolesPage rolesPage;
	private PlanogramsPage planogramsPage;
	private BannersPage bannersPage;
	private BannerMetricsPage bannerMetricsPage;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public UserProfilePage getUserProfilePage() {
		return (userProfilePage == null) ? userProfilePage = new UserProfilePage() : userProfilePage;
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

	public AdminDashboardPage getAdminDashboardPage() {
		return (adminDashboardPage == null) ? adminDashboardPage = new AdminDashboardPage() : adminDashboardPage;
	}

	public AdminOrderTemplatesPage getAdminOrderTemplatesPage() {
		return (adminOrderTemplatesPage == null) ? adminOrderTemplatesPage = new AdminOrderTemplatesPage()
				: adminOrderTemplatesPage;
	}

	public DetailsPage getDetailsPage() {
		return (detailsPage == null) ? detailsPage = new DetailsPage() : detailsPage;
	}

	public UsersPage getUsersPage() {
		return (usersPage == null) ? usersPage = new UsersPage() : usersPage;
	}

	public RolesPage getRolesPage() {
		return (rolesPage == null) ? rolesPage = new RolesPage() : rolesPage;
	}

	public PlanogramsPage getPlanogramsPage() {
		return (planogramsPage == null) ? planogramsPage = new PlanogramsPage() : planogramsPage;
	}

	public BannersPage getBannersPage() {
		return (bannersPage == null) ? bannersPage = new BannersPage() : bannersPage;
	}

	public BannerMetricsPage getBannerMetricsPage() {
		return (bannerMetricsPage == null) ? bannerMetricsPage = new BannerMetricsPage() : bannerMetricsPage;
	}

}

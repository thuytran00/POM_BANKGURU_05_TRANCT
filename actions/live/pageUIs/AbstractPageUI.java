package live.pageUIs;

public class AbstractPageUI {
	public static final String DYNAMIC_PAGE_LINK = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_BUTTON = "//*[@title='%s']";
	public static final String DYNAMIC_TEXTBOX_RADIO_CHECKBOX= "//*[@id='%s']";
	public static final String DYNAMIC_HEADER_LINK = "//div[@id='header-account']//a[text()='%s']";
	public static final String DYNAMIC_HEADER_LABEL_TEXT= "//div[@class='page-header-container']//span[text()='%s']";
	public static final String DYNAMIC_COMMON_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_IMAGE = "//a[@title='%s']/img";
	public static final String DYNAMIC_PRODUCT_NAME = "//h2[@class='product-name']/a[@title='%s']";
	public static final String DYNAMIC_PRODUCT_PRICE = "//h2[@class='product-name']/a[@title='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
	public static final String DYNAMIC_ADD_TO_CART_BUTTON = "//h2[@class='product-name']/a[@title='%s']/parent::h2/following-sibling::div[@class='actions']//button[@title='Add to Cart']";
	public static final String DYNAMIC_ADD_WISHLIST_OR_COMPARE = "//h2[@class='product-name']/a[@title='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='%s']";
}

package utils;

public class PageUrls {

    private static final String homePageUrl = "https://www.falabella.com.co/falabella-co/";
    private static final String registrationPageUrl = "https://secure.falabella.com.co/falabella-co/myaccount/register.jsp";
    private static final String productPageUrl = homePageUrl+"product/3000165/Consola-Switch-Neon-Azul-Rojo/3000165";
    private static final String shoppingBagPageUrl = homePageUrl+"basket";

    /**
     * @return The home page url
     */
    public static String getHomePageUrl() {
        return homePageUrl;
    }

    /**
     * @return The registration url
     */
    public static String getRegistrationPageUrl() {
        return registrationPageUrl;
    }

    /**
     * @return The product page url
     */
    public static String getProductPageUrl() {
        return productPageUrl;
    }

    /**
     * @return The shopping bag page url
     */
    public static String getShoppingBagPageUrl() {
        return shoppingBagPageUrl;
    }
}

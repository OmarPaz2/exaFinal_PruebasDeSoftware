package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CatalogPage {
    public static final Target CATALOG_TITLE = Target
            .the("catalog title")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Productos']"));

    public static final Target SEARCH_INPUT = Target
            .the("product search input")
            .located(AppiumBy.className("android.widget.EditText"));

    public static final Target FIRST_PRODUCT = Target
            .the("first product in catalog")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Laptop HP Pavilion']"));

    public static Target productWithText(String productName) {
        return Target
                .the("product containing " + productName)
                .located(AppiumBy.xpath("//android.widget.TextView[contains(@text,'" + productName + "')]"));
    }

    public static Target categoryOption(String category) {
        return Target
                .the(category + " category option")
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + category + "']"));
    }

    public static Target productFromCategory(String category) {
        if (category.equals("Electrónica")) {
            return Target
                    .the("electronic product")
                    .located(AppiumBy.xpath("//android.widget.TextView[@text='Laptop HP Pavilion']"));
        }

        return Target
                .the("product from " + category)
                .located(AppiumBy.xpath("//android.widget.TextView[contains(@text,'" + category + "')]"));
    }
}

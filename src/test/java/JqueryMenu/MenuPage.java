package JqueryMenu;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MenuPage {


    // Локаторы элементов

    private static final SelenideElement titleJQueryUIMenu = $x("//h3[text()='JQueryUI - Menu']");

    private static final SelenideElement titleMenu = $x("//a[text()='Menu']");

    private static final SelenideElement disabled = $("#ui-id-1");

    private static final SelenideElement enabled = $x("//*[@class='ui-state-disabled ui-menu-item']");

    private static final SelenideElement enabledMenu = $("#menu");

    private static final SelenideElement downloads = $x("//a[contains(text(), 'Downloads')]");

    private static final SelenideElement downloadsMenu = $x("//*[@class='ui-menu ui-widget ui-widget-content ui-front'][3]");

   // private static final SelenideElement backToJQueryUI = $x("//a[text()='Back to JQuery UI']");
   private static final SelenideElement backToJQueryUI = $( "a[href='/jqueryui']" );
    private static final SelenideElement filePDF = $("#ui-id-5");

    private static final SelenideElement fileCSV = $("#ui-id-6");

    private static final SelenideElement fileExcel = $("#ui-id-7");

    public static void shouldSeeTitleJQueryUIMenu() {
        titleJQueryUIMenu.shouldBe(visible);
    }

    public static void shouldSeeTitleMenu() {
        titleMenu.shouldBe(visible);
    }

    public static void hoverDisabled() {
        disabled.hover();
        disabled.should(exist);
        disabled.shouldHave(cssValue("pointer-events", "auto"));
        disabled.shouldHave(cssValue("opacity", "0.35"));
        disabled.shouldHave(attribute("aria-disabled", "true"));
    }

    public static void hoverEnabled() {
        enabled.hover();
        enabled.should(exist);
        enabled.shouldBe(visible, Duration.ofSeconds(10));
    }

    public static void enabledMenu() {
        enabledMenu.should(exist);
        enabledMenu.shouldBe(visible, Duration.ofSeconds(10));
    }

    public static void downloadsMenu() {
        downloadsMenu.should(exist);
        downloadsMenu.shouldBe(visible, Duration.ofSeconds(10));

    }

    public static void hoverDownloads() {
        downloads.hover();
        downloads.should(Condition.visible, Duration.ofSeconds(20));
        downloads.should(exist);
    }

    public static void clickBackToJQueryUI() {
        backToJQueryUI.scrollTo().hover();
        backToJQueryUI.should(exist);
        backToJQueryUI.should(Condition.visible, Duration.ofSeconds(20));
        backToJQueryUI.shouldBe(Condition.interactable, Duration.ofSeconds(20));
        backToJQueryUI.click();
    }

    public static void clickFilePDF() {
        filePDF.hover();
        filePDF.should(exist);
        filePDF.shouldBe(visible, Duration.ofSeconds(30));
        filePDF.shouldBe(Condition.interactable, Duration.ofSeconds(10));
        filePDF.click();
    }

    public static void clickFileCSV() {
        fileCSV.hover();
        fileCSV.should(exist);
        fileCSV.shouldBe(visible, Duration.ofSeconds(30));
        fileCSV.shouldBe(Condition.interactable, Duration.ofSeconds(10));
        fileCSV.click();
    }

    public static void clickFileExcel() {
        fileExcel.hover();
        fileExcel.should(exist);
        fileExcel.shouldBe(visible, Duration.ofSeconds(30));
        fileExcel.shouldBe(Condition.interactable, Duration.ofSeconds(10));
        fileExcel.click();
    }
}
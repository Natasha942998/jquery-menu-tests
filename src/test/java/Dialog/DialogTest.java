package Dialog;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DialogTest {
    public static final SelenideElement titleDialog = $x("//h1[text()='Dialog']");

    public static final SelenideElement modalDialog = $("#dialog");

    public static final SelenideElement closeButton = $(".ui-dialog-titlebar-close");

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless"); // без UI

        Configuration.browserCapabilities = options;

        Configuration.pageLoadTimeout = 160000;

        open("https://jqueryui.com/dialog/");
    }

    @Test
    public void checkSeeTitleTest() {
        titleDialog.shouldBe(visible);

    }

    @Test
    public void testDialog() {

        Selenide.switchTo().frame($("iframe.demo-frame").shouldBe(visible));

        modalDialog.shouldBe(visible)
                .shouldHave(exactText("This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon."));


        //  взаимодействие с кнопкой закрытия (крестик в заголовке)
        closeButton.shouldBe(visible);
        closeButton.click();
        modalDialog.shouldNotBe(visible);

    }
}

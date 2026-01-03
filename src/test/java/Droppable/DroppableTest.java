package Droppable;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DroppableTest {

    public static final SelenideElement titleDroppable = $x("//h1[text()='Droppable']");

    public static final SelenideElement draggable = $("#draggable");

    public static final SelenideElement droppable = $("#droppable");

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

        open("https://jqueryui.com/droppable/");
    }

    @Test
    public void checkSeeTitleTest() {
        titleDroppable.shouldBe(visible);

    }

    @Test
    public void testDragAndDrop() {

        Selenide.switchTo().frame($("iframe.demo-frame").shouldBe(visible));

        // Выполняем drag-and-drop
        actions()
                .clickAndHold(draggable)
                .moveToElement(droppable)
                .release()
                .build()
                .perform();


        // Проверяем текст внутри droppable ("Dropped!")
        droppable.$("p")
                .shouldHave(exactText("Dropped!"));

    }
}


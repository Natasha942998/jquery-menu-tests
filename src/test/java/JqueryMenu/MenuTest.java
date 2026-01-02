package JqueryMenu;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static JqueryMenu.MenuPage.*;
import static com.codeborne.selenide.Selenide.open;


public class MenuTest {

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

        open("https://the-internet.herokuapp.com/jqueryui/menu");
    }

    @Test
    public void checkSeeTitleTest() {
        shouldSeeTitleJQueryUIMenu();
    }

    @Test
    public void checkHoverDisabledTest() {
        hoverDisabled();
    }

    @Test
    public void checkHoverDownloadsTest() {
        hoverEnabled();
        enabledMenu();
        hoverDownloads();
        downloadsMenu();
    }

    @Test
    public void checkBackToJQueryUITest() {
        hoverEnabled();
        clickBackToJQueryUI();
        shouldSeeTitleMenu();
    }

    @Test
    public void checkFilePDFTest() {
        hoverEnabled();
        hoverDownloads();
        clickFilePDF();
    }

    @Test
    public void checkFileCSVTest() {
        hoverEnabled();
        hoverDownloads();
        clickFileCSV();
    }

    @Test
    public void checkFileExcelTest() {
        hoverEnabled();
        hoverDownloads();
        clickFileExcel();
    }
}
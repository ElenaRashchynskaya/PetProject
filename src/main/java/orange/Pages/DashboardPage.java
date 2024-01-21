package orange.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage extends CommonPage {

    public class Header {

        private static SelenideElement header() {
            return $(".oxd-topbar-header ").shouldBe(Condition.visible);
        }

        public static SelenideElement userName = header().$(".oxd-userdropdown-name");

        public static SelenideElement topBarUserMenu(String text) {
            return $x(".//a[contains(text(), '" + text + "')]");
        }

        public static ElementsCollection topBarUserMenuItems = $$("[role='menuitem']");
    }
}

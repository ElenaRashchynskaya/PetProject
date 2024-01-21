package orange.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends CommonPage {

    public class LoginForm {

        private static SelenideElement loginForm() {
            return $(".oxd-form").shouldBe(Condition.visible);
        }

        public static SelenideElement loginInput = loginForm().$("[name='username']");

        public static SelenideElement passwordInput = loginForm().$("[name='password']");

        public static SelenideElement submitButton = loginForm().$(".orangehrm-login-button");
    }
}
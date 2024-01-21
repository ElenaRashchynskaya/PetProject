package orange.Steps;
import orange.Pages.DashboardPage;
import orange.Pages.LoginPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrangeSteps {

    LoginPage loginPage = new LoginPage();

    public OrangeSteps openPage(PageName pageName) {
        loginPage.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/".concat(pageName.pagePath));
        return this;
    }

    public OrangeSteps fillInLoginInput(String email) {
        LoginPage.LoginForm.loginInput.setValue(email);
        return this;
    }

    public OrangeSteps fillInPasswordInput(String password) {
        LoginPage.LoginForm.passwordInput.setValue(password);
        return this;
    }

    public void clickSubmitButton() {
        LoginPage.LoginForm.submitButton.click();
    }

    public boolean userIconIsDisplayed() {
        return DashboardPage.Header.userName.isDisplayed();
    }

    public OrangeSteps clickUserIcon() {
        DashboardPage.Header.userName.click();
        return this;
    }

    public void clickUserMenu(String text) {
        DashboardPage.Header.topBarUserMenu(text).click();
    }

    public List<String> getTopBarUserMenuItems(){
        return DashboardPage.Header.topBarUserMenuItems.texts().stream()
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.toList());
    }

    public List<String> expectedTopBarUserMenu(){
        return Arrays.stream(UserMenu.values())
                .map(Enum::name).toList();
    }


    public enum PageName {
        Login("auth/login"),
        Dashboard("dashboard/index");

        public final String pagePath;

        PageName(String pagePath) {
            this.pagePath = pagePath;
        }
    }

    public enum UserMenu {
        About,
        Support,
        ChangePassword,
        Logout
    }
}

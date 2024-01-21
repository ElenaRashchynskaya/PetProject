package orange.Tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import orange.Core.Models.LoginUser;
import orange.Steps.OrangeSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {

    @BeforeMethod(onlyForGroups = "AfterLogin")
    public void LoginWithAdmin() {
        OrangeSteps s = new OrangeSteps();
        LoginUser.UserModel user = LoginUser.UserModel.loginUser();
        s.openPage(OrangeSteps.PageName.Login)
                .fillInLoginInput(user.email())
                .fillInPasswordInput(user.password())
                .clickSubmitButton();
    }

    @Test(groups = "smoke")
    public void Login() {
        OrangeSteps s = new OrangeSteps();
        LoginUser.UserModel user = LoginUser.UserModel.loginUser();
        s.openPage(OrangeSteps.PageName.Login)
                .fillInLoginInput(user.email())
                .fillInPasswordInput(user.password())
                .clickSubmitButton();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(WebDriverRunner.url().contains(OrangeSteps.PageName.Dashboard.pagePath), "Dashboard isn't opened");
        sa.assertTrue(s.userIconIsDisplayed(), "User icon isn't displayed");
        sa.assertAll();
    }

    @Test(groups = {"smoke", "AfterLogin"})
    public void Logout() {
        OrangeSteps s = new OrangeSteps();
        s.clickUserIcon().clickUserMenu(OrangeSteps.UserMenu.Logout.name());
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(WebDriverRunner.url().contains(OrangeSteps.PageName.Login.pagePath), "Login page isn't opened");
        sa.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

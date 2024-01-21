package orange.Tests;

import com.codeborne.selenide.Selenide;
import orange.Core.Models.LoginUser;
import orange.Steps.OrangeSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboard {

    @BeforeMethod(groups = "AfterLogin")
    public void LoginWithAdmin(){
        OrangeSteps s = new OrangeSteps();
        LoginUser.UserModel user = LoginUser.UserModel.loginUser();
        s.openPage(OrangeSteps.PageName.Login)
                .fillInLoginInput(user.email())
                .fillInPasswordInput(user.password())
                .clickSubmitButton();
    }

    @Test(groups = {"smoke", "AfterLogin"})
    public void Check_User_Menu(){
        OrangeSteps s = new OrangeSteps();
        s.clickUserIcon();
        Assert.assertEquals(s.getTopBarUserMenuItems(), s.expectedTopBarUserMenu(), "Menu isn't correct.");
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

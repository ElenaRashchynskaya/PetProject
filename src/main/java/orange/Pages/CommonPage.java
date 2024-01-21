package orange.Pages;

import static com.codeborne.selenide.Selenide.open;

public abstract class CommonPage implements Waiter{

    public void navigate(String pageName) {
        open(pageName);
        //Waiter.waitForSpinnerDisappear();
    }
}

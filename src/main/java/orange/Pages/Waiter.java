package orange.Pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public interface Waiter {//todo locators
    static void waitForSpinnerVisible(){
        $("").should(Condition.disappear, Duration.ofSeconds(60));
    }
    static void waitForSpinnerDisappear(){
        $("").should(Condition.disappear, Duration.ofSeconds(360));
    }

    static void waitForDataLoaded(){
        $("").should(Condition.disappear, Duration.ofSeconds(120));
    }

    static void findErrorNotification(){
        $("").should(Condition.visible, Duration.ofSeconds(120));
    }
}

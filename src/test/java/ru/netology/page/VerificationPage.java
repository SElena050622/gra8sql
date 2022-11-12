package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.data.DataHelper;
import ru.netology.test.BankTest;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;

public class VerificationPage {
    @FindBy(css = "[data-test-id=code] input")
    private SelenideElement codeField;
    @FindBy(css = "[data-test-id=action-verify]")
    private SelenideElement verifyButton;
    @FindBy(css = "[data-test-id='error-notification']")
    private SelenideElement errorNotification;

    public void verifyVerificationPageVisiblity() {
        codeField.shouldBe(Condition.visible);
    }

    public void verifyErrorNotificationVisiblity() {
        errorNotification.shouldBe(Condition.visible);
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return page(DashboardPage.class);
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
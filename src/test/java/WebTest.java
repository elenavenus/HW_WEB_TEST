import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest {

    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");
        SelenideElement nameAndSurnameInput = form
                .find("[data-test-id=name]")
                .find("[name=name]");
        nameAndSurnameInput.setValue("Елена Колесникова");
        SelenideElement phoneInput = form
                .find("[data-test-id=phone]")
                .find("[name=phone]");
        phoneInput.setValue("+79062655137");
        SelenideElement agreementInput = form
                .find("[data-test-id=agreement]")
                .find(".checkbox__box");
        agreementInput.click();
        SelenideElement submitButton = form.find(".button_theme_alfa-on-white");
        submitButton.click();
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}

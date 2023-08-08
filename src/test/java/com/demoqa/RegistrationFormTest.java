package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {
    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Salma");
        $("#lastName").setValue("Hayek");
        $("#userEmail").setValue("salmahayek@gmail.com");
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("3366312077");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1966");
        $(".react-datepicker__month-select").selectOptionContainingText("September");
        $(".react-datepicker__day--002").click();

        $("#subjectsInput").setValue("Arts").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();

        $("#uploadPicture").uploadFile(new File("src/test/data/image.png"));
        $("#currentAddress").setValue("Current address");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Salma"),
                text("Hayek"),
                text("salmahayek@gmail.com"),
                text("Female"),
                text("3366312077"),
                text("02 September,1966"),
                text("Arts"),
                text("Music"),
                text("image.png"),
                text("Current address"),
                text("NCR Delhi")
        );

    }

}

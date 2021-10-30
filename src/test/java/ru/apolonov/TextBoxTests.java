package ru.apolonov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true; //развернуть окно браузера на весь экран
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Vasya Pupkin"); //один вариант записи
        $("#userEmail").setValue("test@test.com"); //второй вариант записи
        $("#currentAddress").setValue("Some current address");
        $("#permanentAddress").setValue("Some permanent address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Vasya Pupkin")); //один вариант записи
        $("#output").$("#email").shouldHave(text("test@test.com")); //второй вариант записи
        $("#output #currentAddress").shouldHave(text("Some current address"));
        $("#output #permanentAddress").shouldHave(text("Some permanent address"));

        $("#output").shouldHave(text("Vasya Pupkin"), text("test@test.com"), text("Some current address"), text("Some permanent address"));
    }

}

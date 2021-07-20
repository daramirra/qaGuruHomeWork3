package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com";
        Configuration.startMaximized = true;
    }

    @Test
    void checkPageWhithExampleJUnitCode(){
        //Открыть страницу Selenide в Github
        open("/selenide/selenide");

        //Перейти на вкладку Wiki проекта
        $("[data-content=Wiki]").click();

        //Ввести критерий поиска "SoftAssertions" в поле "Find a Page"
        $("#wiki-pages-filter").setValue("SoftAssertions");

        //Перейти на страницу SoftAssertions
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();

        //На странице SoftAssertions есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));

    }

}

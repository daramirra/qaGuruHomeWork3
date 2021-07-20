package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.startMaximized = true;
    }

    @Test
    void dragRectangleAToLocationB(){
        //Открыть страницу https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");

        //Перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        //Проверить, что прямоугольники поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

}

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.codeborne.selenide.testng.SoftAsserts;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

@Listeners({SoftAsserts.class})
public class SelenideTests {
    public SelenideTests(){
        Configuration.timeout = 5000;
        Configuration.screenshots = true;
        baseUrl="http://the-internet.herokuapp.com";
        reportsFolder = "src/main/resources/Failed";
    }

    @Test
    public void dropdownTest() {
        open(baseUrl + "/dropdown");
        $("select").selectOptionContainingText("tion 2");
        $("select").shouldHave(value("2"));
    }

    @Test
    public void inputTest() {
        open(baseUrl + "/inputs");
        $(By.tagName("input")).setValue("100");
        $(By.tagName("input")).shouldBe(value(""));
    }

}
package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class FirstTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("    beforeAll()");
        Configuration.browser = "chrome";
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll()");
    }

    @BeforeEach
    void beforeEach() {
        open("https://google.com");
        System.out.println("   beforeEach()");
    }

    @Test
    void firstTest() {
        System.out.println("    firstTest()");
        Assertions.assertTrue(3 > 2);

    }

    @Test
    void secondTest() {
        System.out.println("    secondTest()");
        Assertions.assertTrue(3 > 2);

    }

    @Test
    void thirdTest() {
        System.out.println("    thirdTest()");
        Assertions.assertTrue(3 > 2);

    }
}

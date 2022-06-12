package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class GreetingTest {
    public static GreetingPage greetingPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        //определяем путь до драйвера из конфига и настраиваем драйвер
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создаем экземпляра драйвера
        driver = new ChromeDriver();
        greetingPage = new GreetingPage(driver);
        //устанавливаем неявное ожидание элементов страницы в 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получаем ссылку на страницу из конфига
        driver.get(ConfProperties.getProperty("url")); }

    @Test
    public void greetingTest() throws InterruptedException {
        //вставляем имя, указанное в конфиге, в input
        greetingPage.inputName(ConfProperties.getProperty("name"));
        //нажимаем кнопку Отправить
        greetingPage.clickSendBtn();
        //получаем приветствие
        String greeting = greetingPage.getGreeting();
        //сравниваем приветствие с именем из файла настроек
        Assertions.assertEquals("Привет, " + ConfProperties.getProperty("name"), greeting); }

    @AfterAll
    public static void tearDown() {
        //закрываем драйвер
        driver.quit(); } }
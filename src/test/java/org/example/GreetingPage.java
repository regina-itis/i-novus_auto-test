package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class GreetingPage {

    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public GreetingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //определение локатора поля Имя
    @FindBy(xpath = "//*[@id=\"field-undefined-id\"]/div/div[1]/div[1]/input")
    private WebElement nameField;


     // определение локатора кнопки Отправить
    @FindBy(className = "btn")
    private WebElement sendBtn;

    // определение локатора кнопки Отправить
    @FindBy(xpath = "//*[@id=\"n2o\"]/div[1]/section[2]/div/a/div[2]/section")
    private WebElement greeting;

    //метод для ввода логина
    public void inputName(String name) {
        nameField.sendKeys(name);}

    //метод для осуществления нажатия кнопки Отправить
    public void clickSendBtn() {
        sendBtn.click(); }

    //метод для получения приветствия
    public String getGreeting() {
        return greeting.getAttribute("innerText"); }
}


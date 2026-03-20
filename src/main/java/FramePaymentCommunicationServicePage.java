import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class FramePaymentCommunicationServicePage extends OnlineReplenishmentWithoutCommissionPage{

    public FramePaymentCommunicationServicePage(WebDriver driver) {
        super(driver);
    }


    private By framePayment = By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']");
    private By sumPayment = By.xpath("//span[text()='" + (String.format(Locale.ENGLISH, "%.2f", Math.floor(TestValue.sumTest * 100) / 100)) + " BYN']");
    private By SumPaymentButton = By.xpath("//span[text()=' Оплатить  " + (String.format(Locale.ENGLISH, "%.2f", Math.floor(TestValue.sumTest * 100) / 100)) + " BYN ']");
    private By phone = By.xpath("//div[@class = 'pay-description__text']/span");
    private By inputNumberCard = By.xpath("//label[text()='Номер карты']");
    private By inputValidityPeriod = By.xpath("//label[text()='Срок действия']");
    private By inputSurnameCard = By.xpath("//label[text()='Имя и фамилия на карте']");
    private By inputCVC = By.xpath("//label[text()='CVC']");
    private By logoVisa = By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']");
    private By logoMasterCard = By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    private By logoBelkart = By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
    private By logoMaestro = By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']");
    private By logoMir = By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']");


    public void open(){
        driver.get("https://www.mts.by/");
        proceedToPayment(TestValue.phoneTest, TestValue.sumTest);
        driver.switchTo().frame(driver.findElement(framePayment));
    }


    public By getFramePayment() {
        return framePayment;
    }

    public By getSumPayment() {
        return sumPayment;
    }

    public By getSumPaymentButton() {
        return SumPaymentButton;
    }

    public By getPhone() {
        return phone;
    }

    public By getInputNumberCard() {
        return inputNumberCard;
    }

    public By getInputValidityPeriod() {
        return inputValidityPeriod;
    }

    public By getInputSurnameCard() {
        return inputSurnameCard;
    }

    public By getInputCVC() {
        return inputCVC;
    }

    public By getLogoVisa() {
        return logoVisa;
    }

    public By getLogoMasterCard() {
        return logoMasterCard;
    }

    public By getLogoBelkart() {
        return logoBelkart;
    }

    public By getLogoMaestro() {
        return logoMaestro;
    }

    public By getLogoMir() {
        return logoMir;
    }
}

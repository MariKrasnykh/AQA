import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.*;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class FramePaymentCommunicationServiceTest extends BaseTest{

    FramePaymentCommunicationServicePage paymentPage = new FramePaymentCommunicationServicePage(driver);

    @DisplayName("Проверить корректность отображения суммы (в том числе на кнопке)")
    @Test
    public void displaysSum(){
        String sum = String.format(Locale.ENGLISH, "%.2f", Math.floor(TestValue.sumTest * 100) / 100) + " BYN";
        String sumButton = "Оплатить " + String.format(Locale.ENGLISH, "%.2f", Math.floor(TestValue.sumTest * 100) / 100) + " BYN";
        paymentPage.open();
        new WebDriverWait(driver,5).until(ExpectedConditions.textToBePresentInElementLocated(paymentPage.getSumPayment(), (sum)));
        assertAll("summa",
                () -> assertEquals(sum,driver.findElement(paymentPage.getSumPayment()).getText()),
                () -> assertEquals(sumButton, driver.findElement(paymentPage.getSumPaymentButton()).getText()));
    }

    @DisplayName("Проверить корректность отображения номера телефона")
    @Test
    public void displaysPhone(){
        String phone = "Оплата: Услуги связи Номер:" + 375 + TestValue.phoneTest;
        paymentPage.open();
        new WebDriverWait(driver,5).until(ExpectedConditions.textToBePresentInElementLocated(paymentPage.getPhone(), (phone)));
        assertEquals(phone, driver.findElement(paymentPage.getPhone()).getText());
    }

    @DisplayName("Проверить отображение надписей в незаполненных полях для ввода реквизитов карты")
    @Test
    public void placeholderCardDetailsTest(){
        paymentPage.open();
        new WebDriverWait(driver,5).until(ExpectedConditions.textToBePresentInElementLocated(paymentPage.getInputNumberCard(), "Номер карты"));
        assertAll("CardDetails",
                () -> assertEquals("Номер карты", driver.findElement(paymentPage.getInputNumberCard()).getText()),
                () -> assertEquals("Срок действия", driver.findElement(paymentPage.getInputValidityPeriod()).getText()),
                () -> assertEquals("Имя и фамилия на карте", driver.findElement(paymentPage.getInputSurnameCard()).getText()),
                () -> assertEquals("CVC", driver.findElement(paymentPage.getInputCVC()).getText()));
    }

    @DisplayName("Проверить наличие иконок платёжных систем")
    @Test
    public void availabilityLogoTest(){
        paymentPage.open();
        assertAll("Logo",
                () -> assertTrue(findElement(paymentPage.getLogoVisa())),
                () -> assertTrue(findElement(paymentPage.getLogoMasterCard())),
                () -> assertTrue(findElement(paymentPage.getLogoBelkart())),
                () -> assertTrue(findElement(paymentPage.getLogoMaestro())),
                () -> assertTrue(findElement(paymentPage.getLogoMir())));
    }



}

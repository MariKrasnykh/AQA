import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class OnlineReplenishmentWithoutCommissionTest extends BaseTest {

    OnlineReplenishmentWithoutCommissionPage replenishmentPage = new OnlineReplenishmentWithoutCommissionPage(driver);

    @DisplayName("Проверить название блока 'Онлайн пополнение без комиссии'")
    @Test
    public void titleTest(){
        replenishmentPage.open();
        assertEquals("Онлайн пополнение\nбез комиссии",
                driver.findElement(replenishmentPage.getTitlePage()).getText());
    }

    @DisplayName("Проверить наличие логотипов платёжных систем")
    @Test
    public void availabilityLogoTest(){
        replenishmentPage.open();
        assertAll("Logo",
                () -> assertTrue(findElement(replenishmentPage.getLogoVisa())),
                () -> assertTrue(findElement(replenishmentPage.getLogoVerifiedByVisa())),
                () -> assertTrue(findElement(replenishmentPage.getLogoMasterCard())),
                () -> assertTrue(findElement(replenishmentPage.getLogoMasterCardSecureCode())),
                () -> assertTrue(findElement(replenishmentPage.getLogoBelkart())));
    }

    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    @Test
    public void linkTest(){
        replenishmentPage.open();
        driver.findElement(replenishmentPage.getLink()).click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
    }

    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить» (вариант «Услуги связи», номер - 297777777)")
    @Test
    public void  buttonContinueTest(){
        replenishmentPage.open();
        replenishmentPage.proceedToPayment(TestValue.phoneTest,TestValue.sumTest);
        assertTrue(findElement(replenishmentPage.getFramePayment()));
    }

    @DisplayName("Проверить надписи в незаполненных полях для варианта оплаты - услуги связи")
    @Test
    public void placeholderCommunicationServiceTest(){
        replenishmentPage.open();
        assertAll("CommunicationService",
                () -> assertEquals("Номер телефона", findPlaceholder(replenishmentPage.getInputPhone())),
                () -> assertEquals("Сумма", findPlaceholder(replenishmentPage.getInputSum())),
                () -> assertEquals("E-mail для отправки чека", findPlaceholder(replenishmentPage.getInputEmail())));
    }

    @DisplayName("Проверить надписи в незаполненных полях для варианта оплаты - домашний интернет")
    @Test
    public void placeholderHomeInternetTest(){
        replenishmentPage.open();
        assertAll("CommunicationService",
                () -> assertEquals("Номер абонента", findPlaceholder(replenishmentPage.getInputInternetPhone())),
                () -> assertEquals("Сумма", findPlaceholder(replenishmentPage.getInputInternetSum())),
                () -> assertEquals("E-mail для отправки чека", findPlaceholder(replenishmentPage.getInputInternetEmail())));
    }

    @DisplayName("Проверить надписи в незаполненных полях для варианта оплаты - рассрочка")
    @Test
    public void placeholderInstalmentTest(){
        replenishmentPage.open();
        assertAll("CommunicationService",
                () -> assertEquals("Номер счета на 44", findPlaceholder(replenishmentPage.getInputInstalmentAccountNumber())),
                () -> assertEquals("Сумма", findPlaceholder(replenishmentPage.getInputInstalmentSum())),
                () -> assertEquals("E-mail для отправки чека", findPlaceholder(replenishmentPage.getInputInstalmentEmail())));
    }

    @DisplayName("Проверить надписи в незаполненных полях для варианта оплаты - задолженность")
    @Test
    public void placeholderArrearsTest(){
        replenishmentPage.open();
        assertAll("CommunicationService",
                () -> assertEquals("Номер счета на 2073", findPlaceholder(replenishmentPage.getInputArrearsAccountNumber())),
                () -> assertEquals("Сумма", findPlaceholder(replenishmentPage.getInputArrearsSum())),
                () -> assertEquals("E-mail для отправки чека", findPlaceholder(replenishmentPage.getInputArrearsEmail())));
    }

}

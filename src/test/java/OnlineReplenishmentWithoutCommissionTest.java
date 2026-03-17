import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class OnlineReplenishmentWithoutCommissionTest {

    WebDriver driver;
    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
    }

   @AfterEach
   void teardown() {
        driver.quit();
    }

    @DisplayName("Проверить название блока 'Онлайн пополнение без комиссии'")
    @Test
    public void titleTest(){
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии",
                driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']")).getText());
    }

    public boolean findElement(String locator){
        try {   driver.findElement(By.xpath(locator));  }
        catch (NoSuchElementException e)
        {   return false;   }
        return true;
    }

    @DisplayName("Проверить наличие логотипов платёжных систем")
    @Test
    public void availabilityLogoTest(){
        Assertions.assertAll("",
                () -> Assertions.assertTrue(findElement("//img[@alt='Visa']")),
                () -> Assertions.assertTrue(findElement("//img[@alt='Verified By Visa']")),
                () -> Assertions.assertTrue(findElement("//img[@alt='MasterCard']")),
                () -> Assertions.assertTrue(findElement("//img[@alt='MasterCard Secure Code']")),
                () -> Assertions.assertTrue(findElement("//img[@alt='Белкарт']")));

    }

    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    @Test
    public void linkTest(){
        driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']")).click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
    }

    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить» (вариант «Услуги связи», номер - 297777777)")
    @Test
    public void  buttonContinueTest(){
        driver.findElement(By.xpath("//input[@id='connection-phone']")).click();
        driver.findElement(By.xpath("//input[@id='connection-phone']")).sendKeys("297777777");
        driver.findElement(By.xpath("//input[@id='connection-sum']")).click();
        driver.findElement(By.xpath("//input[@id='connection-sum']")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        Assertions.assertTrue(findElement("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']"));
    }


}

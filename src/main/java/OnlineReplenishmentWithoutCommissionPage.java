import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlineReplenishmentWithoutCommissionPage extends BasePage{

    public OnlineReplenishmentWithoutCommissionPage(WebDriver driver){
        super(driver);
    }

    private By titlePage = By.xpath("//h2[text()='Онлайн пополнение ']");
    private By logoVisa = By.xpath("//img[@alt='Visa']");
    private By logoVerifiedByVisa = By.xpath("//img[@alt='Verified By Visa']");
    private By logoMasterCard = By.xpath("//img[@alt='MasterCard']");
    private By logoMasterCardSecureCode = By.xpath("//img[@alt='MasterCard Secure Code']");
    private By logoBelkart = By.xpath("//img[@alt='Белкарт']");
    private By link = By.xpath("//a[text()='Подробнее о сервисе']");
    private By inputPhone = By.xpath("//input[@id='connection-phone']");
    private By inputSum = By.xpath("//input[@id='connection-sum']");
    private By inputEmail = By.xpath("//input[@id='connection-email']");
    private By buttonContinue = By.xpath("//*[@id='pay-connection']/button");
    private By inputInternetPhone = By.xpath("//input[@id='internet-phone']");
    private By inputInternetSum = By.xpath("//input[@id='internet-sum']");
    private By inputInternetEmail = By.xpath("//input[@id='internet-email']");
    private By inputInstalmentAccountNumber = By.xpath("//input[@id='score-instalment']");
    private By inputInstalmentSum = By.xpath("//input[@id='instalment-sum']");
    private By inputInstalmentEmail = By.xpath("//input[@id='instalment-email']");
    private By inputArrearsAccountNumber = By.xpath("//input[@id='score-arrears']");
    private By inputArrearsSum = By.xpath("//input[@id='arrears-sum']");
    private By inputArrearsEmail = By.xpath("//input[@id='arrears-email']");
    private By framePayment = By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']");



    public void open(){
        driver.get("https://www.mts.by/");
    }

    public void proceedToPayment(String phone, float summa){
        driver.findElement(inputPhone).click();
        driver.findElement(inputPhone).sendKeys(phone);
        driver.findElement(inputSum).click();
        driver.findElement(inputSum).sendKeys(Float.toString(summa));
        driver.findElement(buttonContinue).click();
    }


    public By getTitlePage() {
        return titlePage;
    }

    public By getLogoVisa() {
        return logoVisa;
    }

    public By getLogoVerifiedByVisa() {
        return logoVerifiedByVisa;
    }

    public By getLogoMasterCard() {
        return logoMasterCard;
    }

    public By getLogoMasterCardSecureCode() {
        return logoMasterCardSecureCode;
    }

    public By getLogoBelkart() {
        return logoBelkart;
    }

    public By getLink() {
        return link;
    }

    public By getInputPhone() {
        return inputPhone;
    }

    public By getInputSum() {
        return inputSum;
    }

    public By getInputEmail() {
        return inputEmail;
    }

    public By getInputInternetPhone() {
        return inputInternetPhone;
    }

    public By getInputInternetSum() {
        return inputInternetSum;
    }

    public By getInputInternetEmail() {
        return inputInternetEmail;
    }

    public By getInputInstalmentAccountNumber() {
        return inputInstalmentAccountNumber;
    }

    public By getInputInstalmentSum() {
        return inputInstalmentSum;
    }

    public By getInputInstalmentEmail() {
        return inputInstalmentEmail;
    }

    public By getInputArrearsAccountNumber() {
        return inputArrearsAccountNumber;
    }

    public By getInputArrearsSum() {
        return inputArrearsSum;
    }

    public By getInputArrearsEmail() {
        return inputArrearsEmail;
    }

    public By getFramePayment() {
        return framePayment;
    }
}

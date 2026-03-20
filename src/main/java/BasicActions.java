import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasicActions {

    public static WebDriver setupDriver(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;


public class BaseTest {
    protected static WebDriver driver = BasicActions.setupDriver();

    @AfterAll
    static void teardown(){
        driver.quit();
    }

    public boolean findElement(By locator){
        try {   driver.findElement(locator);  }
        catch (NoSuchElementException e)
        {   return false;   }
        return true;
    }

    public String findPlaceholder(By locator){
        return driver.findElement(locator).getAttribute("placeholder");
    }


}

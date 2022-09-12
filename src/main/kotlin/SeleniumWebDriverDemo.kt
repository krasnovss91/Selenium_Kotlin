import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.Assertions
import org.junit.Test
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.chrome.ChromeDriver

class SeleniumWebDriverDemo {

    @Test
    fun fillFormTest(){

        WebDriverManager.chromedriver().setup()
        val driver = ChromeDriver()

        driver.get("https://demoqa.com/automation-practice-form")
        driver.manage().window().maximize()


        driver.findElement(cssSelector("[id='firstName']")).sendKeys("Petr");
        driver.findElement(cssSelector("[id='lastName']")).sendKeys("Petrov");
        driver.findElement(cssSelector("[id='userNumber']")).sendKeys("1234567898");
        driver.findElement(cssSelector("[for='gender-radio-1']")).click();
        driver.findElement(cssSelector("[id='submit']")).click();

        Assertions.assertTrue(driver.findElement(cssSelector("[id='example-modal-sizes-title-lg']")).isDisplayed)

        Thread.sleep(3000)

        driver.quit()
    }
}
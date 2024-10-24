package puj.web.clinicahaven.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PetDetailTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions cromeOptions = new ChromeOptions();

        cromeOptions.addArguments("--disable-notifications");
        cromeOptions.addArguments("--disable-extentions");
        //cromeOptions.addArguments("--headless");

        this.driver = new ChromeDriver(cromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void SystemTest_PetDetail_PetName() {
        driver.get("http://localhost:4200/Mascotas/informacion/2");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-informacion-mascota/main/div/div/div/div[2]/div[1]/h3")));
        WebElement petName = driver.findElement(By.xpath("/html/body/app-root/app-informacion-mascota/main/div/div/div/div[2]/div[1]/h3"));

        String expected = "Trufa";
        Assertions.assertThat(petName.getText()).isEqualTo(expected);


    }
}

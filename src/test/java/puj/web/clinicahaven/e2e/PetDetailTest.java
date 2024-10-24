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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //indica el puerto con el que se hara el test
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) //indica que se hara antes de cada prueba
public class PetDetailTest {

    private final String BASE_URL = "http://localhost:4200";

    private WebDriver driver; //llena los formularios
    private WebDriverWait wait;

    @BeforeEach   //para inicializar ciertas configuraciones para los tests en chrome
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions cromeOptions = new ChromeOptions();

        cromeOptions.addArguments("--disable-notifications");   //desactiva las notificaciones
        cromeOptions.addArguments("--disable-extensions");         //desactiva las extensiones
        //cromeOptions.addArguments("--headless");              //es util para correr las pruebas sin interfas graficas 

        this.driver = new ChromeDriver(cromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));   //espera maximo 10 segundos hasta que la maquina corra para continuar
    }

    @Test
    public void SystemTest_PetDetail_PetName() {
        driver.get(BASE_URL +"/Mascotas/informacion/2");//lanza la url(html) en el navegador

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-informacion-mascota/main/div/div/div/div[2]/div[1]/h3"))); //Espera hasta que el elemento sea visible no continua
        WebElement petName = driver.findElement(By.xpath("/html/body/app-root/app-informacion-mascota/main/div/div/div/div[2]/div[1]/h3"));

        String expected = "Trufa";
        Assertions.assertThat(petName.getText()).isEqualTo(expected);//verifica que el nombre de la mascota sea Trufa(expected)


    }
}

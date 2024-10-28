package puj.web.clinicahaven.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import java.time.Duration;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //indica el puerto con el que se hara el test
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) //indica que se hara antes de cada prueba
public class UseCaseTest1 {

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

    //Caso 1 Codigo intento solo clickear el boton iniciar sesion
    @Test
    public void SystemTest_VerMascotas() {
        driver.get(BASE_URL);
    
        // 1. Iniciar Sesion incorrectamente
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LogIn")));
        WebElement btnLogIn = driver.findElement(By.id("LogIn"));
        btnLogIn.click();
    
       }


    @AfterEach
    void tearDown() {
           // driver.quit();
    }
}

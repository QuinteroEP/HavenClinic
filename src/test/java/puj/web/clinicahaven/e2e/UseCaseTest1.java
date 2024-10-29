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
    
        
        // Esperar a que el popup aparezca
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Loginemail")));
    
        // inicio incorrecto/info incorrecta
        WebElement inputLoginCorreo = driver.findElement(By.id("Loginemail"));
        inputLoginCorreo.sendKeys("qwasdfge@m.c");
    
        WebElement inputLoginpass = driver.findElement(By.id("Loginpsw"));
        inputLoginpass.sendKeys("abdefrtgyhuc");
    
        //  checkbox
        WebElement checkBox = driver.findElement(By.id("check-box"));
        checkBox.click();
    
        // Attempt to log in/incorrectamente
        WebElement btnLoginCuenta = driver.findElement(By.id("cancel"));
        btnLoginCuenta.click();
    
        /*
    
        // 2. Iniciar Sesion correctamente
        // Clear the previous inputs
        inputLoginCorreo.clear();
        inputLoginpass.clear();
    
        // informacion correcta
        inputLoginCorreo.sendKeys("qwe@m.c");
        inputLoginpass.sendKeys("abc");
    
        // Attempt to log in again
        btnLoginCuenta.click();
    
        // verificar login
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id())); // Replace with an element that appears after successful login
    */

    //2. inciar sesion correctamente
    //desplegar popup
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LogIn")));
    WebElement btnLogIn2 = driver.findElement(By.id("LogIn"));
    btnLogIn2.click();

    // Esperar a que el popup aparezca
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Loginemail")));
    
    // inicio incorrecto/info incorrecta
    WebElement inputLoginCorreo2 = driver.findElement(By.id("Loginemail"));
    inputLoginCorreo2.sendKeys("qwe@m.c");

    WebElement inputLoginpass2 = driver.findElement(By.id("Loginpsw"));
    inputLoginpass2.sendKeys("abc");

    //  checkbox
    WebElement checkBox2 = driver.findElement(By.id("check-box"));
    checkBox2.click();

    // Attempt to log in/correctamente
    WebElement btnLoginCuentaCorrecta = driver.findElement(By.id("btnloginCuenta"));
    btnLoginCuentaCorrecta.click();

    //3.ingresar nuevo cliente
    //entrar a lista de clientes

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnlistaClientes")));
    WebElement btnListaClientes = driver.findElement(By.id("btnlistaClientes"));
    btnListaClientes.click();

    //entrar a forms agregar un nuevo cliente

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregarCliente")));
    WebElement btnAgregarCliente = driver.findElement(By.id("btnagregarCliente"));
    btnAgregarCliente.click();

     // Llenar informacion nuevo cliente
     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));

     WebElement inputNameCliente = driver.findElement(By.id("name"));
     inputNameCliente.sendKeys("Juan Perez");
 
     WebElement inputCedulaCliente = driver.findElement(By.id("cedula"));
     inputCedulaCliente.sendKeys(Keys.BACK_SPACE);
     inputCedulaCliente.sendKeys("98765");
 
     WebElement inputCelularCliente = driver.findElement(By.id("celular"));
     inputCelularCliente.sendKeys(Keys.BACK_SPACE);
     inputCelularCliente.sendKeys("987654");
 
     WebElement inputCorreoCliente = driver.findElement(By.id("correo"));
     inputCorreoCliente.sendKeys("juan.perez@example.com");
 
     WebElement inputContrasenaCliente = driver.findElement(By.id("contrasena"));
     inputContrasenaCliente.sendKeys("password123");
 
     // Submit the form
     WebElement submitButton = driver.findElement(By.id("SubmitCliente"));
     submitButton.click();
 
    //4. Agregar una mascota nueva asociandola al nuevo cliente

    //entrar al forms agregar nueva mascota
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregarMascota")));
    WebElement btnagregarMascota = driver.findElement(By.id("btnagregarMascota"));
    btnagregarMascota.click();

    // Llenar informacion nueva mascota
        // Fill out the form
        WebElement inputName = driver.findElement(By.id("name"));
        inputName.sendKeys("Firulais");
    
        WebElement inputAge = driver.findElement(By.id("age"));
        inputAge.sendKeys("5");
    
        WebElement inputBreed = driver.findElement(By.id("breed"));
        inputBreed.sendKeys("Labrador");
    
        WebElement inputCedulaDueno = driver.findElement(By.id("cedulaDueno"));
        inputCedulaDueno.sendKeys(Keys.BACK_SPACE);
        inputCedulaDueno.sendKeys("98765");
    
        WebElement inputGender = driver.findElement(By.id("gender"));
        inputGender.sendKeys("Macho");
    
        WebElement inputCondition = driver.findElement(By.id("condition"));
        inputCondition.sendKeys("Sano");
    
        WebElement inputDescription = driver.findElement(By.id("description"));
        inputDescription.sendKeys("Muy amigable");
    
        WebElement inputUrl = driver.findElement(By.id("url"));
        inputUrl.sendKeys("http://example.com/firulais.jpg");

        // Submit the form
            // Submit the form      // Wait until the button is clickable
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitMascotaBtn")));
    WebElement submitButtonMascota = driver.findElement(By.id("submitMascotaBtn"));
    submitButtonMascota.click();

//5.El cliente verifica que se realizo correctamente el inicio de sesion
//salir de la sesion de veterinario
wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCerrarSesion")));
WebElement btnCerrarSesion = driver.findElement(By.id("btnCerrarSesion"));
btnCerrarSesion.click();





       }


    @AfterEach
    void tearDown() {
           // driver.quit();
    }
}

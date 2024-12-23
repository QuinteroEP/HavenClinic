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
    public void SystemTest_VerMascotas() throws InterruptedException {
        driver.get(BASE_URL);
    
        // 1. Iniciar Sesion incorrectamente
    // 1. Iniciar Sesion incorrectamente
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LogIn")));
    WebElement btnLogIn = driver.findElement(By.id("LogIn"));

    // Scroll to the button to ensure it is in view
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnLogIn);
    Thread.sleep(500);

    // Wait until the button is clickable
    wait.until(ExpectedConditions.elementToBeClickable(btnLogIn));

    // Click the login button
    btnLogIn.click();
        
        // Esperar a que el popup aparezca
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cancel")));
    
        // inicio incorrecto/info incorrecta
        WebElement inputLoginCorreo = driver.findElement(By.id("Loginemail"));
        inputLoginCorreo.sendKeys("qwasdfge@m.c");
    
        WebElement inputLoginpass = driver.findElement(By.id("Loginpsw"));
        inputLoginpass.sendKeys("abdefrtgyhuc");
    
        //  checkbox
        WebElement checkBox = driver.findElement(By.id("checkVeterinario"));
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

     /*   //  checkbox
        WebElement checkBox2 = driver.findElement(By.id("checkVeterinario"));
        checkBox2.click();*/

    // Attempt to log in/correctamente
    WebElement btnLoginCuentaCorrecta = driver.findElement(By.id("btnloginCuenta"));
    btnLoginCuentaCorrecta.click();

    //3.ingresar nuevo cliente
    //entrar a lista de clientes

    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Lista de Clientes")));
    WebElement btnListaClientes = driver.findElement((By.linkText("Lista de Clientes")));
    btnListaClientes.click();

    //entrar a forms agregar un nuevo cliente

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregarCliente")));
    WebElement btnAgregarCliente = driver.findElement(By.id("btnAgregarCliente"));

    // Scroll to the button to ensure it is in view
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnAgregarCliente);
    Thread.sleep(1500);

    // Wait until the button is clickable
    wait.until(ExpectedConditions.elementToBeClickable(btnAgregarCliente));

    // Click the "Agregar Cliente" button
    btnAgregarCliente.click();

     // Llenar informacion nuevo cliente
     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));

     WebElement inputNameCliente = driver.findElement(By.id("name"));
     inputNameCliente.sendKeys("Juancho Perez");
 
     WebElement inputCedulaCliente = driver.findElement(By.id("cedula"));
     inputCedulaCliente.sendKeys(Keys.BACK_SPACE);
     inputCedulaCliente.sendKeys("9876565");
 
     WebElement inputCelularCliente = driver.findElement(By.id("celular"));
     inputCelularCliente.sendKeys(Keys.BACK_SPACE);
     inputCelularCliente.sendKeys("9874654");
 
     WebElement inputCorreoCliente = driver.findElement(By.id("correo"));
     inputCorreoCliente.sendKeys("juanperezprueba@example.com");
 
     WebElement inputContrasenaCliente = driver.findElement(By.id("contrasena"));
     inputContrasenaCliente.sendKeys("password123j");
 
     // Submit the form
     WebElement submitButton = driver.findElement(By.id("SubmitCliente"));
     submitButton.click();
 
    //4. Agregar una mascota nueva asociandola al nuevo cliente

    //entrar al forms agregar nueva mascota
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Añadir Mascota")));
    WebElement btnagregarMascota = driver.findElement(By.linkText("Añadir Mascota"));
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
        inputCedulaDueno.sendKeys("9876565");
    
        WebElement inputGender = driver.findElement(By.id("gender"));
        inputGender.sendKeys("Macho");
    
        WebElement inputCondition = driver.findElement(By.id("condition"));
        inputCondition.sendKeys("Sano");
    
        WebElement inputDescription = driver.findElement(By.id("description"));
        inputDescription.sendKeys("Muy amigable");
    
        WebElement inputUrl = driver.findElement(By.id("url"));
        inputUrl.sendKeys("http://example.com/firulais.jpg");

        // Submit the form
                // Wait until the "Submit Mascota" button is present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitMascotaBtn")));
        WebElement submitButtonMascota = driver.findElement(By.id("submitMascotaBtn"));

        // Scroll to the button to ensure it is in view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButtonMascota);
        Thread.sleep(500);

        // Wait until the button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonMascota));

        // Click the "Submit Mascota" button
        submitButtonMascota.click();
    //5.El cliente verifica que se realizo correctamente el inicio de sesion

    //5.1 inicio sesion cliente

    //salir de la sesion de veterinario
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Cerrar Sesion")));
    WebElement btnCerrarSesion = driver.findElement(By.linkText("Cerrar Sesion"));
    btnCerrarSesion.click();

      // 1. Iniciar Sesion cliente
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LogIn")));
      WebElement btnLogInCliente = driver.findElement(By.id("LogIn"));
  
      // Scroll to the button to ensure it is in view
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnLogInCliente);
      Thread.sleep(500);
  
      // Wait until the button is clickable
      wait.until(ExpectedConditions.elementToBeClickable(btnLogInCliente));
  
      // Click the login button
      btnLogInCliente.click();

    
    // Esperar a que el popup aparezca
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Loginemail")));

    // inicio sesion con cliente
    WebElement inputLoginCorreoCliente = driver.findElement(By.id("Loginemail"));
    inputLoginCorreoCliente.sendKeys("juanperezprueba@example.com");

    WebElement inputLoginpassCliente = driver.findElement(By.id("Loginpsw"));
    inputLoginpassCliente.sendKeys("password123j");
    //click iniciar sesion
    // Attempt to log in/correctamente
    WebElement btnLoginCuentaCliente = driver.findElement(By.id("btnloginCuenta"));
    btnLoginCuentaCliente.click();

    //5.2ver mascotas del cliente
    //entrar a ver mis mascotas
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Mis Mascotas")));
    WebElement btnVerMisMascotas = driver.findElement(By.linkText("Mis Mascotas"));
    btnVerMisMascotas.click();

    //ver la mascota ->FIN
    






       }


    @AfterEach
    void tearDown() {
           // driver.quit();
    }
}

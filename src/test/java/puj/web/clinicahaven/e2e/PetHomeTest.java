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
public class PetHomeTest {

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

    //Ver si esta  mostrando toda la informacion
    @Test
    public void SystemTest_VerMascotas() {
        driver.get(BASE_URL + "/Mascotas/all?userType=veterinario&correo=qwe@m.c");
        
    

    }

//eliminar un estudiante
    @Test
    public void HomeTest_deleteStudent_listSize(){
        driver.get(BASE_URL +"/Mascotas/all?userType=veterinario&correo=qwe@m.c");

        String path =  "/html/body/app-root/app-tabla-mascota/div[2]/table/tbody/tr[1]/td[6]/button[1]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));     //espera hasta que lleguen los datos:
        WebElement btnElement = driver.findElement(By.xpath(path));
        btnElement.click();

        List<WebElement> list = driver.findElements(By.className("btn-danger"));
        Assertions.assertThat(list.size()).isEqualTo(101);

    }

    //Eliminar todas las entidades//es decir una lista vacia
    @Test
    public void HomeTest_deleteStudent_lEmptylist (){
        driver.get(BASE_URL +"/Mascotas/all?userType=veterinario&correo=qwe@m.c");

        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-danger")));     //espera hasta que lleguen los datos:
        List<WebElement> allButtons = driver.findElements(By.className("btn-danger"));

        for (WebElement button : allButtons) {
            button.click();
            
        }
    

        List<WebElement> list = driver.findElements(By.className("btn-danger"));
        Assertions.assertThat(list.size()).isEqualTo(0);

    }


    //agregar una nueva mascota
@Test
public void HomeTest_addStudent_listSize() {
    driver.get(BASE_URL + "/Mascotas/all?userType=veterinario&correo=qwe@m.c");
    
    // Wait until the "Registrar Nueva Mascota" button is present
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-agregar")));
    WebElement btnAgregar = driver.findElement(By.id("btn-agregar"));
    btnAgregar.click();
    
    
    // Wait until the form is present
    //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
    
    // Fill out the form
    WebElement inputName = driver.findElement(By.id("name"));
    inputName.sendKeys("Firulais");

    WebElement inputAge = driver.findElement(By.id("age"));
    inputAge.sendKeys("5");

    WebElement inputBreed = driver.findElement(By.id("breed"));
    inputBreed.sendKeys("Labrador");

    WebElement inputCedulaDueno = driver.findElement(By.id("cedulaDueno"));
        inputCedulaDueno.sendKeys(Keys.BACK_SPACE);
        inputCedulaDueno.sendKeys("123");

    WebElement inputGender = driver.findElement(By.id("gender"));
    inputGender.sendKeys("Macho");

    WebElement inputCondition = driver.findElement(By.id("condition"));
    inputCondition.sendKeys("Sano");

    WebElement inputDescription = driver.findElement(By.id("description"));
    inputDescription.sendKeys("Muy amigable");

    WebElement inputUrl = driver.findElement(By.id("url"));
    inputUrl.sendKeys("http://example.com/firulais.jpg");

    // Submit the form      // Wait until the button is clickable
    ///wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitMascotaBtn")));
    WebElement submitButton = driver.findElement(By.id("submitMascotaBtn"));
    submitButton.click();

    List<WebElement> list = driver.findElements(By.className("liStudentName"));
    Assertions.assertThat(list.size()).isEqualTo(103);
}

//CAS DE USO
//agregar una mascota y ver los detalles de esa mascota
@Test
public void HomeTest_addStudent_petName(){

    //1. GREGAR UNA MASCOTA

    driver.get(BASE_URL + "/Mascotas/all?userType=veterinario&correo=qwe@m.c");

    // Wait until the "Registrar Nueva Mascota" button is present
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-agregar")));
    WebElement btnAgregar = driver.findElement(By.id("btn-agregar"));
    btnAgregar.click();
    
    
    // Wait until the form is present
    //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
    
    // Fill out the form
    WebElement inputName = driver.findElement(By.id("name"));
    inputName.sendKeys("Firulais");

    WebElement inputAge = driver.findElement(By.id("age"));
    inputAge.sendKeys("5");

    WebElement inputBreed = driver.findElement(By.id("breed"));
    inputBreed.sendKeys("Labrador");

    WebElement inputCedulaDueno = driver.findElement(By.id("cedulaDueno"));
    inputCedulaDueno.sendKeys(Keys.BACK_SPACE);
    inputCedulaDueno.sendKeys("123");

    WebElement inputGender = driver.findElement(By.id("gender"));
    inputGender.sendKeys("Macho");

    WebElement inputCondition = driver.findElement(By.id("condition"));
    inputCondition.sendKeys("Sano");

    WebElement inputDescription = driver.findElement(By.id("description"));
    inputDescription.sendKeys("Muy amigable");

    WebElement inputUrl = driver.findElement(By.id("url"));
    inputUrl.sendKeys("http://example.com/firulais.jpg");

    // Submit the form      // Wait until the button is clickable
    //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitMascotaBtn")));
    WebElement submitButton = driver.findElement(By.id("submitMascotaBtn"));
    submitButton.click();

    List<WebElement> list = driver.findElements(By.className("btn-danger"));
    Assertions.assertThat(list.size()).isEqualTo(102);

    List<WebElement> allButtonsInfo = driver.findElements(By.className("info-button"));
    allButtonsInfo.get(allButtonsInfo.size()-1).click(); 
    
    //2. ver detalles de la mascota que agregue en este caso esta al final de la lista
// Submit the form      // Wait until the button is clickable
///wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitMascotaBtn")));
String idinfo=  "nombreMascotaInfo";
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idinfo))); //Espera hasta que el elemento sea visible no continua
WebElement petName = driver.findElement(By.id(idinfo));

String expected = "Firulais";
Assertions.assertThat(petName.getText()).isEqualTo(expected);//verifica que el nombre de la mascota sea Trufa(expected)


}

    @AfterEach
    void tearDown() {
           // driver.quit();
    }
}

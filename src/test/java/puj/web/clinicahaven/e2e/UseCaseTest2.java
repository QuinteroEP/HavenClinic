package puj.web.clinicahaven.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
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

public class UseCaseTest2 {
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
    public void testVeterinarianAdministersNewMedication() {
        driver.get(BASE_URL + "/Mascotas/all?userType=veterinario&correo=qwe@m.c");

        // Step 1: Search for the pet
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-box")));
        searchBox.sendKeys("Moira");
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();

        // Step 2: Select the pet
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("info-button")));
        WebElement infoButton = driver.findElement(By.id("info-button"));
        infoButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ATbutton")));
        WebElement administerTreatmentButton = driver.findElement(By.id("ATbutton"));
        administerTreatmentButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Gbutton")));
        WebElement generateTreatmentButton = driver.findElement(By.id("Gbutton"));
        generateTreatmentButton.click();

        // Step 3: Select treatment and save
        WebElement treatmentDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombreDroga")));
        treatmentDropdown.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nombreDroga\"]/option[2]")));
        WebElement treatmentOption = driver.findElement(By.xpath("//*[@id=\"nombreDroga\"]/option[2]"));
        treatmentOption.click();
        WebElement saveButton = driver.findElement(By.id("AT2button"));
        saveButton.click();

        // Step 4: Verify the new treatment is saved correctly
        WebElement searchBox2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-box")));
        searchBox2.sendKeys("Moira");
        WebElement searchButton2 = driver.findElement(By.id("search-button"));
        searchButton2.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("info-button")));
        WebElement infoButton2 = driver.findElement(By.id("info-button"));
        infoButton2.click();

        WebElement treatmentDetails = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("droga-treatment")));
        Assertions.assertThat(treatmentDetails.getText()).contains("ACTIONIS");
/*
        // Step 5: Verify quantity sold and earnings
        driver.get(BASE_URL + "/dashboard");
        WebElement quantitySold = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("quantity-sold")));
        int initialQuantitySold = Integer.parseInt(quantitySold.getText());
        WebElement earnings = driver.findElement(By.id("earnings"));
        double initialEarnings = Double.parseDouble(earnings.getText());

        // Re-enter the dashboard to verify changes
        driver.get(BASE_URL + "/dashboard");
        quantitySold = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("quantity-sold")));
        int finalQuantitySold = Integer.parseInt(quantitySold.getText());
        earnings = driver.findElement(By.id("earnings"));
        double finalEarnings = Double.parseDouble(earnings.getText());

        Assertions.assertThat(finalQuantitySold).isEqualTo(initialQuantitySold + 1);
        Assertions.assertThat(finalEarnings).isGreaterThan(initialEarnings);*/
    }
    @AfterEach
    void tearDown() {
        // driver.quit();
    }

}

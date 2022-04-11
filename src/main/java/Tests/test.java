package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ecm9980a\\Desktop\\installationProyect\\Project\\src\\main\\resources\\drivers\\chromedriver.exe");

        //Inicializar driver
        WebDriver driver = new ChromeDriver();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Abrir el sitio web
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");


        //Maximizar la pagina
        driver.manage().window().maximize();

        //Localizador By.
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector(".button:nth-child(1)")).click();
        driver.findElement(By.linkText("12789")).click();
        driver.findElement(By.id("month")).click();

        ///Filtrar Activity period
        {
            Select oldStyleMenu = new Select(driver.findElement(By.id("month")));
            oldStyleMenu.selectByIndex(3);

        }
        //Filtrar Type
        {
            Select oldStyleMenu = new Select(driver.findElement(By.id("transactionType")));
            oldStyleMenu.selectByValue("Credit");

        }
        driver.findElement(By.linkText("Funds Transfer Received")).click();
        driver.findElement(By.linkText("Log Out")).click();


    }
}

package CodigoSemRefatoracao;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampoDeTreinamentoAlerts {

    @Test
    public void validarAlertSimples(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("alert")).click();
        Alert alerta = chrome.switchTo().alert();

        Assert.assertEquals("Alert Simples", alerta.getText());
        alerta.accept();
        chrome.quit();
    }

    @Test
    public void validarAlertConfirmar(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("confirm")).click();
        Alert alerta = chrome.switchTo().alert();

        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();
        Assert.assertEquals("Confirmado", alerta.getText());
        alerta.accept();
    }

    @Test
    public void validarAlertConfirmarNegativo(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("confirm")).click();
        Alert alerta = chrome.switchTo().alert();

        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.dismiss();
        Assert.assertEquals("Negado", alerta.getText());
        alerta.accept();
        chrome.quit();
    }

    @Test
    public void validarAlertPrompt(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("prompt")).click();
        Alert alerta = chrome.switchTo().alert();
        alerta.sendKeys("Testando alerta");
        alerta.accept();
        Assert.assertEquals("Era Testando alerta?", alerta.getText());
        alerta.accept();
        Assert.assertEquals(":D", alerta.getText());
        alerta.accept();
        chrome.quit();
    }
}

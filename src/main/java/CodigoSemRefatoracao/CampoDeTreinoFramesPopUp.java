package CodigoSemRefatoracao;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampoDeTreinoFramesPopUp {

    @Test
    public void validarCampoFrame(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.switchTo().frame("frame1");
        chrome.findElement(By.id("frameButton")).click();
        Alert alert = chrome.switchTo().alert();
        String mensagem = alert.getText();

        Assert.assertEquals("Frame OK!", alert.getText());
        alert.accept();
        chrome.switchTo().defaultContent();
        chrome.findElement(By.id("elementosForm:nome")).sendKeys(mensagem);
        Assert.assertEquals("Frame OK!", chrome.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        chrome.quit();
    }

    @Test
    public void validarCampoPopUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        chrome.findElement(By.id("buttonPopUpEasy")).click();
        chrome.switchTo().window("Popup");
        chrome.findElement(By.tagName("textarea")).sendKeys("Testando");
        chrome.close();
        chrome.switchTo().window("");
        chrome.findElement(By.tagName("textarea")).sendKeys("Testando");

        Assert.assertEquals("Testando", chrome.findElement(By.tagName("textarea")).getAttribute("value"));

    }
}

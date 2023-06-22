import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampoDeTreinamento {
    @Test
    public  void testeCampoDeInputTexto() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("elementosForm:nome")).sendKeys("Alicia");
        chrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza");
        String resultadoNome = chrome.findElement(By.id("elementosForm:nome")).getAttribute("value");
        String resultadoSobrenome = chrome.findElement(By.id("elementosForm:sobrenome")).getAttribute("value");

        Assert.assertEquals("Alicia", resultadoNome);
        Assert.assertEquals("Souza", resultadoSobrenome);
        chrome.quit();
    }

    @Test
    public void testeCampoDeTextoArea (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando o campo de texto");
        String resultadoSugestao = chrome.findElement(By.id("elementosForm:sugestoes")).getAttribute("value");

        Assert.assertEquals(resultadoSugestao, "Testando o campo de texto");
        chrome.quit();
    }
}
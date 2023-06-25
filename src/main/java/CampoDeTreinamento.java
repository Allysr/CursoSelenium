import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CampoDeTreinamento {
    @Test
    public  void validarCampoDeInputTexto() {
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
    public void validarCampoDeTextoArea (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando o campo de texto");
        String resultadoSugestao = chrome.findElement(By.id("elementosForm:sugestoes")).getAttribute("value");

        Assert.assertEquals(resultadoSugestao, "Testando o campo de texto");
        chrome.quit();
    }

    @Test
    public void validarCampoDeSelecaoRadio(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("elementosForm:sexo:1")).click();
        Boolean resultado = chrome.findElement(By.id("elementosForm:sexo:1")).isSelected();

        Assert.assertEquals(true, resultado );
        chrome.quit();
    }

    @Test
    public void validarCampoCheckbox(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        Boolean resultado = chrome.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected();

        Assert.assertEquals(true, resultado );
        chrome.quit();
    }

    @Test
    public void validarCampoSelect(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement select = chrome.findElement(By.id("elementosForm:escolaridade"));
        Select escolaridade = new Select(select);
        escolaridade.selectByVisibleText("Especializacao");

        Assert.assertEquals("Especializacao", escolaridade.getFirstSelectedOption().getText());
        chrome.quit();
    }

    @Test
    public void validarCampoSelectMultiplo(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement select = chrome.findElement(By.id("elementosForm:esportes"));
        Select esportes = new Select(select);
        esportes.selectByVisibleText("Natacao");
        esportes.selectByVisibleText("Futebol");
        esportes.selectByVisibleText("Corrida");
        List<WebElement> opcoesSelecionadas = esportes.getAllSelectedOptions();

        Assert.assertEquals(3, opcoesSelecionadas.size());
        chrome.quit();
    }

    @Test
    public void validarClicarBotaoSimples(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.id("buttonSimple")).click();
        String resultado = chrome.findElement(By.id("buttonSimple")).getAttribute("value");

        Assert.assertEquals("Obrigado!", resultado);
        chrome.quit();
    }

    @Test
    public void validarClicarNoLink(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        chrome.findElement(By.linkText("Voltar")).click();
        String resultado = chrome.findElement(By.id("resultado")).getText();

        Assert.assertEquals("Voltou!", resultado);
        chrome.quit();
    }

    @Test
    public void validarVerificarTitulo(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        Assert.assertTrue(chrome.findElement(By.tagName("h3")).getText().contains("Campo de Treinamento"));
        chrome.quit();
    }



}
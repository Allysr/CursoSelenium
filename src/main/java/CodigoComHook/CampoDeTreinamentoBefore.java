package CodigoComHook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CampoDeTreinamentoBefore {
    private WebDriver chrome;

    @Before
    public void antesDeCada(){
        chrome = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @After
    public void depoisDeCada(){
        chrome.quit();
    }

    @Test
    public  void validarCampoDeInputTexto() {
        chrome.findElement(By.id("elementosForm:nome")).sendKeys("Alicia");
        chrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza");
        String resultadoNome = chrome.findElement(By.id("elementosForm:nome")).getAttribute("value");
        String resultadoSobrenome = chrome.findElement(By.id("elementosForm:sobrenome")).getAttribute("value");

        Assert.assertEquals("Alicia", resultadoNome);
        Assert.assertEquals("Souza", resultadoSobrenome);
    }

    @Test
    public void validarCampoDeTextoArea (){
        chrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando o campo de texto");
        String resultadoSugestao = chrome.findElement(By.id("elementosForm:sugestoes")).getAttribute("value");

        Assert.assertEquals(resultadoSugestao, "Testando o campo de texto");
    }

    @Test
    public void validarCampoDeSelecaoRadio(){
        chrome.findElement(By.id("elementosForm:sexo:1")).click();
        Boolean resultado = chrome.findElement(By.id("elementosForm:sexo:1")).isSelected();

        Assert.assertEquals(true, resultado );
    }

    @Test
    public void validarCampoCheckbox(){
        chrome.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        Boolean resultado = chrome.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected();

        Assert.assertEquals(true, resultado );
    }

    @Test
    public void validarCampoSelect(){
        WebElement select = chrome.findElement(By.id("elementosForm:escolaridade"));
        Select escolaridade = new Select(select);
        escolaridade.selectByVisibleText("Especializacao");

        Assert.assertEquals("Especializacao", escolaridade.getFirstSelectedOption().getText());
    }

    @Test
    public void validarCampoSelectMultiplo(){
        WebElement select = chrome.findElement(By.id("elementosForm:esportes"));
        Select esportes = new Select(select);
        esportes.selectByVisibleText("Natacao");
        esportes.selectByVisibleText("Futebol");
        esportes.selectByVisibleText("Corrida");
        List<WebElement> opcoesSelecionadas = esportes.getAllSelectedOptions();

        Assert.assertEquals(3, opcoesSelecionadas.size());
    }

    @Test
    public void validarClicarBotaoSimples(){
        chrome.findElement(By.id("buttonSimple")).click();
        String resultado = chrome.findElement(By.id("buttonSimple")).getAttribute("value");

        Assert.assertEquals("Obrigado!", resultado);
    }

    @Test
    public void validarClicarNoLink(){
        chrome.findElement(By.linkText("Voltar")).click();
        String resultado = chrome.findElement(By.id("resultado")).getText();

        Assert.assertEquals("Voltou!", resultado);
    }

    @Test
    public void validarVerificarTitulo(){
        Assert.assertTrue(chrome.findElement(By.tagName("h3")).getText().contains("Campo de Treinamento"));
    }




}
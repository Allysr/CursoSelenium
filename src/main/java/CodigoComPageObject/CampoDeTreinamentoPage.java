package CodigoComPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CampoDeTreinamentoPage {

    private WebDriver chrome;

    public void antesDeCada(){
        chrome = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    public void depoisDeCada(){
        chrome.quit();
    }

    public void preencherCampoNome(String nome){
        chrome.findElement(By.id("elementosForm:nome")).sendKeys(nome);
    }

    public void preencherCampoSobrenome(String sobrenome){
        chrome.findElement(By.id("elementosForm:sobrenome")).sendKeys(sobrenome);
    }

    public void preencherCampoSugestoes (){
        chrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando o campo de texto");
        String resultadoSugestao = chrome.findElement(By.id("elementosForm:sugestoes")).getAttribute("value");
    }

    public void preencherCampoSexo(String sexo){
        if (sexo == "Feminino") {
            chrome.findElement(By.id("elementosForm:sexo:1")).click();
        } else {
            chrome.findElement(By.id("elementosForm:sexo:0")).click();
        }
    }

    public void preencherCampoComidaFavorita(){
        chrome.findElement(By.id("elementosForm:comidaFavorita:3")).click();
    }

    public void  preencherCampoEscolaridade(){
        WebElement select = chrome.findElement(By.id("elementosForm:escolaridade"));
        Select escolaridade = new Select(select);
        escolaridade.selectByVisibleText("Especializacao");
    }

    public void preencherCampoEsportes(){
        WebElement select = chrome.findElement(By.id("elementosForm:esportes"));
        Select esportes = new Select(select);
        esportes.selectByVisibleText("Natacao");
        esportes.selectByVisibleText("Futebol");
        esportes.selectByVisibleText("Corrida");
    }


    public String clicarNoBotao(){
        chrome.findElement(By.linkText("Voltar")).click();
        String resultado = chrome.findElement(By.id("resultado")).getText();
        return  resultado;
    }

    public void clicarNoBotaoCadastrar(){
        chrome.findElement(By.id("elementosForm:cadastrar")).click();
    }

    public String mensagemSucessoAoCadastrar(){
        return chrome.findElement(By.cssSelector("div > span")).getText();
    }





}

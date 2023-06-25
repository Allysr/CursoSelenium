package CodigoSemRefatoracao;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastroCompleto {
   @Test
    public void cadastroCompleto(){
       System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
       WebDriver chrome = new ChromeDriver();
       chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
       chrome.findElement(By.id("elementosForm:nome")).sendKeys("Alicia");
       chrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza");
       chrome.findElement(By.id("elementosForm:sexo:1")).click();
       chrome.findElement(By.id("elementosForm:comidaFavorita:2")).click();

       WebElement campoEscolaridade = chrome.findElement(By.id("elementosForm:escolaridade"));
       Select escolaridade = new Select(campoEscolaridade);
       escolaridade.selectByValue("superior");

       WebElement campoEsportes = chrome.findElement(By.id("elementosForm:esportes"));
       Select esportes = new Select(campoEsportes);
       esportes.selectByValue("Corrida");

       chrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Gostaria de deixar sugerido um novo campo.");

       chrome.findElement(By.id("elementosForm:cadastrar")).click();


       Assert.assertEquals("Cadastrado!", chrome.findElement(By.cssSelector("div > span")).getText());
       Assert.assertEquals("Nome: Alicia", chrome.findElement(By.id("descNome")).getText());
       Assert.assertEquals("Sobrenome: Souza", chrome.findElement(By.id("descSobrenome")).getText());
       Assert.assertEquals("Sexo: Feminino", chrome.findElement(By.id("descSexo")).getText());
       Assert.assertEquals("Comida: Pizza", chrome.findElement(By.id("descComida")).getText());
       Assert.assertEquals("Escolaridade: superior", chrome.findElement(By.id("descEscolaridade")).getText());
       Assert.assertEquals("Esportes: Corrida", chrome.findElement(By.id("descEsportes")).getText());
       Assert.assertEquals("Sugestoes: Gostaria de deixar sugerido um novo campo.", chrome.findElement(By.id("descSugestoes")).getText());

       chrome.quit();
   }

}

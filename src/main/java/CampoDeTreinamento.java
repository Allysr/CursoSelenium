import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampoDeTreinamento {
    @Test
    public  void testandoCamposDeTexto() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }
}
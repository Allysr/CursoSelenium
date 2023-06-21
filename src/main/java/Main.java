import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("http:///google.com");
        System.out.printf(chrome.getTitle());


    }
}
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BulkImport {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\SelenimPraticeWorkspace\\TestJavaMO\\Drivers\\chromedriver.exe");
        System.setProperty("Path", "D:\\SelenimPraticeWorkspace\\TestJavaMO\\Doc\\demo-data.xlsx");
        ChromeOptions options = new ChromeOptions();

         options.addArguments("--disable-notifications");
         WebDriver driver = new ChromeDriver(options);
         driver.get("https://demo.dealsdray.com/");

       
        driver.manage().window().maximize();

        driver.findElement(By.id("mui-1")).sendKeys("prexo.mis@dealsdray.com"); 
        driver.findElement(By.id("mui-2")).sendKeys("prexo.mis@dealsdray.com"); 
        
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/button[1]")).click(); 
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'chevron_right')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]")).click();
        String filename = "D:\\SelenimPraticeWorkspace\\TestJavaMO\\Doc\\demo-data.xlsx";
        File file = new File(filename);
        String path = file.getAbsolutePath();
        WebElement upload = driver.findElement(By.id("mui-7"));
         upload.sendKeys(path);
       
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[3]/button[1]")).click();
        File screenshot = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
       

        try {
            
            FileUtils.copyFile(screenshot, new File("Screenshot/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        driver.quit();
    }
}


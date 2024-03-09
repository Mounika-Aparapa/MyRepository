import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

public class MultiBrowserSS {
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "D:\\SelenimPraticeWorkspace\\TestJavaMO\\Drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\SelenimPraticeWorkspace\\TestJavaMO\\Drivers\\geckodriver.exe");
       

        
        Dimension[] resolutions = {new Dimension(1920,1080), new Dimension(1366,768), new Dimension(1536, 864 )};

       
        String[] browsers = {"Chrome", "Firefox"};
        for (String browser : browsers) {
            File browserFolder = new File(browser);
            browserFolder.mkdir();
        }

        
        for (String browser : browsers) {
            WebDriver driver = null;
            try {
                
                if (browser.equals("Chrome")) {
                    driver = new ChromeDriver();
                } else if (browser.equals("Firefox")) {
                    driver = new FirefoxDriver();
                } 

               
                driver.get("https://www.getcalley.com/page-sitemap.xml");

                
                for (int i = 0; i < resolutions.length; i++) {
                    driver.manage().window().setSize(resolutions[i]);
                    File screenshot = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    String filePath = browser+" Screenshots" + "/screenshot_" + i + ".png";
                    FileUtils.copyFile(screenshot, new File(filePath));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }
}

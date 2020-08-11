package driverutil;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory implements DriverSource {

    @Override
    public WebDriver newDriver() {
        WebDriver _driver = null;
        String _browserName = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("browser").toUpperCase();
        DriverType _driverType = DriverType.valueOf(_browserName);
        switch (_driverType) {
            case CHROME:
                WebDriverManager.chromedriver().proxy("mscmcproxy.gva.icrc.priv:8080").setup();
                _driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().proxy("mscmcproxy.gva.icrc.priv:8080").setup();
                _driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().proxy("mscmcproxy.gva.icrc.priv:8080").setup();
                _driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().proxy("mscmcproxy.gva.icrc.priv:8080").setup();
                _driver = new InternetExplorerDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().proxy("mscmcproxy.gva.icrc.priv:8080").setup();
                _driver = new OperaDriver();
                break;
            default:
                WebDriverManager.chromedriver().proxy("mscmcproxy.gva.icrc.priv:8080").setup();
                _driver = new ChromeDriver();
                break;
        }
        _driver.manage().window().maximize();
        return _driver;

    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}

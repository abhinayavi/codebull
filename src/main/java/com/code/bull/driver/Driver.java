package com.code.bull.driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class Driver {

    private static String browser = System.getProperty("browser");
    private static String env = System.getProperty("env");
    private static WebDriver driver;

    @BeforeSuite
    public void Setup(){

      /*  String browser = null; */
        envSetup();
        browser();

    }

    /**
     *
     */

    private void envSetup() {

        if (env.equalsIgnoreCase("sit")) {
            env = "SIT";
        } else if (env.equalsIgnoreCase("uat")) {
            env = "UAT";
        } else if (env.equalsIgnoreCase("prod")) {
            env = "PROD";
        } else {
            env = "SIT";
        }

    }

        private void browser(){

            try {

                switch (browser){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        browserCapabilities();
                        break;
                    case "firrefox":
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                        break;
                    default:
                        break;

                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());

             }

        }

    private void browserCapabilities() {
    }


}

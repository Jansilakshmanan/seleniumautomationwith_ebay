package com.ebay.Baselayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static  Properties prop;
    String path="C:\\Users\\user\\Desktop\\backup 12112019\\jansi_javafiles_2\\selenium_assignment\\src\\main\\java\\com\\ebay\\Configlayer\\config.properties";
    public  TestBase()  {
        try{
            FileInputStream ip=new FileInputStream(path);
             prop=new Properties();
            prop.load(ip);


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        if(prop.getProperty("browser").equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
        }
    }

    public void initialization()
    {
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }
}

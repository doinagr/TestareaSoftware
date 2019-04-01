package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver browser;
        System.setProperty("webdriver.chrome.driver", "/Users/User/IdeaProjects/LoginTest/chromedriver/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().fullscreen();
        browser.get("http://localhost:8090/home");
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((ChromeDriver) browser).findElementByXPath("//*[@id=\"navbar\"]/ul[2]/li").click();
        Thread.sleep(1000);
        ((ChromeDriver) browser).findElementByXPath("//*[@id=\"username\"]").sendKeys("pavlik22");
        Thread.sleep(1000);
        WebElement password = ((ChromeDriver) browser).findElementByXPath("//*[@id=\"password\"]");
        WebDriverWait wait = new WebDriverWait(browser,20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("1234567");
        Thread.sleep(1000);
        ((ChromeDriver) browser).findElementByXPath("/html/body/div[3]/div/div/form/fieldset/div[3]/div/input").click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       /* browser.close();
        browser.quit();*/




    }
}
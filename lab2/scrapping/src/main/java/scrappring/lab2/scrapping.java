package scrappring.lab2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class scrapping {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/User/IdeaProjects/LoginTest/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.sportsdirect.com/");
        Thread.sleep(400);
        WebElement closecloseAdvertPopup;
        closecloseAdvertPopup = ((ChromeDriver) driver).findElementByXPath("//div[@id='advertPopup']/div[@class='modal-dialog advertPopup']/" +
                "div[@class='modal-content']/div[@class='modal-header']/button[@class='close']");
        closecloseAdvertPopup.click();
        Thread.sleep(800);

        WebElement clickToLadies;
        clickToLadies = ((ChromeDriver) driver).findElementByXPath("//nav[@id='topMenu']/ul/li[2]");
        clickToLadies.click();
        Thread.sleep(800);

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("scroll(0, 350);");
        Thread.sleep(1000);

        WebElement selectLadiesTrainers;
        selectLadiesTrainers = ((ChromeDriver) driver).findElementByXPath("//div[@class='col-sm-8 col-md-12 divLPtiles']/div[@class='divLPtilesInner']/div[5]");
        selectLadiesTrainers.click();
        Thread.sleep(1000);

        WebElement selectNikeTrainers;
        selectNikeTrainers = ((ChromeDriver) driver).findElementByXPath("//*[@id=\"dnn_ctr128595886_ViewTemplate_ctl00_ctl08_lstFilters_productFilterList_1\"]/div[2]/a");
        selectNikeTrainers.click();
        Thread.sleep(6000);

        WebElement itms = ((ChromeDriver) driver).findElementByXPath("//ul[@id='navlist']/li");
        List<WebElement> brandNameFromPage1 = itms.findElements(By.xpath("//span[@class='productdescriptionbrand']"));
        List<WebElement> titleFromPage1 = itms.findElements(By.xpath("//span[@class='productdescriptionname']"));
        List<WebElement> priceFromPage1 = itms.findElements(By.xpath("//span[@class='CurrencySizeLarge curprice productHasRef' or @class='CurrencySizeLarge curprice ']"));

        for (int i = 0; i < brandNameFromPage1.size(); i++) {
            int count = i + 1;
            System.out.println("Product nr. " + count);
            System.out.println("  brand: " + brandNameFromPage1.get(i).getText());
            System.out.println("  name: " + titleFromPage1.get(i).getText());
            System.out.println("  price: " + priceFromPage1.get(i).getText());
            System.out.println("______________________________________");
            System.out.println();

        }
    }
}


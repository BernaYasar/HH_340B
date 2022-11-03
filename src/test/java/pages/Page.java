package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page {

    public Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[contains(text(),'Developer Requirements')]")
    public WebElement developerRequirements;

    @FindBy(xpath="//input[@type='file']")
    public WebElement chooseFiles;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement uploadFiles;

    @FindBy(xpath="/html/body/div/main/p[1]")
    public WebElement numberOfFiles;

    @FindBy(xpath="/html/body/div/main/p[2]")
    public WebElement sizeOfFiles;

    @FindBy(xpath="//table[@class='table']/tbody")
    public WebElement noFile;


}

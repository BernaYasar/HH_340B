package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.List;

public class Requirements {
    Page page = new Page();

    @Given("user navigates to application page")
    public void user_navigates_to_application_page() {
        Driver.navigateToUrl(ConfigReader.getProperty("app_url"));
    }
    @Given("user asserts Developer Requirements is visible")
    public void user_asserts_developer_requirements_is_visible() {
      Assert.assertTrue(page.developerRequirements.isDisplayed());
    }
    @When("user uploads files")
    public void user_uploads_doc(List<String> fileNames) {
        fileNames.forEach(fileName -> page.chooseFiles.sendKeys(ConfigReader.getProperty(fileName)));
        page.uploadFiles.click();
    }
    @Then("user verifies total count of files is {int}")
    public void total_count_of_files_is_three(int fileCount) {
        Assert.assertEquals("Total Files Uploaded: "+fileCount,page.numberOfFiles.getText());
    }
    @Then("user verifies total size is {int}")
    public void total_size_is_100(int size) {
        Assert.assertEquals("Total Size in Bytes: "+size, page.sizeOfFiles.getText());
    }
    @Then("names and extensions of files are displayed")
    public void names_and_extensions_of_files_are_displayed(List<String> fileNames) {
        fileNames.forEach(fileName -> Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//td[contains(text(), '"+fileName+"')]")).isDisplayed()));
    }
    @Given("user does not upload doc")
    public void user_does_not_upload_doc() {
        page.uploadFiles.click();
    }
    @Then("user verifies total count of files is one")
    public void total_count_of_files_is_one() {
        Assert.assertEquals("Total Files Uploaded: 1",page.numberOfFiles.getText());
    }
    @Then("no file names appear")
    public void no_file_names_appear() {
        Assert.assertEquals("",page.noFile.getText());
    }
    @Then("user closes the page")
    public void user_closes_the_page() {
        Driver.wait(3);
        Driver.closeDriver();
    }
}

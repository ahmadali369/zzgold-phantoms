package sqe;

import org.openqa.*;
import org.testng.Assert;
import io.restassured.*;
import io.cucumber.*;


public class AdminModuleTestSteps {
    private WebDriver driver;
    private RequestSpecification request;
    private Response response;

    @Given("the admin is on the login page")
    public void the_admin_is_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run Chrome in headless mode (optional)
        driver = new ChromeDriver(options);
        driver.get("https://yourapp.com/login");
    }

    @When("the admin enters valid credentials")
    public void the_admin_enters_valid_credentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("admin_username");
        passwordField.sendKeys("admin_password");
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("the admin is successfully logged in")
    public void the_admin_is_successfully_logged_in() {
        WebElement dashboardElement = driver.findElement(By.id("dashboard"));
        Assert.assertTrue(dashboardElement.isDisplayed());
    }

    @And("the admin cannot log in")
    public void the_admin_cannot_log_in() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @When("the admin navigates to the dashboard")
    public void the_admin_navigates_to_the_dashboard() {

        WebElement dashboardLink = driver.findElement(By.id("dashboardLink"));
        dashboardLink.click();
    }

    @Then("the admin can access the dashboard")
    public void the_admin_can_access_the_dashboard() {
       WebElement dashboardTitle = driver.findElement(By.id("dashboardTitle"));
        Assert.assertTrue(dashboardTitle.isDisplayed());
    }

    @When("the admin creates a new user account")
    public void the_admin_creates_a_new_user_account() {
        WebElement newUserButton = driver.findElement(By.id("newUserButton"));
        newUserButton.click();
        WebElement usernameField = driver.findElement(By.id("newUsername"));
        WebElement passwordField = driver.findElement(By.id("newPassword"));
        WebElement createUserButton = driver.findElement(By.id("createUserButton"));

        usernameField.sendKeys("new_user");
        passwordField.sendKeys("new_password");
        createUserButton.click();
    }

    @When("edits user account details")
    public void edits_user_account_details() {
       WebElement editUserButton = driver.findElement(By.id("editUserButton"));
        editUserButton.click();
        WebElement usernameField = driver.findElement(By.id("editUsername"));
        WebElement saveChangesButton = driver.findElement(By.id("saveChangesButton"));

        usernameField.clear();
        usernameField.sendKeys("edited_user");
        saveChangesButton.click();
    }

    @When("deactivates a user account")
    public void deactivates_a_user_account() {
      WebElement deactivateUserButton = driver.findElement(By.id("deactivateUserButton"));
        deactivateUserButton.click();
    }

    @When("reactivates a deactivated user account")
    public void reactivates_a_deactivated_user_account() {
        WebElement reactivateUserButton = driver.findElement(By.id("reactivateUserButton"));
        reactivateUserButton.click();
    }

    @Then("user account actions are successfully performed")
    public void user_account_actions_are_successfully_performed() {
       WebElement userElement = driver.findElement(By.id("userElement"));
        Assert.assertTrue(userElement.isDisplayed());
    }

    @When("the admin creates a new user role")
    public void the_admin_creates_a_new_user_role() {
      WebElement newRoleButton = driver.findElement(By.id("newRoleButton"));
        newRoleButton.click();
        WebElement roleNameField = driver.findElement(By.id("roleName"));
        WebElement createRoleButton = driver.findElement(By.id("createRoleButton"));

        roleNameField.sendKeys("new_role");
        createRoleButton.click();
    }

    @When("edits role details")
    public void edits_role_details() {
       WebElement editRoleButton = driver.findElement(By.id("editRoleButton"));
        editRoleButton.click();
        WebElement roleNameField = driver.findElement(By.id("editRoleName"));
        WebElement saveChangesButton = driver.findElement(By.id("saveRoleChangesButton"));

        roleNameField.clear();
        roleNameField.sendKeys("edited_role");
        saveChangesButton.click();
    }

    @When("assigns roles to users")
    public void assigns_roles_to_users() {
       WebElement assignRoleButton = driver.findElement(By.id("assignRoleButton"));
        assignRoleButton.click();
        WebElement roleDropdown = driver.findElement(By.id("roleDropdown"));
        WebElement saveAssignmentsButton = driver.findElement(By.id("saveAssignmentsButton"));

        roleDropdown.sendKeys("selected_role");
        saveAssignmentsButton.click();
    }

    @Then("role actions are successfully performed")
    public void role_actions_are_successfully_performed() {
     WebElement roleAssignedElement = driver.findElement(By.id("roleAssignedElement"));
        Assert.assertTrue(roleAssignedElement.isDisplayed());
    }

    @When("the admin assigns permissions to roles")
    public void the_admin_assigns_permissions_to_roles() {
        WebElement assignPermissionButton = driver.findElement(By.id("assignPermissionButton"));
        assignPermissionButton.click();
        WebElement permissionDropdown = driver.findElement(By.id("permissionDropdown"));
        WebElement saveAssignmentsButton = driver.findElement(By.id("savePermissionAssignmentsButton"));

        permissionDropdown.sendKeys("selected_permission");
        saveAssignmentsButton.click();
    }



    @When("the admin removes permissions from roles")
    public void the_admin_removes_permissions_from_roles() {
        WebElement removePermissionButton = driver.findElement(By.id("removePermissionButton"));
        removePermissionButton.click();
        WebElement permissionToRemove = driver.findElement(By.id("permissionToRemove"));
        permissionToRemove.click();
        WebElement saveChangesButton = driver.findElement(By.id("savePermissionChangesButton"));
        saveChangesButton.click();
    }

    @Then("permission actions are successfully performed")
    public void permission_actions_are_successfully_performed() {
       WebElement permissionElement = driver.findElement(By.id("permissionElement"));
        Assert.assertTrue(permissionElement.isDisplayed());
    }

    @When("the admin adds new data to the system")
    public void the_admin_adds_new_data_to_the_system() {
        WebElement addDataButton = driver.findElement(By.id("addDataButton"));
        addDataButton.click();
        WebElement dataField = driver.findElement(By.id("dataField"));
        WebElement saveDataButton = driver.findElement(By.id("saveDataButton"));

        dataField.sendKeys("new_data");
        saveDataButton.click();
    }

    @When("edits existing data")
    public void edits_existing_data() {
      WebElement editDataButton = driver.findElement(By.id("editDataButton"));
        editDataButton.click();
        WebElement dataField = driver.findElement(By.id("editDataField"));
        WebElement saveChangesButton = driver.findElement(By.id("saveDataChangesButton"));

        dataField.clear();
        dataField.sendKeys("edited_data");
        saveChangesButton.click();
    }

    @When("deletes data entries")
    public void deletes_data_entries() {
        WebElement deleteDataButton = driver.findElement(By.id("deleteDataButton"));
        deleteDataButton.click();
    }

    @Then("data management actions are successfully performed")
    public void data_management_actions_are_successfully_performed() {
        WebElement dataElement = driver.findElement(By.id("dataElement"));
        Assert.assertTrue(dataElement.isDisplayed());
    }

    @When("the admin changes application settings")
    public void the_admin_changes_application_settings() {
        WebElement settingsButton = driver.findElement(By.id("settingsButton"));
        settingsButton.click();
        WebElement settingField = driver.findElement(By.id("settingField"));
        WebElement saveSettingsButton = driver.findElement(By.id("saveSettingsButton"));

        settingField.clear();
        settingField.sendKeys("new_setting");
        saveSettingsButton.click();
    }

    @Then("the settings are successfully updated")
    public void the_settings_are_successfully_updated() {
       WebElement updatedSettingElement = driver.findElement(By.id("updatedSettingElement"));
        Assert.assertTrue(updatedSettingElement.isDisplayed());
    }

    @When("the admin accesses the audit trail")
    public void the_admin_accesses_the_audit_trail() {
        WebElement auditTrailButton = driver.findElement(By.id("auditTrailButton"));
        auditTrailButton.click();
    }

    @Then("the audit trail is displayed with user actions")
    public void the_audit_trail_is_displayed_with_user_actions() {
       WebElement auditTrailElement = driver.findElement(By.id("auditTrailElement"));
        Assert.assertTrue(auditTrailElement.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
........,///////////////
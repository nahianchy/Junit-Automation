import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RegFormAutomation {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--window-size=400,1000");
        driver = new ChromeDriver(ops);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void _1_submitForm() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        // firstName, lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("F:\\NC\\resume\\my_documents\\nahian300x300.jpg");
        driver.findElement(By.id("lastName")).sendKeys("chy");
        driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();


        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");
        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).click().perform();


        // Get Modal Title
        String textExpected = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Assert.assertTrue(textExpected.contains("Thanks for submitting the form"));

        Thread.sleep(3000);

        // Close Modal
        WebElement closeModal = driver.findElement(By.id("closeLargeModal"));
        action.moveToElement(closeModal).click().perform();


    }
    @Test
    public void _2_submitFormWithoutFirstNameField() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        //lastName, Email
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }

    @Test
    public void _3_submitFormWithoutLastNameField() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }

    @Test
    public void _4_submitFormWithoutSelectingGender() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName, lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        Actions action = new Actions(driver);
        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }

    @Test
    public void _5_submitFormWithoutMobileNumber() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName, lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }
    @Test
    public void _6_1_submitFormWithInvalidEmail() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan$gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }
    @Test
    public void _6_2_submitFormWithInvalidEmail() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan$gmail");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }
    @Test
    public void _6_3_submitFormWithInvalidEmail() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@$.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }
    @Test
    public void _7_1_submitFormWithMobileNumberLessThan10Digits() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("181279498");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }
    @Test
    public void _7_2_submitFormWithMobileNumberWithAlphabets() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("181279498s");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }
    @Test
    public void _7_3_submitFormWithMobileNumberWithSpecialChar() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("181279_98$");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();
    }
    @Test
    public void _8_submitFormWithPictureInWrongFormat() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 1997");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.exe");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();

        String textExpected = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Assert.assertTrue(!textExpected.contains("Thanks for submitting the form"));
    }

    @Test
    public void _8_1_submitFormWithInvalidDate() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 2030");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();

        String textExpected = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Assert.assertTrue(!textExpected.contains("Thanks for submitting the form"));
    }
    @Test
    public void _8_2_submitFormWithInvalidDate() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        // firstName,lastName, Email
        driver.findElement(By.id("firstName")).sendKeys("Iftekhar");
        driver.findElement(By.id("lastName")).sendKeys("Hasan");
        driver.findElement(By.id("userEmail")).sendKeys("iftekharhasan@gmail.com");

        // gender radio button
        WebElement maleRadioElement = driver.findElement(By.id("gender-radio-1"));
        Actions action = new Actions(driver);
        action.moveToElement(maleRadioElement).click().perform();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys("1812794985");

        // Datepicker
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        action.moveToElement(dob).click().perform();
        action.doubleClick().click().perform();
        dob.sendKeys("28 Jun 2022");
        dob.sendKeys(Keys.ENTER);

        // Select Subject
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        subjectsElement.sendKeys("English");
        subjectsElement.sendKeys(Keys.ENTER);
        subjectsElement.sendKeys("Maths");
        subjectsElement.sendKeys(Keys.ENTER);

        // Select Hobbies checkbox
        WebElement sportElement = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        action.moveToElement(sportElement).click().perform();
        action.moveToElement(musicElement).click().perform();

        // Upload Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("F:\\NC\\resume\\my_documents\\F:\\NC\\resume\\my_documents\\nahian300x300.jpg300x300.jpg");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Chattogram");

        // Select State and City
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));

        action.moveToElement(stateDropdown).click().perform();
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        action.moveToElement(cityDropdown).click().perform();
        cityDropdown.sendKeys("De");
        cityDropdown.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        // Click Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        action.moveToElement(submitButton).doubleClick().click().perform();

        String textExpected = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Assert.assertTrue(!textExpected.contains("Thanks for submitting the form"));
    }

    @After
    public void quit() {
        driver.quit();
    }

}

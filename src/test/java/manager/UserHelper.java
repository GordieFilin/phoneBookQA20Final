package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnOpenLoginForm = By.xpath("//a[@href='/login']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btnLogin = By.xpath("//button[@name='login']");
    String btnRegistration = "document.querySelector('[name=\"registration\"]').click();\n";
    By textContacts = By.xpath("//a[@href='/contacts']");
    By btnLogout = By.xpath("//button[text()='Sign Out']");

    public void openLoginPage() {
        clickBase(btnOpenLoginForm);
    }

    public void fillLoginUserDto(UserDTO userDTO) {
        typeTextBase(inputEmail, userDTO.getEmail());
        typeTextBase(inputPassword, userDTO.getPassword());
        clickBase(btnLogin);
    }

    public void fillLoginUserDtoWith(UserDTOWith userDTOWith) {
        typeTextBase(inputEmail, userDTOWith.getEmail());
        typeTextBase(inputPassword, userDTOWith.getPassword());
        clickBase(btnLogin);
    }

    public boolean validateContactTextDisplaysMainMenu() {
        String expectedResult = "CONTACTS".toUpperCase();
        return isTextEqual(textContacts, expectedResult);
    }

    public void fillLoginUserDtoLombok(UserDtoLombok user) {
        typeTextBase(inputEmail, user.getUsername());
        typeTextBase(inputPassword, user.getPassword());
        clickBase(btnLogin);
    }

    public void fillRegUserDtoLombok(UserDtoLombok user) {
        clickBase(btnOpenLoginForm);
        typeTextBase(inputEmail, user.getUsername());
        typeTextBase(inputPassword, user.getPassword());
        jsClickBase(btnRegistration);
    }

    public boolean validateMessageAlertWrongEmailPasswordCorrect() {
        String expectedResult = "Wrong email or password".toUpperCase();
        String actualResult = getTextAlert();
        return isTextContainsGet2Strings(expectedResult, actualResult);
    }

    public boolean validateMessageAlertWrongEmailPasswordCorrectReg() {
        String expectedResult = "WRONG EMAIL OR PASSWORD FORMAT";
        String actualResult = getTextAlert();
        return isTextContainsGet2Strings(expectedResult, actualResult);
    }

    public void logout() {
        clickBase(btnLogout);
    }
}

package manager;

import dto.NewContactDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends BaseHelper{


    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    //String phoneLocal = "";
    By btnAddNewContact = By.xpath("//a[@href='/add']");
    By inputNameAddContact = By.xpath("//input[@placeholder='Name']");
    By inputLastNameAddContact = By.xpath("//input[@placeholder='Last Name']");
    By inputPhoneAddContact = By.xpath("//input[@placeholder='Phone']");
    By inputEmailAddContact = By.xpath("//input[@placeholder='email']");
    By inputAddressAddContact = By.xpath("//input[@placeholder='Address']");
    By inputDescriptionAddContact = By.xpath("//input[@placeholder='description']");
    By btnSaveNewContact = By.xpath("//button/b");
    By textH3ContactList = By.xpath("//h3");
    By btnRemoveContact = By.xpath("//button[text()='Remove']");

    //-------------------------------------------------
    //By phoneNumberInContacts = By.xpath(String.format("//h3[contains(text(),'%s')]", phoneLocal));
   public By getPhoneNumberInContactsLocator(String phone) {
       return By.xpath(String.format("//h3[contains(text(),'%s')]", phone));
   }
   //-----------------------------------------------------

    public void addNewContact(NewContactDto newContactDto) {
        clickBase(btnAddNewContact);
        typeTextBase(inputNameAddContact, newContactDto.getName());
        typeTextBase(inputLastNameAddContact, newContactDto.getLastName());
        typeTextBase(inputPhoneAddContact, newContactDto.getPhone());
        typeTextBase(inputEmailAddContact, newContactDto.getEmail());
        typeTextBase(inputAddressAddContact, newContactDto.getAddress());
        typeTextBase(inputDescriptionAddContact, newContactDto.getDescription());
        clickBase(btnSaveNewContact);
    }

    public boolean validateContactCreated(String phone) {
        return isElementByTextExistInTheList(textH3ContactList, phone);
    }

    public void openContactInfoByPhone(String phone) {
//        phoneLocal = phone;
        clickBase(getPhoneNumberInContactsLocator(phone));
    }

    public void removeActiveContact() {
        clickBase(btnRemoveContact);
    }

    public void navigateToContactPage() {
       driver.navigate().to("https://telranedu.web.app/contacts");
    }
}

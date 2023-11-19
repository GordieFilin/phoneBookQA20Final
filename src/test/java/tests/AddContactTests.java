package tests;

import dto.NewContactDto;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddContactTests extends BaseTests{

    @BeforeClass(alwaysRun = true)
    public void preconditionsBeforeClass() {
        if(app.isPageUrlHome()) {
            app.getUserHelper().openLoginPage();
        }
        app.getUserHelper().fillLoginUserDtoLombok(user);
    }

    @AfterClass(alwaysRun = true)
    public void postConditions() {
        app.getUserHelper().logout();
    }


    @Test
    public void addContactPositive() {
        String phone = randomUtils.generateStringDigits(12);
        System.out.println("phone for the new contact: " + phone);
        logger.info("phone for the new contact: " + phone);
        NewContactDto newContactDto = NewContactDto.builder()
                .address("ghj")
                .description("asadhj")
                .email("dfrdd@mail.ff")
                .lastName("ghjlkd")
                .name("dsbj")
                .phone(phone)
                .build();
        app.getContactHelper().addNewContact(newContactDto);
        Assert.assertTrue(app.getContactHelper().validateContactCreated(phone));
    }
}

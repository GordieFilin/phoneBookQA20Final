package tests;

import dto.NewContactDto;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteConactTests extends BaseTests{

    @BeforeClass(alwaysRun = true)
    public void preconditionsBeforeClass() {
        if(app.isPageUrlHome()) {
            app.getUserHelper().openLoginPage();
        }
        app.getUserHelper().fillLoginUserDtoLombok(user);
    }

    @AfterClass(alwaysRun = true)
    public void postConditions() throws InterruptedException {
        app.getUserHelper().logout();
        Thread.sleep(500);
    }

    @Test
    public void deleteCreatedContactPositive() {
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
        app.getContactHelper().openContactInfoByPhone(phone);
        app.getContactHelper().removeActiveContact();
        app.getContactHelper().navigateToContactPage();
        Assert.assertFalse(app.getContactHelper().validateContactCreated(phone));
    }
}

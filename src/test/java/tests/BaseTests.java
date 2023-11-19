package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.RandomUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners(TestNGListener.class)
public class BaseTests {
    boolean flagIsAlertPresent = false;
    boolean flagIsUserLogin = false;
    Logger logger = LoggerFactory.getLogger(BaseTests.class);
    protected RandomUtils randomUtils = new RandomUtils();

    static ApplicationManager app = new ApplicationManager();

    UserDtoLombok user = UserDtoLombok.builder()
            .username("testqa20@gmail.com")
            .password("123456Aa$")
            .build();

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void stop() {
        app.tearDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeEachMethod(Method method) {
        logger.info("----------------------------------------------------------------------------------");
        logger.info("started method: " + method.getName());
        logger.info("started method with params: " + Arrays.toString(method.getParameters()));
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachMethod(Method method) {
        logger.info("stopped method: " + method.getName());
        logger.info("stopped method with params: " + Arrays.toString(method.getParameters()));
    }

    public void preconditionForLoginAndRegTests() {
        if(flagIsAlertPresent) {
            flagIsAlertPresent = false;
            app.getUserHelper().clickAcceptAlert();
        }
        if (flagIsUserLogin) {
            flagIsUserLogin = false;
            app.getUserHelper().logout();
        }
    }

}

package testSuites;


import com.github.javafaker.Faker;
import helpers.logListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static testSteps.register.tsRegister.*;

@Listeners(logListener.class)
@Feature("Register")

@Test(groups = {"TCREG"})
public class registerTC {
    private static Faker faker=new Faker();

    @Test(groups = {"TCREG001"})
    @Description("Verify user successfully register")
    public static void TCREG001() {
        registerStep(
                "user:newAccount",
                faker.name().lastName(),
                faker.address().city(),
                faker.name().username()
        );
    }
}

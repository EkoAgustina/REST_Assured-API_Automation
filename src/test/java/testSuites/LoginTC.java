package testSuites;


import com.google.common.collect.ImmutableMap;
import helpers.logListener;
import io.qameta.allure.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static testSteps.login.tsLogin.*;
import static testSteps.login.tsLogin.loginStep;

@Listeners(logListener.class)
@Feature("Login Module")

@Test(groups = {"Login Suite"} )
public class LoginTC {

    @Test(groups = {"TCLG001"})
    @Description("Verify user successfully logged in using a valid account")
    public void TCLG001(){
        loginStep("user:validAccount","Login successfully");
    }

    @Test(groups = {"TCLG002"})
    @Description("Verify user failed to login using an invalid account")
    public void TCLG002(){loginStep("user:invalidAccount","Login failed");}
}

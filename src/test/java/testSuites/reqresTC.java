package testSuites;

import helpers.logListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static testSteps.reqres.tsReqres.*;

@Listeners(logListener.class)
@Feature("Reqres Module")
public class reqresTC {

    @Test(groups = {"TCRQ001"})
    @Description("Verify data shown is appropriate")
    public void TCRQ001(){
        reqresStep();
    }
}

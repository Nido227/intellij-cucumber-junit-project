package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order=1)
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");
    }

    @Before (value = "@login",order=2)
    public void setupForLogin(){

    }

   // @Before (value="@db", order=3)
    public void setupDatabaseScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");

    }

    @After
    public void teardownScenario(Scenario scenario){
        //System.out.println("It will be closing browser using cucumber @After each scenario");
        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }

    @BeforeStep
    public void setupScenarioStepForLogin(){
        System.out.println("Setting up browser using cucumber @Before each scenario step for login");
    }
}

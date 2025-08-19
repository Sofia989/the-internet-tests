package com.theinternet.runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue  = "com/theinternet/runner/stepDefinitions",

        plugin= {"pretty", "json:build/cucumber-report/cucumber.json"}

)

public class TestRunner {


}

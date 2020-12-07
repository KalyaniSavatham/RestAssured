package com.infy;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java"},
		glue= {"stepDefinitions"}
		)
public class TestRunner {

}

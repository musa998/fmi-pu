package project.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",
        plugin = {"pretty","html:target/raport"},
        monochrome = true
)
public class CucumberStarter {

}

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(tags="@smokeTest",glue={"stepDefinitions"})
public class CucumberRunner {

}

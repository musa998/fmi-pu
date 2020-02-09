package project.cucumber.SearchEvent;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import project.cucumber.ui.models.HomePage;
import project.cucumber.ui.models.SearchBox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SearchSteps {

    HomePage homePage;
    SearchBox searchBox;
    @Given("^потребителя отваря началната страница$")
    public void потребителя_отваря_началната_страница() throws Throwable {
       homePage = new HomePage();
    }

    @Given("^натиска върху бутона за търсене в системата$")
    public void натиска_върху_бутона_за_търсене_в_системата() throws Throwable {
        searchBox = homePage.clickSearchButton();
    }

    @Given("^визуализира се форма за търсене в системата$")
    public void визуализира_се_форма_за_търсене_в_системата() throws Throwable {
       assertNotNull(searchBox);
    }

    @When("^въведе валидни входни данни за търсене$")
    public void въведе_валидни_входни_данни_за_търсене() throws Throwable {
       searchBox.addToInputBox("PlovDev");
    }

    @When("^натисне бутона за търсене$")
    public void натисне_бутона_за_търсене() throws Throwable {
        searchBox.clickSearchButton();
    }

    @Then("^вижда съобщение \"([^\"]*)\"$")
    public void вижда_съобщение(String expectedMessage) throws Throwable {
        assertEquals(expectedMessage, searchBox.getMessage());
    }

    @When("^въведе невалидни входни данни за търсене$")
    public void въведе_невалидни_входни_данни_за_търсене() throws Throwable {
       searchBox.addToInputBox("#$#$#%$$$");
    }

}

package project.cucumber.BuyTickets;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import project.cucumber.models.Event;
import project.cucumber.ui.models.BuyTiketForm;
import project.cucumber.ui.models.EventPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BuyTicketSteps {

    EventPage eventPage;
    BuyTiketForm buyTiketForm;
    Event event  = new Event("PlovDev", "Plovdiv", 0.0d);


    @Given("^потребителя отваря станицата на събитието$")
    public void потребителя_отваря_станицата_на_събитието() throws Throwable {
       eventPage = new EventPage();
    }

    @Given("^натиска върху бутона за купуване на билет$")
    public void натиска_върху_бутона_за_купуване_на_билет() throws Throwable {
        buyTiketForm = eventPage.clickSearchButton();
    }

    @Given("^визуализира се форма за купуване на билети$")
    public void визуализира_се_форма_за_купуване_на_билети() throws Throwable {
        assertNotNull(buyTiketForm);
    }

    @When("^избере някои от предоставените начини за плащане$")
    public void избере_някои_от_предоставените_начини_за_плащане() throws Throwable {
        buyTiketForm.choosePaymentMethod(true);
    }

    @When("^въведе валиден имеѝл$")
    public void въведе_валиден_имеѝл() throws Throwable {
       buyTiketForm.addEmail("mymail@mail.com");
    }

    @When("^натисне бутона за закуване$")
    public void натисне_бутона_за_закуване() throws Throwable {
        buyTiketForm.checkout(event);
    }

    @Then("^вижда съобщение с текст \"([^\"]*)\"$")
    public void вижда_съобщение_с_текст(String expectedMessage) throws Throwable {
        assertEquals(expectedMessage, buyTiketForm.getMessage());
    }

    @When("^въведе невалиден имеѝл$")
    public void въведе_невалиден_имеѝл() throws Throwable {
        buyTiketForm.addEmail("#%#$WWCCWC");
    }
}

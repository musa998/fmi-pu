package project.cucumber.ui.models;

import project.cucumber.services.SearchService;

public class SearchBox {

    private String input;
    private String message;

    public void addToInputBox(String value) {
        this.input = value;
    }

    public void clickSearchButton() {
        boolean isInputNotValid = input == null || input.isEmpty();
        if (isInputNotValid) {
            message = "Липса на входни данни!!!!";
        } else {
            message = new SearchService().search(input);
        }
    }

    public String getMessage() {
        return message;
    }

}

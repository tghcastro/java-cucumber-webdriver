package tghcastro.pageobjects.components;

import tghcastro.pageobjects.SearchResultsPage;

public class SearchQueryCorrection {
    public String message() {
        System.out.println("Getting Search Query Correction message");
        String message = "Showing results for tgh castro Search instead for tghcastro";
        return message;
    }

    public SearchResultsPage searchInsteadFor(String userName) {
        System.out.println("Searching instead for " + userName);
        return new SearchResultsPage();
    }
}

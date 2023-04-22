package tghcastro.pageobjects.components;

import tghcastro.pageobjects.SearchResultsPage;

public class SearchBar {

    public SearchResultsPage searchFor(String userName) {
        System.out.println("Searching for " + userName);
        return new SearchResultsPage();
    }

}

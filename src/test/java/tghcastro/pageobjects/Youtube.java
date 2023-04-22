package tghcastro.pageobjects;

import tghcastro.pageobjects.support.InstancesRepository;

public class Youtube {
    public Youtube() {
        System.out.println("Starting Youtube");
    }

    public MainPage main() {
        return InstancesRepository.loadInstance(MainPage.class);
    }

    public SearchResultsPage searchResults() {
        return InstancesRepository.loadInstance(SearchResultsPage.class);
    }
}

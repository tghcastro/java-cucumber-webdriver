package tghcastro.pageobjects;

import tghcastro.pageobjects.components.SearchQueryCorrection;
import tghcastro.pageobjects.support.InstancesRepository;

public class SearchResultsPage {
    public SearchQueryCorrection searchQueryCorrection() {
        return InstancesRepository.loadInstance(SearchQueryCorrection.class);
    }

    public String displayedUser() {
        return "Thiago de Castro";
    }
}

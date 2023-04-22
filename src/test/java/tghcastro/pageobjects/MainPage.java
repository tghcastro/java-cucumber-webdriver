package tghcastro.pageobjects;

import tghcastro.pageobjects.components.SearchBar;
import tghcastro.pageobjects.support.InstancesRepository;

public class MainPage {
    public SearchBar searchBar() {
        return InstancesRepository.loadInstance(SearchBar.class);
    }
}

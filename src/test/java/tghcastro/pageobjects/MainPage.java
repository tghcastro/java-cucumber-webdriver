package tghcastro.pageobjects;

import tghcastro.pageobjects.components.CookiesPolicy;
import tghcastro.pageobjects.components.SearchBar;
import tghcastro.pageobjects.support.InstancesRepository;

import java.net.ServerSocket;

public class MainPage {
    public SearchBar searchBar() {
        return InstancesRepository.loadInstance(SearchBar.class);
    }

    public CookiesPolicy CookiesPolicy() {
        return InstancesRepository.loadInstance(CookiesPolicy.class);
    }
}

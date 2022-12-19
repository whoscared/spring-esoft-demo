package whoscared.esoftdemo.esoft.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.people.Person;
import whoscared.esoftdemo.esoft.demo.search.SearchClientsAndRealtors;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final SearchClientsAndRealtors searchClientsAndRealtors;

    @Autowired
    public SearchController(SearchClientsAndRealtors searchClientsAndRealtors) {
        this.searchClientsAndRealtors = searchClientsAndRealtors;
    }

    @PostMapping()
    public String search(Model model,
                         @ModelAttribute("person") Person person) {
        List<Person> resultOfSearch = searchClientsAndRealtors.searchPersons(person);
        model.addAttribute("personList", resultOfSearch);
        return "/search/search";
    }

    @GetMapping()
    public String search(Model model) {
        model.addAttribute("person", new Person());
        return "/search/search";
    }

}

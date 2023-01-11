package whoscared.esoftdemo.esoft.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.services.ClientService;
import whoscared.esoftdemo.esoft.demo.services.DealService;
import whoscared.esoftdemo.esoft.demo.utils.validator.ClientValidator;

@Controller
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final ClientValidator clientValidator;
    private final DealService dealService;
    @Autowired
    public ClientController(ClientService clientService, ClientValidator clientValidator, DealService dealService) {
        this.clientService = clientService;
        this.clientValidator = clientValidator;
        this.dealService = dealService;
    }

    @GetMapping("/main")
    public String allClients(Model model) {
        model.addAttribute("clients", clientService.allClients());
        return "client/client_main";
    }

    @GetMapping("/new")
    public String newClient(Model model) {
        model.addAttribute("client", new Client());
        return "client/client_new";
    }

    @PostMapping()
    public String addNewClient(@ModelAttribute("client") @Valid Client client,
                               BindingResult bindingResult,
                               Model model) {
        clientValidator.validate(client, bindingResult);

        if (bindingResult.hasErrors()) {
            return "client/client_new";
        }
        clientService.save(client);
        return "redirect:/client/main";
    }

    @GetMapping("/{id}")
    public String oneClient(@PathVariable("id") long id,
                            Model model) {
        Client current = clientService.findById(id);
        model.addAttribute("client", current);
        model.addAttribute("offers", current.getOffer());
        model.addAttribute("demands", current.getDemand());
        model.addAttribute("deals", dealService.findByClientId(id));

        return "client/client_id";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id,
                       Model model) {
        model.addAttribute("client", clientService.findById(id));
        return "client/client_edit";
    }

    @PostMapping("/{id}")
    public String change(@PathVariable("id") long id,
                         @ModelAttribute("client") @Valid Client client,
                         BindingResult bindingResult,
                         Model model) {

        Client current = clientService.findById(id);
        model.addAttribute("offers", current.getOffer());
        model.addAttribute("demands", current.getDemand());
        model.addAttribute("deals", dealService.findByClientId(id));
        model.addAttribute("client", current);

        clientValidator.validate(client, bindingResult);
        if (bindingResult.hasErrors()) {
            return "client/client_edit";
        }
        clientService.update(id, client);
        return "client/client_id";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id,
                         Model model) {
        Client current = clientService.findById(id);
        if (current.getOffer() != null) {
            model.addAttribute("error", "You have not to delete this client!(This client has a offer)");
            return "client/client_id";
        }
        if (current.getDemand() != null) {
            model.addAttribute("error", "You have not to delete this client!(This client has a demand)");
            return "client/client_id";
        }
        if (dealService.findByClientId(id) != null){
            model.addAttribute("error", "You have not to delete this client!(This client predicate in deal)");
            return "client/client_id";
        }
        clientService.delete(id);
        return "client/client_main";
    }
}


package whoscared.esoftdemo.esoft.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import whoscared.esoft.esoftdemo.models.Client;
import whoscared.esoft.esoftdemo.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
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
                               Model model,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "client/client_new";
        }
        if (client.getEmail() == null && client.getPhone() == null){
            model.addAttribute("error", "You must fill in one of the fields: email or number");
            return "client/client_new";
        }
        clientService.save(client);
        return "redirect:/client";
    }

    @GetMapping("/{id}")
    public String oneClient(@PathVariable("id") long id,
                            Model model) {
        model.addAttribute("client", clientService.findById(id));
        model.addAttribute("offers", clientService.findById(id).getOffer());
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
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "client/client_edit";
        }
        clientService.update(id, client);
        return "client/client_id";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id,
                         Model model) {
        if (clientService.findById(id).getOffer() != null) {
            model.addAttribute("error", "You have not to delete this client!(This client has a offer)");
            return "client/client_id";
        }
        clientService.delete(id);
        return "client/client_main";
    }
}


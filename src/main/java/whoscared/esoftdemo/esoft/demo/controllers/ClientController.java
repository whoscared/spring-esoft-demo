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
//начало url для всех методов данного контроллера
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

    //главная страница - список клиентов
    @GetMapping("/main")
    public String allClients(Model model) {
        model.addAttribute("clients", clientService.allClients());
        return "client/client_main";
    }

    //создание нового клиента
    @GetMapping("/new")
    public String newClient(Model model) {
        model.addAttribute("client", new Client());
        return "client/client_new";
    }

    //получаем данные с представления о новом клиенте
    //аннотация @Valid для валидации данных с формы
    //если данные некорректны возвращаем страницу с ошибками
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

    //страница для каждого из клиентов
    @GetMapping("/{id}")
    public String oneClient(@PathVariable("id") long id,
                            Model model) {
        Client current = clientService.findById(id);
        model.addAttribute("client", current);
        //список предложений
        model.addAttribute("offers", current.getOffer());
        // список потребностей
        model.addAttribute("demands", current.getDemand());
        // список сделок
        model.addAttribute("deals", dealService.findByClientId(id));

        return "client/client_id";
    }

    //страница для редактирования клиентов (аналогично созданию нового клиента )
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

    //нельзя удалить клиента, у которого имеются предложения или потребности
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
        if (dealService.findByClientId(id) != null) {
            model.addAttribute("error", "You have not to delete this client!(This client predicate in deal)");
            return "client/client_id";
        }
        clientService.delete(id);
        return "client/client_main";
    }
}


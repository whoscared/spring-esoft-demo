package whoscared.esoftdemo.esoft.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;
import whoscared.esoftdemo.esoft.demo.services.RealtorService;

@Controller
@RequestMapping("/realtor")
public class RealtorController {
    private final RealtorService realtorService;

    @Autowired
    public RealtorController(RealtorService realtorService) {
        this.realtorService = realtorService;
    }

    @GetMapping("/main")
    public String allRealtors(Model model) {
        model.addAttribute("realtors", realtorService.allRealtors());
        return "realtor/realtor_main";
    }

    @GetMapping("/new")
    public String newRealtor(Model model) {
        model.addAttribute("realtor", new Realtor());
        return "realtor/realtor_new";
    }

    @PostMapping()
    public String addNewRealtor(@ModelAttribute("realtor") @Valid Realtor realtor,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "realtor/realtor_new";
        }
        realtorService.save(realtor);
        return "redirect:/realtor";
    }

//    @GetMapping("/{id}")
//    public String oneRealtor(@PathVariable("id") long id,
//                             Model model) {
//        model.addAttribute("realtor", realtorService.findById(id));
//        return "realtor/realtor_id";
//    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id,
                       Model model) {
        model.addAttribute("realtor", realtorService.findById(id));
        return "realtor/realtor_edit";
    }

    @PostMapping("/{id}")
    public String change(@PathVariable("id") long id,
                         @ModelAttribute("realtor") @Valid Realtor realtor,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "realtor/realtor_edit";
        }
        realtorService.update(id, realtor);
        return "realtor/realtor_id";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id,
                         Model model) {
        if (realtorService.findById(id).getOffer() != null){
            model.addAttribute("error", "You have not to delete this realtor!(This realtor has a offer)");
            return "realtor/realtor_id";
        }
        realtorService.delete(id);
        return "realtor/realtor_main";
    }
}

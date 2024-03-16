package whoscared.esoftdemo.esoft.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class HelloController {

    // для представления меню
    @GetMapping()
    public String hello() {
        return "/hello";
    }
}

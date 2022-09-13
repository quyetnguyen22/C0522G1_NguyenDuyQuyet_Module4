package email.configuration.controller;

import email.configuration.model.Setting;
import email.configuration.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/email")
@Controller
public class SettingController {

    @Autowired
    private ISettingService configuration;

//    @GetMapping("/create")
//    public String createEmail(Model model) {
//        model.addAttribute("email", new Setting());
//        model.addAttribute("language", configuration.getLanguages());
//        model.addAttribute("pageSize", configuration.getPageSize());
//        return "email";
//    }

    @GetMapping("/config")
    public ModelAndView configuration() {
        return new ModelAndView("configuration", "email", configuration.getEmail());
    }

    @GetMapping("/edit")
    public String editConfig(Model model) {
        model.addAttribute("email", configuration.getEmail());
        model.addAttribute("language", configuration.getLanguages());
        model.addAttribute("pageSize", configuration.getPageSize());
        return "email";
    }

    @GetMapping("/save")
    public String saveConfig(@ModelAttribute Setting email, Model model) {
        configuration.saveConfig(email);
        model.addAttribute("email", configuration.getEmail());
        return "configuration";
    }

}

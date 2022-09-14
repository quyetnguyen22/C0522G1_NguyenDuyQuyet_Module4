package medical.form.controller;

import medical.form.model.Medical;
import medical.form.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MedicalController {

    @Autowired
    IMedicalService medicalService;

    @GetMapping("/medicalForm")
    public String medicalForm(Model model) {
        model.addAttribute("medicalForm", new Medical());
        model.addAttribute("commute", medicalService.getCommuteInfo());
        model.addAttribute("nationality", medicalService.getNationality());
        model.addAttribute("gender", medicalService.getGender());
        return "medicalForm";
    }

    @GetMapping("/info")
    public String info(@Validated @ModelAttribute("medicalForm") Medical medical) {
        return "info";
    }
}

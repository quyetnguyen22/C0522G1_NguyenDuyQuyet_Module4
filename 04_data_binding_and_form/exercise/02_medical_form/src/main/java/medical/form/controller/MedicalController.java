package medical.form.controller;

import medical.form.model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicalController {

    @GetMapping("/medicalForm")
    public String medicalForm(Model model) {
        model.addAttribute("medicalForm", new Medical());
        return "medicalForm";
    }
}

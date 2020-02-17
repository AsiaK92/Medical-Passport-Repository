package pl.sda.medicalpassport.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.medicalpassport.infrastructure.HistoryFinder;
import pl.sda.medicalpassport.infrastructure.HistorySearch;
import pl.sda.medicalpassport.infrastructure.domain.MedicalHistoryService;
import pl.sda.medicalpassport.infrastructure.dto.MedicalHistoryDTO;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
class MainViewController {

    private  final MedicalHistoryService medicalHistoryService;

    private final HistoryFinder historyFinder;

    private final HistorySearch historySearch;

    @RequestMapping("/")
    ModelAndView mainView() {
        ModelAndView mav = new ModelAndView("index.html");
        mav.addObject("todayDate", LocalDate.now());

        return mav;
    }


    @GetMapping("/medical_history")
    ModelAndView getMedicalHistory() {
        ModelAndView modelAndView = new ModelAndView("medical_history.html");
        modelAndView.addObject("medical_history", historyFinder.findByLoggedUser());

        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView createMedicalHistoryView() {
        ModelAndView modelAndView = new ModelAndView("create_medical_history.html");
        modelAndView.addObject("medical_history", new MedicalHistoryDTO());

        return modelAndView;
    }

    @PostMapping("/create")
    String createMedicalHistory(@ModelAttribute MedicalHistoryDTO medicalHistory) {
        medicalHistoryService.create(medicalHistory);

        return "redirect:/";
    }

    @GetMapping("/delete")
    String deleteHistory(@RequestParam Long id) {
        medicalHistoryService.delete(id);

        return "redirect:/";
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/edit")
    ModelAndView editMedicalHistory(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("create_medical_history.html");
        modelAndView.addObject("medical_history", historyFinder.findById(id));

        return modelAndView;
    }

}
package com.residentevil.controllers;


import com.residentevil.models.viewModels.VirusViewModel;
import com.residentevil.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/cures")
public class CuresController {


    @Autowired
    private VirusService virusService;


    @GetMapping("")
    public String getVirusHomePage(Model model) {
        List<VirusViewModel> viruses = this.virusService.findAllViruses();
        model.addAttribute("viruses",viruses);
        return "cures";
    }

    @GetMapping("/delete/{virusId}")
    public String deleteVirus(@PathVariable long virusId) {
        this.virusService.deleteById(virusId);
        return "redirect:/cures";
    }
}

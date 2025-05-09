package com.kosmos.hospitalapp.controller;

import com.kosmos.hospitalapp.model.*;
import com.kosmos.hospitalapp.repository.*;
import com.kosmos.hospitalapp.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired private CitaService citaService;
    @Autowired private DoctorRepository doctorRepo;
    @Autowired private ConsultorioRepository consultorioRepo;

    @GetMapping
    public String listarCitas(Model model) {
        model.addAttribute("citas", citaService.todasLasCitas());
        return "lista-citas";
    }

    @GetMapping("/nueva")
    public String nuevaCitaForm(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("doctores", doctorRepo.findAll());
        model.addAttribute("consultorios", consultorioRepo.findAll());
        return "nueva-cita";
    }

    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Cita cita, Model model) {
        if (!citaService.validarCita(cita)) {
            model.addAttribute("error", "No se puede agendar la cita por conflicto de horarios o reglas.");
            return nuevaCitaForm(model);
        }
        citaService.guardarCita(cita);
        return "redirect:/citas";
    }
}

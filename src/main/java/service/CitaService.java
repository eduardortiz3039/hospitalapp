package com.kosmos.hospitalapp.service;

import com.kosmos.hospitalapp.model.*;
import com.kosmos.hospitalapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    @Autowired private CitaRepository citaRepo;

    public boolean validarCita(Cita nueva) {
        LocalDateTime startOfDay = nueva.getHorario().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);

        // Mismo consultorio y hora
        List<Cita> citasConsultorio = citaRepo.findByConsultorioAndHorarioBetween(
                nueva.getConsultorio(), nueva.getHorario(), nueva.getHorario().plusMinutes(1));
        if (!citasConsultorio.isEmpty()) return false;

        // Mismo doctor y hora
        List<Cita> citasDoctor = citaRepo.findByDoctorAndHorarioBetween(
                nueva.getDoctor(), nueva.getHorario(), nueva.getHorario().plusMinutes(1));
        if (!citasDoctor.isEmpty()) return false;

        // Paciente con menos de 2 horas entre citas
        List<Cita> citasPaciente = citaRepo.findByNombrePacienteAndHorarioBetween(
                nueva.getNombrePaciente(), startOfDay, endOfDay);
        for (Cita c : citasPaciente) {
            long minutos = Math.abs(java.time.Duration.between(c.getHorario(), nueva.getHorario()).toMinutes());
            if (minutos < 120) return false;
        }

        // Doctor con más de 8 citas en el día
        List<Cita> citasHoyDoctor = citaRepo.findByDoctorAndHorarioBetween(
                nueva.getDoctor(), startOfDay, endOfDay);
        if (citasHoyDoctor.size() >= 8) return false;

        return true;
    }

    public void guardarCita(Cita cita) {
        citaRepo.save(cita);
    }

    public List<Cita> todasLasCitas() {
        return citaRepo.findAll();
    }
}

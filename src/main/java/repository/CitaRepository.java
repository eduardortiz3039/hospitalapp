package com.kosmos.hospitalapp.repository;

import com.kosmos.hospitalapp.model.Cita;
import com.kosmos.hospitalapp.model.Consultorio;
import com.kosmos.hospitalapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByHorarioBetween(LocalDateTime start, LocalDateTime end);
    List<Cita> findByDoctorAndHorarioBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);
    List<Cita> findByConsultorioAndHorarioBetween(Consultorio consultorio, LocalDateTime start, LocalDateTime end);
    List<Cita> findByNombrePacienteAndHorarioBetween(String nombrePaciente, LocalDateTime start, LocalDateTime end);
}

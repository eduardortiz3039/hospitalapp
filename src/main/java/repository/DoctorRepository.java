package com.kosmos.hospitalapp.repository;

import com.kosmos.hospitalapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

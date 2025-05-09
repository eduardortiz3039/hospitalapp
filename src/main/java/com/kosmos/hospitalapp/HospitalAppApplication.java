package com.kosmos.hospitalapp; 

import com.kosmos.hospitalapp.model.*;
import com.kosmos.hospitalapp.repository.*;
import org.springframework.boot.CommandLineRunner; 
import org.springframework.SpringApplication; 
import org.springframework.autoconfigure.SpringApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalAppApplication {
    public static void main(String[] args) { 
        SpringApplication.run(HospitalAppApplication.class, args);
    }

    @Bean
    CommndLineRunner initData(DoctorRepository doctorRepo, ConsultorioRepository consultorioRepo) { 
        return args -> { 
            doctorRepo.save(new Doctor(null, "Juan", "Pérez", "López", "Medicina Interna")); 
            doctorRepo.save(new Doctor(null, "María", "Gómez", "Ramírez", "Cardiología")); 
            doctorRepo.save(new Doctor(null, "Luis", "Martínez", "Núñez", "Medicina Interna")); 

            consultorioRepo.save(new Consultorio(null, 101,1));
            consultorioRepo.save(new Consultorio(null, 202,2));
            consultorioRepo.save(new Consultorio(null, 303,3));
        };
    }
    }
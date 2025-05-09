# 🏥 HospitalApp - Gestión de Citas Médicas

Aplicación web desarrollada con Spring Boot para facilitar la gestión de citas médicas en el área de Medicina Interna de un hospital.

## 🎯 Objetivo

Resolver la problemática donde los doctores no tienen visibilidad de cuántas citas tienen al día ni a qué hora, permitiendo a los asistentes registrar y consultar citas médicas.

---

## 🧱 Funcionalidades

- Alta de citas médicas con reglas de validación:
  - No se puede agendar más de una cita en el mismo consultorio y hora.
  - No se puede agendar una cita para el mismo doctor y hora.
  - Un paciente no puede tener más de una cita con menos de 2 horas de diferencia el mismo día.
  - Un doctor no puede tener más de 8 citas por día.
- Consulta de citas por fecha, doctor o consultorio.
- Edición y cancelación de citas (solo si aún no ha pasado la hora).
- Interfaz web sencilla con Thymeleaf.

---

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database (en memoria)
- Thymeleaf (HTML + Bootstrap)
- Maven

---

## ⚙️ Instalación y ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/eduardortiz3039/HospitalApp.git
cd HospitalApp

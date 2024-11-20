package com.clinica.springboot.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.springboot.model.entities.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, String> {

}

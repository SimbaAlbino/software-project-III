package com.clinica.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.clinica.springboot.controller.exceptions.DatabaseException;
import com.clinica.springboot.controller.exceptions.ResourceNotFoundException;
import com.clinica.springboot.model.entities.AuxVeterinario;
import com.clinica.springboot.repositories.AuxVeterinarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuxVeterinarioService {
	
	@Autowired
	private AuxVeterinarioRepository repository;

	public List<AuxVeterinario> findAll() {
		return repository.findAll();
	}

	public AuxVeterinario findById(String id) {
		Optional<AuxVeterinario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // retorna o objeto do tipo AuxVeterinario que estiver																	// dentro do optional
	}

	public AuxVeterinario insert(AuxVeterinario obj) {
		return repository.save(obj);
	}

	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); //Passando exception da própria camada de serviço
		}
	}

	public AuxVeterinario update(String id, AuxVeterinario obj) {
		try {
			AuxVeterinario entity = repository.getReferenceById(id); //monitorar um obj pelo jpa para depois efetuar uma op no bd
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(AuxVeterinario entity, AuxVeterinario obj) {
		entity.setNome(obj.getNome());
		entity.setSenha(obj.getSenha());
	}
	
	public AuxVeterinario updatePatch(String id, AuxVeterinario obj) {
	    try {
	    	AuxVeterinario entity = repository.getReferenceById(id);
	        partialUpdateData(entity, obj); 
	        return repository.save(entity); 
	    } catch (EntityNotFoundException e) {
	        throw new ResourceNotFoundException(id); 
	    }
	}

	private void partialUpdateData(AuxVeterinario entity, AuxVeterinario obj) {
		if (obj.getNome() != null) {
			entity.setNome(obj.getNome());
		}
		if (obj.getSenha() != null) {
			entity.setSenha(obj.getSenha());
		}
	}
}

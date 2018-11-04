package it.laterale.demo.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.laterale.demo.rest.model.Demo;
import it.laterale.demo.rest.repositories.DemoRepository;

@Service
public class DemoService {

	@Autowired
	DemoRepository demoRepository;

	public Demo add(Demo entity) {
		if (entity.getId() != null) {
			this.exceptionManager(HttpStatus.UNPROCESSABLE_ENTITY, "The id field must not be specified.");
		}
		return this.demoRepository.saveAndFlush(entity);
	}

	public void delete(Long id) {
		try {
			this.demoRepository.deleteById(id);
		} catch (Exception e) {
			this.exceptionManager(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	private void exceptionManager(HttpStatus status, String message) {
		if (message != null) {
			throw new ResponseStatusException(status, message);
		}
		throw new ResponseStatusException(status);
	}

	public List<Demo> getAll() {
		return this.demoRepository.findAll();
	}

	public Demo getById(Long id) {
		Optional<Demo> entityOpt = this.demoRepository.findById(id);
		if (!entityOpt.isPresent()) {
			this.exceptionManager(HttpStatus.NOT_FOUND, "Entity with id '" + id + "' not found.");
		}
		return entityOpt.get();
	}

	public Demo getByName(String name) {
		Demo entity = this.demoRepository.findByName(name);
		if (entity == null) {
			this.exceptionManager(HttpStatus.NOT_FOUND, "Entity with name '" + name + "' not found.");
		}
		return entity;
	}

	public Demo update(Demo entity) {
		if (!this.demoRepository.existsById(entity.getId())) {
			this.exceptionManager(HttpStatus.NOT_FOUND, "Entity with id '" + entity.getId() + "' not found.");
		}
		return this.demoRepository.saveAndFlush(entity);
	}

}

package it.laterale.demo.rest.services;

import java.util.List;

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
		return this.demoRepository.getOne(id);
	}

	public Demo getByName(String name) {
		return this.demoRepository.findByName(name);
	}

	public Demo update(Demo entity) {
		if (!this.demoRepository.existsById(entity.getId())) {
			this.exceptionManager(HttpStatus.NOT_FOUND, null);
		}
		return this.demoRepository.saveAndFlush(entity);
	}

}

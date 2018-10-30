package it.laterale.demo.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.laterale.demo.rest.model.Demo;
import it.laterale.demo.rest.repositories.DemoRepository;

@Service
public class DemoService {

	@Autowired
	DemoRepository demoRepository;

	public Demo add(Demo entity) {
		return this.demoRepository.saveAndFlush(entity);
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

}

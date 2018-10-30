package it.laterale.demo.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.laterale.demo.rest.model.Demo;
import it.laterale.demo.rest.services.DemoService;

@RestController
@RequestMapping("demos")
public class DemoController {

	@Autowired
	DemoService demoService;

	@PostMapping("add")
	public Demo add(@RequestBody Demo entity) {
		return this.demoService.add(entity);
	}

	@GetMapping
	public List<Demo> get() {
		return this.demoService.getAll();
	}

	@GetMapping("demo")
	public Demo get(@RequestParam(name = "id") Long id) {
		return this.demoService.getById(id);
	}

	@GetMapping("demo/{name}")
	public Demo getByName(@PathVariable(name = "name") String name) {
		return this.demoService.getByName(name);
	}

}

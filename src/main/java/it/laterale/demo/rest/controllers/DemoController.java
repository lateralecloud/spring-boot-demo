package it.laterale.demo.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.laterale.demo.rest.model.Demo;
import it.laterale.demo.rest.services.DemoService;

@RestController
@RequestMapping("demos")
@Api(value = "Demo Api")
public class DemoController {

	@Autowired
	DemoService demoService;

	@PostMapping("add")
	@ApiOperation(value = "Create", notes = "Add new entity")
	public Demo add(@ApiParam(name = "entity", value = "The body request") @RequestBody Demo entity) {
		return this.demoService.add(entity);
	}

	@DeleteMapping("demo/{id}/delete")
	@ApiOperation(value = "Delete", notes = "Delete entity")
	public void delete(@ApiParam(name = "id", value = "Demo entity ID") @PathVariable(name = "id") Long id) {
		this.demoService.delete(id);
	}

	@GetMapping
	public List<Demo> get() {
		return this.demoService.getAll();
	}

	@GetMapping("demo/{id}")
	@ApiOperation(value = "Get one", notes = "Get entity by ID")
	public Demo get(@ApiParam(name = "id", value = "Demo entity ID") @PathVariable(name = "id") Long id) {
		return this.demoService.getById(id);
	}

	@GetMapping("demo")
	@ApiOperation(value = "Get one", notes = "Get entity by name")
	public Demo getByName(
			@ApiParam(name = "name", value = "Demo entity name") @RequestParam(name = "name") String name) {
		return this.demoService.getByName(name);
	}

	@PutMapping("demo/update")
	@ApiOperation(value = "Update", notes = "Update entity")
	public Demo update(@ApiParam(name = "entity", value = "The body request") @RequestBody Demo entity) {
		return this.demoService.update(entity);
	}

}

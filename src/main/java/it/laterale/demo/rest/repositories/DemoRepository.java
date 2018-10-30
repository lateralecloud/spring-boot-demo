package it.laterale.demo.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.laterale.demo.rest.model.Demo;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long> {

	public Demo findByName(String name);

}

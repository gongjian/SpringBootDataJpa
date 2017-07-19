package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;

@RestController
public class CacheController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/put")
	public Person put(Person person) {
		return personService.save(person);
	}
	
	@RequestMapping("/able")
	public Person cacheable(Person person) {
		return personService.findOne(person);
	}
	
	@RequestMapping("/evict")
	public void evict(Long id) {
		personService.remove(id);
	}

}

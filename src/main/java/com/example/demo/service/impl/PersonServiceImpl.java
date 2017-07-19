package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	@CachePut(value = "people", key = "'people' + #person.id")
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println("Cached key: " + person.getId());

		return p;
	}

	@Override
	@CacheEvict(value = "people", key = "'people' + #person.id")
	public void remove(Long id) {
		personRepository.delete(id);
		System.out.println("Removed cache for key: " + id);
	}

	@Override
	@Cacheable(value = "people", key = "'people' + #person.id")
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println("Cached key:: " + person.getId());

		return p;
	}

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Person;

@RestController
public class DataController {

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/save")
	public Person save(String name, String address, Integer age) {

		Person p = personRepository.save(new Person(null, name, age, address));

		return p;
	}

	@RequestMapping("/q1")
	public List<Person> q1(String address) {

		List<Person> people = personRepository.findByAddress(address);

		return people;

	}

	@RequestMapping("/q2")
	public Person q2(String name, String address) {

		Person person = personRepository.findByNameAndAddress(name, address);

		return person;
	}

	@RequestMapping("/q3")
	public Person q3(String name, String address) {

		Person person = personRepository.withNameAndAddressQuery(name, address);

		return person;
	}

	@RequestMapping("/q4")
	public List<Person> q4(String name, String address) {

		List<Person> people = personRepository.withNameAndAddressNamedQuery(name, address);

		return people;
	}

	@RequestMapping("/sort")
	public List<Person> sort() {

		List<Person> people = personRepository.findAll(new Sort(Direction.ASC, "age"));

		return people;
	}

	@RequestMapping("/page")
	public Page<Person> page() {

		Page<Person> people = personRepository.findAll(new PageRequest(1, 2, new Sort(Direction.ASC, "age")));

		return people;

	}

	//定制的模糊查询
	/*@RequestMapping("/auto")
	public Page<Person> auto(Person person) {

		Page<Person> people = personRepository.findByAuto(person, null);

		return people;
	}*/

}

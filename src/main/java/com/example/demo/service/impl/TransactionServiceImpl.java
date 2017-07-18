package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Person;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	@Transactional(rollbackFor = { IllegalArgumentException.class })
	public Person savePersonWithRollBack(Person person) {
		Person p = personRepository.save(person);

		if ("gongjian".equals(p.getName())) {
			throw new IllegalArgumentException("记录已存在");
		}

		return p;
	}

	@Override
	@Transactional(noRollbackFor = { IllegalArgumentException.class })
	public Person savePersonWithoutRollBack(Person person) {
		Person p = personRepository.save(person);

		if ("gongjian".equals(p.getName())) {
			throw new IllegalArgumentException("记录已存在");
		}

		return p;
	}

}

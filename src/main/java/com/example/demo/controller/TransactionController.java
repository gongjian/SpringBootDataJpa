package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Person;
import com.example.demo.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@RequestMapping("/rollback")
	public Person rollback(Person person) {
		return transactionService.savePersonWithRollBack(person);
	}

	@RequestMapping("/norollback")
	public Person noRollback(Person person) {
		return transactionService.savePersonWithoutRollBack(person);
	}

}

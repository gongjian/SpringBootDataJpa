package com.example.demo.service;

import com.example.demo.domain.Person;

public interface TransactionService {

	public Person savePersonWithRollBack(Person person);

	public Person savePersonWithoutRollBack(Person person);

}

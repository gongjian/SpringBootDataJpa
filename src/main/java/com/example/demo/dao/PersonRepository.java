package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Person;
import com.example.demo.support.CustomRepository;

public interface PersonRepository extends CustomRepository<Person, Long> {

	// 方法名查询
	List<Person> findByAddress(String address);

	// 方法名查询
	Person findByNameAndAddress(String name, String address);

	// 使用@Query查询
	@Query("select p from Person p where p.name = :name and p.address = :address")
	Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

	// 使用@NamedQuery查询
	List<Person> withNameAndAddressNamedQuery(String name, String address);
}

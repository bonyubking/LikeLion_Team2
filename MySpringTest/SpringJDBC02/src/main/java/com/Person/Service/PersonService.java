package com.Person.Service;

import java.util.List;

import com.Person.java.Person;

public interface PersonService {
	
	//biz dao
	
	List<Person> selectAllPerson();
	int insertPerson(Person p);
	int deletePerson(Person p);
	int updatePerson(Person p);

}

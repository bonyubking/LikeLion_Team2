package com.Person.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Person.dao.PersonDao;
import com.Person.dao.PersonDaoImple;
import com.Person.java.Person;

@Service
public class PersonServiceImple implements PersonService{
	
	@Autowired
	private PersonDao dao;
	
	@Override
	public List<Person> selectAllPerson(){
		
		return dao.selectAllPerson();
		
	}

	@Override
	public int insertPerson(Person p) {
		// TODO Auto-generated method stub
		return dao.insertPerson(p);
	}

	@Override
	public int deletePerson(Person p) {
		// TODO Auto-generated method stub
		return dao.deletePerson(p);
	}

	@Override
	public int updatePerson(Person p) {
		// TODO Auto-generated method stub
		return dao.updatePerson(p);
	}

	public Person searchByName(Person p) {

		return dao.searchByName(p);

	}

	public List<Person> getPersonByPage(int page, int size) {
		
		return dao.getPersonByPage(page, size);
	}
}

package com.Person.view;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Person.java.Person;

@Component
public class PersonColsolView {
	
	public void showAllList(List<Person> list) {
		for (Person p : list) {
			System.out.println(p.getName() + "\t" + p.getAddress() + "\t" + p.getPhone());
		}
	}
	
	public void showMessage(String message) {
		System.out.println("[알림]" + message);
	}

	public void saveToFile(List<Person> selectAllPerson, String file_name) {
		
		try(java.io.FileWriter fw = new java.io.FileWriter(file_name)){
			
			for(Person p : selectAllPerson) {
				
				fw.write(p.getName()+ "\t" + p.getAddress() + "\t" + p.getPhone() + "\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

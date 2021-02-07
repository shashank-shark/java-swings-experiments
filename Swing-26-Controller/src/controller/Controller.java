package controller;

import gui.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmployeeCategory;
import model.Gender;
import model.Person;

public class Controller {
	
	Database database = new Database();
	
	public void addPerson(FormEvent e) {
		String name = e.getName();
		String occupation = e.getOccupation();
		int ageCat = e.getAgeCategory();
		String empCat = e.getEmpCat();
		String gender = e.getGender();
		boolean isIndian = e.isIndian();
		String taxId = e.getTaxId();
		
		// Set AgeCategory
		AgeCategory ageCategory = null;
		switch (ageCat) {
			case 0: {
				ageCategory = AgeCategory.child;
			} break;
			case 1: {
				ageCategory = AgeCategory.adult;
			} break;
			case 2: {
				ageCategory = AgeCategory.senior;
			} break;
		}
		
		// Set Employee Category
		EmployeeCategory employeeCategory = null;
		if (empCat.equalsIgnoreCase("employed")) {
			employeeCategory = EmployeeCategory.employed;
		} else if (empCat.equalsIgnoreCase("unemployed")) {
			employeeCategory = EmployeeCategory.unemployed;
		} else if (empCat.equalsIgnoreCase("self-employed")) {
			employeeCategory = EmployeeCategory.selfEmployed;
		}
		
		// Set Gender Category
		Gender genderCategory = null;
		if (gender.equalsIgnoreCase("male")) {
			genderCategory = Gender.male;
		} else if (gender.equalsIgnoreCase("female")) {
			genderCategory = Gender.female;
		}
		
		Person person = new Person(name, occupation, ageCategory, employeeCategory, genderCategory, taxId, isIndian);
	}
}

package model;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static int count = 0;
	private int id;
	private String name;
	private String occupation;
	private AgeCategory ageCategory;
	private EmployeeCategory empCat;
	private Gender gender;
	private String taxId;
	private boolean isIndianCitizen;
	
	public Person(String name, String occupation, AgeCategory ageCategory, EmployeeCategory empCat,
			Gender gender, String taxId, boolean isIndianCitizen) {
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.empCat = empCat;
		this.gender = gender;
		this.taxId = taxId;
		this.isIndianCitizen = isIndianCitizen;
		
		this.id = count;
		count ++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public AgeCategory getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}
	public EmployeeCategory getEmpCat() {
		return empCat;
	}
	public void setEmpCat(EmployeeCategory empCat) {
		this.empCat = empCat;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public boolean isIndianCitizen() {
		return isIndianCitizen;
	}
	public void setIndianCitizen(boolean isIndianCitizen) {
		this.isIndianCitizen = isIndianCitizen;
	}
	
	
}

package com.inmar.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 	private Long Id;
	
    @Column(name = "Name")
	private String location;

    @Column(name = "Department")
	private String Department;
    
    @Column(name = "Category")
	private String Category;
    
    @Column(name = "sub_category")
	private String SubCategory;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getSubCategory() {
		return SubCategory;
	}

	public void setSubCategory(String subCategory) {
		SubCategory = subCategory;
	}

}

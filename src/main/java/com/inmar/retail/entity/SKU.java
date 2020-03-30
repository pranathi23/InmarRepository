/**
 * 
 */
package com.inmar.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SKU")
public class SKU {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(name = "NAME")
	private String skuName;

	@Column(name = "LOCATION")
	private String locationName;

	@Column(name = "DEPARTMENT")
	private String Department;

	@Column(name = "CATEGORY")
	private String Category;

	@Column(name = "SUBCATEGORY")
	private String SubCategory;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

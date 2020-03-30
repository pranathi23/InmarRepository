package com.inmar.retail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmar.retail.CustomException;
import com.inmar.retail.dao.RetailLocationRepo;
import com.inmar.retail.entity.Location;

@Service
public class RetailLocationService {

	@Autowired
	private RetailLocationRepo repository;

	public List<Location> getLocations() {
		List<Location> locationList = new ArrayList<Location>();
		locationList = (List<Location>) repository.findAll();
		if (locationList.isEmpty()) {
			try {
				throw new CustomException("Empty locations");
			} catch (CustomException e) {
				e.printStackTrace();
			}
		}
		return locationList;

	}

	public List<String> getDepartmentsForLocation(String locationName) {
		List<String> deptList = repository.getDepartmentsForLocation(locationName);
		return deptList;
	}

	public List<String> getCategoriesForLocation(String locationName, String dept_Name) {
		List<String> categoryList = repository.getCategoriesForLocation(locationName, dept_Name);
		return categoryList;
	}

	public List<String> getAllSubCategoriesForLocation(String locationName, String dept_Name, String category_Name) {
		List<String> subCategoryList = repository.getAllSubCategoriesForLocation(locationName, dept_Name,
				category_Name);
		return subCategoryList;
	}

	public List<String> getSubCategoriesForLocation(String locationName, String dept_Name, String category_Name,
			String subCategory) {
		List<String> subCategoryList = repository.getSubCategoriesForLocation(locationName, dept_Name, category_Name,
				subCategory);
		return subCategoryList;
	}

	public void saveLocation(Location location) {
		repository.save(location);
	}

	public Location findByName(String locationName) {
		Location location = repository.findByName(locationName);
		return location;

	}

}

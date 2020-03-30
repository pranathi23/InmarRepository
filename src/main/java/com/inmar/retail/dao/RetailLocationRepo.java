package com.inmar.retail.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmar.retail.entity.Location;

@Repository
public interface RetailLocationRepo extends JpaRepository<Location, Long> {

	@Query("select c from Location c")
	public List<Location> getLocations();

	@Query("select c.Department from Location c where Name=?1")
	public List<String> getDepartmentsForLocation(String locationName);

	@Query("select c.Department from Location c where Name=?1 AND Department=?2")
	public List<String> getCategoriesForLocation(String locationName, String dept_Name);

	@Query("select c.Department from Location c where Name=?1 AND Department=?2 AND Category=?3")
	public List<String> getAllSubCategoriesForLocation(String locationName, String dept_Name, String category_Name);

	@Query("select c.Department from Location c where Name=?1 AND Department=?2 AND Category=?3 AND sub_category=?4")
	public List<String> getSubCategoriesForLocation(String locationName, String dept_Name, String category_Name,
			String subCategory);

	@Query("select c from Location c where Name=?1")
	public Location findByName(String locationName);

}

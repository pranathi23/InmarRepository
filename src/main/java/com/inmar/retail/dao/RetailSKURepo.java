package com.inmar.retail.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmar.retail.entity.SKU;

@Repository
public interface RetailSKURepo extends JpaRepository<SKU, Long> {

	@Query("select c from SKU c where LOCATION=?1 AND DEPARTMENT=?2")
	public List<String> getSKUCodeForLocationAndDept(String locationName, String dept_Name);

	@Query("select c from SKU c where Name=?1")
	public SKU findByName(String skuName);
}

package com.inmar.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmar.retail.dao.RetailSKURepo;
import com.inmar.retail.entity.SKU;

@Service
public class RetailSKUService {
	@Autowired
	private RetailSKURepo repository;

	public List<String> getSKUCodeForLocationAndDept(String locationName, String dept_Name) {
		List<String> skuCodeList = repository.getSKUCodeForLocationAndDept(locationName, dept_Name);
		return skuCodeList;
	}

	public SKU findBySKUName(String skuName) {
		SKU skuInfo = repository.findByName(skuName);
		return skuInfo;
	}

	public void deleteSKUInfo(SKU sku) {
		repository.delete(sku);

	}
}

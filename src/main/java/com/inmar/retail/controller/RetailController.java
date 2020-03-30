package com.inmar.retail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inmar.retail.CustomException;
import com.inmar.retail.entity.Location;
import com.inmar.retail.entity.SKU;
import com.inmar.retail.service.RetailLocationService;
import com.inmar.retail.service.RetailSKUService;

@Controller
public class RetailController {

	@Autowired
	private RetailLocationService service;

	@Autowired
	private RetailSKUService skuService;

	@RequestMapping(value = "/location", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Location> getAllLocationInfo() {
		List<Location> location_list = new ArrayList<>();
		location_list = service.getLocations();
		return location_list;
	}

	@RequestMapping(value = "/location/{location_Name}/department", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getDepartmentsForLocation(@PathVariable("location_Name") String name) {
		List<String> deptList = new ArrayList<>();
		deptList = service.getDepartmentsForLocation(name);
		if (deptList.isEmpty()) {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(deptList, HttpStatus.OK);

	}

	@RequestMapping(value = "/location/{location_Name}/department/{department_Name}/category", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getCategoriesForLocation(@PathVariable("location_Name") String locName,
			@PathVariable("department_Name") String dept_Name) {
		List<String> categoryList = new ArrayList<>();
		categoryList = service.getCategoriesForLocation(locName, dept_Name);
		if (categoryList.isEmpty()) {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(categoryList, HttpStatus.OK);

	}

	@RequestMapping(value = "/location/{location_Name}/department/{department_Name}/category/{category_Name}/subcategory", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllSubCategoriesForLocation(@PathVariable("location_Name") String locName,
			@PathVariable("department_Name") String dept_Name, @PathVariable("category_Name") String category_Name) {
		List<String> subCategoryList = new ArrayList<>();
		subCategoryList = service.getAllSubCategoriesForLocation(locName, dept_Name, category_Name);
		if (subCategoryList.isEmpty()) {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(subCategoryList, HttpStatus.OK);

	}

	@RequestMapping(value = "/location/{location_Name}/department/{department_Name}/category/{category_Name}/subcategory/{subcategory_Name}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSubCategoriesForLocation(@PathVariable("location_Name") String locName,
			@PathVariable("department_Name") String dept_Name, @PathVariable("category_Name") String category_Name,
			@PathVariable("subcategory_Name") String subcategory_Name) {
		List<String> subCategoryList = new ArrayList<>();
		subCategoryList = service.getSubCategoriesForLocation(locName, dept_Name, category_Name, subcategory_Name);
		if (subCategoryList.isEmpty()) {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(subCategoryList, HttpStatus.OK);

	}

	@RequestMapping(value = "/location/{location_Name}/department/{department_Name}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSKUCodeForLocationAndDept(@PathVariable("location_Name") String locName,
			@PathVariable("department_Name") String dept_Name) {
		List<String> skuList = new ArrayList<>();
		skuList = skuService.getSKUCodeForLocationAndDept(locName, dept_Name);
		if (skuList.isEmpty()) {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(skuList, HttpStatus.OK);

	}

	@RequestMapping(value = "/createLocation", method = RequestMethod.POST)
	public void createDeptForLocation(@RequestBody Location location) {
		service.saveLocation(location);

	}

	@RequestMapping(value = "/location/{department_Name}", method = RequestMethod.PUT)
	public void updateDeptForLocation(@PathVariable("department_Name") String dept_Name,
			@RequestBody Location location) {
		Location locationInfo = service.findByName(location.getLocation());
		locationInfo.setDepartment(dept_Name);
		locationInfo.setCategory(location.getCategory());
		locationInfo.setLocation(location.getLocation());
		locationInfo.setSubCategory(location.getSubCategory());
		service.saveLocation(locationInfo);

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/sku/{sku_name}", method = RequestMethod.DELETE)
	public ResponseEntity<SKU> updateDeptForLocation(@PathVariable("sku_name") String sku_name, @RequestBody SKU sku) {
		SKU skuInfo = skuService.findBySKUName(sku_name);
		if (skuInfo == null) {
			return new ResponseEntity(new CustomException("Unable to delete" + sku_name + " not found."),
					HttpStatus.NOT_FOUND);
		}
		skuService.deleteSKUInfo(skuInfo);
		return new ResponseEntity<SKU>(HttpStatus.NO_CONTENT);

	}

}

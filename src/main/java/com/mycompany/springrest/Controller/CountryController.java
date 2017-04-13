package com.mycompany.springrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springrest.domain.Country;
import com.mycompany.springrest.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List getCountries() {
		List listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}
	
	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		return countryService.getCountryById(id);
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.POST, headers = "Accept=application/json")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@RequestBody int id) {
		countryService.deleteCountry(id);
	}
	
}

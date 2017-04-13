package com.mycompany.springrest.service;

import java.io.Serializable;
import java.util.List;

import com.mycompany.springrest.domain.Country;

public interface CountryService extends Serializable{
	
	public List<Country> getAllCountries();
	
	public Country getCountryById(int id);
	
	public Country addCountry(Country country); 

	public Country updateCountry(Country country);
	
	public Country deleteCountry(int id);
}

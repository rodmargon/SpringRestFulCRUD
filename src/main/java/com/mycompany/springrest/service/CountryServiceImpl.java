package com.mycompany.springrest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.springrest.domain.Country;

@Component
public class CountryServiceImpl implements CountryService {

	private static final long serialVersionUID = 1L;
	
	static HashMap<Integer, Country> countryIdMap = getCountryIdMap();

	public CountryServiceImpl() {
		super();
		if (countryIdMap==null) {
			countryIdMap=new HashMap<Integer,Country>();
			 // Creating some objects of Country while initializing
			 Country indiaCountry=new Country(1, "India",10000);
			 Country chinaCountry=new Country(4, "China",20000);
			 Country nepalCountry=new Country(3, "Nepal",8000);
			 Country bhutanCountry=new Country(2, "Bhutan",7000);
			 
			 countryIdMap.put(1,indiaCountry);
			 countryIdMap.put(4,chinaCountry);
			 countryIdMap.put(3,nepalCountry);
			 countryIdMap.put(2,bhutanCountry);
		}
	}
	
	public List<Country> getAllCountries() {
		return new ArrayList<Country>(countryIdMap.values());
	}

	public Country getCountryById(int id) {
		return countryIdMap.get(id);
	}

	public Country addCountry(Country country) {
		country.setId(getMaxId()+1);
		return countryIdMap.put(country.getId(), country);
	}

	public Country updateCountry(Country country) {
		if (country.getId()<=0)return null;
		return countryIdMap.put(country.getId(), country);
	}

	public Country deleteCountry(int id) {
		return countryIdMap.remove(id);
	}
	
	private int getMaxId() {
		int max=0;
		for (int id : countryIdMap.keySet()) {
			if(id>max) {
				max = id;
			}
		}
		return max;
	}
	
	private static HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}

}

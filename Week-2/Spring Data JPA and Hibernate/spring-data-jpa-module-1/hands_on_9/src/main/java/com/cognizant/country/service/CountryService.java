package com.cognizant.country.service;

import com.cognizant.country.model.Country;
import com.cognizant.country.repository.CountryRepository;
import com.cognizant.country.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);

        if(!result.isPresent()) {
            throw new CountryNotFoundException("Country Not Found For Code: " + countryCode);
        }

        Country country = result.get();
        return country;
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) {
        Optional<Country> result = countryRepository.findById(code);

        if(result.isPresent()) {
            Country country = result.get();
            country.setName(name);
            countryRepository.save(country);
        }
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
}

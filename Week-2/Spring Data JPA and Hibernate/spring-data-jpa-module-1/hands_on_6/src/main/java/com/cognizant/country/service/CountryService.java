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
}

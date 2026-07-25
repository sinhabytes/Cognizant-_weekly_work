package com.cognizant.country;

import com.cognizant.country.model.Country;
import com.cognizant.country.service.CountryService;
import com.cognizant.country.service.exception.CountryNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        countryService = context.getBean(CountryService.class);
        getAllCountriesTest();
        testAddCountry();
        testUpdateCountry();
    }

    private static void getAllCountriesTest() {
        try {
            Country country = countryService.findCountryByCode("IN");
            System.out.println("Country: " + country);
        }
        catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testAddCountry() {
        countryService.addCountry(new Country("ZZ", "Test Country"));

        try {
            Country added = countryService.findCountryByCode("ZZ");
            System.out.println("Added Country: " + added);
        }
        catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testUpdateCountry() {
        countryService.updateCountry("ZZ", "Updated Test Country");

        try {
            Country updated = countryService.findCountryByCode("ZZ");
            System.out.println("Updated Country: " + updated);
        }
        catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

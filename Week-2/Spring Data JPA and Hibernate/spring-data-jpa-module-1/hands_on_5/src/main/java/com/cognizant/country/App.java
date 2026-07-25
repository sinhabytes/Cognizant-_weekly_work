package com.cognizant.country;

import com.cognizant.country.model.Country;
import com.cognizant.country.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        countryService = context.getBean(CountryService.class);
        getAllCountriesTest();
    }

    private static void getAllCountriesTest() {
        List<Country> countries = countryService.getAllCountries();
        System.out.println("All Countries:");
        for(Country country : countries) {
            System.out.println("  " + country);
        }
    }
}

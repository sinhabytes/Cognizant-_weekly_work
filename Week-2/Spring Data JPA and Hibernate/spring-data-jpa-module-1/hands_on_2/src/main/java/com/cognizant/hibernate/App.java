package com.cognizant.hibernate;

import com.cognizant.hibernate.dao.CountryDAO;
import com.cognizant.hibernate.model.Country;
import com.cognizant.hibernate.util.HibernateUtil;

import java.util.List;

public class App {

    private static final CountryDAO countryDAO = new CountryDAO();

    public static void main(String[] args) {
        try {
            testGetAllCountries();
            testSaveCountry();
            testGetCountryByCode("IN");
            testUpdateCountry();
            testDeleteCountry();
        }
        finally {
            HibernateUtil.shutdown();
        }
    }

    private static void testGetAllCountries() {
        List<Country> countries = countryDAO.getAllCountries();
        System.out.println("All Countries:");
        for(Country country : countries) {
            System.out.println("  " + country);
        }
    }

    private static void testGetCountryByCode(String code) {
        Country country = countryDAO.getCountryByCode(code);
        System.out.println("Country = " + country);
    }

    private static void testSaveCountry() {
        countryDAO.saveCountry(new Country("IN", "India"));
        System.out.println("Country Saved Successfully");
    }

    private static void testUpdateCountry() {
        countryDAO.updateCountry("IN", "Republic of India");
        System.out.println("Country Updated Successfully");
    }

    private static void testDeleteCountry() {
        countryDAO.deleteCountry("IN");
        System.out.println("Country Deleted Successfully");
    }
}

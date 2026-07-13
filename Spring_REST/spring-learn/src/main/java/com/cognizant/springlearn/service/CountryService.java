package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private final List<Country> countries;

    @SuppressWarnings("unchecked")
    public CountryService() {
        LOGGER.info("START: Loading countryList bean in CountryService constructor");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countries = (List<Country>) context.getBean("countryList", ArrayList.class);
        LOGGER.info("END: CountryService constructor complete. Total countries loaded: {}", countries.size());
    }

    public List<Country> getAllCountries() {
        LOGGER.info("START: getAllCountries()");
        LOGGER.info("END: getAllCountries()");
        return countries;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START: getCountry() for code: {}", code);
        Country foundCountry = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);

        if (foundCountry == null) {
            LOGGER.error("Country code: {} not found", code);
            throw new CountryNotFoundException();
        }

        LOGGER.info("END: getCountry() found: {}", foundCountry);
        return foundCountry;
    }
}

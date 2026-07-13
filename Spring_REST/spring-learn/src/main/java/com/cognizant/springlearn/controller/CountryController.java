package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.service.CountryService;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    private Country indiaCountryBean;

    public CountryController() {
        LOGGER.info("START: Loading country bean in CountryController constructor");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.indiaCountryBean = context.getBean("country", Country.class);
        LOGGER.info("END: CountryController constructor complete. Loaded bean: {}", indiaCountryBean);
    }

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START: getCountryIndia()");
        LOGGER.info("END: getCountryIndia() returning: {}", indiaCountryBean);
        return indiaCountryBean;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START: getAllCountries()");
        List<Country> list = countryService.getAllCountries();
        LOGGER.info("END: getAllCountries()");
        return list;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START: getCountry() for code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END: getCountry() returning: {}", country);
        return country;
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START: addCountry() for country: {}", country);
        LOGGER.info("END: addCountry()");
        return country;
    }
}

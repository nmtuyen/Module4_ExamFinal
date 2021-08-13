package com.example.exam.controller;


import com.example.exam.model.Country;
import com.example.exam.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @GetMapping
    public ResponseEntity<Iterable<Country>> findAll(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

}

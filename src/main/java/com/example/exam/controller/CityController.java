package com.example.exam.controller;

import com.example.exam.model.City;
import com.example.exam.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping("")
    public ResponseEntity<Iterable<City>> findAll() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        if (!cityService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Optional<City> city = cityService.findById(id);
        return new ResponseEntity<>(city.get(), HttpStatus.OK);
    }

    @PutMapping("/api/update/{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city) {
        Optional<City> city1 = cityService.findById(id);
        if (!city1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        city.setId(id);
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("api/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id){
        Optional<City> city1 = cityService.findById(id);
        if (!city1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Optional<City>> saveNew(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(cityService.findById(city.getId()), HttpStatus.CREATED);
    }
}

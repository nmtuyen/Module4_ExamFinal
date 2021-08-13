package com.example.exam.repository;

import com.example.exam.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICountryRepository extends CrudRepository<Country, Long> {
}

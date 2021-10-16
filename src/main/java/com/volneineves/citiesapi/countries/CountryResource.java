package com.volneineves.citiesapi.countries;

import com.volneineves.citiesapi.countries.repository.CountryRepository;
import com.volneineves.citiesapi.states.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository repository;


    @GetMapping
    public ResponseEntity<List<Country>> findAll(){
        List<Country> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<Country> findById = repository.findById(id);

        if( findById.isPresent()){
            return ResponseEntity.ok().body(findById);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

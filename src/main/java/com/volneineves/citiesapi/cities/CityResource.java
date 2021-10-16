package com.volneineves.citiesapi.cities;

import com.volneineves.citiesapi.cities.repository.CityRepository;
import com.volneineves.citiesapi.states.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {

    @Autowired
    private CityRepository repository;

    @GetMapping
    public ResponseEntity<List<City>> findAll(){
        List<City> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<City> findById = repository.findById(id);

        if( findById.isPresent()){
            return ResponseEntity.ok().body(findById);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

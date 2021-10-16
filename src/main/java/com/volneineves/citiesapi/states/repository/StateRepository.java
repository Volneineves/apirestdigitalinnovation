package com.volneineves.citiesapi.states.repository;

import com.volneineves.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}

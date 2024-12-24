package com.airportsolutions.airportcrudservice.repo;

import com.airportsolutions.airportcrudservice.entity.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {
    List<Airport> findByStatus(String status);
    List<Airport> findByCityOrCountry(String city, String country);
    List<Airport> findByAirportNameContainingIgnoreCase(String airportName);

}
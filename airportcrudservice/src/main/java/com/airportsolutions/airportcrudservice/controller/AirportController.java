package com.airportsolutions.airportcrudservice.controller;
import com.airportsolutions.airportcrudservice.entity.Airport;
import com.airportsolutions.airportcrudservice.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService service;

    @GetMapping("/all")
    public List<Airport> listAirports()
    {
        return service.listAirports();
    }



    @GetMapping("/{airportCode}/searchbyairportCode")
    public Airport searchByAirportCode(@PathVariable String airportCode) {
        return service.searchAirportByCode(airportCode);
    }



    //remove update
    @PatchMapping("/{airportCode}/update")
    public Airport updateAirport(@PathVariable String airportCode, @RequestBody String jsonString) throws Exception {

        return service.updateAirport(airportCode, jsonString);
    }

    @DeleteMapping("/{airportCode}/delete")
    public void deleteAirport(@PathVariable String airportCode) {
        service.deleteAirport(airportCode);
    }

    @PatchMapping("/{airportCode}/deactivate")
    public Airport deactivateAirport(@PathVariable String airportCode) {
        return service.deactivateAirport(airportCode);
    }

    @GetMapping("/search")
    public List<Airport> searchAirports(@RequestParam String keyword) {
        return service.searchAirports(keyword);
    }



    @PostMapping("/upload")
    public String bulkUpload(@RequestBody String jsonString) {
        try {
            service.Upload(jsonString);
            return "upload successful!";
        } catch (Exception e) {
            return "Error during upload: " + e.getMessage();
        }
    }


}

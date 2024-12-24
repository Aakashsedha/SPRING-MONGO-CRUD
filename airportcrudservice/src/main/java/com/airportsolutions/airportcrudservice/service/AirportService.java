package com.airportsolutions.airportcrudservice.service;

import com.airportsolutions.airportcrudservice.entity.Airport;
import com.airportsolutions.airportcrudservice.repo.AirportRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AirportService {

    @Autowired
    private AirportRepository repository;

    //Listing the airports
    public List<Airport> listAirports()
    {
        return repository.findAll();
    }





    public  Airport searchAirportByCode(String airportCode)
    {
        return repository.findById(airportCode).get();
    }



   //Update Airport
   public Airport updateAirport(String airportCode,String jsonString) throws Exception {
       ObjectMapper objectMapper = new ObjectMapper();
       JsonNode rootNode = objectMapper.readTree(jsonString);

       // Assuming there is only one airportCode in the root of the JSON
       if (rootNode.size() != 1) {
           throw new IllegalArgumentException("Invalid JSON structure: Expected one airportCode key.");
       }

       Map.Entry<String, JsonNode> entry = rootNode.fields().next();
       String airportCode1 = entry.getKey(); // Extract airportCode
       JsonNode airportData = entry.getValue(); // Extract corresponding airport data

       // Find the existing Airport object
       Airport existing = repository.findById(airportCode)
               .orElseThrow(() -> new NoSuchElementException("Airport not found with code: " + airportCode));

       // Update fields only if they exist in the input JSON



       if (airportData.has("airport_name")) {
           existing.setAirportName(airportData.get("airport_name").asText());
       }
       if (airportData.has("city")) {
           existing.setCity(airportData.get("city").asText());
       }
       if (airportData.has("country")) {
           existing.setCountry(airportData.get("country").asText());
       }
       if (airportData.has("country_code")) {
           existing.setCountryCode(airportData.get("country_code").asText());
       }
       if (airportData.has("dst_indicator")) {
           existing.setDstIndicator(airportData.get("dst_indicator").asText());
       }
       if (airportData.has("latitude")) {
           existing.setLatitude(airportData.get("latitude").asText());
       }
       if (airportData.has("longitude")) {
           existing.setLongitude(airportData.get("longitude").asText());
       }
       if (airportData.has("listing_display")) {
           existing.setListingDisplay(airportData.get("listing_display").asBoolean());
       }
       if (airportData.has("pseudonyms")) {
           existing.setPseudonyms(airportData.get("pseudonyms").asText());
       }
       if (airportData.has("region")) {
           existing.setRegion(airportData.get("region").asText());
       }
       if (airportData.has("timezone")) {
           existing.setTimezone(airportData.get("timezone").asText());
       }
       if (airportData.has("outbound")) {
           existing.setOutbound(airportData.get("outbound").asText());
       }
       if (airportData.has("tzregion")) {
           existing.setTzregion(airportData.get("tzregion").asText());
       }
       if (airportData.has("status")) {
           existing.setStatus(airportData.get("status").asText());
       }

       //Edge-case AirportCode change
       if(existing.getAirportCode()!=airportCode1)
       {
           existing.setAirportCode(airportCode1);
       }


       // Save and return the updated Airport object
       return repository.save(existing);
   }





//   public Airport updateAirport(String airportCode, Airport airport) {
//       Airport existing = repository.findById(airportCode).get();
//
//
//       // Update all fields directly
//       existing.setAirportName(airport.getAirportName());
//       existing.setCity(airport.getCity());
//       existing.setCountry(airport.getCountry());
//       existing.setCountryCode(airport.getCountryCode());
//       existing.setDstIndicator(airport.getDstIndicator());
//       existing.setLatitude(airport.getLatitude());
//       existing.setLongitude(airport.getLongitude());
//       existing.setListingDisplay(airport.getListingDisplay());
//       existing.setPseudonyms(airport.getPseudonyms());
//       existing.setRegion(airport.getRegion());
//       existing.setTimezone(airport.getTimezone());
//       existing.setOutbound(airport.getOutbound());
//       existing.setTzregion(airport.getTzregion());
//       existing.setStatus(airport.getStatus());
//
//       return repository.save(existing);
//       //ct config changes
//   }


   //Delete Airport
    public void deleteAirport(String airportCode)
    {
        repository.deleteById(airportCode);
    }



    public Airport deactivateAirport(String airportCode) {
        Airport airport = repository.findById(airportCode).get();
        airport.setStatus("DEACTIVE");
        return repository.save(airport);
    }

    public List<Airport> searchAirports(String keyword) {
        return repository.findByAirportNameContainingIgnoreCase(keyword);
    }




    //upload
    public void Upload(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);

        List<Airport> airportList = new ArrayList<>();
        Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            String airportCode = entry.getKey(); // Key as airportCode

            JsonNode airportData = entry.getValue();
            Airport airport = new Airport();
            airport.setAirportCode(airportCode); // Now serves as the _id
            airport.setAirportName(airportData.get("airport_name").asText());
            airport.setCity(airportData.get("city").asText());
            airport.setCountry(airportData.get("country").asText());
            airport.setCountryCode(airportData.get("country_code").asText());
            airport.setDstIndicator(airportData.get("dst_indicator").asText());
            airport.setLatitude(airportData.get("latitude").asText());
            airport.setLongitude(airportData.get("longitude").asText());
            airport.setRegion(airportData.get("region").asText());
            airport.setTimezone(airportData.get("timezone").asText());
            airport.setOutbound(airportData.has("outbound") ? airportData.get("outbound").asText("") : null);
            airport.setTzregion(airportData.get("tzregion").asText());
            airport.setListingDisplay(airportData.get("listing_display").asBoolean());
            airport.setPseudonyms(airportData.get("pseudonyms").asText());
            airport.setStatus("ACTIVE");

            airportList.add(airport);
        }

        // Bulk Insert
        if (!airportList.isEmpty()) {
            repository.saveAll(airportList);
        }
    }


}

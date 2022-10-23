package com.GargAbhishek.RestfulWebServicesApi.controller;

import com.GargAbhishek.RestfulWebServicesApi.classes.UserV1;
import com.GargAbhishek.RestfulWebServicesApi.classes.UserV2;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/static-filter")
    public UserV1 staticFilter(){
        return new UserV1("Abhishek Garg","1234",22,"Indian");
    }

    @GetMapping("/dynamic-filter")
    public MappingJacksonValue dynamicFilter(){
        UserV2 userV2= new UserV2("Abhishek","Garg","1234",22,"Indian",30000);

        SimpleBeanPropertyFilter filter=
                SimpleBeanPropertyFilter.filterOutAllExcept("firstName","lastName","nationality","income");

        FilterProvider filters= new SimpleFilterProvider().addFilter("UserV2 Filter",filter);

        MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(userV2);

        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}

package com.GargAbhishek.RestfulWebServicesApi.controller;

import com.GargAbhishek.RestfulWebServicesApi.classes.UserV1;
import com.GargAbhishek.RestfulWebServicesApi.classes.UserV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VersionController {

    @GetMapping("/v1/user")
    public UserV1 apiVersionOne(){
        return new UserV1("Abhishek Garg", "1234",22,"Indian");
    }

    @GetMapping("/v2/user")
    public UserV2 apiVersionTwo(){
        return new UserV2("Abhishek","Garg","1234"
                ,22,"Indian",30000);
    }

    @GetMapping(path = "/user", params = "version=1")
    public UserV1 apiVersionOneParameter(){
        return new UserV1("Abhishek Garg", "1234",22,"Indian");
    }

    @GetMapping(path = "/user",params = "version=2")
    public UserV2 apiVersionTwoParameter(){
        return new UserV2("Abhishek","Garg","1234"
                ,22,"Indian",30000);
    }

    @GetMapping(path = "/user/header", headers = "user-api-version=1")
    public UserV1 apiVersionOneCustom(){
        return new UserV1("Abhishek Garg", "1234",22,"Indian");
    }

    @GetMapping(path = "/user/header",headers = "user-api-version=2")
    public UserV2 apiVersionTwoCustom(){
        return new UserV2("Abhishek","Garg","1234"
                ,22,"Indian",30000);
    }

    @GetMapping(path = "/user/accept", produces = "application/api-v1+json")
    public UserV1 apiVersionOneMime(){
        return new UserV1("Abhishek Garg", "1234",22,"Indian");
    }

    @GetMapping(path = "/user/accept",produces = "application/api-v2+json")
    public UserV2 apiVersionTwoMime(){
        return new UserV2("Abhishek","Garg","1234"
                ,22,"Indian",30000);
    }
}

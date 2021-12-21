package com.ls.server.controller;

import com.ls.server.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestServices testServices;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String get(@RequestParam("name") String name) {
        return testServices.get(name);
    }



}
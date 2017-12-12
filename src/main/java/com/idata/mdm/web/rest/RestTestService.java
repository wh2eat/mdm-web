package com.idata.mdm.web.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RestTestService {

    //
    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> helloWorld(@RequestParam("name") String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", name);
        map.put("time", new Date(System.currentTimeMillis()));
        return map;
    }

    @GetMapping(value = "/xml/hello", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Map<String, Object> xmlHello(@RequestParam("name") String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", name);
        map.put("time", new Date(System.currentTimeMillis()));
        return map;
    }
}

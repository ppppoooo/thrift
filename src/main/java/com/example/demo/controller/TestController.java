package com.example.demo.controller;

import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @CreatTime 2019/7/22
 **/
@RestController
public class TestController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("test")
    public String get(@RequestParam(value = "test") String s){
        try {
            return clientService.get(s);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}

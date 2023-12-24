package com.exemple.client2service.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Value("${eureka.instance.instance-id}")
    private String id;

    @GetMapping("/test")
    public String test() {
        return id;
    }
   /*@GetMapping("/test")
    public String test() {
        List<String> stringList = Arrays.asList("bbb");
        Random ram = new Random();
        int randomNum = ram.nextInt(stringList.size());
        return stringList.get(randomNum);
    }**/
}
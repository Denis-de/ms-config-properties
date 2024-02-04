package com.exemple.checkbookservice.controller;

import com.exemple.checkbookservice.model.RemotePropertyField;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckBookServiceController {
    private RemotePropertyField field;


    @GetMapping(value = "/getRemoteField")
    public String getRemotePropertyField() {
        return "Data: " + field.getField();
    }
}

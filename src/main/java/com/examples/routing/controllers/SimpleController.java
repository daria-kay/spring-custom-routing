package com.examples.routing.controllers;

import com.examples.routing.models.SimpleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examples.routing.annotation.ApiVersion;

@RestController
@RequestMapping
public class SimpleController {

    @ApiVersion("v1")
    @GetMapping
    public SimpleResponse createTaskV1() {
        return SimpleResponse.builder()
                .name("Response version 1")
                .build();
    }

    @ApiVersion("v2")
    @GetMapping
    public SimpleResponse createTaskV2() {
        return SimpleResponse.builder()
                .name("Response version 2 or upper")
                .build();
    }

}

package com.spring.assignments.applicateai.controllers;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path="/")
public class HomeController {
    @GetMapping(path = "/ping",produces = MediaType.TEXT_HTML_VALUE)
    public String ping() {
        return "pong";
    }
}
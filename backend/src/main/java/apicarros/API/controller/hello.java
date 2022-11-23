package apicarros.API.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class hello {

    @GetMapping("/")
    public String hello()
        {
            return "Ola mundo"+ new Date();
        }

}

package com.example.weather.controllers;

import com.example.weather.models.WeatherModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("city") String city,
                        Model model) {
        // tutaj bedziemy laczyc sie z pogoda
//        https://api.openweathermap.org/data/2.5/weather?q=Warsaw,pl&appid=3a2a64c92fee5e868fcf6dc7e1c1b598

        WeatherModel weatherModel = getRestTemplate().getForObject("http://api.openweathermap.org/data/2.5/weather?q="+city+",pl&appid=3a2a64c92fee5e868fcf6dc7e1c1b598",
        WeatherModel.class );
        model.addAttribute("weather",weatherModel);



        return "index";
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();


    }




}

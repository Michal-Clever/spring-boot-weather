package com.example.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherModel {

    @JsonProperty("main")
    private TempModel tempModel;

    @JsonProperty("clouds")
    private CloudsModel cloudModel;


    @Data
    public static class TempModel {


        private int temp ;

        public void setTemp(int temp) {
            this.temp = temp-273;
        }
    }

    @Data
    public static class CloudsModel {
        @JsonProperty("all")
        private double cloud;
    }

}

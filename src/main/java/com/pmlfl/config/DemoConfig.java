package com.pmlfl.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DemoConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

package org.luke.calculator;

import org.luke.addition.AdderModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorApplicationConfiguration {

    @Bean
    public AdderModule adderModule() {
        return new AdderModule();
    }
}

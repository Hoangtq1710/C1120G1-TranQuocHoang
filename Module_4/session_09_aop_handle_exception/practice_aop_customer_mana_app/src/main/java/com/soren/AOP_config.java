package com.soren;

import com.soren.concern.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOP_config {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}

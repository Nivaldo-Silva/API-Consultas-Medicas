package br.com.nivaldosilva.consultas_api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
 
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}

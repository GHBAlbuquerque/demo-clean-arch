package br.com.ghbalbuquerque.democleanarch.infrastructure.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        final var mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);

        return mapper;
    }
}

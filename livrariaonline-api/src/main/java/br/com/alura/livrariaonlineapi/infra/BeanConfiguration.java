package br.com.alura.livrariaonlineapi.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfiguration {

    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder(){

        return new BCryptPasswordEncoder();

    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
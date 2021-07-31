package com.pacatovisk.ordemservico.configuration;

import com.pacatovisk.ordemservico.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstaciaBaseDeDados {

    @Autowired
    private DBService dbService;

    @Bean
    public void instacia(){
        dbService.IntanciaBaseDeDados();
    }
}

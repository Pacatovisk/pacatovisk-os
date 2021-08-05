package com.pacatovisk.ordemservico.configuration;

import com.pacatovisk.ordemservico.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstaciaBaseDeDados {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;


    @Bean
    public void instacia(){

        //if (ddl.equals("create")) {
            this.dbService.IntanciaBaseDeDados();
        //}

       // return false;
    }
}

package com.cdc.config;

import com.cdc.model.AutorModel;
import com.cdc.model.CategoriaModel;
import com.cdc.model.PaisModel;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @org.springframework.context.annotation.Bean
    public AutorModel autorModel(){
        return new AutorModel();
    }

    @org.springframework.context.annotation.Bean
    public CategoriaModel categoriaModel(){
        return new CategoriaModel();
    }

    @org.springframework.context.annotation.Bean
    public PaisModel paisModel(){
        return new PaisModel();
    }




}

package com.cdc.config;

import com.cdc.model.Autor;
import com.cdc.model.Categoria;
import com.cdc.model.PaisModel;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @org.springframework.context.annotation.Bean
    public Autor autorModel(){
        return new Autor();
    }

    @org.springframework.context.annotation.Bean
    public Categoria categoriaModel(){
        return new Categoria();
    }

    @org.springframework.context.annotation.Bean
    public PaisModel paisModel(){
        return new PaisModel();
    }




}

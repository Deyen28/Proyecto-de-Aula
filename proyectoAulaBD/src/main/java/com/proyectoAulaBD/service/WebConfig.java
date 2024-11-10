package com.proyectoAulaBD.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapear la URL /evidencias/** al directorio físico donde se guardan las imágenes
        registry.addResourceHandler("/evidencias/**")
                .addResourceLocations("file:C:/Users/esnne/OneDrive/Desktop/proyectoAulaBD/src/main/resources/evidencias/");
    }
}

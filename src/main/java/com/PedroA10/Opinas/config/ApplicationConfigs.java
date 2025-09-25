package com.PedroA10.Opinas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class ApplicationConfigs {
  @Bean
  public ModelMap modelMapper() {
    return new ModelMap();
  }
}

package com.lima.battleofmyeongnyang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {
    @Value("${datasource.driver-class-name}")
    private String className;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String userName;

    @Value("${datasource.password}")
    private String password;

  @Bean
  public DataSource dataSource() {
      return DataSourceBuilder.create()
              .driverClassName(className)
              .url(url)
              .username(userName)
              .password(password)
              .build();
  }
}

package com.example.gallery.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataBaseConfig {

  @Value("${spring.datasource.driver}")
  private String driverClassName;

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String dbUser;

  @Value("${spring.datasource.password}")
  private String dbPassword;

  @Bean(name = "DataSource")
  @ConfigurationProperties(prefix = "bar.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create()
            .password(dbPassword)
            .url(url)
            .username(dbUser)
            .driverClassName(driverClassName)
            .build();
  }

  @Bean(name = "EntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean EntityManagerFactory(
          EntityManagerFactoryBuilder builder, @Qualifier("DataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.example.gallery.domain").persistenceUnit("gallery")
            .build();
  }

  @Bean(name = "TransactionManager")
  public PlatformTransactionManager TransactionManager(
          @Qualifier("EntityManagerFactory") EntityManagerFactory EntityManagerFactory) {
    return new JpaTransactionManager(EntityManagerFactory);
  }
}

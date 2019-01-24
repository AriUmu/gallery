package com.example.gallery.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DataBaseConfig {

  @Value("${spring.datasource.driverClassName}")
  private String driverClassName;

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String dbUser;

  @Value("${spring.datasource.password}")
  private String dbPassword;

  @Value("${spring.jpa.database-platform}")
  private String hibernateDialect;


  @Value("${dbSQLSchema}")
  private Resource dbSQLSchema;

  @Value("${dbSQLData}")
  private Resource dbSQLSData;

  @Value("${spring.profiles.active}")
  private String profile;

  @Bean(name = "DataSource")
  public DataSource dataSource() {
    DataSource dataSource = DataSourceBuilder.create()
            .password(dbPassword)
            .url(url)
            .username(dbUser)
            .driverClassName(driverClassName)
            .build();

    final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    if(profile.equals("dev")){
//       populator.addScript(dbSQLSchema);
//      populator.addScript(dbSQLSData);
    }
    DatabasePopulatorUtils.execute(populator, dataSource);
    return dataSource;
  }

  @Bean
  public Properties hibernateProperties() {
    Properties hibernateProp = new Properties();
    hibernateProp.put("hibernate.dialect", hibernateDialect);
    hibernateProp.put("hibernate.hbm2ddl.auto", "create-drop");
    hibernateProp.put("hibernate.format_sql", true);
    return hibernateProp;
  }
}

package com.honsoft.springhsql.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

		@Bean
		public BasicDataSource hsqlDataSource() {
			BasicDataSource hsqlDataSource = new BasicDataSource();
			hsqlDataSource.setUrl("jdbc:hsqldb:mem:mydb");
			hsqlDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
			hsqlDataSource.setUsername("sa");
			hsqlDataSource.setPassword("");
			return hsqlDataSource;
		}
}

package com.baeldung.ls.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class PersistenceConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("ls").setDataSourceFactory(factory).build();
    }

    private final DataSourceFactory factory = new DataSourceFactory() {

        private final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        @Override
        public DataSource getDataSource() {
            return dataSource;
        }

        @Override
        public ConnectionProperties getConnectionProperties() {
            return new ConnectionProperties() {

                @Override
                public void setUrl(String url) {
                    dataSource.setUrl(url);
                }

                @Override
                public void setUsername(String username) {
                    dataSource.setUsername("username");
                }

                @Override
                public void setPassword(String password) {
                    dataSource.setPassword("password");
                }

                @Override
                public void setDriverClass(Class<? extends java.sql.Driver> driverClass) {
                    dataSource.setDriverClass(driverClass);

                }
            };
        }
    };

}

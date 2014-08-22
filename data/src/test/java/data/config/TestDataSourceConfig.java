package data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author Dmitry Tsydzik
 * @since Date: 22.08.2014
 */
@Configuration
@Profile("test")
public class TestDataSourceConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseFactory databaseFactory = new EmbeddedDatabaseFactory();
        databaseFactory.setDatabaseType(EmbeddedDatabaseType.HSQL);
        return databaseFactory.getDatabase();
    }
}

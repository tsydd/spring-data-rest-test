package data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.URI;

/**
 * @author Dmitry Tsydzik
 * @since Date: 22.08.2014
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "data.config")
public class MyWebConfig extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.setBaseUri(URI.create("http://localhost:8081/api"));
    }
}

package src.com.revature.flash_back_api.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// This class is used for programmatic bean registration with the container (aka: ApplicationContext)
@Configuration
@ComponentScan("com.revature") // if no package string is provided, then Spring will scan the package that this class is in for components
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


}

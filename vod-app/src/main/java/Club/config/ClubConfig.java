package Club.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClubConfig {
    @Bean
    public String sampleBean() {
        return "Przykładowy tekst";
    }
}

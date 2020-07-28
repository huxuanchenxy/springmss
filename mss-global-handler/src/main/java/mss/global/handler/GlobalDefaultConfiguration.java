package mss.global.handler;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author purgeyao
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(GlobalDefaultProperties.class)
public class GlobalDefaultConfiguration {

    @Bean
    public GlobalExceptionHandler globalDefaultExceptionHandler() {
        return new GlobalExceptionHandler();
    }

//    @Bean
//    public GlobalExceptionHandler commonResponseDataAdvice(GlobalDefaultProperties globalDefaultProperties) {
//        return new GlobalExceptionHandler(globalDefaultProperties);
//    }

}
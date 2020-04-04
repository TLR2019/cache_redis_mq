package cn.edu.nuaa.searchuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @version 1.0
 **/

@SpringBootApplication

public class SearchUserApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SearchUserApplication.class, args);
    }
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

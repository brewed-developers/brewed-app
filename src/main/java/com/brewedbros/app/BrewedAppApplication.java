package com.brewedbros.app;

import com.brewedbros.app.peoperties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.UUID;
@ComponentScan(basePackages="com.brewedbros")
@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class BrewedAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrewedAppApplication.class, args);
    }


}

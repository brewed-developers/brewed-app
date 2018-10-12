package com.brewedbros.app;

import com.brewedbros.app.peoperties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages="com.brewedbros")
@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
//@EnableAutoConfiguration
public class BrewedAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrewedAppApplication.class, args);
    }


}

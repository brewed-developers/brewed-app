package com.brewedbros.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "copsboot-security") //<2>
public class SecurityConfiguration {
    private String mobileAppClientId;
    private String mobileAppClientSecret;
}
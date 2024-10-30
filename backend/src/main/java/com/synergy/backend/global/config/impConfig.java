package com.synergy.backend.global.config;

import com.siot.IamportRestClient.IamportClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class impConfig {
    private IamportClient iamportClient;
    @Value("${imp.api}")
    private String IMP_API_KEY;
    @Value("${imp.secret}")
    private String IMP_SECRET_KEY;

    @Bean
    public IamportClient iamportClient() {
        return new IamportClient(IMP_API_KEY, IMP_SECRET_KEY);
    }

}

package com.example.spring.boot.chatgpt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Indexed;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Configuration
@ConfigurationProperties
@Indexed
@Data
@Slf4j
public class OpenAIClientConfig {

    @Value("${openai-service.http-client.read-timeout}")
    private int readTimeOut;

    @Value("${openai-service.http-client.connect-timeout}")
    private int connectTimeOut;

    @Value("${openai-service.api-key}")
    private String apiKey;

    @Value("${openai-service.gpt-model}")
    private String model;

    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return request -> request.header("Authorization", "Bearer " + apiKey);
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(getConnectTimeOut(), getConnectTimeOut());
    }

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }


}

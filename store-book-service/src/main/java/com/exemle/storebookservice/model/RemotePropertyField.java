package com.exemle.storebookservice.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.yml")
@Data
@RefreshScope
public class RemotePropertyField {
    private String field;
}

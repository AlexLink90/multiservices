package com.example.supportmodule.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "app.cache")
@Configuration
@Getter
@Setter
public class CacheProperties {

    private CacheConfig addition;
    private CacheConfig multiplication;
    private CacheConfig division;
    private CacheConfig subtraction;

//    Map<String, CacheConfig> caches;

    public static class CacheConfig {
        String name;
        Integer ttl;
        Integer size;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getTtl() {
            return ttl;
        }

        public void setTtl(Integer ttl) {
            this.ttl = ttl;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }
    }

}

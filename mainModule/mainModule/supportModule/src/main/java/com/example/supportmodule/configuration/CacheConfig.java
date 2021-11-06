package com.example.supportmodule.configuration;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    private static final String DIVISION_CACHE_NAME = "divisionCache";
    private static final String ADDITIONAL_CACHE = "additionCache";
    private static final String SUBTRACTION_CACHE = "subtractionCache";
    private static final String MULTIPLICATION_CACHE = "multiplicationCache";

    private final CacheProperties cacheProperties;

    @Autowired
    public CacheConfig(CacheProperties cacheProperties) {
        this.cacheProperties = cacheProperties;
    }

    @Bean("cacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(String cacheName) {

                int maximumSize = 10;
                int ttl = 3000;

                switch (cacheName) {
                    case DIVISION_CACHE_NAME:
                        maximumSize = cacheProperties.getDivision().size;
                        ttl = cacheProperties.getDivision().ttl;
                        break;
                    case ADDITIONAL_CACHE:
                        maximumSize = cacheProperties.getAddition().size;
                        ttl = cacheProperties.getAddition().ttl;
                        break;
                    case MULTIPLICATION_CACHE:
                        maximumSize = cacheProperties.getMultiplication().size;
                        ttl = cacheProperties.getMultiplication().ttl;
                        break;
                    case SUBTRACTION_CACHE:
                        maximumSize = cacheProperties.getSubtraction().size;
                        ttl = cacheProperties.getSubtraction().ttl;
                        break;
                }
                return new ConcurrentMapCache(cacheName, CacheBuilder.newBuilder()
                        .maximumSize(maximumSize)
                        .expireAfterWrite(ttl, TimeUnit.SECONDS)
                        .build().asMap(), false);
            }
        };
    }
}

package com.springboot.cache.cacheConfiguration;

import org.apache.el.util.ConcurrentCache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public SimpleCacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        ConcurrentMapCache concurrentCache =new ConcurrentMapCache("cache-1");
        ConcurrentMapCache concurrentCache2 =new ConcurrentMapCache("persons");
        simpleCacheManager.setCaches(Arrays.asList(concurrentCache,concurrentCache2));
        return simpleCacheManager;
    }
}

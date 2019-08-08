package com.springboot.webConfiguration.configuration;

import com.springboot.webConfiguration.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PersonConfiguration {

    @Bean
    @Profile("prod")
    public Person liudehua() {
        Person person = new Person();
        person.setId(3l);
        person.setAge(13);
        person.setName("刘德华");
        return person;
    }
}

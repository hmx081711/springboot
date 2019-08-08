package com.springboot.webConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ImportResource(locations = {"classpath:META-INF/beans.xml","classpath:META-INF/bean2.xml"})
public class WebConfigurationApplication implements EnvironmentAware {

	public static void main(String[] args) {
		SpringApplication.run(WebConfigurationApplication.class, args);
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.err.println("当前激活的Profile："+ Arrays.asList(environment.getActiveProfiles()));

		ConfigurableEnvironment env = ConfigurableEnvironment.class.cast(environment);
		MutablePropertySources sources = env.getPropertySources();

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("server-port",8888);
		PropertySource source = new MapPropertySource("Java-code", map);
		sources.addFirst(source);
		System.out.println(sources);
	}
}

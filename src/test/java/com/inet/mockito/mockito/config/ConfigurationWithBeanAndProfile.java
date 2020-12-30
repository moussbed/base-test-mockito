package com.inet.mockito.mockito.config;

import com.inet.mockito.mockito.DataService;
import com.inet.mockito.mockito.SomeBusiness;
import com.inet.mockito.mockito.SomeBusinessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigurationWithBeanAndProfile {

    @Bean
    @Profile("test")
    public DataService dataService() {
        return new DataService() {
            @Override
            public int[] retrieveAllData() {
                return new int[]{12, 4};
            }

            @Override
            public void save(String name) {

            }
        };
    }

    @Bean
    @Profile("test")
    public SomeBusiness someBusiness(DataService dataService) {
        return new SomeBusinessImpl(dataService);
    }
}

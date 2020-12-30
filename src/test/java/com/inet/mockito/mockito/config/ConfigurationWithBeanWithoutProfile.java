package com.inet.mockito.mockito.config;

import com.inet.mockito.mockito.DataService;
import com.inet.mockito.mockito.SomeBusiness;
import com.inet.mockito.mockito.SomeBusinessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationWithBeanWithoutProfile {

    @Bean
    public DataService dataService() {
        return new DataService() {
            @Override
            public int[] retrieveAllData() {
                return new int[]{7, 4};
            }

            @Override
            public void save(String name) {

            }
        };
    }

    @Bean
    public SomeBusiness someBusiness(DataService dataService) {
        return new SomeBusinessImpl(dataService);
    }
}

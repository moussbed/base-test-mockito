package com.inet.mockito.mockito;

import com.inet.mockito.mockito.config.ConfigurationWithBeanAndProfile;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationWithBeanAndProfile.class})
@ActiveProfiles("test")
public class SomeBusinessWithBeanDefinedInClassConfigurationAndMarkActiveProfileTest {

    @Autowired
    DataService dataService;

    @Autowired
    SomeBusiness someBusiness;

    @Test
    public void test1(){
        int theGreatestFromAllData = someBusiness.findTheGreatestFromAllData();
       assertEquals(12,theGreatestFromAllData);
    }
}

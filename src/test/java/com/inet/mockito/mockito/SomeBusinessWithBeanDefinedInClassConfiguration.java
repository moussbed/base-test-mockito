package com.inet.mockito.mockito;

import com.inet.mockito.mockito.config.ConfigurationWithBeanWithoutProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationWithBeanWithoutProfile.class})
public class SomeBusinessWithBeanDefinedInClassConfiguration {

    @Autowired
    DataService dataService;

    @Autowired
    SomeBusiness someBusiness;

    @Test
    public void test1() {
        int theGreatestFromAllData = someBusiness.findTheGreatestFromAllData();
        assertEquals(7, theGreatestFromAllData);
    }
}

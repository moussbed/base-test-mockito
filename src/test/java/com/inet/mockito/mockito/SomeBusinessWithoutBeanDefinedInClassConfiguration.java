package com.inet.mockito.mockito;

import com.inet.mockito.mockito.config.ConfigurationComponentScanWithoutBeanDefined;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationComponentScanWithoutBeanDefined.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SomeBusinessWithoutBeanDefinedInClassConfiguration {

    @Autowired
    DataService dataService;

    @Autowired
    SomeBusiness someBusiness;

    @Test
    public void test1() {
        int theGreatestFromAllData = someBusiness.findTheGreatestFromAllData();
        assertEquals(Integer.MIN_VALUE, theGreatestFromAllData);
    }
}

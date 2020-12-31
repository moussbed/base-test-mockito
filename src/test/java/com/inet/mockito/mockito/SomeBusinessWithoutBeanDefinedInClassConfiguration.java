package com.inet.mockito.mockito;

import com.inet.mockito.mockito.config.ConfigurationComponentScanWithoutBeanDefined;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationComponentScanWithoutBeanDefined.class})
public class SomeBusinessWithoutBeanDefinedInClassConfiguration {

    @Autowired
    DataService dataService;

    @Autowired
    SomeBusiness someBusiness;

    @Test
    public void test1() {
        int theGreatestFromAllData = someBusiness.findTheGreatestFromAllData();
        /*
        * Pour que ce test marche il faut commenter l'annotation @Configuration dans la classe ConfigurationWithBeanWithoutProfile.
        * Puisque cette  configuration definit des beans qui override les beans definit scanner [@ComponentScan(basePackageClasses = {DataServiceImpl.class, SomeBusinessImpl.class})]
        * dans la classe de configuration ConfigurationComponentScanWithoutBeanDefined. Ces beans etant ceux utiliser pendant l'execution du programme.
        */
        assertEquals(Integer.MIN_VALUE, theGreatestFromAllData);
    }
}

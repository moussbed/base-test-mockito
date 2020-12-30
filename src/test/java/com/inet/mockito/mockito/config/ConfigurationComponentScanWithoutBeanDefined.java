package com.inet.mockito.mockito.config;

import com.inet.mockito.mockito.DataServiceImpl;
import com.inet.mockito.mockito.SomeBusinessImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.inet.mockito.mockito") or
@ComponentScan(basePackageClasses = {DataServiceImpl.class, SomeBusinessImpl.class})
public class ConfigurationComponentScanWithoutBeanDefined {


}

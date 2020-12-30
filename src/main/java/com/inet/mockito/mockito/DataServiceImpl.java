package com.inet.mockito.mockito;

import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService{
    @Override
    public int[] retrieveAllData() {
        return new int[0];
    }

    @Override
    public void save(String name) {

    }
}

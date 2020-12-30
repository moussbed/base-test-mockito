package com.inet.mockito.mockito;

import org.springframework.stereotype.Service;

@Service
public class SomeBusinessImpl implements SomeBusiness{


	private DataService dataService;

	
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}



	@Override
	public int findTheGreatestFromAllData(){
		int[] data= dataService.retrieveAllData();
		int greatest =Integer.MIN_VALUE;
		//System.out.println("Min : "+greatest);

		for (int value : data) {
			if(value > greatest){
				greatest=value;
			}
		}
		return greatest;
	}

	@Override
	public void save(String name){
		dataService.save(name);
	}
}



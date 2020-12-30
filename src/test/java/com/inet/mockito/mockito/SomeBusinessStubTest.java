package com.inet.mockito.mockito;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * stub (bouchon) : classes qui renvoient une valeur codée en dur à l'invocation d'une méthode
 */

public class SomeBusinessStubTest {

	@Test
	public void findTheGreatestFromAllData() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(new DataServiceStub());
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(24,result);
	}

}

class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {24,6,15};
	}

	@Override
	public void save(String name) {

	}
}



package com.inet.mockito.mockito;


import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * stub (bouchon) : classes qui renvoient une valeur codée en dur à l'invocation d'une méthode
 * spy (espion) : classe qui vérifie l'utilisation qui en est faite après l'exécution
 * mock (simulacre:Ce qui n'a que l'apparence (de ce qu'il prétend être)) : classes qui agissent comme un stub et un spy
 *
 */

public class SomeBusinessMockTest {


	DataService dataServiceMock = mock(DataService.class);


	@Test
	public void findTheGreatestFromAllData() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,6,15});
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(24,someBusinessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void findTheGreatestFromAllData_OneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(15,someBusinessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testUseStubToImplementMock(){

		DataService dataService= Mockito.mock(DataService.class);
		//renvoient une valeur codée en dur à l'invocation d'une méthode
		Mockito.when(dataService.retrieveAllData()).thenReturn(new int[] {1,3,5});
		SomeBusinessImpl someBusiness= new SomeBusinessImpl(dataService);
		assertEquals(5,someBusiness.findTheGreatestFromAllData());
	}


	@Test
	public void testUseSpyToImplementMock(){
		DataService dataService = Mockito.mock(DataService.class);
		SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataService);
		someBusiness.save("Bedril");

		/* Verifie l'utilisation qui a ete de dataService.save("Bedril")
		 * apres l'execution de someBusiness.save("Bedril")
		 */
		Mockito.verify(dataService).save("Bedril");
	}

}




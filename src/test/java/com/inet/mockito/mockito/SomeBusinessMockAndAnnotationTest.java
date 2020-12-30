package com.inet.mockito.mockito;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Le lancement de tout le contexte de ressort ralentit le test unitaire (@RunWith(SpringRunner.class) && @SpringBootTest ). 
 * Les tests unitaires échoueront également s'il y a des erreurs dans d'autres beans dans les contextes. 
 * L’approche MockitoJUnitRunner est donc préférable.
 * */

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAndAnnotationTest {
	
	@Mock
	DataService dataServiceMock ;
	
	@InjectMocks
	SomeBusinessImpl someBusinessImpl;
	
	@Test
	public void findTheGreatestFromAllData() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,6,15});
		assertEquals(24,someBusinessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	public void findTheGreatestFromAllData_OneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		assertEquals(15,someBusinessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	public void findTheGreatestFromAllData_NoValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE,someBusinessImpl.findTheGreatestFromAllData());
	}

}




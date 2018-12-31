import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mindtree.carapp.dao.CarDao;
import com.mindtree.carapp.entity.Car;
import com.mindtree.carapp.exception.AppException;
import com.mindtree.carapp.exception.ServiceException;
import com.mindtree.carapp.service.CarService;
import com.mindtree.carapp.service.serviceimpl.CarServiceImpl;

import static org.mockito.Mockito.*;

import junit.framework.TestCase;

public class CarServiceTest extends TestCase {

	Car c= null;
	CarDao dao = Mockito.mock(CarDao.class);
	CarService service = new CarServiceImpl();
	static Car car = null;
	
	@Before
	public void setup() throws ServiceException {
		//c = service.getCarById(1104);
		car = getCar();
	}
	
	/*@Test
	public void testPerform() throws AppException {
		try {
			//String value = null;
			when(dao.insert(car)).thenReturn("success");
			assertEquals(service.addCar(car), "scccess");
		} catch (ServiceException e) {
			throw new AppException(e.getMessage(),e.getCause());
		}
	}*/
	
	@Test
	public void testFetchCar() throws AppException {
		when(dao.getCar(1101)).thenReturn(getCar());
		assertEquals("FordXT18",dao.getCar(1101).getModelName());
	}
	
	static Car getCar() {
		car.setModelNum(1101);
		car.setModelName("FordXT18");
		car.setPrice(1250);
		return car;
	}
	
}

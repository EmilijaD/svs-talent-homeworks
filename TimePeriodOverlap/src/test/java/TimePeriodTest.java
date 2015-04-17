import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimePeriodTest {
	private TimePeriod timePeriodA;
	Date dataStartA = new Date(2015 / 11 / 11);
	Date dataEndA = new Date(2015 / 12 / 12);

	@Before
	public void setUp() throws Exception {
		timePeriodA = new TimePeriod(dataStartA, dataEndA);

	}

	@Test
	public void testAcontainsB() throws Exception {
		Date dataStartB = new Date(2015 / 11 / 10);
		Date dataEndB = new Date(2015 / 12 / 13);
		TimePeriod timePeriodB = new TimePeriod(dataStartB, dataEndB);
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}

	@Test
	public void testBcontainsA() throws Exception {
		Date dataStartB = new Date(2015 / 11 / 12);
		Date dataEndB = new Date(2015 / 12 / 13);
		TimePeriod timePeriodB = new TimePeriod(dataStartB, dataEndB);
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}

	@Test
	public void testBinteractA() throws Exception {
		Date dataStartB = new Date(2015 / 11 / 01);
		Date dataEndB = new Date(2015 / 12 / 01);
		TimePeriod timePeriodB = new TimePeriod(dataStartB, dataEndB);
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));

	}
    @Test
	public void testAinteractB() throws Exception {
		Date dataStartB = new Date(2015 / 11 / 12);
		Date dataEndB = new Date(2015 / 12 / 13);
		TimePeriod timePeriodB = new TimePeriod(dataStartB, dataEndB);
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}
     @Test
	public void testAequalsB() throws Exception {
		Date dataStartB = new Date(2015 / 11 / 11);
		Date dataEndB = new Date(2015 / 12 / 12);
		TimePeriod timePeriodB = new TimePeriod(dataStartB, dataEndB);
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}
     @Test
     public void testAendEqualToBstart()
     {
    	 Date dataStartB = new Date(2015 / 12 / 12);
 		Date dataEndB = new Date(2015 / 12 / 21);
 		TimePeriod timePeriodB = new TimePeriod(dataStartB, dataEndB);
 		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
    	 
     }
     
    

}

package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainSensor;

import java.text.SimpleDateFormat;


public class TrainSensorTest {

	TrainSensor sensor;
	
	@Before
	public void before() {
		sensor = new TrainSensorImpl(null, null);
	}

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void TestTachoGraph() {
        String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        sensor.addDataToTacho(time, 5, 2);
        try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        String time2 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        sensor.addDataToTacho(time2, 5, 9);
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        String time3 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        sensor.addDataToTacho(time3, 6, 1);
        int refSpeed = sensor.getReferenceSpeed(time, 5);
        Assert.assertEquals(2, refSpeed);
    }
}

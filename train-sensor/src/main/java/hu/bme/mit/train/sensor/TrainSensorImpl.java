package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<String, Integer, Integer> tachoGraph = HashBasedTable.create();

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

	@Override
	public void addDataToTacho(String time, int joyStickPosition, int referenceSpeed){
		tachoGraph.put(time, joyStickPosition, referenceSpeed);
	}

	@Override
	public int getReferenceSpeed(String time, int joyStickPosition){
		return tachoGraph.get(time, joyStickPosition);
	}

}

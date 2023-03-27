package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private int speedValue = -1;

	@Override
	public void followSpeed() {
		if(speedValue<0){
			if (referenceSpeed < 0) {
				referenceSpeed = 0;
			} else {
				if(referenceSpeed+step > 0) {
					referenceSpeed += step;
				} else {
					referenceSpeed = 0;
				}
			}
		}
		else{
			referenceSpeed = speedValue;
			speedValue= -1;
		}

		enforceSpeedLimit();
	}

	@Override
	public void setSpeedByValue(int newSpeed){
		speedValue = newSpeed;
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}

}

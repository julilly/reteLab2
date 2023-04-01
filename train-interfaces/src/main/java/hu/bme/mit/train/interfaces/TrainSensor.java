package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void addDataToTacho(String currentTime, int joyStickPosition, int referenceSpeed);

	int getReferenceSpeed(String time, int joyStickPosition);

}

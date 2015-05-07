import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.HiTechnicColorSensor;

public class SensorFrontal implements Runnable {
	HiTechnicColorSensor sensorFrontal = new HiTechnicColorSensor(SensorPort.S2);
	static int leituraFrontal, RED = 0;
	static boolean vivo, parede, morto;

	void LeituraF() {
		while (true) {
			leituraFrontal = sensorFrontal.getColorID();

			if (leituraFrontal == RED) {
				vivo = true;
				
			}
			if (leituraFrontal == 6){
				parede = true;
			}
			if (leituraFrontal == 7){
				morto = true;
			}
		}
	}

	public void run() {
		LeituraF();
	}
}

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class SensorUltrassonico implements Runnable {
	public void run() {
		Leitura();
	}

	EV3UltrasonicSensor sensorUltrassom = new EV3UltrasonicSensor(SensorPort.S4);
	private float dis;
	public float getDis() {
		return dis;
	}

	public static boolean obstaculoDetectado = false;

	public void Leitura() {
		while (true) {
			SampleProvider distancia = sensorUltrassom.getDistanceMode();
			float amostraDistancia[] = new float[distancia.sampleSize()];
			distancia.fetchSample(amostraDistancia, 0);
			System.out.println(amostraDistancia[0]);
			dis = amostraDistancia[0];

			if (dis < 0.05) {
				obstaculoDetectado = true;
			} else {
				obstaculoDetectado = false;
			}

		}
	}
}

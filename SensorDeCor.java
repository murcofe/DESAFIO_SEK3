import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
//import lejos.hardware.sensor.HiTechnicColorSensor;

public class SensorDeCor implements Runnable {

	EV3ColorSensor sensorDireito = new EV3ColorSensor(SensorPort.S1);
	//HiTechnicColorSensor sensorFrontal = new HiTechnicColorSensor(SensorPort.S2);
	EV3ColorSensor sensorEsquerdo = new EV3ColorSensor(SensorPort.S3);
	private int BLACK = 7;
	public static boolean virarDireita = false;
	public static boolean virarEsquerda = false;

	public void Leitura() {
		while (true) {
			int leituraDireita = sensorDireito.getColorID();
			int leituraEsquerda = sensorEsquerdo.getColorID();

			System.out.println("direita = " + leituraDireita);
			System.out.println("esquerda = " + leituraEsquerda);
			// Liberar as flags
			if (leituraDireita == BLACK) {
				virarDireita = true;
			} else {
				virarDireita = false;
			}
			if (leituraEsquerda == BLACK) {
				virarEsquerda = true;
			} else {
				virarEsquerda = false;
			}
			
		}
	}

	public void run() {
		Leitura();
	}
}

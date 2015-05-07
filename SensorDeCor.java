import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

public class SensorDeCor implements Runnable {

	EV3ColorSensor sensorDireito = new EV3ColorSensor(SensorPort.S1);
	EV3ColorSensor sensorEsquerdo = new EV3ColorSensor(SensorPort.S3);
	private int BLACK = 7;
	public static boolean virarDireita = false;
	public static boolean virarEsquerda = false;
	public static boolean parar = false;
	public static boolean vEsquerda = false;
	public static boolean vDireita = false;

	public void Leitura() {
		while (true) {
			int leituraDireita = sensorDireito.getColorID();
			int leituraEsquerda = sensorEsquerdo.getColorID();

			// Liberar as flags
			if (leituraDireita == BLACK && leituraEsquerda == BLACK) {
				parar = true;
				virarDireita = false;
				virarEsquerda = false;
				Delay.msDelay(100);
			} else {
				if (leituraDireita == BLACK
						&& SensorUltrassonico.obstaculoDetectado == false) {
					virarDireita = true;
					vEsquerda = true;
				} else {
					virarDireita = false;
					vEsquerda = false;
				}
				if (leituraEsquerda == BLACK
						&& SensorUltrassonico.obstaculoDetectado == false) {
					virarEsquerda = true;
					vDireita = true;

				} else {
					virarEsquerda = false;
					vDireita = false;
				}
			}
		}
	}

	public void run() {
		Leitura();
	}
}

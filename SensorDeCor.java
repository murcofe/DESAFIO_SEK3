import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.HiTechnicColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class SensorDeCor implements Runnable{
	
	EV3ColorSensor sensorDireito = new EV3ColorSensor(SensorPort.S1);
	HiTechnicColorSensor sensorFrontal = new HiTechnicColorSensor(SensorPort.S2);
	EV3ColorSensor sensorEsquerdo = new EV3ColorSensor(SensorPort.S3);
	private int BLACK = 7;
	public static boolean virarDireita = false;
	public static boolean virarEsquerda = false;
	
	public void Leitura(){
		while(true){
	/*		// Leitura do Sensor da Direita
			SampleProvider corDireita = sensorDireito.getColorIDMode();
			float amostraCorDireita[] = new float[corDireita.sampleSize()];
			corDireita.fetchSample(amostraCorDireita, 0);
			
			// Leitura do Sensor da Esquerda
			SampleProvider corEsquerda = sensorEsquerdo.getColorIDMode();
			float amostraCorEsquerda[] = new float[corEsquerda.sampleSize()];
			corDireita.fetchSample(amostraCorEsquerda, 0);
			
			// Leitura do Sensor Frontal
			SampleProvider corFrontal = sensorFrontal.getColorIDMode();
			float amostraCorFrontal[] = new float[corFrontal.sampleSize()];
			corFrontal.fetchSample(amostraCorFrontal, 0);
	*/		
			int leituraDireita = sensorDireito.getColorID();
			int leituraEsquerda = sensorEsquerdo.getColorID();
			
			System.out.println("direita = "+leituraDireita);
			System.out.println("esquerda = "+leituraEsquerda);
			Delay.msDelay(1000);
			// Liberar as flags
			if(leituraDireita == BLACK){
				virarDireita = true;
			}
			if(leituraEsquerda == BLACK){
				virarEsquerda = true;
			}
		}
	}

	public void run() {
		Leitura();
	}
}

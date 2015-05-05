import lejos.hardware.Button;


public class Main_DesafioSEK3 {

	public static void main(String[] args) throws InterruptedException {
		Navegacao navegacao = new Navegacao();	
		Thread sensorCor = new Thread(new SensorDeCor());
		sensorCor.start();
		SensorUltrassonico sensorUltra = new SensorUltrassonico();
		Thread sensorUltras = new Thread(sensorUltra);
		sensorUltras.start();
		while(true){	
			navegacao.Andar();
			navegacao.RedirecionarParaDireita();
			navegacao.RedirecionarParaEsquerda();
			navegacao.Parar();
			while(SensorUltrassonico.obstaculoDetectado){
				sensorCor.wait();
				navegacao.Desviar();
				
			}
			
			
			
			if (Button.ESCAPE.isDown()) {
				System.exit(0);
			}
		}
	}
}

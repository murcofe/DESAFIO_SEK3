import lejos.hardware.Button;

public class Main_DESAFIOSEK3 {

	public static void Sair() {
		if (Button.ESCAPE.isDown()) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Navegacao navegacao = new Navegacao();
		Thread sensorCor = new Thread(new SensorDeCor());
		sensorCor.start();
		SensorUltrassonico sensorUltra = new SensorUltrassonico();
		Thread sensorUltras = new Thread(sensorUltra);
		sensorUltras.start();
		Navegacao2 navegacao2 = new Navegacao2();
		// Execução da Primeira parte do Desafio
		while (true) {
		 	
			navegacao.Andar();
			navegacao.RedirecionarParaDireita();
			navegacao.RedirecionarParaEsquerda();
			navegacao.Parar();
			while (SensorUltrassonico.obstaculoDetectado) {
				navegacao.Desviar();
				Sair();
			}
			if (SensorDeCor.parar) {
				navegacao.Parar();
				break;
			}
		}
		
		// Execução da Segunda parte do Desafio
		while (true){
			navegacao2.Andar();
			navegacao2.virarEsquerda();
			Thread procurar = new Thread(navegacao2);
			procurar.start();
			while(true){
				navegacao2.virarDireita();
				navegacao2.virarDireita();
				navegacao2.Andar();
				
				navegacao2.virarEsquerda();
				navegacao2.virarEsquerda();
				navegacao2.Andar();
				
				Sair();
			}
			
		}
		
	}
}

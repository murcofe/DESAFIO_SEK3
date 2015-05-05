import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Navegacao {
	EV3LargeRegulatedMotor motorDireito = new EV3LargeRegulatedMotor(MotorPort.A);
	EV3LargeRegulatedMotor motorEsquerdo = new EV3LargeRegulatedMotor(MotorPort.D);
	
	private final int VELOCIDADE = 200;
	private final int VELOCIDADE_REDIRECIONAMENTO = 100;
	private final int VELOCIDADE_ZERO = 100;
	public static boolean ultrapassou = false;
	public void Andar() {
		motorDireito.setSpeed(VELOCIDADE);
		motorEsquerdo.setSpeed(VELOCIDADE);
		motorDireito.forward();
		motorEsquerdo.forward();
	}// fim andar
	public void Desviar(){
		motorDireito.rotate(360); //vira pra esquerda
		motorEsquerdo.rotate(-360);
		
		motorDireito.rotate(360); //anda um pouco pra frente
		motorEsquerdo.rotate(360);
		
		motorDireito.rotate(-360); // vira pra direita
		motorEsquerdo.rotate(360);
		motorDireito.rotate(360);	//anda
		motorEsquerdo.rotate(360);
		motorDireito.rotate(-360); // vira pra direita
		motorEsquerdo.rotate(360);
		
		notifyAll(); //liga a thread do sensor de cor
		
	}
	public void RedirecionarParaDireita() {
	while(SensorDeCor.virarDireita){
			motorDireito.setSpeed(VELOCIDADE_ZERO);
			motorEsquerdo.setSpeed(VELOCIDADE_REDIRECIONAMENTO);
			motorEsquerdo.forward();
			motorDireito.backward();
			
		}
	}// fim redirecionar para direita

	public void RedirecionarParaEsquerda() {
		while(SensorDeCor.virarEsquerda){
			motorDireito.setSpeed(VELOCIDADE_REDIRECIONAMENTO);
			motorEsquerdo.setSpeed(VELOCIDADE_ZERO);
			motorDireito.forward();
			motorEsquerdo.backward();
		}
	}// fim redirecionar para esquerda
	
	public void Parar(){
		if(SensorDeCor.virarEsquerda && SensorDeCor.virarDireita){
			motorEsquerdo.stop(true);
			motorDireito.stop();
		}
	}
}

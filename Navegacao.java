import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Navegacao {
	EV3LargeRegulatedMotor motorDireito = new EV3LargeRegulatedMotor(MotorPort.A);
	EV3LargeRegulatedMotor motorEsquerdo = new EV3LargeRegulatedMotor(MotorPort.D);
	public boolean virarDireita = false;
	public boolean virarEsquerda = false;
	private final int VELOCIDADE = 300;
	private final int VELOCIDADE_REDIRECIONAMENTO = 400;
	
	public void Andar() {
		motorDireito.setSpeed(VELOCIDADE);
		motorEsquerdo.setSpeed(VELOCIDADE);
		motorDireito.forward();
		motorEsquerdo.forward();
	}// fim andar

	public void RedirecionarParaDireita() {
		if(virarDireita){
			motorDireito.setSpeed(VELOCIDADE);
			motorEsquerdo.setSpeed(VELOCIDADE_REDIRECIONAMENTO);
			motorEsquerdo.forward();
			motorDireito.forward();
		}
	}// fim redirecionar para direita

	public void RedirecionarParaEsquerda() {
		if(virarEsquerda){
			motorDireito.setSpeed(VELOCIDADE_REDIRECIONAMENTO);
			motorEsquerdo.setSpeed(VELOCIDADE);
			motorDireito.forward();
			motorEsquerdo.forward();
		}
	}// fim redirecionar para esquerda
	
	public void Parar(){
		motorEsquerdo.stop(true);
		motorDireito.stop();
	}
}

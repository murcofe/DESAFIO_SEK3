import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Navegacao {
	static EV3LargeRegulatedMotor motorDireito = new EV3LargeRegulatedMotor(
			MotorPort.A);
	static EV3LargeRegulatedMotor motorEsquerdo = new EV3LargeRegulatedMotor(
			MotorPort.D);

	private final int VELOCIDADE = 100;
	private final int VELOCIDADE_REDIRECIONAMENTO = 100;
	private final int VELOCIDADE_ZERO = 100;
	public static boolean ultrapassou = false;

	public void Andar() {
		motorDireito.setSpeed(VELOCIDADE);
		motorEsquerdo.setSpeed(VELOCIDADE);
		motorDireito.forward();
		motorEsquerdo.forward();
	}// fim andar

	public void RedirecionarParaDireita() {
		while (SensorDeCor.virarDireita) {
			motorDireito.setSpeed(VELOCIDADE_ZERO);
			motorEsquerdo.setSpeed(VELOCIDADE_REDIRECIONAMENTO);
			motorEsquerdo.forward();
			motorDireito.backward();
		}
	}// fim redirecionar para direita

	public void RedirecionarParaEsquerda() {
		while (SensorDeCor.virarEsquerda) {
			motorDireito.setSpeed(VELOCIDADE_REDIRECIONAMENTO);
			motorEsquerdo.setSpeed(VELOCIDADE_ZERO);
			motorDireito.forward();
			motorEsquerdo.backward();
		}
	}// fim redirecionar para esquerda

	public void Parar() {
		if (SensorDeCor.parar) {
			motorEsquerdo.stop(true);
			motorDireito.stop();
		}
	}

	public void Desviar() {
		motorDireito.rotate(180, true); // vira pra esquerda
		motorEsquerdo.rotate(-180);

		motorDireito.rotate(400, true); // anda um pouco pra frente
		motorEsquerdo.rotate(400);

		motorDireito.rotate(-180, true); // vira pra direita
		motorEsquerdo.rotate(180);

		motorDireito.rotate(400, true); // anda
		motorEsquerdo.rotate(400);

		motorDireito.rotate(-120, true); // vira pra direita
		motorEsquerdo.rotate(120);

		motorDireito.rotate(500, true); // anda um pouco pra frente
		motorEsquerdo.rotate(500);

		motorDireito.rotate(210, true); // vira pra esquerda
		motorEsquerdo.rotate(-210);

		SensorUltrassonico.obstaculoDetectado = false;
		SensorDeCor.parar = false;
	}
/*	
	
	public void NoLimite(){
	if(SensorDeCor.vEsquerda){
		motorDireito.backward();
		motorEsquerdo.backward();
		motorDireito.rotate(-180, true);
		motorEsquerdo.rotate(180);
	}
	}*/

}

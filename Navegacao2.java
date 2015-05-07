import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Navegacao2 implements Runnable{
	static EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(
			MotorPort.A);
	static EV3LargeRegulatedMotor motorE = new EV3LargeRegulatedMotor(
			MotorPort.D);

	public void virarDireita() {
		Navegacao.motorDireito.rotate(-180, true);
		Navegacao.motorEsquerdo.rotate(180);
	}

	public void virarEsquerda() {
		Navegacao.motorDireito.rotate(180, true);
		Navegacao.motorEsquerdo.rotate(-180);
	}

	public void Re() {
		Navegacao.motorDireito.rotate(-180, true);
		Navegacao.motorEsquerdo.rotate(-180);
	}

	public void Desviar() {
		if (SensorUltrassonico.corpoIdentificado = true && SensorFrontal.morto) {
			virarDireita();
			Navegacao.motorDireito.rotate(270, true);
			Navegacao.motorEsquerdo.rotate(270);
			virarEsquerda();
		}
	}

	public void Parar(){
		motorD.stop(true);
		motorE.stop();
	}
	public static void procurando(){
		motorD.rotate(90,true);
		motorE.rotate(-90);
		motorD.rotate(-180,true);
		motorE.rotate(180);
	}
	public void Andar() {
		motorD.setSpeed(100);
		motorE.setSpeed(100);
		motorD.rotate(180,true);
		motorE.rotate(180);

	}

	public void run() {
		while(true){
			if(SensorUltrassonico.corpoIdentificado){
				procurando();
				Delay.msDelay(1000);
			}
		}

	}
}

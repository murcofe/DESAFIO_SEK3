import lejos.utility.Delay;

public class Navegacao2 implements Runnable{
	

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
		Navegacao.motorDireito.stop(true);
		Navegacao.motorEsquerdo.stop();
	}
	public static void procurando(){
		Navegacao.motorDireito.rotate(90,true);
		Navegacao.motorEsquerdo.rotate(-90);
		Navegacao.motorDireito.rotate(-180,true);
		Navegacao.motorEsquerdo.rotate(180);
	}
	public void Andar() {
		Navegacao.motorDireito.setSpeed(100);
		Navegacao.motorEsquerdo.setSpeed(100);
		Navegacao.motorDireito.rotate(180,true);
		Navegacao.motorEsquerdo.rotate(180);

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

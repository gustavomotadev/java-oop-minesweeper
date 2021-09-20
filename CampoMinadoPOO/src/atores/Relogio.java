package atores;

import java.awt.Color;
//import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import estaticos.Campo;
import gui.FontesEstaticas;
import gui.Periodico;
import gui.Texto;
import gui.TextoMutavel;

public class Relogio extends TextoMutavel implements Periodico {

	private static final long serialVersionUID = -4210288685762039682L;
	
	private int segundos;
	private int minutos;
	
	private Texto fundo;
	
	private Timer temporizador;
	
	private boolean ativo;

	public Relogio(Color cor, Color corFundo) {
		
		super(FontesEstaticas.getDseg7ClassicMiniBold(), "00:00", cor);
		this.segundos = 0;
		this.minutos = 0;
		this.fundo = new Texto(FontesEstaticas.getDseg7ClassicMiniBold(), "88:88", corFundo);
		this.temporizador = new Timer();
		this.setText(String.format("%02d", this.minutos) + ":" + String.format("%02d", this.segundos));
		this.ativo = false;
	}
	
	@Override
	public void moverPara(int x, int y) {
		
		this.fundo.moverPara(x, y);
		super.moverPara(x, y);
	}
	
	@Override
	public void execucaoPeriodica() {
		this.temporizador.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				executarUmaVez();
				
			}
		}, 1000, 1000);
	}

	@Override
	public void executarUmaVez() {
		
		if(Campo.isTerminado()) this.parar();
		
		this.segundos++;
		if(this.segundos >= 60) {
			this.segundos = 0;
			this.minutos++;
		}
		this.setText(String.format("%02d", this.minutos) + ":" + String.format("%02d", this.segundos));
	}
	
	public void iniciar() {
		
		this.execucaoPeriodica();
		this.ativo = true;
	}
	
	public void parar() {
		
		this.temporizador.cancel();
		this.temporizador.purge();
		this.ativo = false;
	}
	
	public void zerar() {
		
		this.segundos = 0;
		this.minutos= 0;
		this.setText(String.format("%02d", this.minutos) + ":" + String.format("%02d", this.segundos));
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public Texto getFundo() {
		return fundo;
	}

	public void setFundo(Texto fundo) {
		this.fundo = fundo;
	}

	public Timer getTemporizador() {
		return temporizador;
	}

	public void setTemporizador(Timer temporizador) {
		this.temporizador = temporizador;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}

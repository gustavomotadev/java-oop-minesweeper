package atores;

import java.awt.Color;
//import java.awt.Font;

import gui.FontesEstaticas;
import gui.Texto;
import gui.TextoMutavel;

public class ContadorDeBombas extends TextoMutavel {

	private static final long serialVersionUID = 145599542511993216L;
	
	private int max;
	private int contador;
	private Texto fundo;

	public ContadorDeBombas(Color cor, Color corFundo, int max) {
		
		super(FontesEstaticas.getDseg7ClassicMiniBold(), "000", cor);
		
		this.fundo = new Texto(
				FontesEstaticas.getDseg7ClassicMiniBold(), 
				"888", 
				corFundo);
		
		this.max = max;
		this.contador = max;
		this.executarUmaVez();
	}
	
	@Override
	public void moverPara(int x, int y) {
		
		this.fundo.moverPara(x, y);
		super.moverPara(x, y);
	}
	
	
	@Override
	public void executarUmaVez() {
		
		this.setText(String.format("%03d", this.contador));
	}

	public void incrementar() {
		if(this.contador < max) this.contador++;
	}
	
	public void decrementar() {
		if(this.contador > 0) this.contador--;
	}

	public int getMax() {
		return this.max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getContador() {
		return this.contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Texto getFundo() {
		return fundo;
	}

	public void setFundo(Texto fundo) {
		this.fundo = fundo;
	}
	
}

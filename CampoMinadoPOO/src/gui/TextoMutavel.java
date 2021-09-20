package gui;

import java.awt.Color;
import java.awt.Font;

public abstract class TextoMutavel extends Texto implements Executavel {

	private static final long serialVersionUID = 6094984137778765381L;

	public TextoMutavel(Font fonte, String texto, Color cor) {
		super(fonte, texto, cor);
	}

	@Override
	public abstract void executarUmaVez();
	
}

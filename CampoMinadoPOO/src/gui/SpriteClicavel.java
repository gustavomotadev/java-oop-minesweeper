package gui;

import java.awt.image.BufferedImage;

public abstract class SpriteClicavel extends Sprite implements Clicavel {

	private static final long serialVersionUID = 5472049870304781855L;
	
	public SpriteClicavel(String arquivo) {
		
		super(arquivo);
	}
	
	public SpriteClicavel(BufferedImage imagem) {
		
		super(imagem);
	}

	@Override
	public abstract void tratarClique();
	
}

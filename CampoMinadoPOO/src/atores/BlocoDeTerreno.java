package atores;

import gui.ImagensEstaticas;
import gui.SpriteClicavel;

public abstract class BlocoDeTerreno extends SpriteClicavel {

	private static final long serialVersionUID = -6850996572510127330L;
	
	private int gradeX;
	private int gradeY;
	private boolean comBandeira;
	
	public BlocoDeTerreno(String arquivo, int gradeX, int gradeY) {
		super(arquivo);
		this.gradeX = gradeX;
		this.gradeY = gradeY;
		this.comBandeira = false;
	}
	
	public BlocoDeTerreno(int gradeX, int gradeY) {
		super(ImagensEstaticas.getEscondido());
		this.gradeX = gradeX;
		this.gradeY = gradeY;
		this.comBandeira = false;
	}

	@Override
	public abstract void tratarClique();
	
	public void alternarBandeira() {
		
		if(!this.comBandeira) {
			
			this.trocarImagem(ImagensEstaticas.getBandeira());
			this.comBandeira = true;
			
		} else {
			
			this.trocarImagem(ImagensEstaticas.getEscondido());
			this.comBandeira = false;
		}

	}

	public int getGradeX() {
		return gradeX;
	}

	public void setGradeX(int gradeX) {
		this.gradeX = gradeX;
	}

	public int getGradeY() {
		return gradeY;
	}

	public void setGradeY(int gradeY) {
		this.gradeY = gradeY;
	}

	public boolean isComBandeira() {
		return comBandeira;
	}

	public void setComBandeira(boolean comBandeira) {
		this.comBandeira = comBandeira;
	}
	
}

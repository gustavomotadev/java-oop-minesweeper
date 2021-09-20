package atores;

import java.awt.Color;
import estaticos.Campo;
import gui.FontesEstaticas;
import gui.ImagensEstaticas;
import gui.Texto;

public class BlocoVazio extends BlocoDeTerreno {

	private static final long serialVersionUID = 2727866351274932913L;
	
	private int bombasProximas;
	private Texto numeroExibido;
	private boolean clicado;
	
	public BlocoVazio(String arquivo, int gradeX, int gradeY) {
		
		super(arquivo, gradeX, gradeY);
		this.bombasProximas = 0;
		this.clicado = false;
		this.numeroExibido = null;
	}

	public BlocoVazio(int gradeX, int gradeY) {
		super(gradeX, gradeY);
		this.bombasProximas = 0;
		this.clicado = false;
		this.numeroExibido = null;
	}
	
	public void calcularBombasProximas() {
		
		this.bombasProximas = 0;
		
		for(int i = -1; i <= 1; i++) {
			
			for(int j = -1; j <= 1; j++) {
				
				try {
					
					if(Campo.getGradeBlocos()[this.getGradeX()+i][this.getGradeY()+j] instanceof BlocoBomba) this.bombasProximas++;
					
				} catch (ArrayIndexOutOfBoundsException e) {
					// nao somar nada
				}
				
			}
		}
		
		if(this.bombasProximas > 0) {
			
			this.numeroExibido = new Texto(
					FontesEstaticas.getOpenSansBold(), 
					Integer.toString(this.bombasProximas), 
					Color.getHSBColor((float) (0.3 + 0.2 + this.bombasProximas*0.1), (float) 1, (float) (1 - this.bombasProximas*0.05)));
			
			this.numeroExibido.moverPara((Campo.getInicioGradeX()*2) + 6 + this.getGradeY()*20,  (Campo.getInicioGradeY()*2) + 4 + this.getGradeX()*20);
			this.numeroExibido.setVisible(false);
		}
		
	}
	
	@Override
	public void tratarClique() {
		
		if(this.clicado || this.isComBandeira()) return;
		
		this.clicado = true;
		
		if(this.numeroExibido != null) this.numeroExibido.setVisible(true);
		
		this.trocarImagem(ImagensEstaticas.getVazio());

		if(this.bombasProximas == 0) {

			try {
				if(!(Campo.getGradeBlocos()[this.getGradeX()-1][this.getGradeY()+0] instanceof BlocoBomba)) 
					Campo.getGradeBlocos()[this.getGradeX()-1][this.getGradeY()+0].tratarClique();
			} catch (ArrayIndexOutOfBoundsException e) {	
				//evitar acessos fora da matriz
			}

			try {
				if(!(Campo.getGradeBlocos()[this.getGradeX()-0][this.getGradeY()+1] instanceof BlocoBomba)) 
					Campo.getGradeBlocos()[this.getGradeX()-0][this.getGradeY()+1].tratarClique();
			} catch (ArrayIndexOutOfBoundsException e) {	
				//evitar acessos fora da matriz
			}

			try {
				if(!(Campo.getGradeBlocos()[this.getGradeX()+1][this.getGradeY()+0] instanceof BlocoBomba)) 
					Campo.getGradeBlocos()[this.getGradeX()+1][this.getGradeY()+0].tratarClique();
			} catch (ArrayIndexOutOfBoundsException e) {	
				//evitar acessos fora da matriz
			}

			try {
				if(!(Campo.getGradeBlocos()[this.getGradeX()+0][this.getGradeY()-1] instanceof BlocoBomba)) 
					Campo.getGradeBlocos()[this.getGradeX()+0][this.getGradeY()-1].tratarClique();
			} catch (ArrayIndexOutOfBoundsException e) {	
				//evitar acessos fora da matriz
			}
		}

	}

	public int getBombasProximas() {
		return bombasProximas;
	}

	public void setBombasProximas(int bombasProximas) {
		this.bombasProximas = bombasProximas;
	}

	public boolean isClicado() {
		return clicado;
	}

	public void setClicado(boolean clicado) {
		this.clicado = clicado;
	}

	public Texto getNumeroExibido() {
		return numeroExibido;
	}

	public void setNumeroExibido(Texto numeroExibido) {
		this.numeroExibido = numeroExibido;
	}
}

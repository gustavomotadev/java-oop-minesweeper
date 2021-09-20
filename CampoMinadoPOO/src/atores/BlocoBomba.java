package atores;

import estaticos.Campo;
import gui.ImagensEstaticas;

public class BlocoBomba extends BlocoDeTerreno {

	private static final long serialVersionUID = 8701854353186763810L;

	public BlocoBomba(int gradeX, int gradeY) {
		
		super(gradeX, gradeY);
	}

	public BlocoBomba(String arquivo, int gradeX, int gradeY) {
		
		super(arquivo, gradeX, gradeY);
	}

	@Override
	public void tratarClique() {
		
		if(this.isComBandeira()) return;

		Campo.setTerminado(true);

		this.trocarImagem(ImagensEstaticas.getExplodiu());

		for(BlocoDeTerreno[] blocosDeTerreno : Campo.getGradeBlocos()) {

			for(BlocoDeTerreno blocoDeTerreno : blocosDeTerreno) {

				if((blocoDeTerreno instanceof BlocoBomba) && blocoDeTerreno != this) {

					if(!blocoDeTerreno.isComBandeira()) blocoDeTerreno.trocarImagem(ImagensEstaticas.getBomba());

				} else if(blocoDeTerreno.isComBandeira()) {

					blocoDeTerreno.trocarImagem(ImagensEstaticas.getBombaFalsa());
				}
			}
		}
	}
}

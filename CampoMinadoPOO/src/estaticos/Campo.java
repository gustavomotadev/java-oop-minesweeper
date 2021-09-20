package estaticos;

import java.util.Random;

import atores.BlocoBomba;
import atores.BlocoDeTerreno;
import atores.BlocoVazio;

public class Campo {
	
	private static BlocoDeTerreno[][] gradeBlocos;
	
	private static int largura;
	private static int altura;
	private static int numeroBombas;
	
	private static int inicioGradeX;
	private static int inicioGradeY;
	
	private static boolean terminado;
	
	private static boolean primeiroClique;
	
	public static void construirCampo() {
		
		inicioGradeX = (200-5*largura);
		inicioGradeY = (165-altura*5);
		
		gradeBlocos = new BlocoDeTerreno[altura][largura];
		
		for (int i = 0; i < altura; i++) {
			
			for (int j = 0; j < largura; j++) {
				
				gradeBlocos[i][j] = new BlocoVazio(i, j);
				gradeBlocos[i][j].moverPara(inicioGradeX + j*10, inicioGradeY + i*10);
				gradeBlocos[i][j].setVisible(true);
			}
		}
	}
	
	public static void armarCampo() {
		
		Random r = new Random();
		int gradeX;
		int gradeY;
		
		for(int i = 0; i < numeroBombas; i++) {
			
			gradeX = r.nextInt(altura);
			gradeY = r.nextInt(largura);
			
			if(!(gradeBlocos[gradeX][gradeY] instanceof BlocoBomba)) {
				
				gradeBlocos[gradeX][gradeY] = new BlocoBomba(gradeX, gradeY);
				gradeBlocos[gradeX][gradeY].moverPara(inicioGradeX + gradeY*10, inicioGradeY + gradeX*10);
				gradeBlocos[gradeX][gradeY].setVisible(true);
			}
			else i--;
		}
	}
	
	public static void enumerarBombas() {
		
		for (BlocoDeTerreno[] blocoDeTerrenos : gradeBlocos) {
			
			for (BlocoDeTerreno blocoDeTerreno : blocoDeTerrenos) {
				
				if(blocoDeTerreno instanceof BlocoVazio) 
					((BlocoVazio) blocoDeTerreno).calcularBombasProximas();
			}
		}
	}
	
	public static boolean checarVitoria() {
		
		for (BlocoDeTerreno[] blocoDeTerrenos : gradeBlocos) {
			
			for (BlocoDeTerreno blocoDeTerreno : blocoDeTerrenos) {
				
				if(blocoDeTerreno instanceof BlocoVazio) {
					
					if(!((BlocoVazio) blocoDeTerreno).isClicado()) {
						
						return false;
					}
					
				} else if(blocoDeTerreno instanceof BlocoBomba) {
					
					if(!((BlocoBomba) blocoDeTerreno).isComBandeira()) {
						
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public static BlocoDeTerreno[][] getGradeBlocos() {
		return gradeBlocos;
	}
	public static void setGradeBlocos(BlocoDeTerreno[][] gradeBlocos) {
		Campo.gradeBlocos = gradeBlocos;
	}
	public static int getLargura() {
		return largura;
	}
	public static void setLargura(int largura) {
		Campo.largura = largura;
	}
	public static int getAltura() {
		return altura;
	}
	public static void setAltura(int altura) {
		Campo.altura = altura;
	}
	public static int getNumeroBombas() {
		return numeroBombas;
	}
	public static void setNumeroBombas(int numeroBombas) {
		Campo.numeroBombas = numeroBombas;
	}

	public static int getInicioGradeX() {
		return inicioGradeX;
	}

	public static void setInicioGradeX(int inicioGradeX) {
		Campo.inicioGradeX = inicioGradeX;
	}

	public static int getInicioGradeY() {
		return inicioGradeY;
	}

	public static void setInicioGradeY(int inicioGradeY) {
		Campo.inicioGradeY = inicioGradeY;
	}

	public static boolean isTerminado() {
		return terminado;
	}

	public static void setTerminado(boolean terminado) {
		Campo.terminado = terminado;
	}

	public static boolean isPrimeiroClique() {
		return primeiroClique;
	}

	public static void setPrimeiroClique(boolean primeiroClique) {
		Campo.primeiroClique = primeiroClique;
	}
	
}

package aplicativo;

import java.awt.Color;
//import java.awt.Font;
//import java.awt.FontFormatException;
//import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.io.IOException;
//import java.io.InputStream;

//import javax.swing.Icon;
import javax.swing.JOptionPane;

import atores.*;
import estaticos.Campo;

//import javax.swing.JPanel;

import gui.*;

public class Main {
	
	public static int coletarInteiro(int limiteInferior, int limiteSuperior, int padrao, String titulo, String pergunta) {
		
		if(limiteInferior > limiteSuperior) throw new IllegalArgumentException("Intervalo invalido");
		
		boolean coletandoEntradas = true;
		String entrada = null;
		int retorno = limiteInferior-1;
		
		while(coletandoEntradas) {

			try {
				
				entrada  = JOptionPane.showInputDialog(null, pergunta, titulo, JOptionPane.QUESTION_MESSAGE);
				if(entrada == null) break;
				retorno = Integer.parseInt(entrada);
				if(retorno < limiteInferior || retorno > limiteSuperior) throw new IllegalArgumentException("Numero fora do intervalo");
				coletandoEntradas = false;
				
			} catch (NumberFormatException e1) {
				
				continue;
				
			} catch (IllegalArgumentException e2) {
				
				continue;
			}
		}
		
		if(entrada == null) return padrao;
		else return retorno;
	}
	
	public static void main(String[] args) {
		
		int largura = 16;
		int altura = 16;
		int numeroBombas = 40;
		
		largura = coletarInteiro(2, 30, 16, "Campo Minado", "Qual deve ser a largura do campo?\n(Mínimo: 2; Máximo 30)");
		altura = coletarInteiro(2, 20, 16, "Campo Minado", "Qual deve ser a altura do campo?\n(Mínimo: 2; Máximo 20)");
		numeroBombas = coletarInteiro(1, (largura*altura-1), 40, "Campo Minado", "Qual deve ser o numero de bombas?\n(Mínimo: 1; Máximo " + (largura*altura-1) + ")");
		
		Janela minhaJanela = new Janela("Campo Minado", true, 800, 600, 200, 100);
		minhaJanela.getContentPane().setBackground(new Color(0, 154, 192));
		minhaJanela.setResizable(false);
		
		ImagensEstaticas.carregarImagens();
		FontesEstaticas.carregarFontes();
		
		Campo.setLargura(largura);
		Campo.setAltura(altura);
		Campo.setNumeroBombas(numeroBombas);
		Campo.construirCampo();
		Campo.armarCampo();
		Campo.enumerarBombas();
		
		for (BlocoDeTerreno[] blocosDeTerreno : Campo.getGradeBlocos()) {
			
			for (BlocoDeTerreno blocoDeTerreno : blocosDeTerreno) {
				
				minhaJanela.adicionarComponente(blocoDeTerreno, -1);
				
				if(blocoDeTerreno instanceof BlocoVazio) {
					
					if(((BlocoVazio) blocoDeTerreno).getBombasProximas() > 0) {
						
						minhaJanela.adicionarComponente(((BlocoVazio) blocoDeTerreno).getNumeroExibido(), 1);
					}
				}
			}
		}
		
		ContadorDeBombas meuContador = new ContadorDeBombas(new Color(0, 230, 50), new Color(80, 170, 120), Campo.getNumeroBombas());
		meuContador.moverPara(100, 40);
		meuContador.getFundo().setVisible(true);
		meuContador.setVisible(true);
		minhaJanela.adicionarComponente(meuContador.getFundo(), -1);
		minhaJanela.adicionarComponente(meuContador, 0);
		
		Relogio meuRelogio = new Relogio(new Color(0, 230, 50), new Color(80, 170, 120));
		meuRelogio.moverPara(550, 40);
		meuRelogio.getFundo().setVisible(true);
		meuRelogio.setVisible(true);
		minhaJanela.adicionarComponente(meuRelogio.getFundo(), -1);
		minhaJanela.adicionarComponente(meuRelogio, 0);
		
		Campo.setPrimeiroClique(true);
		
		minhaJanela.addMouseListener(new MouseAdapter() {
			
		      public void mousePressed(MouseEvent me) {
		    	  
		    	  if(me.getButton() == MouseEvent.BUTTON1) {
		    		  
		    		  if(!Campo.isTerminado()) {
			    		  
			    		  try {
			    			  
			    			  Campo.getGradeBlocos()[(me.getY()-Campo.getInicioGradeY()*2)/20][(me.getX()-Campo.getInicioGradeX()*2)/20].tratarClique();
			    			  
			    			  if(Campo.isPrimeiroClique()) {
			    				  
			    				  meuRelogio.iniciar();
			    				  Campo.setPrimeiroClique(false);
			    			  }
				    		  
							
				    	  } catch (ArrayIndexOutOfBoundsException e) {
							
				    		  //nao fazer nada se clicou fora do campo
				    	  }
			    		  
			    	  }
		    		  
		    	  } else if(me.getButton() == MouseEvent.BUTTON3) {
		    		  
		    		  if(!Campo.isTerminado()) {
			    		  
			    		  try {
				    		  
				    		  if(Campo.getGradeBlocos()[(me.getY()-Campo.getInicioGradeY()*2)/20][(me.getX()-Campo.getInicioGradeX()*2)/20].isComBandeira()) {
				    			  
				    			  //tem bandeira
				    			  Campo.getGradeBlocos()[(me.getY()-Campo.getInicioGradeY()*2)/20][(me.getX()-Campo.getInicioGradeX()*2)/20].alternarBandeira();;
				    			  meuContador.incrementar();
				    			  meuContador.executarUmaVez();
				    			  
				    		  } else {
				    			  
				    			  //nao tem bandeira
				    			  if(meuContador.getContador() > 0) {
				    				  Campo.getGradeBlocos()[(me.getY()-Campo.getInicioGradeY()*2)/20][(me.getX()-Campo.getInicioGradeX()*2)/20].alternarBandeira();;
					    			  meuContador.decrementar();
					    			  meuContador.executarUmaVez();
				    			  }
				    		  }
				    		  
							
				    	  } catch (ArrayIndexOutOfBoundsException e) {
							
				    		  //nao fazer nada se clicou fora do campo
				    	  }
			    		  
			    	  }
		    		  
		    	  }
		    	  
		    	  if(Campo.checarVitoria()) {
		    		  meuRelogio.parar();
		    		  Campo.setTerminado(true);
		    	  }
		      }
		      
		});
		
		minhaJanela.setVisible(true);
	}
}

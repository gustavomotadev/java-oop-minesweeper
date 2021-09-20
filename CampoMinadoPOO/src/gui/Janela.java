package gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class Janela extends JFrame implements Posicionavel {

	private static final long serialVersionUID = -1745134521360075802L;
	
	public Janela(String titulo, boolean Redimensionavel, int Largura, int Altura, int x, int y) {
		
			this.setTitle(titulo);
			this.setResizable(Redimensionavel);
			this.setSize(Largura, Altura);
			this.setLocation(x, y);
			this.getContentPane().setBackground(Color.gray.brighter());
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.gray.darker(), 1));
			this.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
			this.setUndecorated(true);
			this.getContentPane().setLayout(null);
			
	}
	
	public void adicionarComponente(Component c, int layer) {
		
		this.getLayeredPane().add(c, layer);
	}
	
	@Override
	public void moverPara(int x, int y) {
		
		this.setBounds(x, y, x + this.getWidth(), y + this.getHeight());
	}
}

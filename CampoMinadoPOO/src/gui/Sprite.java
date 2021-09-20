package gui;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Dimension;

public class Sprite extends Component implements Posicionavel {

	private static final long serialVersionUID = 1753081375242458675L;
	
    private BufferedImage imagem;
    
    public Sprite(String arquivo) {
    	
        try {
        	
            imagem = ImageIO.read(this.getClass().getResource(arquivo));

        } catch (IOException e) {
        	
            System.out.println("Nao foi possivel abrir a imagem");
            e.printStackTrace();
            System.exit(1);
        }
        
        this.setSize(this.getPreferredSize());
        this.setBounds(0, 0, imagem.getWidth(), imagem.getHeight());
    }
    
    public Sprite(BufferedImage imagem) {
    	
        this.imagem = imagem;
        
        this.setSize(this.getPreferredSize());
        this.setBounds(0, 0, imagem.getWidth(), imagem.getHeight());
    }

	public void trocarImagem(String arquivo) {
		
		try {
        	
            imagem = ImageIO.read(this.getClass().getResource(arquivo));

        } catch (IOException e) {
        	
            System.out.println("Nao foi possivel abrir a imagem");
            e.printStackTrace();
            System.exit(1);
        }
        
        this.setSize(this.getPreferredSize());
        this.setBounds(this.getX(), this.getY(), imagem.getWidth(), imagem.getHeight());
	}
	
	public void trocarImagem(BufferedImage imagem) {
		
		this.imagem = imagem;
		this.repaint();
	}
    
	@Override
    public void moverPara(int x, int y) {
    	
    	this.setLocation(x, y);
    	this.setBounds(x, y, x + imagem.getWidth(), y + imagem.getHeight());
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(imagem.getWidth(), imagem.getHeight());
    }
    
    @Override
    public void paint(Graphics g) {
    	
    	g.drawImage(imagem, this.getX(), this.getY(), null);
    }
}
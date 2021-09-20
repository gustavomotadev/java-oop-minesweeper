package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class Texto extends JLabel implements Posicionavel {

	private static final long serialVersionUID = -9071676122220360048L;
	
	private int xPadding;
	private int yPadding;
	
	private boolean pintavel;
	
	public Texto(Font fonte, String texto, Color cor) {
		
		this.xPadding = 4;
		this.yPadding = 4;
		this.setFont(fonte);
		this.setSize(this.getFontMetrics(this.getFont()).stringWidth(texto) + xPadding, this.getFontMetrics(this.getFont()).getHeight() + yPadding);
		this.setText(texto);
		this.setForeground(cor);
		this.setBounds(0, 0, this.getFontMetrics(this.getFont()).stringWidth(this.getText()) + xPadding, this.getFontMetrics(this.getFont()).getHeight() + yPadding);
		this.setOpaque(false);
		this.pintavel = false;
	}
	
	@Override
	public void moverPara(int x, int y) {
		
		int newX, newY;
		
		newX = x;
		newY = -4 + (int) Math.round(((float) (2) / (float) 3) * (float) y);
		
		this.setBounds(newX, newY, newX + this.getFontMetrics(this.getFont()).stringWidth(this.getText()) + xPadding, newY + this.getFontMetrics(this.getFont()).getHeight() + yPadding);
	}
	
	public void reformatar() {
		
		this.setSize(this.getFontMetrics(this.getFont()).stringWidth(this.getText()) + xPadding, this.getFontMetrics(this.getFont()).getHeight() + yPadding);
		
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(this.getFontMetrics(this.getFont()).stringWidth(this.getText()) + xPadding, this.getFontMetrics(this.getFont()).getHeight() + yPadding);
    }

	public int getxPadding() {
		return xPadding;
	}

	public void setxPadding(int xPadding) {
		this.xPadding = xPadding;
	}

	public int getyPadding() {
		return yPadding;
	}

	public void setyPadding(int yPadding) {
		this.yPadding = yPadding;
	}

	public boolean isPintavel() {
		return pintavel;
	}

	public void setPintavel(boolean pintavel) {
		this.pintavel = pintavel;
	}
	
}

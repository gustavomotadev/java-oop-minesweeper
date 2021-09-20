package gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagensEstaticas {
	
	private static BufferedImage escondido;
	private static BufferedImage vazio;
	private static BufferedImage bomba;
	private static BufferedImage explodiu;
	private static BufferedImage bandeira;
	private static BufferedImage bombaFalsa;
	
	public static void carregarImagens() {
		
		try {
        	
			ImagensEstaticas.escondido = ImageIO.read(ImagensEstaticas.class.getResource("/recursos/escondido.bmp"));
            
            ImagensEstaticas.vazio = ImageIO.read(ImagensEstaticas.class.getResource("/recursos/vazio.bmp"));
            
            ImagensEstaticas.bomba = ImageIO.read(ImagensEstaticas.class.getResource("/recursos/bomba.bmp"));
            
            ImagensEstaticas.explodiu = ImageIO.read(ImagensEstaticas.class.getResource("/recursos/explodiu.bmp"));
            
            ImagensEstaticas.bandeira = ImageIO.read(ImagensEstaticas.class.getResource("/recursos/bandeira.bmp"));
            
            ImagensEstaticas.bombaFalsa = ImageIO.read(ImagensEstaticas.class.getResource("/recursos/bombaFalsa.bmp"));

        } catch (IOException e) {
        	
            System.out.println("Nao foi possivel carregar uma imagem");
            e.printStackTrace();
            System.exit(1);
        }
        
	}

	public static BufferedImage getEscondido() {
		return ImagensEstaticas.escondido;
	}

	public static void setEscondido(BufferedImage escondido) {
		ImagensEstaticas.escondido = escondido;
	}

	public static BufferedImage getVazio() {
		return ImagensEstaticas.vazio;
	}

	public static void setVazio(BufferedImage vazio) {
		ImagensEstaticas.vazio = vazio;
	}

	public static BufferedImage getBomba() {
		return ImagensEstaticas.bomba;
	}

	public static void setBomba(BufferedImage bomba) {
		ImagensEstaticas.bomba = bomba;
	}

	public static BufferedImage getExplodiu() {
		return explodiu;
	}

	public static void setExplodiu(BufferedImage explodiu) {
		ImagensEstaticas.explodiu = explodiu;
	}

	public static BufferedImage getBandeira() {
		return bandeira;
	}

	public static void setBandeira(BufferedImage bandeira) {
		ImagensEstaticas.bandeira = bandeira;
	}

	public static BufferedImage getBombaFalsa() {
		return bombaFalsa;
	}

	public static void setBombaFalsa(BufferedImage bombaFalsa) {
		ImagensEstaticas.bombaFalsa = bombaFalsa;
	}
	
}

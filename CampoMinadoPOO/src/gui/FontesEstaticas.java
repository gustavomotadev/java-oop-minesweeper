package gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class FontesEstaticas {
	
	private static Font openSansBold;
	private static Font dseg7ClassicMiniBold;
	
	public static void carregarFontes() {
		
	    try {
	    	
			openSansBold = Font.createFont(Font.TRUETYPE_FONT, FontesEstaticas.class.getResourceAsStream("/recursos/opensansbold.ttf")).deriveFont(15f);
			dseg7ClassicMiniBold = Font.createFont(Font.TRUETYPE_FONT, FontesEstaticas.class.getResourceAsStream("/recursos/dseg7classicminibold.ttf")).deriveFont(40f);
			
		} catch (FontFormatException | IOException e) {
			
			System.out.println("Nao foi possivel criar fonte a partir de tff\n");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static Font getOpenSansBold() {
		return openSansBold;
	}

	public static void setOpenSansBold(Font openSansBold) {
		FontesEstaticas.openSansBold = openSansBold;
	}

	public static Font getDseg7ClassicMiniBold() {
		return dseg7ClassicMiniBold;
	}

	public static void setDseg7ClassicMiniBold(Font dseg7ClassicMiniBold) {
		FontesEstaticas.dseg7ClassicMiniBold = dseg7ClassicMiniBold;
	}
		
}

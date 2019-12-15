package jayrender.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	public BufferedImage buffer;
	public File image;
	
	public Image(String filename, int bufferWidth, int bufferHeight) {
		image  = new File(filename);
		buffer = new BufferedImage(bufferWidth, bufferHeight, BufferedImage.TYPE_INT_RGB);
	}
	
	public void write(String filetype) {
		try {
			ImageIO.write(buffer, filetype, image);
		} catch (IOException e) {
			System.out.println("Could not write to file");
			System.exit(1);
		}
	}
}

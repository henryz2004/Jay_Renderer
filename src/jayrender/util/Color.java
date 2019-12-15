package jayrender.util;

public class Color {
	
	public float r, g, b;	// OpenGL converts ints to floats, let's just use floats
	
	public Color() {
		r = 0.0f;
		g = 0.0f;
		b = 0.0f;
	}
	public Color(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	public Color(int r, int g, int b) {
		this.r = r/255;
		this.g = g/255;
		this.b = b/255;
	}
	public Color(Color color) {
		r = color.r;
		g = color.g;
		b = color.b;
	}
	
	public void add(Color color) {
		
		r += color.r;
		g += color.g;
		b += color.b;
	}
	public void divide(int scalar) {
		
		r /= scalar;
		g /= scalar;
		b /= scalar;
	}
	
	public int toInteger() {
		return (int)(r*255)<<16|(int)(g*255)<<8|(int)(b*255);
	}
}

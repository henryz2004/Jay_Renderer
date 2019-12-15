import jayrender.geometry.Plane;
import jayrender.geometry.Sphere;
import jayrender.scene.World;
import jayrender.util.Color;
import jayrender.util.Image;
import jayrender.util.Normal;
import jayrender.util.OrthoTracer;
import jayrender.util.Point3D;
import jayrender.util.Tracer;

public class Render {

	static World world;
	static Image image;
	static Tracer tracer;
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		final int width  = 320;
		final int height = 180;
		
		image  = new Image("RenderOutput.png", width, height);
		world  = new World(width, height, 1.0);
		tracer = new OrthoTracer();
		
		// Initialize world
		world.addObject(new Sphere(new Point3D(0.0, 0.0, 0.0), 50.0, new Color(255, 0, 0)));
		world.addObject(new Sphere(new Point3D(0.0, 50.0, -300.0), 100.0, new Color(0, 255, 0)));
		world.addObject(new Plane(new Point3D(0.0, 0.0, 0.0), new Normal(0.0, 1.0, 0.1), new Color(0, 0, 255)));
		
		// Render loop
		for (int y=0; y<height; y++) {
			for (int x=0; x<width; x++) {
				
				tracer.trace(x, y, world, image);
			}
		}
		image.write("PNG");
		
		System.out.println("Rendering took: " + (System.currentTimeMillis() - start) + " milliseconds");
	}
}

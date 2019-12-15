package jayrender.util;

import jayrender.geometry.GeometricObject;
import jayrender.scene.World;

public class OrthoTracer implements Tracer {
	
	public OrthoTracer() {}

	public void trace(int x, int y, World world, Image image) {

		Ray ray = new Ray(
			new Point3D(
				(x-world.camera.width/2+.5),
				(y-world.camera.height/2+.5), 100),	// TODO: Adjustable z, sampling
			new Vector3D(0.0, 0.0, -1.0)
		);
		
		// Correct rendering order
		double min = Double.MAX_VALUE;
		Color color = world.background;
		
		for (GeometricObject obj : world.objects) {
			double t = obj.hit(ray); 
			if (t != 0.0 && t < min) {
				color = obj.color;
				min = t;
			}
		}
		
		image.buffer.setRGB(x, world.camera.height-y-1, color.toInteger());
	}
}

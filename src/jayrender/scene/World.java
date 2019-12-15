package jayrender.scene;

import java.util.ArrayList;
import java.util.List;

import jayrender.geometry.GeometricObject;
import jayrender.util.Color;

public class World {

	public ViewPlane camera;
	public List<GeometricObject> objects;
	public Color background;
	
	public World(int width, int height, double size) {
		camera = new ViewPlane(width, height, size);
		background = new Color(0,0,0);
		
		objects = new ArrayList<>();
	}
	
	public void addObject(GeometricObject o) {
		objects.add(o);
	}
}

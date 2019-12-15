package jayrender.geometry;

import jayrender.util.Color;
import jayrender.util.Ray;

public abstract class GeometricObject {
	
	public Color color;		// TODO replace with materials
	
	public abstract double hit(Ray ray);
}

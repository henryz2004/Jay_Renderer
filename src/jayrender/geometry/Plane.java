package jayrender.geometry;

import jayrender.util.Color;
import jayrender.util.Normal;
import jayrender.util.Point3D;
import jayrender.util.Ray;

public class Plane extends GeometricObject {

	Point3D point;
	Normal normal;
	
	public Plane(Point3D point, Normal normal, Color color) {
		this.point  = new Point3D(point);
		this.normal = new Normal(normal);
		this.color  = new Color(color);
	}
	
	public double hit(Ray ray) {

		double t = point.sub(ray.origin).dot(normal)/ray.direction.dot(normal);
		
		return t > 10E-9 ? t : 0.0;
	}
}

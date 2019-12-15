package jayrender.util;

import jayrender.scene.World;

public interface Tracer {
	
	public abstract void trace(int x, int y, World world, Image image);
}

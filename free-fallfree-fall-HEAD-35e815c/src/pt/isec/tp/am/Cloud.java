package pt.isec.tp.am;

import android.graphics.Rect;

public class Cloud 
{
	Point coordinates;
	Rect rect;
	Size size;
	int resource;
	
	public Cloud(int res, Point coord, Size s)
	{
		coordinates = coord;
		size = s;
		int x = (int) coordinates.x;
		int y = (int) coordinates.y;
		rect = new Rect(x, y, x+(int)size.width, y+(int)size.height);
		resource = res;
	}
	
	public void moveUp()
	{
		coordinates.subY(1);
		int y = (int) coordinates.y;
		rect.set(rect.left, y, rect.right, y+(int)size.height);
	}
}

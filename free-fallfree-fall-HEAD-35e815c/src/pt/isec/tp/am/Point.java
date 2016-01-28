package pt.isec.tp.am;

public class Point {
	float x;
	float y;
	
	public Point() {
		this(0, 0);
	}
	
	public Point(float _x, float _y) {
		x = _x;
		y = _y;
	}
	
	public Point(int _x, int _y) {
		x = _x;
		y = _y;
	}

	public Point(Point p) {
		this(p.x, p.y);
	}

	public void addX(int i){
		x += i;
	}
	
	public void addX(float i){
		x += i;
	}
	
	public void subX(int i){
		x -= i;
	}
	
	public void setX(int _x){
		x = _x;
	}
	
	public void setX(float _x){
		x = _x;
	}
	
	public void addY (int i){
		y += i;
	}
	
	public void addY (float i){
		y += i;
	}
	
	public void subY (int i){
		y -= i;
	}
	
	public void setY(int _y){
		y = _y;
	}
	
	public void setY(float _y){
		y = _y;
	}
	
	public boolean equals(Object o){
		if (this == o)
			return true;
		
		if(o == null || o.getClass() != this.getClass() )
			return false;
		
		Point point = (Point) o;
		
		if ( point.x == this.x && point.y == this.y)
			return true;
			
		return false;
	}
	
	public float distance (Point p) {
		return(float) Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2) );
	}
	
	public float distance (int x, int y) {
		return distance (new Point(x, y));
	}
	
	public float distance (float x, float y) {
		return distance (new Point(x, y));
	}
	
	public String toString(){
		return Float.toString(x) + ", " + Float.toString(y);
	}
}
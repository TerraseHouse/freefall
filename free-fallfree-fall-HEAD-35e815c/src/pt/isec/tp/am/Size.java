package pt.isec.tp.am;

public class Size extends Object {
	
	float width;
	float height;
	
	public Size(float w, float h) {
		width = w;
		height = h;
	}
	
	public Size(int width, int height) {
		this((float) width, (float) height);
	}
	
    public Size(double width, double height) {
    	this((float) width, (float) height);
    }
	
	public Size(Size s) {
		this(s.width, s.height);
	}
	
	public Size() {
		this(0, 0);
	}

	public void setWidth(float w){
		width = w;
	}
	
	public void addWidth(float w){
		width += w;
	}

	public void setHeight (float h){
		height = h;
	}
	
	public void addHeight (float h){
		height += h;
	}
	
	public boolean equals(Object o){
		if (this == o)
			return true;
		
		if(o == null || o.getClass() != this.getClass() )
			return false;
		
		Size size = (Size) o;
		
		if ( size.width == this.width && size.height == this.height)
			return true;
			
		return false;
	}

}

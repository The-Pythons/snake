package logica;

public class Punto2D {
	public int x;
	public int y;
	
	public Punto2D() {
		this.x=0;
		this.y=0;
	}
	
	public Punto2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto2D(Punto2D p) {
		this.x = p.x;
		this.y = p.y;
	}
	public boolean puntoCorrecto(int dim_x,int dim_y){
		if(this.x>=dim_x || this.y>=dim_y || this.y<=0 || this.x<=0 )
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto2D other = (Punto2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}

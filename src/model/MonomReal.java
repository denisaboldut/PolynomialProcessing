package tema1;

public class MonomReal extends Monom{
	private double coeficient;
	
	public MonomReal() {
	
	}

	
	public MonomReal(double coeficient,int grad) {
		super.grad=grad;
		this.coeficient = coeficient;
	}

	

	public double getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}
	
	public String toString() {
		if (coeficient>=0) {
			//String.format("%.2f", coeficient);
		return "+"+String.format("%.2f", coeficient)+"x"+"^"+grad+"";
		}
		else
			return ""+String.format("%.2f", coeficient)+"x"+"^"+grad+"";
	}
	
}

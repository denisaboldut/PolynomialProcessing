package tema1;

public class MonomIntreg extends Monom{
	private int coeficient;
	
	
	MonomIntreg(){
		
	}
	public MonomIntreg(int coeficient, int grad) {
		super();
		this.coeficient = coeficient;
		super.grad = grad;
	}



	public int getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(int coeficient) {
		this.coeficient = coeficient;
	}


	public String toString() {
		if (coeficient>=0) {
		return "+"+coeficient+"x"+"^"+grad+"";
		}
		else
			return ""+coeficient+"x"+"^"+grad+"";
	}

}

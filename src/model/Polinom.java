package tema1;

import java.awt.List;
import java.util.ArrayList;
import java.util.regex.Pattern;





public class Polinom {
	ArrayList<Monom> monoame = new ArrayList<Monom>();
	
	 public void spargeInMonoame(String p) throws Exception {         //5x^4+2x^2+3x^1+2x^0
		
		String s= new String();
		//p = StringUtils.replace(p, "+", "plus");
	
		String inceput=p.substring(0,1);
		String sfarsit=p.substring(1, p.length());
		
		
	    sfarsit=sfarsit.replaceAll("\\+"," +");                  //punem spatiu frumos inainte de semn
		sfarsit=sfarsit.replaceAll("-", " -");                   // astfel le putem sparge in functie de spatiu
		p=inceput+sfarsit;                                             // foarte important fara sa pierdem semnul
		
		String[] separatorSpatiu=p.split(" ");
		int i=0;
		
		for (String part: separatorSpatiu) {
			if (part.contains("x^")) {
			  String[] separator=part.split("x\\^");
			  MonomIntreg m= new MonomIntreg();
			  if(separator[0]==""){
				  m.setCoeficient(1);
			  }else {
			  m.setCoeficient(Integer.parseInt(separator[0]));
			  }
			  m.setGrad(Integer.parseInt(separator[1]));

			  monoame.add(m);
			}  
//		   else if (part.contains("x")) {
//				String[] separator=part.split("x");
//			Monom m= new Monom();			
//			m.setCoeficient(Integer.parseInt(separator[0]));
//				  m.setGrad(Integer.parseInt(separator[1]));
//
//				  monoame.add(m);
//		    }
		
			
			else{
				 MonomIntreg m= new MonomIntreg();
		//	 System.out.println(part);
				 m.setCoeficient(Integer.parseInt(part));
			 m.setGrad(0);
			 monoame.add(m);
		}
			
		}
		 
	//	System.out.println(monoame.get(3));
		
	 }
	 
	 public int pozitieGrad(int grad) {
		 for(Monom m:monoame) {
			 if (m.getGrad()==grad )
			 {
				return monoame.indexOf(m); 
			 }
		 }
		 return -1;
	 }
	 
	 public void removeMonom(int grad) {
		 for(int i=0;i<this.monoame.size();i++) {
			 if (this.monoame.get(i).getGrad()==grad )
			 {
				this.monoame.remove(this.monoame.get(i));
			 }
		 }
	 }
	 
	 public Polinom inversat() {
		 Polinom aux=new Polinom();
		 for(Monom m: this.monoame) {
				aux.monoame.add(new MonomIntreg(((MonomIntreg) m).getCoeficient()*(-1),m.getGrad()));	 
		 }
		 return aux;
		 
	 }
	 
	 public void ordoneaza() {
			int ok = 0, i;
			Monom aux = new Monom();

			do {
				ok = 1;
				for (i = 0; i < this.monoame.size() - 1; i++)
					if (this.monoame.get(i).getGrad() < this.monoame.get(i+1).getGrad()) {
						aux = this.monoame.get(i);
						this.monoame.set(i, this.monoame.get(i + 1));
						this.monoame.set(i + 1, aux);
						ok = 0;
					}
			} while (ok == 0);
		}
	 public void adunaIntermediar() {
			int i;
			for (i = 0; i < this.monoame.size() - 1; i++)
				if (this.monoame.get(i).getGrad() == this.monoame.get(i + 1).getGrad()) {
					((MonomIntreg) this.monoame.get(i)).setCoeficient(((MonomIntreg) this.monoame.get(i)).getCoeficient()+ ((MonomIntreg) this.monoame.get(i + 1)).getCoeficient());
					this.monoame.remove(i + 1);
				}
		}

	@Override
	public String toString() {
		String s="";
		for ( Monom p: monoame) {
			s=s+p;
		}
		return s;
	}
		
	

	 
	 
}

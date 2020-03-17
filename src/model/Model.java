package tema1;



public class Model {
	static final String MODEL_INIT = "Introduceti aici";
	static final String MODEL_INIT_REZULTAT = "";
	private String rezultat;
	private Polinom p1;
	private Polinom p2;

	public Model() {
		reset();
	}

	public void setRezultat(String s) {
		// TODO Auto-generated method stub
		rezultat = new String();
		rezultat = s;
	}

	public String getRezultat() {
		return rezultat;
	}

	public void reset() {
		rezultat = "";
	}

//	public void crearePolinoame(String sp1, String sp2) {
//		 p1= new Polinom();
//		 p2 = new Polinom();
//		p1.spargeInMonoame(sp1);
//		p2.spargeInMonoame(sp2);
//	}

	public String aduna(String sp1, String sp2) throws Exception {
		p1 = new Polinom();
		p2 = new Polinom();
		p1.spargeInMonoame(sp1);
		p2.spargeInMonoame(sp2);
		Polinom rez = new Polinom();

		for (Monom m : p1.monoame) {
			int grad1 = m.getGrad();
			int coeficient1 = ((MonomIntreg) m).getCoeficient();
			int pozitie = p2.pozitieGrad(grad1);

			if (pozitie == -1) {
				rez.monoame.add(new MonomIntreg(coeficient1, grad1));
			} else {
				int grad2 = p2.monoame.get(pozitie).getGrad();
				int coeficient2 = ((MonomIntreg) p2.monoame.get(pozitie)).getCoeficient();
				rez.monoame.add(new MonomIntreg(coeficient1 + coeficient2, grad2));
				p2.removeMonom(grad2);
			}
		}

		int inPlus = 0;
		for (int i = p2.monoame.size() - 1; i >= 0; i--) {
			if (p2.monoame.get(i).getGrad() > p1.monoame.get(0).getGrad()) {
				rez.monoame.add(0, // inseram monomul la inceput
						new MonomIntreg(((MonomIntreg) p2.monoame.get(i)).getCoeficient(),
								p2.monoame.get(i).getGrad()));
				inPlus++;
			} else {
				for (int j = p1.monoame.size() - 1; j >= 0; j--) {
					if (p2.monoame.get(i).getGrad() < p1.monoame.get(j).getGrad()) {
						rez.monoame.add(p1.monoame.size() - j + inPlus, // inseram monomul pe pozitia corespunzatoare
																		// coeficientului sau
								new MonomIntreg(((MonomIntreg) p2.monoame.get(i)).getCoeficient(),
										p2.monoame.get(i).getGrad()));
						break;
					}
				}
			}
		}
		for (Monom m : rez.monoame) {
			if (((MonomIntreg) m).getCoeficient() == 0) {
				// rez.removeMonom(m.getGrad());
				// System.out.println(rez.monoame.isEmpty());
				if (rez.monoame.isEmpty()) {
					return "0";

				}
			}

		}
		rez.ordoneaza();
		String rezultat = rez.toString();
		if (rezultat == "") {
			rezultat = "0";
		}
		return rezultat;
	}

	public Polinom inverseaza(String sp2) throws Exception {
		// TODO Auto-generated method stub
		p2 = new Polinom();
		Polinom p3 = new Polinom();

		p2.spargeInMonoame(sp2);

		p3 = p2.inversat();

		return p3;
	}

	public String deriveaza(String spolinom) throws Exception {
		p1 = new Polinom();
		p1.spargeInMonoame(spolinom);
		Polinom rez = new Polinom();
		int ok = 1; // in cazul in care avem x^0 sa nu mai punem monomul
		for (Monom m : p1.monoame) {
			ok = 1;
			((MonomIntreg) m).setCoeficient(((MonomIntreg) m).getCoeficient() * m.getGrad());
			if (m.getGrad() == 0) {
				ok = 0;
			}
			m.setGrad(m.getGrad() - 1);
			if (ok != 0) {
				rez.monoame.add(m);
			}
		}
		String rezultat = rez.toString();
		if (rezultat == "") {
			rezultat = "0";
		}
		return rezultat;
	}

	public String integreaza(String spolinom) throws Exception {
		p1 = new Polinom();
		p1.spargeInMonoame(spolinom);
		Polinom rez = new Polinom();
		for (int i = 0; i < p1.monoame.size(); i++) {
			MonomReal m = new MonomReal();
			m.setCoeficient(
					(double) ((MonomIntreg) p1.monoame.get(i)).getCoeficient() / (p1.monoame.get(i).getGrad() + 1));
			m.setGrad(p1.monoame.get(i).getGrad() + 1);
			rez.monoame.add(m);
		}
		String rezultat = rez.toString();
		if (rezultat == "") {
			rezultat = "0";
		}
		return rezultat;
	}

	public String inmulteste(String sp1, String sp2) throws Exception {
		p1 = new Polinom();
		p2 = new Polinom();
		p1.spargeInMonoame(sp1);
		p2.spargeInMonoame(sp2);
		Polinom rez = new Polinom();

		for (Monom m1 : p1.monoame) {
			for (Monom m2 : p2.monoame) {
				MonomIntreg aux = new MonomIntreg();
				aux.setCoeficient(((MonomIntreg) m1).getCoeficient() * ((MonomIntreg) m2).getCoeficient());
				aux.setGrad(m1.getGrad() + m2.getGrad());
				rez.monoame.add(aux);
			}
		}
		rez.ordoneaza();
		rez.adunaIntermediar();
		String rezultat = rez.toString();
		if (rezultat == "") {
			rezultat = "0";
		}
		return rezultat;

	}

	public String imparte(String sp1, String sp2) throws Exception {
		p1 = new Polinom();
		p2 = new Polinom();
		p1.spargeInMonoame(sp1);
		p2.spargeInMonoame(sp2);
		Polinom rez = new Polinom();
		int grad = 0;

		// while(p1.monoame.get(0).getGrad()>= p2.monoame.get(0).getGrad()) {
		for (int i = 0; i < p1.monoame.size(); i++) {
			if (((MonomIntreg) p1.monoame.get(i)).getCoeficient() > 0) {
				grad = p1.monoame.get(0).getGrad() - p2.monoame.get(0).getGrad();
				break;
			} else
				grad = 0;
		}
		int coef = ((MonomIntreg) p1.monoame.get(0)).getCoeficient()
				/ ((MonomIntreg) p2.monoame.get(0)).getCoeficient();

		Monom monomRez = new MonomIntreg(coef, grad);
		rez.monoame.add(monomRez);
		Model m = new Model();
		String scazator = m.inmulteste(monomRez.toString(), sp2);
		String inv = m.inverseaza(scazator).toString();
		System.out.println(m.aduna(sp1, scazator));
		String newPolinom = m.aduna(sp1, m.inverseaza(scazator).toString());

		Polinom polinomIntermediar = new Polinom();
		polinomIntermediar.spargeInMonoame(newPolinom);
		System.out.println(grad);
		System.out.println("aici:" + p2.monoame.get(0).getGrad());
		if (grad < p2.monoame.get(0).getGrad()) {
			return rez.toString();
		}
//		int i = 5;
//		while(i > 0) {
		imparte(newPolinom, sp2);
//		i--;
//		}

		return rez.toString();
	}

}

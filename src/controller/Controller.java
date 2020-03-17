package tema1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private Model model;
	private View view;

	public Controller(View v, Model m) {
		// TODO Auto-generated constructor stub
		model = m;
		view = v;

		// listener
		 view.addAdunareListener(new AdunareListener());
		 view.addScadereListener(new ScadereListener());
		 view.addInmultireListener(new InmultireListener());
		 view.addImpartireListener(new ImpartireListener());
		view.addStergereListener(new StergereListener());
		view.addDerivareListener(new DerivareListener1(),new DerivareListener2());
		view.addIntegrareListener(new IntegrareListener1(), new IntegrareListener2());
	}

	public class StergereListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			view.reset();
			model.reset();
			view.setRezultat(model.MODEL_INIT_REZULTAT);

		}
	}

	public class AdunareListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String p1 = new String();
			String p2 = new String();

			try {
				p1 = view.getFirstPolinom();
				p2 = view.getSecondPolinom();
				if (p1.equals("") || p1.equals(model.MODEL_INIT)) {
					view.showError("Primul polinom lipseste");
					return;
				}
				if (p2.equals("") || p2.equals(model.MODEL_INIT)) {
					view.showError("Al doilea polinom lipseste");
					return;
				}

				model.setRezultat(model.aduna(p1, p2));

			} catch (Exception e) {
				view.showError("Forma incorecta de introducere a datelor");
			}
			view.setRezultat(model.getRezultat());

		}

	}
	
	public class ScadereListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String p1 = new String();
			String p2 = new String();
			
			try {
				p1 = view.getFirstPolinom();
				p2 = view.getSecondPolinom();
				if (p1.equals("") || p1.equals(model.MODEL_INIT)) {
					view.showError("Primul polinom lipseste");
					return;
				}
				if (p2.equals("") || p2.equals(model.MODEL_INIT)) {
					view.showError("Al doilea polinom lipseste");
					return;
				}
				Polinom p= new Polinom();
				p=model.inverseaza(p2);
				model.setRezultat(model.aduna(p1,p.toString()));
			} catch (Exception e) {
				view.showError("Forma incorecta de introducere a datelor");
			}
			view.setRezultat(model.getRezultat());
		}
		
	}
	
	public class DerivareListener1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String p1 = new String();
			try {
				p1 = view.getFirstPolinom();
			
				if (p1.equals("") || p1.equals(model.MODEL_INIT)) {
					view.showError("Primul polinom lipseste");
					return;
				}	
				model.setRezultat(model.deriveaza(p1));
			} catch (Exception e) {
				view.showError("Forma incorecta de introducere a datelor");
			}
			view.setDerivare1(model.getRezultat());
		}
			
		}
		
	
	public class DerivareListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String p2 = new String();
			try {
				p2 = view.getSecondPolinom();
			
				if (p2.equals("") || p2.equals(model.MODEL_INIT)) {
					view.showError("Al doilea polinom lipseste");
					return;
				}	
				model.setRezultat(model.deriveaza(p2));
			} catch (Exception e) {
				view.showError("Forma incorecta de introducere a datelor");
			}
			view.setDerivare2(model.getRezultat());
		}
	}
	public class IntegrareListener1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String p1 = new String();
			try {
				p1 = view.getFirstPolinom();
			
				if (p1.equals("") || p1.equals(model.MODEL_INIT)) {
					view.showError("Primul polinom lipseste");
					return;
				}	
				model.setRezultat(model.integreaza(p1));
			} catch (Exception e) {
				view.showError("Forma incorecta de introducere a datelor");
			}
			view.setIntegrare1(model.getRezultat());				
		}
		
	}
	public class IntegrareListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String p2 = new String();
			try {
				p2 = view.getSecondPolinom();
			
				if (p2.equals("") || p2.equals(model.MODEL_INIT)) {
					view.showError("Al doilea polinom lipseste");
					return;
				}	
				model.setRezultat(model.integreaza(p2));
			} catch (Exception e) {
				view.showError("Forma incorecta de introducere a datelor");
			}
			view.setIntegrare2(model.getRezultat());
		}
	}
	
	public class InmultireListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String p1 = new String();
			String p2 = new String();
			
			try {
				p1 = view.getFirstPolinom();
				p2 = view.getSecondPolinom();
				if (p1.equals("") || p1.equals(model.MODEL_INIT)) {
					view.showError("Primul polinom lipseste");
					return;
				}
				if (p2.equals("") || p2.equals(model.MODEL_INIT)) {
					view.showError("Al doilea polinom lipseste");
					return;
				}
				
				model.setRezultat(model.inmulteste(p1,p2));
			} catch (Exception e) {
				view.showError("Forma incorecta de introducere a datelor");
			}
			view.setRezultat(model.getRezultat());
		}
		}
	
	public class ImpartireListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String p1 = new String();
			String p2 = new String();
			
			try {
				p1 = view.getFirstPolinom();
				p2 = view.getSecondPolinom();
				if (p1.equals("") || p1.equals(model.MODEL_INIT)) {
					view.showError("Primul polinom lipseste");
					return;
				}
				if (p2.equals("") || p2.equals(model.MODEL_INIT)) {
					view.showError("Al doilea polinom lipseste");
					return;
				}
				
				model.setRezultat(model.imparte(p1,p2));
			} catch (Exception e) {
				view.showError(e.getMessage());
			}
			view.setRezultat(model.getRezultat());
		
			
		}
		
	}
		
	
	
	
}

package tema1;

public class MainClass {

	public static void main (String args[]) {
		Model m= new Model();
		View v= new View(m);
		Controller c= new Controller(v,m);
		v.setVisible(true);
		
	}
}

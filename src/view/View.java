package tema1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class View extends JFrame{
    private Model model;
    private JLabel l1 =new JLabel("  PRIMUL POLINOM (P1):");
    private JLabel l2 =new JLabel("  AL DOILEA POLINOM (P2):");
    private JLabel l3 =new JLabel("  POLINOMUL REZULTAT:");
    private TextArea text1 = new TextArea("");
    private TextArea text2 = new TextArea("");
    private TextArea text3 = new TextArea("");
    private TextArea text4 = new TextArea("");
    private TextArea text5 = new TextArea("");
    private TextArea text6 = new TextArea("");
    private TextArea text7 = new TextArea("");
	private JButton buton1 = new JButton("Adunare(P1+P2)");
	private JButton buton2 = new JButton("Scadere(P1-P2)");
	private JButton buton3 = new JButton("Inmultire(P1*P2)");
	private JButton buton4 = new JButton("Impartire(P1/P2)");
	private JButton buton5 = new JButton("Derivare(P1)");
	private JButton buton6 = new JButton("Integrare(P1)");
	private JButton buton7 = new JButton("Derivare(P2)");
	private JButton buton8 = new JButton("Integrare(P2)");
	private JButton buton9 = new JButton("Stergere date");

   
	public View(Model m) {
		// TODO Auto-generated constructor stub
		model=m;
    	model.setRezultat(model.MODEL_INIT_REZULTAT);
    
    	
    	JPanel panelM= new JPanel();
    	panelM.setLayout(new GridLayout(1,4));
    	JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(14, 1));
		panel.add(new JLabel());
		l1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		l2.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		l3.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 17));
		
		panel.add(l1);
		panel.add(text1);
		text1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
	    text1.setFont(new Font("Curlz MT", Font.PLAIN, 16));
	    panel.add(l2);
		panel.add(text2);
		text2.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		 text2.setFont(new Font("Curlz MT", Font.PLAIN, 16));
		 
		 buton1.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton2.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton3.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton4.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton5.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton6.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton7.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton8.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton9.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		 buton9.setBackground(getBackground().decode("#f9cda8"));
		 
		
		//buton1.setSize(500,500);
		panel.add(new JLabel());
		panel.add(buton1);
		panel.add(buton2);
		panel.add(buton3);
		panel.add(buton4);
		panel.add(new JLabel());
		panel.add(l3);
		panel.add(text3);
		text3.setEditable(false);
		text3.setBackground(getBackground().decode("#a3caff") );
	    text3.setFont(new Font("Curlz MT", Font.PLAIN, 14));
	    text6.setBackground(getBackground().decode("#a3caff") );
	    text6.setFont(new Font("Curlz MT", Font.PLAIN, 14));
	    text7.setBackground(getBackground().decode("#a3caff") );
	    text7.setFont(new Font("Curlz MT", Font.PLAIN, 14));
	    text4.setBackground(getBackground().decode("#a3caff") );
	    text4.setFont(new Font("Curlz MT", Font.PLAIN, 14));
	    text5.setBackground(getBackground().decode("#a3caff") );
	    text5.setFont(new Font("Curlz MT", Font.PLAIN, 14));
	
		
		
		JPanel panelD=new JPanel();
		panelD.setLayout(new GridLayout(14,1));
		panelD.add(new JLabel());
		panelD.add(buton5);
		panelD.add(text4);
		text4.setEditable(false);
		panelD.add(buton7);
		panelD.add(text5);
		text5.setEditable(false);
		
		JPanel panelI=new JPanel();
		panelI.setLayout(new GridLayout(14,1));
		panelI.add(new JLabel());
		panelI.add(buton6);
		panelI.add(text6);
		text6.setEditable(false);
		panelI.add(buton8);
		panelI.add(text7);
		text7.setEditable(false);
		panelI.add(new JLabel());
		panelI.add(new JLabel());
		panelI.add(new JLabel());
		panelI.add(new JLabel());
		panelI.add(new JLabel());
		panelI.add(new JLabel());
		panelI.add(new JLabel());
		panelI.add(buton9);
		
		ImageIcon img = new ImageIcon("da.jpg");
		ImageIcon img1 = new ImageIcon("da2.jpg");
		JLabel l = new JLabel(img);
		JLabel l1 = new JLabel(img1);
		
		
		
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(1,1));
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(1,1));
		panel1.add(l1);
		panelM.add(panel1);
		panelM.add(panel);
		panelM.add(panelD);
		panelM.add(panelI);
		panel2.add(l);
		panelM.add(panel2);
		
	
		
		this.setContentPane(panelM);
		this.setTitle("Sistem de procesare a polinoamelor");
		this.setSize(1000,600);
		this.setLocation(400, 150);
		//this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public String getFirstPolinom() {
		return text1.getText();
	}
	
	public String getSecondPolinom() {
		return text2.getText();
	}
	
	/////////////
	public void showError(String mesajEroare) {
		JOptionPane.showMessageDialog(this, mesajEroare);
	}
	////////////
	
	public void reset() {
		text1.setText(model.MODEL_INIT);
		text2.setText(model.MODEL_INIT);
		text4.setText(model.MODEL_INIT_REZULTAT);
		text5.setText(model.MODEL_INIT_REZULTAT);
		text6.setText(model.MODEL_INIT_REZULTAT);
		text7.setText(model.MODEL_INIT_REZULTAT);
		
	}
	
	public void setRezultat(String s) {
		text3.setText(s);
	}
	public void setDerivare1(String s) {
		text4.setText(s);
	}
	public void setDerivare2(String s) {
		text5.setText(s);
	}
	public void setIntegrare1(String s) {
		text6.setText(s);
	}
	public void setIntegrare2(String s) {
		text7.setText(s);
	}
	
	///add action listener
	public void addAdunareListener(ActionListener adunare) {
		buton1.addActionListener(adunare);
	}
	public void addScadereListener(ActionListener scadere) {
		buton2.addActionListener(scadere);
	}
	public void addInmultireListener(ActionListener inmultire) {
		buton3.addActionListener(inmultire);
	}
	public void addImpartireListener(ActionListener impartire) {
		buton4.addActionListener(impartire);
	} 
	public void addStergereListener(ActionListener stergere) {
		buton9.addActionListener(stergere);
	}
	
	public void addDerivareListener(ActionListener derivare1,ActionListener derivare2) {
		buton5.addActionListener(derivare1);
		buton7.addActionListener(derivare2);
	}
	
	public void addIntegrareListener(ActionListener integrare1,ActionListener integrare2) {
		buton6.addActionListener(integrare1);
		buton8.addActionListener(integrare2);
	}
	

}

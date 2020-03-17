package testareJunit;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import tema1.Model;
import tema1.View;

public class JUnit {
	private Model model;
	private View view;
	private int succes = 0;
	private int fail = 0;

	public JUnit() {
		System.out.println("Constructor");
		model = new Model();
		view = new View(model);
	}
	
	@BeforeAll
	public void testareInainte() throws Exception {
		System.out.println("Inainte tuturor");
	}
	
	@AfterAll
	public void testareDupa() throws Exception {
		System.out.println("A avut loc " + succes + " succes si " + fail + " failuri");
	}
	

	@Test
	public void test1() {
		String s = new String("1x^3+2x^2-1x^1-2x^0");
		view.setRezultat(s);
		
		Assertions.assertEquals(view.getFirstPolinom(),"1x^3+2x^2-1x^1-2x^0");
	}
	@Test
	public void test2() {
		Assertions.fail("A esuat");
	}	


}

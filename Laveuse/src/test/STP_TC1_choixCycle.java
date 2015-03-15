package test;

import static org.junit.Assert.*;
import laveuse.View;
import laveuse.ViewVariables;
import laveuse.WashingMachine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class STP_TC1_choixCycle {

	@Before
	public void setUp() throws Exception {
		View theView  = new View();
		theView.setVisible(true);
		
		ViewVariables theViewVariables  = new ViewVariables();
		theViewVariables.setVisible(true);
		
		WashingMachine washingMachine = new WashingMachine(theView, theViewVariables);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}

}

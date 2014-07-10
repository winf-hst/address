package de.fh_stralsund.winf.adressbook;

import org.junit.Test;

import junit.framework.TestCase;

public class ContactTest extends TestCase{
	
	@Test
	public void testFullAdressStyle()  {
	 
	    // erstellen der benötigten Objekte
	    Contact contact_1 = new Contact("Rainer", "Zufall", "Dorfstraße 6");
	    Contact contact_2 = new Contact("Rainer Zufall, Dorfstraße 6");
	     
	    // assertEquals vergleicht ob die variable fulladress wie gewünscht 
		// initialisiert wird
	    assertEquals("Fulladress entspricht nicht dem gewünschten Standard.", contact_2.getFullAddress(),
	                         contact_1.getFullAddress());
	}

}

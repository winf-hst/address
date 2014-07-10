package de.fh_stralsund.winf.adressbook;

import org.junit.Test;
import junit.framework.TestCase;

public class AddressbookTest extends TestCase {

	@Test
	public void testAddContact()  {
	 
	    // erstellen der benötigten Objekte
	    Addressbook addressBook = new Addressbook();
	    Contact contact = new Contact("Rainer", "Zufall");
	 
	    // der Aufruf der Methode welche getestet werden soll
	    addressBook.addContact(contact);
	 
	    // assertEquals vergleicht die Anzahl der Einträge im Adressbuch 
		// mit dem Wert 1, da wir einen Kontakt hinzugefügt haben sollte
		// auch genau ein Eintrag im Adressbuch stehen
	    assertEquals("Es sollte ein Eintrag vorhanden sein.", 1,
	                         addressBook.size());
	}
	
}

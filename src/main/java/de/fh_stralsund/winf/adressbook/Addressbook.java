package de.fh_stralsund.winf.adressbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Addressbook {
	 
    //das Adressbuch als Liste von Kontakten
    private ArrayList<Contact> contacts;
 
    Addressbook(){
    	contacts = new ArrayList<Contact>();
    }
    
    //fügt dem adressbuch einen Kontakt (contact) hinzu
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
 
    //gibt anzahl der kontakte zurück
    public int size() {
        return 0;
        //return contacts.size();
    }
    
    //speichern der Liste
    public void saveList() {
    	if(contacts != null){
			try {
	    	FileOutputStream fos = new FileOutputStream("list.sav");
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(contacts);
	    	oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
    
    //laden der datei in die kontaktliste
    public void readList() {
    	ArrayList<Contact> con = null;
    	
		try {
	    	FileInputStream fis = new FileInputStream("list.sav");
	    	ObjectInputStream ois = new ObjectInputStream(fis);
	    	 con = (ArrayList<Contact>) ois.readObject();
	    	ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex){}
		
    	
		this.contacts = con;
    }
    
    public ArrayList<Contact> getContactList(){
    	return contacts;
    }
       
}
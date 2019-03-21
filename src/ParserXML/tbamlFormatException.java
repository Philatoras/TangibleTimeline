package ParserXML;

import javax.xml.validation.Schema;

class tbamlFormatException extends Exception{ 
	  public tbamlFormatException(Schema sf){
	    System.out.println("Le fichier tbaml ne corrspond pas au schéma XSD attendu! "
	    		+ "Schema attendu :"+ sf.toString());
	    
	  }  
	}
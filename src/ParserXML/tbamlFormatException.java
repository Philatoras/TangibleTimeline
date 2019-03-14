package ParserXML;
class tbamlFormatException extends Exception{ 
	  public tbamlFormatException(){
	    System.out.println("Le fichier tbaml ne corrspond pas au schéma XSD attendu! ");
	  }  
	}
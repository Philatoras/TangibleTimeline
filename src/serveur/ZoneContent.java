package serveur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZoneContent {
	//Renvoie un liste contenant le contenu textuel de chaque case du plateau dans le même ordre que celui du csv
	//(contenu recuperé du csv)
	public List<String> getContent(){
		List<String> contentList = new ArrayList<>();
		try 
		{
		   BufferedReader buf = new BufferedReader(new FileReader("plateaufrise.csv"));
		   
		   buf.readLine(); // Première ligne : Titre des colonnes ...
		   
		   String line = buf.readLine();
		   
		   while(line != null)
		   {
			  String[] val = line.split(";");
			  //On lit la 7eme colonne du csv
		      contentList.add(val[6]);
		      line = buf.readLine();
		   }
		   buf.close();
		} 
		catch (IOException ioe) 
		{
		   ioe.printStackTrace();
		}
		return contentList;
	}
}

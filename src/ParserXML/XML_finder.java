package ParserXML;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

//Classe permetant l'ouverture d'un explorateur de fichier afin de selectioner un fichier .TBAML 
//La fonction fileChooser retourne le fichier choisi
	
	public class XML_finder {
		
		public File fileChooser()  {
			File selectedFile = null;
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Ouverture d'un fichier tbaml ");
			jfc.setAcceptAllFileFilterUsed(false);
			//seuls les fichier .tbaml ou .xml sont affich�s
			FileNameExtensionFilter filter = new FileNameExtensionFilter("fichier tbaml ou xml", ".tbaml", ".xml");
			jfc.addChoosableFileFilter(filter);
			jfc.showDialog(null, "Charger l'application");

			int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = jfc.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
			}
			
			return selectedFile;

		}
		
		

	}

package ParserXML;

	import java.io.File;

	import javax.swing.JFileChooser;
	import javax.swing.filechooser.FileSystemView;

	public class XML_finder {
		
		
		public File fileChooser()  {
			File selectedFile = null;
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = jfc.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
			}
			
			return selectedFile;

		}

	}

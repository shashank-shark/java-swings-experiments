package gui;
import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFileFilter extends FileFilter {

	@Override
	public boolean accept(File file) {
		
		if (file.isDirectory()) {
			return true;
		}
		
		String extension = Utils.getFileExtension(file.getName());
		
		if (extension == null) {
			return false;
		}
		
		if (extension.equals("per")) {
			return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		return "Person database files (*.per)";
	}

}

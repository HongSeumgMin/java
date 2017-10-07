import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileTypeFilter extends FileFilter {

	private String extension;
	private String description;
	
	public FileTypeFilter(String extension, String description) {
		// TODO Auto-generated constructor stub
		this.extension = extension;
		this.description = description;
	}

	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		if(file.isDirectory())
			return true;
		return file.getName().endsWith(extension);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description + String.format(" (*%s)", extension);
	}

}

package ppc_a4;

import java.io.File;

import library.Message;

public class StartRenamingFilesRequestMessage extends Message {
	
	private File dir;
	private String toBeReplaced;
	private String toReplaceIt;
	
	public StartRenamingFilesRequestMessage(File dir, String toBeReplaced, String toReplaceIt) {
		super();
		this.dir = dir;
		this.toBeReplaced = toBeReplaced;
		this.toReplaceIt = toReplaceIt;
	}

	public String getToReplaceIt() {
		return toReplaceIt;
	}

	public String getToBeReplaced() {
		return toBeReplaced;
	}

	public File getDir() {
		return dir;
	}
	
	
	
	

}

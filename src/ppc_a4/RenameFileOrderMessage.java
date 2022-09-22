package ppc_a4;

import java.io.File;

import library.Address;
import library.Message;

public class RenameFileOrderMessage extends Message {
	
	private Address addressToReply; 
	private File dir; 
	private String toBeReplaced; 
	private String toReplaceIt;

	public RenameFileOrderMessage(Address addressToReply, File dir, String toBeReplaced, String toReplaceIt) {
		super();
		this.addressToReply = addressToReply;
		this.dir = dir;
		this.toBeReplaced = toBeReplaced;
		this.toReplaceIt = toReplaceIt;
	}

	public File getDir() {
		return dir;
	}

	public String getToBeReplaced() {
		return toBeReplaced;
	}

	public String getToReplaceIt() {
		return toReplaceIt;
	}

	public Address getAddressToReply() {
		return addressToReply;
	}
	
}

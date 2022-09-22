package ppc_a4;

import java.io.File;
import java.util.List;
import java.util.Random;
import library.Actor;
import library.Address;
import library.Message;
import library.SystemKillMessage;

public class FolderWorker extends Actor {
	
	private FolderManager subManager;

	public FolderWorker(Address manager) {
		super(manager);
	}

	@Override
	protected void handleMessage(Message m) {

		if (m instanceof RenameFileOrderMessage) {
			RenameFileOrderMessage m2 = ((RenameFileOrderMessage) m);
			
			
			File newDir= renameFile2(m2.getDir(), m2.getToBeReplaced(), m2.getToReplaceIt());
			
			
			if (newDir.listFiles().length!=0) {
				this.subManager = new FolderManager();
				subManager.getAddress().sendMessage(new RenameFileOrderMessage (m2.getAddressToReply(),
						newDir, m2.getToBeReplaced(), m2.getToReplaceIt()));
				
			}
			// implementação sem a criação de mais FolderWorkers do que aqueles que foram criado no manager
			//renameFile(m2.getDir(), m2.getToBeReplaced(), m2.getToReplaceIt());
	

			m2.getAddressToReply().sendMessage(new ResponseMessage());
		}
	
		if(m instanceof SystemKillMessage) {
			if (subManager != null ){
				subManager.getAddress().sendMessage(m);
			}
			this.getAddress().sendMessage(m);
		}


	}

	private static File renameFile2 (File fileToBeRenamed, String oldName,String newName) {
	
		
		if (fileToBeRenamed.getName().contains(oldName)) {

			String newFolderName= fileToBeRenamed.getName().replace(oldName, newName);
			File newDir = new File( fileToBeRenamed.getParent()+ "/"+ newFolderName);
			if(!newDir.exists()) {
				fileToBeRenamed.renameTo(newDir);
				return newDir;
			}

			
		}
		return fileToBeRenamed;


	}

	private static void renameFile (File fileToBeRenamed, String oldName,String newName) {

		boolean renamed= false;
		File[] auxList= fileToBeRenamed.listFiles();
		
		if (fileToBeRenamed.getName().contains(oldName)) {

			String newFolderName= fileToBeRenamed.getName().replace(oldName, newName);
			File newDir = new File( fileToBeRenamed.getParent()+ "/"+ newFolderName);
			renamed= fileToBeRenamed.renameTo(newDir);
			
			if(newDir.listFiles().length==0) {
				return;

			}else {

				for (File f : newDir.listFiles()) {
					renameFile(f, oldName, newName);
				}
			}
		}

		if (!renamed && auxList.length!=0){

			for (File f : auxList) {
				renameFile(f, oldName, newName);
			}

		}else {
			return;
		}


	}



}

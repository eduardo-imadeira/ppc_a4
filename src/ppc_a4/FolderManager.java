package ppc_a4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import library.Actor;
import library.Message;
import library.SystemKillMessage;

public class FolderManager extends Actor{
	
	private List <FolderWorker> foldersToManage= new ArrayList<>();


	@Override
	protected void handleMessage(Message m) {
		if (m  instanceof RenameFileOrderMessage) {
			RenameFileOrderMessage m2 =(RenameFileOrderMessage)m;
			
			File dir= m2.getDir();
			
			if (dir.exists() && dir.listFiles().length>0) {
				for (File file : dir.listFiles()) {
					FolderWorker newWorker = new FolderWorker(this.getAddress());
					foldersToManage.add(newWorker);
					newWorker.getAddress().sendMessage(new RenameFileOrderMessage (m2.getAddressToReply(),file, m2.getToBeReplaced(), m2.getToReplaceIt()));
				}
				
		
			}else {
				// Do something if dir doesnt exists or it's empty
				
			}
			
		}if (m  instanceof SystemKillMessage) {
			for (FolderWorker w : foldersToManage) {
				w.getAddress().sendMessage(m);
			}
		}
	}
}

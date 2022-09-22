package ppc_a4;

import java.io.File;
import java.io.IOException;

import library.SystemKillMessage;
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		File dir = new File ("./tree");
		FolderManager manager = new FolderManager();
		Customer c = new Customer(manager.getAddress());
		
		c.getAddress().sendMessage(new StartRenamingFilesRequestMessage(dir, "1", "13"));
	


		//tempo maximo da executção do programa 10 segundos
		try {
			Thread.sleep(10000);
			
			c.getAddress().sendMessage(new SystemKillMessage());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}

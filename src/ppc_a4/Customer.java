package ppc_a4;

import library.Actor;
import library.Address;
import library.Message;
import library.SystemKillMessage;

public class Customer extends Actor {

	private Address serverAddress;

	public Customer(Address address) {
		serverAddress = address;
	}

	@Override
	protected void handleMessage(Message m) {
		if (m instanceof StartRenamingFilesRequestMessage) {
			System.out.println("Request for renaming files sent");
			StartRenamingFilesRequestMessage m2= (StartRenamingFilesRequestMessage)m;
			
			serverAddress.sendMessage(new RenameFileOrderMessage(this.getAddress(),m2.getDir(),
					m2.getToBeReplaced(), m2.getToReplaceIt()));
		}else if (m instanceof ResponseMessage) {
			System.out.println("Work done!");
		}else if(m instanceof SystemKillMessage) {
			serverAddress.sendMessage(new SystemKillMessage());
			this.getAddress().sendMessage(new SystemKillMessage());
		}
		

	}

}



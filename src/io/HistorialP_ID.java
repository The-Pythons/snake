package io;

import java.io.Serializable;

public class HistorialP_ID implements Serializable{

	private String userID;
	private int partidaID;
	
	public HistorialP_ID() {
		this.userID = "";
		this.partidaID = 0;
	}
	
	public HistorialP_ID(String userID, int partidaID) {
		this.userID = userID;
		this.partidaID = partidaID;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getPartidaID() {
		return partidaID;
	}

	public void setPartidaID(int partidaID) {
		this.partidaID = partidaID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partidaID;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if(!(obj instanceof HistorialP_ID))
			return false;
		HistorialP_ID obj1 = (HistorialP_ID)obj;
		return this.userID.equals(obj1.getUserID()) 
				&& this.partidaID == obj1.getPartidaID();
	}
	
}

package gui;

import javazoom.jl.player.*;


public class PlayerThread extends Thread{
	
	private jlp mReproductor = null;
	
	public PlayerThread(String pFileName){
		try{
			String []args = new String[1];
			args[0] = pFileName;
			mReproductor = jlp.createInstance(args);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}	
	
	public void run(){
		try{
				mReproductor.play();
			}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
